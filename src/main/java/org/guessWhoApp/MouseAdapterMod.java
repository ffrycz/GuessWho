package org.guessWhoApp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAdapterMod extends MouseAdapter {
    public void mousePressed(MouseEvent e){
        PlayableCharacterPanel panel = (PlayableCharacterPanel) e.getSource();
        panel.onClick();
    }
}
