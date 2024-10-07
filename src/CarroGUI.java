import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// javax.swing.*: Importa todos os componentes gráficos que usamos para criar a interface, como botões, janelas, rótulos e áreas de texto.
// java.awt.*: Importa classes que nos permitem desenhar gráficos e definir cores.
// java.awt.event.ActionEvent: Representa o evento de clique no botão.
// java.awt.event.ActionListener: Interface que nos permite reagir a eventos de clique no botão (executando código quando o botão é pressionado).

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

class CarPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Aqui eu tentei fazer um desenho simples do carro kkkkk
        g.setColor(Color.BLUE);
        g.fillRect(50, 100, 200, 50); // "corpo" do carro
        g.setColor(Color.BLACK);
        g.fillOval(60, 150, 50, 50); // Roda 1
        g.fillOval(190, 150, 50, 50); // Roda 2
        
    }
}

//A classe CarroGUI cria uma interface gráfica para o cadastro de carros. 
//O método main inicializa a aplicação, configurando a janela principal (JFrame) 
//com rótulos (JLabel) e campos de texto (JTextField) para entrada de dados como nome, 
//modelo e ano do carro. Um botão (JButton) é adicionado para cadastrar as informações, 
//que são exibidas em uma área de texto (JTextArea). Além disso, um painel (CarPanel) 
//é incluído para representar graficamente o carro. Ao clicar no botão de cadastrar, 
//os dados inseridos são capturados, um objeto Carros é criado, e as informações do carro 
//são exibidas na área de resultados.

public class CarroGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Carros");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50, 50, 80, 25);
        frame.add(nomeLabel);

        JTextField nomeField = new JTextField();
        nomeField.setBounds(150, 50, 180, 25);
        frame.add(nomeField);

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setBounds(50, 100, 80, 25);
        frame.add(modeloLabel);

        JTextField modeloField = new JTextField();
        modeloField.setBounds(150, 100, 180, 25);
        frame.add(modeloField);

        JLabel anoLabel = new JLabel("Ano:");
        anoLabel.setBounds(50, 150, 80, 25);
        frame.add(anoLabel);

        JTextField anoField = new JTextField();
        anoField.setBounds(150, 150, 180, 25);
        frame.add(anoField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(50, 200, 120, 25);
        frame.add(cadastrarButton);

        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setBounds(50, 250, 280, 80);
        frame.add(resultadoArea);

        CarPanel carPanel = new CarPanel();
        carPanel.setBounds(350, 100, 300, 200);
        frame.add(carPanel);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String modelo = modeloField.getText();
                int ano = Integer.parseInt(anoField.getText());

                Carros carro = new Carros(nome, modelo, ano);
                resultadoArea.setText(carro.mostrarInformacoes());
                carPanel.repaint(); // desenhar de novo o painel
            }
        });

        frame.setVisible(true);
        
     // O método frame.setVisible(true); torna a janela (JFrame) visível na tela. 
     // Sem essa linha, a janela é configurada, mas não será exibida ao usuário. 
     // É essencial chamar este método para que a interface gráfica apareça e 
     // permita a interação do usuário com a aplicação.
        
    }
}
