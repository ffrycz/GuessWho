package org.guessWhoApp;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PlayableCharacterPanel extends CharacterPanel{
    private boolean isCrossed = false;
    private final JPanel crossedPanel = new JPanel();

    public PlayableCharacterPanel(File image){
        super(image);
        crossedPanel.setBackground(Color.RED);
        crossedPanel.setPreferredSize(new Dimension(180, 300));
        crossedPanel.setBounds(0, 0, 180, 300);
        crossedPanel.setOpaque(true);
        add(crossedPanel);
        crossedPanel.setVisible(isCrossed);

    }

    private void toggleCrossed(){
        isCrossed = !isCrossed;
    }

    public void onClick(){
        toggleCrossed();
        crossedPanel.setVisible(!isCrossed);
    }
}
