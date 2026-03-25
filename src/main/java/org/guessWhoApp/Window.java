package org.guessWhoApp;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class Window extends JFrame {

    private File[] images;
    private File guess;
    MouseAdapterMod mam = new MouseAdapterMod();

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
                setGuess();
                display();
            }
        });

        setVisible(true);
    }

    public void setImages(File[] images){
        this.images = images;
    }

    private void setGuess(){
        Random rand = new Random();
        int index = rand.nextInt(this.images.length);

        this.guess = images[index];
    }


    public void display() {
        setLayout(new GridLayout(2, 1));

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new FlowLayout());

        JPanel guessPanel = new JPanel();
//        guessPanel.setLayout(new BorderLayout(5,5));


        for (File image : images) {
            PlayableCharacterPanel pcp = new PlayableCharacterPanel(image);
            pcp.addMouseListener(mam);
            gamePanel.add(pcp);
//            gamePanel.pack();
        }

        guessPanel.add(new CharacterPanel(this.guess));

        add(gamePanel);
        add(guessPanel);

        pack();


    }
}
