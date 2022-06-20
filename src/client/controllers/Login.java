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

import shared.classes.*;
import shared.remoteInterface.authenticationInterface;
public class Login implements ActionListener{

    private Registry registry;
    private authenticationInterface authenticationStub;
    private JPanel panel;
    private JLabel label;
    private String type;
    
    //2. Login Componenet
    private JLabel userNameLbl;
    private JLabel passwordLbl;
    private JTextField userNameTxt;
    private JPasswordField passwordTxt;
    private JButton LoginBtn;
    

    public Login(String type){
        this.type = type;
        try {
            registry = LocateRegistry.getRegistry("localhost", 2020);
            authenticationStub = (authenticationInterface)registry.lookup("login");
           
        } catch (Exception e) {
            System.out.println(e);
        }
        
        panel = new JPanel();
        panel.setLayout(null);

        label = new JLabel("Selamu");
        label.setBounds(10, 10, 100, 20);
        
        
        userNameLbl = new JLabel("User Name");
        passwordLbl = new JLabel("Password");
        userNameTxt = new JTextField();
        passwordTxt = new JPasswordField(26);
        LoginBtn = new JButton("Login");

        userNameLbl.setBounds(400, 200, 90, 30);
        userNameTxt.setBounds(500, 200, 120, 30);
        passwordLbl.setBounds(400, 240, 90, 30);
        passwordTxt.setBounds(500, 240, 120, 30);
        LoginBtn.setBounds(500, 280, 90, 30);

        LoginBtn.addActionListener(this);

        panel.add(userNameLbl);
        panel.add(passwordLbl);
        panel.add(userNameTxt);
        panel.add(passwordTxt);
        panel.add(LoginBtn);
    }
   
    public JPanel getPanel(){
        return this.panel;
    }
    public void adminLogin(){
        try {
            String password = new String( passwordTxt.getPassword()); 
            String username = userNameTxt.getText();
            if(authenticationStub.login(username, password, "admin")){
                System.out.println("Admin is logged");
                AdminPage admin = new AdminPage();
                this.panel.setVisible(false);
                this.panel.getParent().add(admin.getPanel());
                this.panel.getParent().add(admin.getHeader());
                this.panel.getParent().add(admin.getDisplay());
                
            }
            else{
                System.out.println("Admin username or password is incorrect");
            }
        } catch (Exception e) {
           System.out.println(e);
        }
    }
    public void teacherLogin(){
        try {
            String password = new String( passwordTxt.getPassword()); 
            String username = userNameTxt.getText();
            if(authenticationStub.login(username, password, "admin")){
                System.out.println("Teacher is logged");
            }
            else{
                System.out.println("Teacher username or password is incorrect");
            }
        } catch (Exception e) {
           System.out.println(e);
        }
    }
    public void studentLogin(){
        try {
            String password = new String( passwordTxt.getPassword()); 
            String username = userNameTxt.getText();
            if(authenticationStub.login(username, password, "admin")){
                System.out.println("Student is logged");
            }
            else{
                System.out.println("Student username or password is incorrect");
            }
        } catch (Exception e) {
           System.out.println(e);
        }
       
    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==LoginBtn){
            if(type.equals("admin")){
                adminLogin();
            }
            else if(type.equals("teacher")){
                teacherLogin();
            }
            else{
                studentLogin();
            }
        }
    }
}
