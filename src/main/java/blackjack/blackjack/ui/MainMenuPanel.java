package blackjack.blackjack.ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends BackgroundPanel {
    public MainMenuPanel(Runnable onPlay, Runnable onQuit) {
        super("bgimage.png");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        add(Box.createVerticalGlue());

        JLabel title = new JLabel("BLACKJACK");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.BOLD, 48));
        title.setForeground(Color.WHITE);
        add(title);
        add(Box.createVerticalStrut(30));

        ImageButton playBtn = new ImageButton("play.png");
        playBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        playBtn.addActionListener(e -> onPlay.run());
        add(playBtn);

        add(Box.createVerticalStrut(20));

        ImageButton quitBtn = new ImageButton("exit.png");
        quitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitBtn.addActionListener(e -> onQuit.run());
        add(quitBtn);

        add(Box.createVerticalGlue());
    }
}
