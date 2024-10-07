import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogadoresGUI extends JFrame {
    private JComboBox<String> comboBoxJogadores;
    private JTextArea infoArea;
    private JTextField pesoField;
    private JTextField numeroField;
    private Jogadores[] jogadores;

    public JogadoresGUI() {
        // Inicializa os jogadores
        jogadores = new Jogadores[]{
                new Jogadores("Lionel Messi (GOAT)", 10, 72.0),
                new Jogadores("Cristiano Ronaldo", 7, 83.0),
                new Jogadores("Neymar Jr", 10, 68.0),
                new Jogadores("Pelé", 10, 75.0),
                new Jogadores("Maradona", 10, 70.0),
                new Jogadores("Rafael", 7, 78.0)
        };

        // Configurações da janela
        setTitle("Jogadores de Futebol");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior (ComboBox para seleção de jogadores)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        comboBoxJogadores = new JComboBox<>();
        for (Jogadores jogador : jogadores) {
            comboBoxJogadores.addItem(jogador.getNome());
        }
        comboBoxJogadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacoesJogador();
            }
        });
        topPanel.add(new JLabel("Selecione um jogador:"));
        topPanel.add(comboBoxJogadores);
        add(topPanel, BorderLayout.NORTH);

        // Área de texto para exibir informações
        infoArea = new JTextArea(8, 30);
        infoArea.setEditable(false);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);

        // Painel inferior (atualizar peso e número)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        bottomPanel.add(new JLabel("Novo Peso (kg):"));
        pesoField = new JTextField(5);
        bottomPanel.add(pesoField);

        bottomPanel.add(new JLabel("Novo Número:"));
        numeroField = new JTextField(5);
        bottomPanel.add(numeroField);

        JButton atualizarBtn = new JButton("Atualizar Informações");
        atualizarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarJogador();
            }
        });
        bottomPanel.add(atualizarBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        // Exibir informações iniciais
        mostrarInformacoesJogador();
    }

    // Mostra as informações do jogador selecionado
    private void mostrarInformacoesJogador() {
        int selectedIndex = comboBoxJogadores.getSelectedIndex();
        Jogadores jogador = jogadores[selectedIndex];
        infoArea.setText("Nome: " + jogador.getNome() + "\n"
                + "Número: " + jogador.getNumero() + "\n"
                + "Peso: " + jogador.getPeso() + " kg");
    }

    // Atualiza o peso e número do jogador selecionado
    private void atualizarJogador() {
        int selectedIndex = comboBoxJogadores.getSelectedIndex();
        Jogadores jogador = jogadores[selectedIndex];
        try {
            double novoPeso = Double.parseDouble(pesoField.getText());
            jogador.atualizarPeso(novoPeso);

            int novoNumero = Integer.parseInt(numeroField.getText());
            jogador.atualizarNumero(novoNumero);

            mostrarInformacoesJogador();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Classe Jogadores
    class Jogadores {
        private String nome;
        private int numero;
        private double peso;

        public Jogadores(String nome, int numero, double peso) {
            this.nome = nome;
            this.numero = numero;
            this.peso = peso;
        }

        public String getNome() {
            return nome;
        }

        public int getNumero() {
            return numero;
        }

        public double getPeso() {
            return peso;
        }

        public void atualizarPeso(double novoPeso) {
            this.peso = novoPeso;
        }

        public void atualizarNumero(int novoNumero) {
            this.numero = novoNumero;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JogadoresGUI().setVisible(true);
            }
        });
    }
}
