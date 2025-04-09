package blackjack.blackjack.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

public class ImageButton extends JButton {
    private ImageIcon normalIcon, hoverIcon, clickedIcon;

    public ImageButton(String imageName) {
        try {
            BufferedImage base = ImageIO.read(getClass().getResourceAsStream("/static/" + imageName));
            normalIcon = new ImageIcon(base);

            Image hoverImg = base.getScaledInstance((int)(base.getWidth() * 1.05), (int)(base.getHeight() * 1.05), Image.SCALE_SMOOTH);
            hoverIcon = new ImageIcon(hoverImg);

            BufferedImage inverted = invertImageColors(base);
            clickedIcon = new ImageIcon(inverted);

        } catch (IOException e) {
            e.printStackTrace();
        }

        setIcon(normalIcon);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { setIcon(hoverIcon); }
            @Override public void mouseExited(MouseEvent e) { setIcon(normalIcon); }
            @Override public void mousePressed(MouseEvent e) { setIcon(clickedIcon); }
            @Override public void mouseReleased(MouseEvent e) {
                Timer t = new Timer(100, evt -> setIcon(hoverIcon));
                t.setRepeats(false);
                t.start();
            }
        });
    }

    private BufferedImage invertImageColors(BufferedImage img) {
        BufferedImage inverted = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < img.getHeight(); y++)
            for (int x = 0; x < img.getWidth(); x++) {
                int rgba = img.getRGB(x, y);
                Color col = new Color(rgba, true);
                Color inv = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue(), col.getAlpha());
                inverted.setRGB(x, y, inv.getRGB());
            }
        return inverted;
    }
}
