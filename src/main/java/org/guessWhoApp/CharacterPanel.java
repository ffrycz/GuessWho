package org.guessWhoApp;

import javax.swing.*;
import java.awt.*;

public class CharacterPanel extends JPanel {
    private Image image;
    private String name;

    public CharacterPanel(String imagePath) {
        this.image = new ImageIcon(imagePath).getImage();
        this.name = imagePath.replaceFirst("[.][^.]+$", "");
        setPreferredSize(new Dimension(180, 300));
        setLayout(new BorderLayout());

        JLabel label = new JLabel(name, SwingConstants.CENTER);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        add(label, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cardWidth = getWidth();
        int imageHeight = getHeight() - 40;

        double imgAspect = (double) image.getWidth(null) / image.getHeight(null);
        double panelAspect = (double) cardWidth / imageHeight;

        int drawWidth, drawHeight, drawX, drawY;

        if (imgAspect > panelAspect) {
            drawHeight = imageHeight;
            drawWidth = (int) (imageHeight * imgAspect);
            drawX = (cardWidth - drawWidth) / 2;
            drawY = 0;
        } else {
            drawWidth = cardWidth;
            drawHeight = (int) (cardWidth / imageHeight);
            drawX = 0;
            drawY = (imageHeight - drawHeight) / 2;
        }

        g.drawImage(image, drawX, drawY, drawWidth, drawHeight, this);
    }
}
