import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EletronicosGUI {
    private JFrame frame;
    private JTextArea infoArea;
    private JTextArea historicoArea;
    private JComboBox<String> dispositivoMenu;
    private ArrayList<Eletronicos> dispositivos;

    public EletronicosGUI(ArrayList<Eletronicos> dispositivos) {
        this.dispositivos = dispositivos;
        criarInterface();
    }

    public void criarInterface() {
        // Criando a janela principal
        frame = new JFrame("Controle de Eletrônicos");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Área de exibição de informações
        infoArea = new JTextArea(5, 30);
        infoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Área de exibição do histórico
        historicoArea = new JTextArea(5, 30);
        historicoArea.setEditable(false);
        JScrollPane historicoScrollPane = new JScrollPane(historicoArea);
        panel.add(historicoScrollPane, BorderLayout.SOUTH);

        // Menu de seleção de dispositivo
        dispositivoMenu = new JComboBox<>();
        for (Eletronicos dispositivo : dispositivos) {
            dispositivoMenu.addItem(dispositivo.getNome());
        }

        dispositivoMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarInfo();
                atualizarHistorico();
            }
        });

        // Botões de ação
        JPanel buttonPanel = new JPanel();
        JButton ligarButton = new JButton("Ligar");
        JButton desligarButton = new JButton("Desligar");
        JButton usarButton = new JButton("Usar por 10 minutos");
        JButton mostrarInfoButton = new JButton("Mostrar Informações");

        ligarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Eletronicos dispositivoSelecionado = getDispositivoSelecionado();
                if (dispositivoSelecionado != null) {
                    dispositivoSelecionado.ligar();
                    atualizarHistorico();
                }
            }
        });

        desligarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Eletronicos dispositivoSelecionado = getDispositivoSelecionado();
                if (dispositivoSelecionado != null) {
                    dispositivoSelecionado.desligar();
                    atualizarHistorico();
                }
            }
        });

        usarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Eletronicos dispositivoSelecionado = getDispositivoSelecionado();
                if (dispositivoSelecionado != null) {
                    dispositivoSelecionado.usar(10);
                    atualizarHistorico();
                }
            }
        });

        mostrarInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarInfo();
            }
        });

        buttonPanel.add(dispositivoMenu);
        buttonPanel.add(ligarButton);
        buttonPanel.add(desligarButton);
        buttonPanel.add(usarButton);
        buttonPanel.add(mostrarInfoButton);

        panel.add(buttonPanel, BorderLayout.NORTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    public Eletronicos getDispositivoSelecionado() {
        String nomeSelecionado = (String) dispositivoMenu.getSelectedItem();
        for (Eletronicos dispositivo : dispositivos) {
            if (dispositivo.getNome().equals(nomeSelecionado)) {
                return dispositivo;
            }
        }
        return null;
    }

    public void atualizarInfo() {
        Eletronicos dispositivoSelecionado = getDispositivoSelecionado();
        if (dispositivoSelecionado != null) {
            infoArea.setText("");
            infoArea.append("Nome: " + dispositivoSelecionado.getNome() + "\n");
            infoArea.append("Marca: " + dispositivoSelecionado.getMarca() + "\n");
            infoArea.append("Armazenamento: " + dispositivoSelecionado.getArmazenamento() + " GB\n");
            infoArea.append("Bateria: " + dispositivoSelecionado.getBateria() + "%\n");
        }
    }

    public void atualizarHistorico() {
        Eletronicos dispositivoSelecionado = getDispositivoSelecionado();
        if (dispositivoSelecionado != null) {
            historicoArea.setText("");
            ArrayList<String> historico = dispositivoSelecionado.getHistoricoUso();
            for (String evento : historico) {
                historicoArea.append(evento + "\n");
            }
        }
    }

    public static void main(String[] args) {
        // Criando vários dispositivos
        ArrayList<Eletronicos> dispositivos = new ArrayList<>();
        dispositivos.add(new Eletronicos("Controle de PS4", "Sony", 0));
        dispositivos.add(new Eletronicos("Caixa de Som JBL", "JBL", 0));
        dispositivos.add(new Eletronicos("Câmera Digital", "Canon", 32));
        dispositivos.add(new Eletronicos("Celular", "Samsung", 128));
        dispositivos.add(new Eletronicos("Projetor", "Epson", 0));
        dispositivos.add(new Eletronicos("Fone de Ouvido", "Sony", 0));

        new EletronicosGUI(dispositivos);
    }
}

class Eletronicos {
    private String nome;
    private String marca;
    private int armazenamento;
    private int bateria; // Nível de bateria de 0 a 100
    private ArrayList<String> historicoUso;

    public Eletronicos(String nome, String marca, int armazenamento) {
        this.nome = nome;
        this.marca = marca;
        this.armazenamento = armazenamento;
        this.bateria = 100; // Bateria inicial cheia
        this.historicoUso = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public int getBateria() {
        return bateria;
    }

    public ArrayList<String> getHistoricoUso() {
        return historicoUso;
    }

    public void ligar() {
        if (bateria > 0) {
            System.out.println(nome + " está agora LIGADO.");
            historicoUso.add(nome + " foi ligado.");
        } else {
            System.out.println(nome + " não pode ser ligado. Bateria esgotada.");
        }
    }

    public void desligar() {
        System.out.println(nome + " está agora DESLIGADO.");
        historicoUso.add(nome + " foi desligado.");
    }

    public void usar(int duracao) {
        if (bateria <= 0) {
            System.out.println(nome + " não pode ser usado. Bateria esgotada.");
            return;
        }
        int consumo = duracao; // Consome 1% de bateria por minuto
        bateria -= consumo;
        if (bateria < 0) {
            bateria = 0;
        }
        System.out.println(nome + " foi usado por " + duracao + " minutos. Bateria restante: " + bateria + "%.");
        historicoUso.add(nome + " foi usado por " + duracao + " minutos.");
    }
}
