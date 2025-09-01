package org.guessWhoApp;

import javax.swing.*;
import java.io.File;
import java.nio.file.FileSystemException;
import java.util.Arrays;

public class FileLoader {
    private final JFrame parentFrame;

    public FileLoader(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public String[] loadDirectory() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        try {
            int returnValue = chooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = chooser.getSelectedFile();
                System.out.println("Selected directory: " + selectedDirectory.getAbsolutePath());

                return getImages(selectedDirectory);
            }else{
                throw new FileSystemException("Operation cancelled.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parentFrame, "Błąd odczytu: " + e.getMessage());
            return null;
        }
    }

    public String[] getImages(File directory) {
        String[] imageList = directory.list();
        if (imageList.length > 24) {
            imageList = Arrays.stream(imageList).limit(24).toArray(String[]::new);
        }
        return Arrays.stream(imageList).map(file -> directory.getAbsolutePath() + "\\" + file).toArray(String[]::new);
    }
}
