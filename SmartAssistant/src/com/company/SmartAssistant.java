package com.company;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SmartAssistant {
    JPanel buttonPanel = new JPanel();

    JTextArea videoTextField = new JTextArea();
    JTextArea adminTextField = new JTextArea();

    JButton nextButton = new JButton("Next");
    JButton clearButton = new JButton("Clear");
    JButton record = new JButton("Record");
    JButton load = new JButton("Load");
    JLabel lessonNameLabel = new JLabel();
    JLabel countLinesLabel = new JLabel();

    ApplicationData applicationData = new ApplicationData();


        SmartAssistant() {

            JPanel mainPanel = new JPanel();
            JPanel videoPanel = new JPanel();
            JPanel adminPanel = new JPanel();


            BorderLayout borderLayout = new BorderLayout(2, 2);
            mainPanel.setLayout(borderLayout);

            GridLayout gridLayout = new GridLayout();
            videoPanel.setLayout(gridLayout);
            adminPanel.setLayout(gridLayout);

            FlowLayout flowLayout = new FlowLayout();
            buttonPanel.setLayout(flowLayout);


            videoTextField.setBorder(new EmptyBorder(40, 40, 20, 20));
            videoTextField.setFont(new Font("Arial", Font.PLAIN, applicationData.fontVideoPanel));
            videoPanel.add(videoTextField);

            ActionEngine actionEngine = new ActionEngine(this);
            nextButton.addActionListener(actionEngine);
            clearButton.addActionListener(actionEngine);

            LoadLesson loadLesson = new LoadLesson(this);
            load.addActionListener(loadLesson);

            buttonPanel.add(nextButton);
            buttonPanel.add(clearButton);
            buttonPanel.add(record);
            buttonPanel.add(load);
            buttonPanel.add(lessonNameLabel);
            buttonPanel.add(countLinesLabel);

            adminTextField.setBorder(new EmptyBorder(40, 40, 20, 20));
            adminTextField.setFont(new Font("Arial", Font.PLAIN, applicationData.fontVideoPanel));
            adminPanel.add(adminTextField);
            adminPanel.add(buttonPanel);
            adminPanel.setPreferredSize(new Dimension(1000, 300));


            mainPanel.add(videoPanel, BorderLayout.CENTER);
            mainPanel.add(adminPanel, BorderLayout.PAGE_END);

            // Get full dimension of monitor
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            JFrame frame = new JFrame();
            frame.setSize(screenSize.width, screenSize.height);
            frame.add(mainPanel);
            frame.setVisible(true);
        }



    public static void main(String[] args) {
        SmartAssistant calculator = new SmartAssistant();
//        ListFonts listFonts = new ListFonts();
//        listFonts.getFonts();
    }
}