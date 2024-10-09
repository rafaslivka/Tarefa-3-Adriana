import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChocolatesGUI extends JFrame {
    private JTextArea infoArea;
    private JList<ChocolateInfo> chocolateList;
    private DefaultListModel<ChocolateInfo> chocolateListModel;
    private ArrayList<ChocolateInfo> chocolates;

    public ChocolatesGUI() {
        setTitle("Catálogo de Chocolates");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chocolates = new ArrayList<>();
        chocolateListModel = new DefaultListModel<>();

        JLabel titleLabel = new JLabel("Catálogo de Chocolates", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        chocolateList = new JList<>(chocolateListModel);
        chocolateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        chocolateList.addListSelectionListener(e -> mostrarInformacoes());
        JScrollPane listScrollPane = new JScrollPane(chocolateList);
        listScrollPane.setPreferredSize(new Dimension(300, 600));

        infoArea = new JTextArea();
        infoArea.setEditable(false);
        JScrollPane infoScrollPane = new JScrollPane(infoArea);
        infoScrollPane.setPreferredSize(new Dimension(300, 600));

        JButton addButton = new JButton("Adicionar Chocolate");
        addButton.setFont(new Font("Arial", Font.BOLD, 18));
        addButton.setBackground(Color.GREEN);
        addButton.setForeground(Color.BLACK);
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> adicionarChocolate());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(listScrollPane, BorderLayout.CENTER);
        leftPanel.add(infoScrollPane, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        leftPanel.add(buttonPanel, BorderLayout.NORTH);

        JLabel gifLabel = new JLabel(new ImageIcon("D:/Tarefa3/chocolates.gif"));
        gifLabel.setHorizontalAlignment(JLabel.CENTER);
        gifLabel.setPreferredSize(new Dimension(500, 600));

        add(leftPanel, BorderLayout.WEST);
        add(gifLabel, BorderLayout.CENTER);
    }

    private void adicionarChocolate() {
        String nome = JOptionPane.showInputDialog("Nome do Chocolate:");
        String tipo = JOptionPane.showInputDialog("Tipo do Chocolate:");

        ChocolateInfo novoChocolate = new ChocolateInfo(nome, tipo);
        chocolates.add(novoChocolate);
        chocolateListModel.addElement(novoChocolate);
    }

    private void mostrarInformacoes() {
        ChocolateInfo selectedChocolate = chocolateList.getSelectedValue();
        if (selectedChocolate != null) {
            infoArea.setText(selectedChocolate.mostrarInformacoes());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChocolatesGUI frame = new ChocolatesGUI();
            frame.setVisible(true);
        });
    }
}

class ChocolateInfo {
    private String nome;
    private String tipo;
    private String marca;

    public ChocolateInfo(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = "Nestlé"; // Pode ser alterado para ser dinâmico
    }

    public String mostrarInformacoes() {
        return "Nome: " + nome + ", Tipo: " + tipo + ", Marca: " + marca;
    }

    @Override
    public String toString() {
        return nome; // Isso permite que a lista mostre o nome do chocolate
    }
}
