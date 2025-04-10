package blackjack.blackjack.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

public class ImageButton extends JButton {
    private ImageIcon normalIcon, hoverIcon, clickedIcon;

    public ImageButton(String imageName, int width, int height) {
        try {
            BufferedImage base = ImageIO.read(getClass().getResourceAsStream("/static/" + imageName));

            // Scale base image
            Image scaledBase = base.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            normalIcon = new ImageIcon(scaledBase);

            // Hover image slightly larger
            Image hoverImg = base.getScaledInstance((int)(width * 1.05), (int)(height * 1.05), Image.SCALE_SMOOTH);
            hoverIcon = new ImageIcon(hoverImg);

            // Inverted and scaled click image
            BufferedImage inverted = invertImageColors(base);
            Image scaledInverted = inverted.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            clickedIcon = new ImageIcon(scaledInverted);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set default icon and button styling
        setIcon(normalIcon);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Restrict button size


        // Mouse events
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
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                int rgba = img.getRGB(x, y);
                Color col = new Color(rgba, true);
                Color inv = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue(), col.getAlpha());
                inverted.setRGB(x, y, inv.getRGB());
            }
        }
        return inverted;
    }
}
