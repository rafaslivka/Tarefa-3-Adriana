import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TimesGUI extends JFrame {
    private JButton tocarHinoButton;
    private Times corinthians;

    public TimesGUI() {
        corinthians = new Times("Corinthians", 30, 30); // Exemplo de instância

        // Configurações da janela
        setTitle("CORINTHIANS O MAIOR DE TODOS!");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Criação do botão
        tocarHinoButton = new JButton("Tocar o hino mais lindo do mundo");
        tocarHinoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                corinthians.tocarHino();
            }
        });

        // Adiciona o botão à janela
        add(tocarHinoButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TimesGUI gui = new TimesGUI();
                gui.setVisible(true);
            }
        });
    }
}

class Times {
    private String nome;
    private int titulos;
    private int quantidadeMembros;

    public Times(String nome, int titulos, int quantidadeMembros) {
        this.nome = nome;
        this.titulos = titulos;
        this.quantidadeMembros = quantidadeMembros;
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Títulos: " + titulos);
        System.out.println("Quantidade de Membros: " + quantidadeMembros);
    }

    public void tocarHino() {
        try {
            // Caminho completo para o arquivo WAV
            File hinoFile = new File("D:/Tarefa3Adriana/hino_corinthians.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(hinoFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            System.out.println("Tocando o hino do " + nome + "...");
            // Esperar o hino terminar
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
