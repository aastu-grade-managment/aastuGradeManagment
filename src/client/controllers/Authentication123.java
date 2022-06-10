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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.*;


import shared.remoteInterface.authenticationInterface;
public class Authentication123 extends JFrame implements ActionListener{

    private Registry registry;
    private authenticationInterface authenticationStub;
    
    private JFrame frame;
    //1.Authentication
    private JButton adminBtn;
    private JButton teacherBtn;
    private JButton studentBtn;

    private JPanel authentPanel;
    private JPanel adminPanel;
    private JPanel teacherPanel;
    private JPanel studentPanel;

    //2. Login Componenet
    private JLabel userNameLbl;
    private JLabel passwordLbl;
    private JTextField userNameTxt;
    private JPasswordField passwordTxt;
    private JButton adminLoginBtn;
    private JButton teacherLoginBtn;
    private JButton studentLoginBtn;

    public Authentication123(){
        try {
           // registry = LocateRegistry.getRegistry("localhost", 2020);
            //authenticationStub = (authenticationInterface)registry.lookup("login");
        } catch (Exception e) {
            System.out.println(e);
        }

        //Frame
        frame  = new JFrame();
        frame.setLayout(null);
        frame.setSize(1200, 1200);
        frame.setTitle("Login Page");

        adminBtn = new JButton("Admin");
        teacherBtn = new JButton("Teacher");
        studentBtn = new JButton("Student");
        adminBtn.setBounds(200, 200, 90, 30);
        teacherBtn.setBounds(300, 200, 90, 30);
        studentBtn.setBounds(400, 200, 90, 30);        
        adminBtn.setBackground(Color.GREEN);
        teacherBtn.setBackground (Color.GREEN);
        studentBtn.setBackground(Color.GREEN);

        
        
        authentPanel = new JPanel();
        adminPanel = new JPanel();
        teacherPanel = new JPanel();
        studentPanel = new JPanel();

        authentPanel.setLayout(null);
        adminPanel.setLayout(null);
        teacherPanel.setLayout(null);
        studentPanel.setLayout(null);

        authentPanel.setBounds(0, 0, 1200, 1200);
        adminPanel.setBounds(0, 0, 1200, 1200);
        teacherPanel.setBounds(0, 0, 1200, 1200);
        studentPanel.setBounds(0, 0, 1200, 1200);

        adminPanel.setVisible(false);
        teacherPanel.setVisible(false);
        studentPanel.setVisible(false);

        // adminPanel.setBackground (Color.GREEN);
        // teacherPanel.setBackground (Color.GREEN);
        // studentPanel.setBackground (Color.green);
       
        userNameLbl = new JLabel("User Name");
        passwordLbl = new JLabel("Password");
        userNameTxt = new JTextField();
        passwordTxt = new JPasswordField(26);

        adminLoginBtn = new JButton("Login");
        teacherLoginBtn = new JButton("Login");
        studentLoginBtn = new JButton("Login");

        userNameLbl.setBounds(400, 200, 90, 30);
        userNameTxt.setBounds(500, 200, 120, 30);
        passwordLbl.setBounds(400, 240, 90, 30);
        passwordTxt.setBounds(500, 240, 120, 30);

        adminLoginBtn.setBounds(500, 280, 90, 30);
        teacherLoginBtn.setBounds(500, 280, 90, 30);
        studentLoginBtn.setBounds(500, 280, 90, 30);

        //Authentication
        authentPanel.add(adminBtn);
        authentPanel.add(teacherBtn);
        authentPanel.add(studentBtn);
        //Admin login
        adminPanel.add(userNameLbl);
        adminPanel.add(passwordLbl);
        adminPanel.add(userNameTxt);
        adminPanel.add(passwordTxt);
        adminPanel.add(adminLoginBtn);
        
        //Teacher login
        // teacherPanel.add(userNameLbl);
        // teacherPanel.add(passwordLbl);
        // teacherPanel.add(userNameTxt);
        // teacherPanel.add(passwordTxt);
        // teacherPanel.add(teacherLoginBtn);

        //Student login
        // studentPanel.add(userNameLbl);
        // studentPanel.add(passwordLbl);
        // studentPanel.add(userNameTxt);
        // studentPanel.add(passwordTxt);
        // studentPanel.add(studentLoginBtn);


        frame.add(authentPanel);
        frame.add(adminPanel);
        frame.add(teacherPanel);
        frame.add(studentPanel);

        adminBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                adminPanel.setVisible(true);
                studentPanel.setVisible(false);
                teacherPanel.setVisible(false);
                authentPanel.setVisible(false);
            }
        });
        teacherBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                adminPanel.setVisible(false);
                studentPanel.setVisible(false);
                teacherPanel.setVisible(true);
                authentPanel.setVisible(false);
            }
        });
        studentBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                adminPanel.setVisible(false);
                studentPanel.setVisible(true);
                teacherPanel.setVisible(false);
                authentPanel.setVisible(false);
            }
        });
        
    }
    public static void main(String[] args){
        Authentication123 land = new Authentication123();
        land.frame.setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
        // if(ae.getSource()==adminBtn){
        //     // adminPanel.setVisible(true);
        //     // authentPanel.setVisible(false);
        //     // teacherPanel.setVisible(false);
        //     // studentPanel.setVisible(false);
        //     frame.remove(authentPanel);
        //     // frame.remove(teacherPanel);
        //     // frame.remove(studentPanel);
        //     frame.add(adminPanel);
        //     System.out.println("admin is selected");
        // }
           
        // else if(ae.getSource()==teacherBtn){
        //     frame.remove(authentPanel);
        //     frame.add(teacherPanel);
        //     // teacherPanel.setVisible(true);
        //     // adminPanel.setVisible(false);
        //     // authentPanel.setVisible(false);
        //     // studentPanel.setVisible(false);
        //     System.out.println("teacher is selected");
        // }
      
        // else if(ae.getSource()==studentBtn){
        //     // studentPanel.setVisible(true);
        //     // authentPanel.setVisible(false);
        //     // adminPanel.setVisible(false);
        //     // teacherPanel.setVisible(false);
        //     frame.remove(authentPanel);
        //     frame.add(studentPanel);
        //     System.out.println("student is selected");
        // } 
        // else if(ae.getSource()==adminLoginBtn){
        //     try {
        //         String userName = userNameTxt.getText();
        //         String password = passwordTxt.getPassword().toString();
        //         boolean isloged = authenticationStub.login(userName, password, "admin");
        //         System.out.println(isloged);
                 
        //     } catch (Exception er) {
        //         System.out.println(er);
        //     }
        // }
        // else if(ae.getSource()==teacherLoginBtn){
        //     try {
        //         String userName = userNameTxt.getText();
        //         String password = passwordTxt.getPassword().toString(); 
        //         boolean isloged = authenticationStub.login(userName, password, "admin");
        //         System.out.println(isloged);
        //     } catch (Exception er) {
        //         System.out.println(er);
        //     } 
        // } 
        // else if(ae.getSource()==studentLoginBtn){
        //     try {
        //         String userName = userNameTxt.getText();
        //         String password = passwordTxt.getPassword().toString();
        //         boolean isloged = authenticationStub.login(userName, password, "admin");
        //         System.out.println(isloged); 
        //     } catch (Exception er) {
        //         System.out.println(er);
        //     }
        // }      
    }
}
