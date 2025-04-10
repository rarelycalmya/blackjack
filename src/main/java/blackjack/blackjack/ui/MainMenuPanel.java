package blackjack.blackjack.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainMenuPanel extends BackgroundPanel {
    public MainMenuPanel(Runnable onPlay, Runnable onQuit) {
        super("bgimage.png");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        add(Box.createVerticalGlue());

        try {
            BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/static/titlecard.png"));
            Image scaledImg = img.getScaledInstance(400, 146, Image.SCALE_SMOOTH);
            ImageIcon titleIcon = new ImageIcon(scaledImg);
            JLabel titleLabel = new JLabel(titleIcon);
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(titleLabel);
            add(Box.createVerticalStrut(10));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageButton playBtn = new ImageButton("play.png", 400, 146);
        playBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        playBtn.addActionListener(e -> onPlay.run());
        add(playBtn);

        add(Box.createVerticalStrut(20));

        ImageButton quitBtn = new ImageButton("exit.png", 400, 146);
        quitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitBtn.addActionListener(e -> onQuit.run());
        add(quitBtn);

        add(Box.createVerticalGlue());
    }
}
