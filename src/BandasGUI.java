import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BandasGUI {
    private static String nomeBanda = "LockFist669";

    public static void main(String[] args) {
        // Criar a janela
        JFrame frame = new JFrame("Informações da Banda");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Criar o label para o nome da banda
        JLabel nomeLabel = new JLabel(nomeBanda);
        nomeLabel.setBounds(150, 50, 200, 30);
        frame.add(nomeLabel);

        // Criar o botão para tocar música
        JButton tocarMusicaButton = new JButton("Tocar Música Wasted");
        tocarMusicaButton.setBounds(100, 150, 200, 30);
        frame.add(tocarMusicaButton);

        // Ação do botão
        tocarMusicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tocarMusica("D:/Tarefa3Adriana/Wasted.wav"); // Caminho do arquivo WAV
            }
        });

        // Exibir a janela
        frame.setVisible(true);
    }

    private static void tocarMusica(String caminho) {
        try {
            File musica = new File(caminho);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
