package client.controllers;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StudentPage {
    private JPanel panel;
    private JButton button;
    StudentPage(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1200, 1200);
        panel.setBackground(Color.GREEN);

        button = new JButton("Check");
        button.setBounds(400, 200, 90, 30);

        panel.add(button);
    }
    JPanel getPanel(){
        return this.panel;
    }
}
