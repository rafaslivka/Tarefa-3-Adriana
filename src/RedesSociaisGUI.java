import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedesSociaisGUI extends JFrame {
    private JComboBox<String> comboBoxRedes;
    private JTextArea infoArea;
    private JTextField mensagemField;
    private RedesSociais[] redes;

    public RedesSociaisGUI() {
        // Inicializa as redes sociais
        redes = new RedesSociais[]{
                new RedesSociais("user_twitter", 1200, 2009),
                new RedesSociais("user_instagram", 3400, 2012),
                new RedesSociais("user_linkedin", 1500, 2007),
                new RedesSociais("user_pinterest", 900, 2010),
                new RedesSociais("user_tiktok", 5000, 2016),
                new RedesSociais("user_facebook", 2400, 2006),
                new RedesSociais("user_whatsapp", 3000, 2013),
                new RedesSociais("user_youtube", 4500, 2005)
        };

        // Configurações da janela
        setTitle("Gerenciamento de Redes Sociais");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior (ComboBox para seleção de redes sociais)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        comboBoxRedes = new JComboBox<>();
        for (RedesSociais rede : redes) {
            comboBoxRedes.addItem(rede.getNomeUsuario());
        }
        comboBoxRedes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacoesRede();
            }
        });
        topPanel.add(new JLabel("Selecione uma rede social:"));
        topPanel.add(comboBoxRedes);
        add(topPanel, BorderLayout.NORTH);

        // Área de texto para exibir informações
        infoArea = new JTextArea(8, 30);
        infoArea.setEditable(false);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);

        // Painel inferior (enviar mensagem e seguir)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        bottomPanel.add(new JLabel("Mensagem:"));
        mensagemField = new JTextField(15);
        bottomPanel.add(mensagemField);

        JButton enviarBtn = new JButton("Enviar Mensagem");
        enviarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarMensagem();
            }
        });
        bottomPanel.add(enviarBtn);

        JButton seguirBtn = new JButton("Seguir");
        seguirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seguirUsuario();
            }
        });
        bottomPanel.add(seguirBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        // Exibir informações iniciais
        mostrarInformacoesRede();
    }

    // Mostra as informações da rede social selecionada
    private void mostrarInformacoesRede() {
        int selectedIndex = comboBoxRedes.getSelectedIndex();
        RedesSociais rede = redes[selectedIndex];
        infoArea.setText("Nome de Usuário: " + rede.getNomeUsuario() + "\n"
                + "Número de Seguidores: " + rede.getNumeroSeguidores() + "\n"
                + "Ano de Criação: " + rede.getAnoCriacao());
    }

    // Envia uma mensagem para o usuário da rede social selecionada
    private void enviarMensagem() {
        int selectedIndex = comboBoxRedes.getSelectedIndex();
        RedesSociais rede = redes[selectedIndex];
        String mensagem = mensagemField.getText();
        if (!mensagem.isEmpty()) {
            rede.enviarMensagem(mensagem);
            JOptionPane.showMessageDialog(this, "Mensagem enviada: " + mensagem);
            mensagemField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma mensagem.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Segue o usuário da rede social selecionada
    private void seguirUsuario() {
        int selectedIndex = comboBoxRedes.getSelectedIndex();
        RedesSociais rede = redes[selectedIndex];
        rede.seguir();
        JOptionPane.showMessageDialog(this, "Agora você está seguindo: " + rede.getNomeUsuario());
    }

    // Classe RedesSociais
    class RedesSociais {
        private String nomeUsuario;
        private int numeroSeguidores;
        private int anoCriacao;

        public RedesSociais(String nomeUsuario, int numeroSeguidores, int anoCriacao) {
            this.nomeUsuario = nomeUsuario;
            this.numeroSeguidores = numeroSeguidores;
            this.anoCriacao = anoCriacao;
        }

        public String getNomeUsuario() {
            return nomeUsuario;
        }

        public int getNumeroSeguidores() {
            return numeroSeguidores;
        }

        public int getAnoCriacao() {
            return anoCriacao;
        }

        public void mostrarInformacoes() {
            System.out.println("Nome de Usuário: " + nomeUsuario);
            System.out.println("Número de Seguidores: " + numeroSeguidores);
            System.out.println("Ano de Criação: " + anoCriacao);
        }

        public void enviarMensagem(String mensagem) {
            System.out.println("Mensagem enviada para " + nomeUsuario + ": " + mensagem);
        }

        public void seguir() {
            System.out.println("Agora você está seguindo " + nomeUsuario + "!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RedesSociaisGUI().setVisible(true);
            }
        });
    }
}
