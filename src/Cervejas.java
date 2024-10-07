import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Cervejas extends JFrame {
    private JTextArea infoArea;
    private JLabel imageLabel;

    public Cervejas() {
        setTitle("Catálogo de Cervejas");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Catálogo de Cervejas", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        infoArea = new JTextArea();
        infoArea.setEditable(false);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);

        imageLabel = new JLabel("", JLabel.CENTER);
        add(imageLabel, BorderLayout.EAST);

        JButton addButton = new JButton("Adicionar Cerveja");
        add(addButton, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarCerveja();
            }
        });
    }

    private void adicionarCerveja() {
        String nome = JOptionPane.showInputDialog("Nome da Cerveja:");
        String tipo = JOptionPane.showInputDialog("Tipo da Cerveja:");
        String marca = JOptionPane.showInputDialog("Marca da Cerveja:");

        // Seleciona a imagem
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha uma imagem para a cerveja");
        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            Cerveja novaCerveja = new Cerveja(nome, tipo, marca, file.getAbsolutePath());
            infoArea.append(novaCerveja.mostrarInformacoes() + "\n");
            mostrarImagem(novaCerveja.getImagemPath());
        }
    }

    private void mostrarImagem(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        imageLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cervejas frame = new Cervejas();
            frame.setVisible(true);
        });
    }
}

class Cerveja {
    private String nome;
    private String tipo;
    private String marca;
    private String imagemPath;

    public Cerveja(String nome, String tipo, String marca, String imagemPath) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
        this.imagemPath = imagemPath;
    }

    public String mostrarInformacoes() {
        return "Nome: " + nome + ", Tipo: " + tipo + ", Marca: " + marca;
    }

    public String getImagemPath() {
        return imagemPath;
    }
}
