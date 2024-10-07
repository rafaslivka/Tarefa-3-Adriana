import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrutasGUI extends JFrame {
    private JComboBox<String> comboBoxFrutas;
    private JTextArea infoArea;
    private JTextField pesoField;
    private Frutas[] frutas;

    public FrutasGUI() {
        // Inicializa as frutas
        frutas = new Frutas[]{
                new Frutas("Kiwi", "Outono", 0.1),
                new Frutas("Abacaxi", "Verão", 1.5),
                new Frutas("Uva", "Primavera", 0.2),
                new Frutas("Romã", "Inverno", 0.3),
                new Frutas("Banana", "Verão", 0.12),
                new Frutas("Manga", "Primavera", 0.5),
                new Frutas("Uva Verde", "Outono", 0.2),
                new Frutas("Melância", "Verão", 5.0),
                new Frutas("Pêra", "Outono", 0.15),
                new Frutas("Laranja", "Inverno", 0.25),
                new Frutas("Mirtilo", "Primavera", 0.05),
                new Frutas("Limão Siciliano", "Inverno", 0.2)
        };

        // Configurações da janela
        setTitle("Catálogo de Frutas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior (ComboBox para seleção de frutas)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        comboBoxFrutas = new JComboBox<>();
        for (Frutas fruta : frutas) {
            comboBoxFrutas.addItem(fruta.getNome());
        }
        comboBoxFrutas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacoesFruta();
            }
        });
        topPanel.add(new JLabel("Selecione uma fruta:"));
        topPanel.add(comboBoxFrutas);
        add(topPanel, BorderLayout.NORTH);

        // Área de texto para exibir informações
        infoArea = new JTextArea(8, 30);
        infoArea.setEditable(false);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);

        // Painel inferior (atualizar peso)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(new JLabel("Novo peso (kg):"));
        pesoField = new JTextField(5);
        bottomPanel.add(pesoField);

        JButton atualizarPesoBtn = new JButton("Atualizar Peso");
        atualizarPesoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarPesoFruta();
            }
        });
        bottomPanel.add(atualizarPesoBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        // Exibir informações iniciais
        mostrarInformacoesFruta();
    }

    // Mostra as informações da fruta selecionada
    private void mostrarInformacoesFruta() {
        int selectedIndex = comboBoxFrutas.getSelectedIndex();
        Frutas fruta = frutas[selectedIndex];
        infoArea.setText("Nome: " + fruta.getNome() + "\n"
                + "Época: " + fruta.getEpoca() + "\n"
                + "Peso: " + fruta.getPeso() + " kg");
    }

    // Atualiza o peso da fruta selecionada
    private void atualizarPesoFruta() {
        int selectedIndex = comboBoxFrutas.getSelectedIndex();
        Frutas fruta = frutas[selectedIndex];
        try {
            double novoPeso = Double.parseDouble(pesoField.getText());
            fruta.atualizarPeso(novoPeso);
            mostrarInformacoesFruta();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Classe Frutas
    class Frutas {
        private String nome;
        private String epoca;
        private double peso;

        public Frutas(String nome, String epoca, double peso) {
            this.nome = nome;
            this.epoca = epoca;
            this.peso = peso;
        }

        public String getNome() {
            return nome;
        }

        public String getEpoca() {
            return epoca;
        }

        public double getPeso() {
            return peso;
        }

        public void atualizarPeso(double novoPeso) {
            this.peso = novoPeso;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrutasGUI().setVisible(true);
            }
        });
    }
}
