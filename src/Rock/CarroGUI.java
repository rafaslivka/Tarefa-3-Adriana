import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Carros {
    private String nome;
    private String modelo;
    private int ano;

    public Carros(String nome, String modelo, int ano) {
        this.nome = nome;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String mostrarInformacoes() {
        return "Carro: " + nome + "\nModelo: " + modelo + "\nAno: " + ano;
    }

    public void ligar() {
        System.out.println(nome + " está ligado.");
    }

    public void desligar() {
        System.out.println(nome + " está desligado.");
    }
}

public class CarroGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Carros");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel gifLabel = new JLabel(new ImageIcon("D:/tarefa3/carros.gif")); // Caminho do GIF
        gifLabel.setBounds(50, 10, 500, 200); // Ajuste o tamanho do GIF
        frame.add(gifLabel);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50, 220, 80, 25);
        frame.add(nomeLabel);

        JTextField nomeField = new JTextField();
        nomeField.setBounds(150, 220, 180, 25);
        frame.add(nomeField);

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setBounds(50, 260, 80, 25);
        frame.add(modeloLabel);

        JTextField modeloField = new JTextField();
        modeloField.setBounds(150, 260, 180, 25);
        frame.add(modeloField);

        JLabel anoLabel = new JLabel("Ano:");
        anoLabel.setBounds(50, 300, 80, 25);
        frame.add(anoLabel);

        JTextField anoField = new JTextField();
        anoField.setBounds(150, 300, 180, 25);
        frame.add(anoField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(50, 340, 120, 25);
        frame.add(cadastrarButton);

        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setBounds(50, 370, 280, 80);
        resultadoArea.setLineWrap(true);
        resultadoArea.setWrapStyleWord(true);
        frame.add(resultadoArea);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String modelo = modeloField.getText();
                int ano = Integer.parseInt(anoField.getText());

                Carros carro = new Carros(nome, modelo, ano);
                resultadoArea.setText(carro.mostrarInformacoes());
            }
        });

        frame.setVisible(true);
    }
}
