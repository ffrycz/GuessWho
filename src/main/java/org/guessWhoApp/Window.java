package org.guessWhoApp;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private String[] images;

    public Window() {

        super("Guess Who");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JMenuBar bar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem openFile = new JMenuItem("Load...");
        fileMenu.add(openFile);
        bar.add(fileMenu);

        setJMenuBar(bar);

        FileLoader loader = new FileLoader(this);

        openFile.addActionListener(e -> {
            String[] imageList = loader.loadDirectory();
            for (String image : imageList) {
                System.out.println(image);
            }
            if (imageList != null) {
                setImages(imageList);
                display();
            }
        });

        setVisible(true);
    }

    public void setImages(String[] images){
        this.images = images;
    }


    public void display() {
        for (String image : images) {
            add(new CharacterPanel(image));
            pack();

        }

    }
}
