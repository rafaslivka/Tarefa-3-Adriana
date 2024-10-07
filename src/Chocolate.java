import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Chocolate extends JFrame {
    private JTextArea infoArea;
    private JLabel imageLabel;
    private DefaultListModel<ChocolateInfo> chocolateListModel;
    private JList<ChocolateInfo> chocolateList;
    private ArrayList<ChocolateInfo> chocolates;

    public Chocolate() {
        setTitle("Catálogo de Chocolates");
        setSize(500, 400);
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
        add(new JScrollPane(chocolateList), BorderLayout.WEST);

        infoArea = new JTextArea();
        infoArea.setEditable(false);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);

        imageLabel = new JLabel("", JLabel.CENTER);
        add(imageLabel, BorderLayout.EAST);

        JButton addButton = new JButton("Adicionar Chocolate");
        add(addButton, BorderLayout.SOUTH);
        addButton.addActionListener(e -> adicionarChocolate());
    }

    private void adicionarChocolate() {
        String nome = JOptionPane.showInputDialog("Nome do Chocolate:");
        String tipo = JOptionPane.showInputDialog("Tipo do Chocolate:");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha uma imagem para o chocolate");
        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ChocolateInfo novoChocolate = new ChocolateInfo(nome, tipo, file.getAbsolutePath());
            chocolates.add(novoChocolate);
            chocolateListModel.addElement(novoChocolate);
        }
    }

    private void mostrarInformacoes() {
        ChocolateInfo selectedChocolate = chocolateList.getSelectedValue();
        if (selectedChocolate != null) {
            infoArea.setText(selectedChocolate.mostrarInformacoes());
            mostrarImagem(selectedChocolate.getImagemPath());
        }
    }

    private void mostrarImagem(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        imageLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Chocolate frame = new Chocolate();
            frame.setVisible(true);
        });
    }
}

class ChocolateInfo {
    private String nome;
    private String tipo;
    private String marca;
    private String imagemPath;

    public ChocolateInfo(String nome, String tipo, String imagemPath) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = "Nestlé"; // Pode ser alterado para ser dinâmico
        this.imagemPath = imagemPath;
    }

    public String mostrarInformacoes() {
        return "Nome: " + nome + ", Tipo: " + tipo + ", Marca: " + marca;
    }

    public String getImagemPath() {
        return imagemPath;
    }

    @Override
    public String toString() {
        return nome; // Isso permite que a lista mostre o nome do chocolate
    }
}
