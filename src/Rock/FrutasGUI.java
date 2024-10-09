import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FrutasGUI {
    private JFrame frame;
    private JTextArea infoArea;
    private JTextArea historicoArea;
    private JComboBox<String> frutaMenu;
    private ArrayList<Frutas> frutas;

    public FrutasGUI(ArrayList<Frutas> frutas) {
        this.frutas = frutas;
        criarInterface();
    }

    public void criarInterface() {
        frame = new JFrame("Controle de Frutas");
        frame.setSize(800, 600); // Aumentando o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Desabilitando a redimensionamento da janela

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        infoArea = new JTextArea(5, 30);
        infoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        historicoArea = new JTextArea(5, 30);
        historicoArea.setEditable(false);
        JScrollPane historicoScrollPane = new JScrollPane(historicoArea);
        panel.add(historicoScrollPane, BorderLayout.SOUTH);

        frutaMenu = new JComboBox<>();
        for (Frutas fruta : frutas) {
            frutaMenu.addItem(fruta.getNome());
        }

        frutaMenu.addActionListener(e -> {
            atualizarInfo();
            atualizarHistorico();
        });

        JPanel buttonPanel = new JPanel();
        JButton mostrarInfoButton = new JButton("Mostrar Informações");
        JButton atualizarPesoButton = new JButton("Atualizar Peso");
        JButton exibirEpocaButton = new JButton("Exibir Época do Ano");

        mostrarInfoButton.addActionListener(e -> atualizarInfo());

        atualizarPesoButton.addActionListener(e -> {
            Frutas frutaSelecionada = getFrutaSelecionada();
            if (frutaSelecionada != null) {
                String novoPeso = JOptionPane.showInputDialog("Digite o novo peso:");
                if (novoPeso != null && !novoPeso.isEmpty()) {
                    frutaSelecionada.atualizarPeso(Double.parseDouble(novoPeso));
                    atualizarHistorico();
                }
            }
        });

        exibirEpocaButton.addActionListener(e -> {
            Frutas frutaSelecionada = getFrutaSelecionada();
            if (frutaSelecionada != null) {
                JOptionPane.showMessageDialog(frame, "Época do ano: " + frutaSelecionada.getEpoca());
            }
        });

        buttonPanel.add(frutaMenu);
        buttonPanel.add(mostrarInfoButton);
        buttonPanel.add(atualizarPesoButton);
        buttonPanel.add(exibirEpocaButton);

        panel.add(buttonPanel, BorderLayout.NORTH);

        JLabel gifLabel = new JLabel(new ImageIcon("D:/Tarefa3/frutas.gif"));
        panel.add(gifLabel, BorderLayout.WEST);

        frame.add(panel);
        frame.setVisible(true);
    }

    public Frutas getFrutaSelecionada() {
        String nomeSelecionado = (String) frutaMenu.getSelectedItem();
        for (Frutas fruta : frutas) {
            if (fruta.getNome().equals(nomeSelecionado)) {
                return fruta;
            }
        }
        return null;
    }

    public void atualizarInfo() {
        Frutas frutaSelecionada = getFrutaSelecionada();
        if (frutaSelecionada != null) {
            infoArea.setText("");
            infoArea.append("Nome: " + frutaSelecionada.getNome() + "\n");
            infoArea.append("Época: " + frutaSelecionada.getEpoca() + "\n");
            infoArea.append("Peso: " + frutaSelecionada.getPeso() + " kg\n");
        }
    }

    public void atualizarHistorico() {
        Frutas frutaSelecionada = getFrutaSelecionada();
        if (frutaSelecionada != null) {
            historicoArea.setText("");
            ArrayList<String> historico = frutaSelecionada.getHistorico();
            for (String evento : historico) {
                historicoArea.append(evento + "\n");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Frutas> frutas = new ArrayList<>();
        frutas.add(new Frutas("Kiwi", "Primavera", 0.5));
        frutas.add(new Frutas("Abacaxi", "Verão", 1.2));
        frutas.add(new Frutas("Uva", "Verão", 0.3));
        frutas.add(new Frutas("Romã", "Outono", 0.4));
        frutas.add(new Frutas("Banana", "Todo o ano", 1.1));
        frutas.add(new Frutas("Manga", "Verão", 1.0));
        frutas.add(new Frutas("Melancia", "Verão", 3.5));
        frutas.add(new Frutas("Laranja", "Inverno", 0.5));
        frutas.add(new Frutas("Pêra", "Outono", 0.8));
        frutas.add(new Frutas("Limão Siciliano", "Primavera", 0.4));

        new FrutasGUI(frutas);
    }
}

class Frutas {
    private String nome;
    private String epoca;
    private double peso;
    private ArrayList<String> historico;

    public Frutas(String nome, String epoca, double peso) {
        this.nome = nome;
        this.epoca = epoca;
        this.peso = peso;
        this.historico = new ArrayList<>();
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

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void atualizarPeso(double novoPeso) {
        this.peso = novoPeso;
        historico.add("Peso atualizado para: " + novoPeso + " kg");
    }
}
