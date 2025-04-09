package blackjack.blackjack.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class CardComponent extends JComponent {
    private String rank;
    private String suit;
    private Image cardBase;
    private Image suitImage;

    public CardComponent(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;

        try {
            cardBase = ImageIO.read(getClass().getResourceAsStream("/static/cardtemplate.png"));
            suitImage = ImageIO.read(getClass().getResourceAsStream("/static/" + suit + "pxl.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setPreferredSize(new Dimension(100, 150));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(cardBase, 0, 0, getWidth(), getHeight(), this);

        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.setColor(suit.equals("hearts") || suit.equals("diamonds") ? Color.RED : Color.BLACK);
        g.drawString(rank, 10, 25);

        g.drawImage(suitImage, getWidth() / 2 - 12, getHeight() / 2, 24, 24, this);
    }
}

