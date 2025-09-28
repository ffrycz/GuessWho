package org.guessWhoApp;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Window extends JFrame {

    private File[] images;

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
            File[] imageList = loader.loadDirectory();
            for (File image : imageList) {
                System.out.println(image);
            }
            if (imageList != null) {
                setImages(imageList);
                display();
            }
        });

        setVisible(true);
    }

    public void setImages(File[] images){
        this.images = images;
    }


    public void display() {
        for (File image : images) {
            add(new CharacterPanel(image));
            pack();

        }

    }
}
