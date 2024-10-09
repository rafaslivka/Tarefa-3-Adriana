package rock;

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
        JFrame frame = new JFrame("LockFist669");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel gifLabel = new JLabel(new ImageIcon("D:/banda.gif"));
        gifLabel.setBounds(50, 10, 400, 247);
        frame.add(gifLabel);

        JButton tocarMusicaButton = new JButton("Tocar música escolhida");
        tocarMusicaButton.setBounds(150, 300, 200, 30);
        frame.add(tocarMusicaButton);

        String[] musicas = {"Wasted", "Home-Cide"};
        JComboBox<String> comboMusicas = new JComboBox<>(musicas);
        comboMusicas.setBounds(150, 260, 200, 30);
        frame.add(comboMusicas);

        tocarMusicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String musicaSelecionada = (String) comboMusicas.getSelectedItem();
                String caminho = "D:/" + musicaSelecionada + ".wav";
                tocarMusica(caminho);
            }
        });

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
