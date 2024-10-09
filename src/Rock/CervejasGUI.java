import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CervejasGUI extends JFrame {
    private JTextArea infoArea;
    private JPanel menuPanel;

    public CervejasGUI() {
        setTitle("Catálogo de Cervejas");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Catálogo de Cervejas", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        infoArea = new JTextArea();
        infoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoArea);
        scrollPane.setPreferredSize(new Dimension(400, 600));

        menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());

        JButton addButton = new JButton("Adicionar Cerveja");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarCerveja();
            }
        });

        menuPanel.add(addButton, BorderLayout.SOUTH);
        menuPanel.add(scrollPane, BorderLayout.CENTER);

        JLabel gifLabel = new JLabel(new ImageIcon("D:/tarefa3/Cervejas.GIF"));
        gifLabel.setHorizontalAlignment(JLabel.CENTER);
        add(gifLabel, BorderLayout.EAST);

        add(menuPanel, BorderLayout.WEST);
    }

    private void adicionarCerveja() {
        String marca = JOptionPane.showInputDialog("Marca da Cerveja:");
        String tipo = JOptionPane.showInputDialog("Tipo da Cerveja:");

        String[] tamanhos = {"350ml", "600ml"};
        String tamanho = (String) JOptionPane.showInputDialog(
                this,
                "Escolha o tamanho:",
                "Tamanho da Cerveja",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tamanhos,
                tamanhos[0]
        );

        Cerveja novaCerveja = new Cerveja(marca, tipo, tamanho);
        infoArea.append(novaCerveja.mostrarInformacoes() + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CervejasGUI frame = new CervejasGUI();
            frame.setVisible(true);
        });
    }
}

class Cerveja {
    private String nome;
    private String tipo;
    private String marca;

    public Cerveja(String marca, String tipo, String tamanho) {
        this.marca = marca;
        this.tipo = tipo;
        this.nome = tamanho;
    }

    public String mostrarInformacoes() {
        return "Marca: " + marca + ", Tipo: " + tipo + ", Tamanho: " + nome;
    }
}
