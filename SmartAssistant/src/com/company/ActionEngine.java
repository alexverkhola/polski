package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ActionEngine implements ActionListener {

    SmartAssistant parent;
    public ActionEngine(SmartAssistant parent) {
        this.parent = parent;
    }

    // Set to videopanel line of text
    private void addTextToVideoPanel() {

        // Если в строке есть символ # тогда это комментарий, и строка пропускается
        // Мы не ищем символ # в начале строки, пото му что там в начале будет стоять цифра с номером строки
        if (parent.adminTextField.getText().contains("#")) {
            System.out.println("Skip");
            return;
        }

        // Take string from admin window, split - take second part of string, and after strip spaces
        String word = parent.adminTextField.getText().split(":")[1].strip();
        Random random = new Random();


        String text = parent.videoTextField.getText();
        for (int i = 0; i < word.length(); i++) {

            // Разграничитель для диалогов
            if (word.charAt(i) == '\\' && word.charAt(i+1) == 'n') {
                text += "\n";
                // Сдвиг для того что  бы не печатался переход на новую строку
                i += 2;
//                break;
            }
            text = text + word.charAt(i);
            parent.videoTextField.setText(text);
            parent.videoTextField.update(parent.videoTextField.getGraphics());
            try {
                int timeSleep =  random.nextInt(200 - 50) + 50;
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Go to next line
        text = text + "\n";
        parent.videoTextField.setText(text);

    }

    private void loadDataToAdminPanel(){

        parent.adminTextField.setText(parent.applicationData.lines.toString());
        parent.lessonNameLabel.setText(parent.applicationData.lessonName);

        //Set first sentence to admin text field
        parent.applicationData.currentLine += 1;
        int lineNumber = parent.applicationData.currentLine;
        String text = new String(lineNumber + " "  + parent.applicationData.lines.get(0));

        parent.adminTextField.setText(text);
        //Remove first sentence from list
        parent.applicationData.lines.remove(0);

        parent.countLinesLabel.setText("Total " + String.valueOf(parent.applicationData.lines.size() + " lines"));


    }

    private void clearVideoPanel() {
        parent.videoTextField.setText("");
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand() == "Clear") {
            clearVideoPanel();
        } else {
            addTextToVideoPanel();
            loadDataToAdminPanel();
        }
    }
}
