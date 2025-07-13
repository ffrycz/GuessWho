package org.guessWhoApp;

import javax.swing.*;

public class Window extends JFrame {

    private String[] images;

    public Window() {

        super("Guess Who");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar bar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem openFile = new JMenuItem("Load...");
        fileMenu.add(openFile);
        bar.add(fileMenu);

        setJMenuBar(bar);

        FileLoader loader = new FileLoader(this);

        openFile.addActionListener(e -> {
            String[] imageList = loader.loadDirectory();
            if (imageList != null) {
                setImages(imageList);
            }
        });
    }

    public void setImages(String[] images){
        this.images = images;
    }
}
