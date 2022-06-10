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
import javax.swing.border.Border;

import java.io.*;
public class AdminPage  implements ActionListener{
    private JPanel panel;
    private JPanel display;
    private JPanel header;
    private JButton addDepBtn;
    private JButton addSecBtn;
    private JButton addCouBtn;
    private JButton addStuBtn;

    AdminAction action;
    public AdminPage(){
        action = new AdminAction();
        header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 1200, 50);
        header.setBackground(Color.blue);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 50, 200, 1200);
        panel.setBackground(Color.yellow);

        addDepBtn = new JButton("Add Department");
        addSecBtn = new JButton("Add Section");
        addCouBtn = new JButton("Add Course");
        addStuBtn = new JButton("Add Student");
        
        addDepBtn.setBounds(20, 100, 120, 30);
        addSecBtn.setBounds(20, 140, 120, 30);
        addCouBtn.setBounds(20, 190, 120, 30);
        addStuBtn.setBounds(20, 250, 120, 30);        
        addDepBtn.addActionListener(this);
        addSecBtn.addActionListener(this);
        addCouBtn.addActionListener(this);
        addStuBtn.addActionListener(this);
        
        
        panel.add(addDepBtn);
        panel.add(addSecBtn);
        panel.add(addCouBtn);
        panel.add(addStuBtn);
        
    }
    public  void actionPerformed(ActionEvent ae){
         if(ae.getSource() == addDepBtn){
           // Border br = BorderFactory.createLineBorder(Color.black);
            action.getAddStudentPanel().setVisible(false);
            action.getAddSectionPanel().setVisible(false);
            action.getAddCoursePanel().setVisible(false);
            JPanel pan = action.getAddDepartmentPanel();
            pan.setVisible(false);
            this.panel.getParent().add(pan);
            pan.setVisible(true);

         }
         else if(ae.getSource() == addSecBtn){
            action.getAddDepartmentPanel().setVisible(false);
            action.getAddStudentPanel().setVisible(false);
            action.getAddCoursePanel().setVisible(false);
            JPanel pan = action.getAddSectionPanel();
            pan.setVisible(false);
            this.panel.getParent().add(pan);
            pan.setVisible(true);
        }
        else if(ae.getSource() == addCouBtn){
           
            action.getAddDepartmentPanel().setVisible(false);
            action.getAddSectionPanel().setVisible(false);
            action.getAddStudentPanel().setVisible(false);
            JPanel pan = action.getAddCoursePanel();
            pan.setVisible(false);
            this.panel.getParent().add(pan);
            pan.setVisible(true);
        }
        else if(ae.getSource() == addStuBtn){
            action.getAddDepartmentPanel().setVisible(false);
            action.getAddSectionPanel().setVisible(false);
            action.getAddCoursePanel().setVisible(false);
            JPanel pan = action.getAddStudentPanel();
            pan.setVisible(false);
            this.panel.getParent().add(pan);
            pan.setVisible(true);
            
        }
    }
    public JPanel getPanel(){
        return this.panel;
    }
    public JPanel getHeader(){
        return this.header;
    }
}
