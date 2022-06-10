/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.controllers;

/**
 *
 * @author holy
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LandingPage implements ActionListener{

    private JFrame frame;
    private JButton adminBtn;
    private JButton teacherBtn;
    private JButton studentBtn;
    private JPanel panel;

    public LandingPage(){
       
        //Frame
        frame  = new JFrame();
        frame.setLayout(null);
        frame.setSize(1200, 1200);
        frame.setTitle("Login Page");

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1200, 1200);

        adminBtn = new JButton("Admin");
        teacherBtn = new JButton("Teacher");
        studentBtn = new JButton("Student");
        adminBtn.setBounds(400, 200, 90, 30);
        teacherBtn.setBounds(500, 200, 90, 30);
        studentBtn.setBounds(600, 200, 90, 30);        
        adminBtn.setBackground(Color.GREEN);
        teacherBtn.setBackground (Color.GREEN);
        studentBtn.setBackground(Color.GREEN);

        adminBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Login login1 = new Login("admin");
                login1.getPanel().setBounds(0, 0, 1200, 1200);
                panel.setVisible(false);
                frame.add(login1.getPanel());
            }
        });
        teacherBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Login login2 = new Login("teacher");
                login2.getPanel().setBounds(0, 0, 1200, 1200);
                panel.setVisible(false);
                frame.add(login2.getPanel());
            }
        });
        studentBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Login login3 = new Login("student");
                login3.getPanel().setBounds(0, 0, 1200, 1200);
                panel.setVisible(false);
                frame.add(login3.getPanel());    
                
            }
        });
        panel.add(adminBtn);
        panel.add(studentBtn);
        panel.add(teacherBtn);
        frame.add(panel);

        frame.setVisible(true);
    
    }
    public JFrame getFrame() {
        return this.frame;
    }
    public void actionPerformed(ActionEvent ae){
        
    }
}
