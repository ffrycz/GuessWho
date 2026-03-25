package org.guessWhoApp;

import ij.IJ;
import ij.ImagePlus;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CharacterPanel extends JLayeredPane {
    private ImagePlus image;
    private String name;
    final private String path;

    public CharacterPanel(File image) {
        this.path = image.getAbsolutePath();
        this.image = IJ.openImage(path);
        this.name = image.getName().replaceFirst("[.][^.]+$", "");
        setPreferredSize(new Dimension(180, 300));
        setBounds(0, 0, 180, 300);
        setOpaque(true);
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

        double imgAspect = (double) image.getWidth() / image.getHeight();
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

        g.drawImage(image.getImage(), drawX, drawY, drawWidth, drawHeight, this);
    }
}
