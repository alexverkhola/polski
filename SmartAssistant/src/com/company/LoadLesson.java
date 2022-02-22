package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadLesson implements ActionListener {

    JFileChooser fileChooser = new JFileChooser();
    SmartAssistant parent;
    LoadLesson(SmartAssistant calculator) {
        this.parent = calculator;
    }

    // Write data to admin panel after data loading
    private void loadDataToAdminPanel(){
        parent.adminTextField.setText(parent.applicationData.lines.toString());
        parent.lessonNameLabel.setText(parent.applicationData.lessonName);

        parent.applicationData.currentLine += 1;
        //Set first sentence to admin text field
        parent.adminTextField.setText(parent.applicationData.currentLine + " " + parent.applicationData.lines.get(0));
        //Remove first sentence from list
        parent.applicationData.lines.remove(0);
        parent.countLinesLabel.setText("Total " + String.valueOf(parent.applicationData.lines.size() + " lines"));
    }

    private void resetApplicationData(){
        parent.applicationData.currentLine = 0;
        parent.applicationData.lines.clear();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

                resetApplicationData();
                int result = fileChooser.showOpenDialog(parent.buttonPanel);
                if (result== JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    parent.applicationData.lessonName = file.getName();

                    try (BufferedReader in = new BufferedReader(new FileReader(file))) {

                        String line = in.readLine(); // read a line at a time
                        while(line != null){ // loop till you have no more lines
                            parent.applicationData.lines.add(line); // add the line to your list
                            line = in.readLine(); // try to read another line
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                loadDataToAdminPanel();
    }
}
