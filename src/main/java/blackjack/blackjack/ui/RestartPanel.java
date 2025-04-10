package blackjack.blackjack.ui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;



public class RestartPanel extends BackgroundPanel {
    public RestartPanel(Runnable onRestart, Runnable onQuit) {
        super("bgimage.png");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        add(Box.createVerticalGlue());

        try {
            BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/static/loser.png"));
            Image scaledImg = img.getScaledInstance(400, 146, Image.SCALE_SMOOTH);
            ImageIcon titleIcon = new ImageIcon(scaledImg);
            JLabel titleLabel = new JLabel(titleIcon);
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(titleLabel);
            add(Box.createVerticalStrut(10));
        } catch (IOException e) {
            e.printStackTrace();
        }


        ImageButton restartBtn = new ImageButton("playag.png", 400, 146);
        restartBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        restartBtn.addActionListener(e -> onRestart.run());
        add(restartBtn);
        add(Box.createVerticalStrut(15));

        ImageButton quitBtn = new ImageButton("exit.png", 400, 146);
        quitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitBtn.addActionListener(e -> onQuit.run());
        add(quitBtn);

        add(Box.createVerticalGlue());
    }
}

