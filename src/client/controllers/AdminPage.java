/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.controllers;

/**
 *
 * @author holy
 */
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import client.utils.RMIConnectio;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import shared.classes.Department;
import shared.remoteInterface.*;

import java.io.*;
import java.util.ArrayList;
public class AdminPage  implements ActionListener{

    private Registry registry;
    private departmentInterface departmentStub;
    private sectionInterface sectionStub;
    private courseInterface courseStub;
    private teacherInterface teacherStub;
    private studentInterface studentStub;
    
    private JPanel panel;
    private JPanel header;
    private JButton addDepBtn;
    private JButton addSecBtn;
    private JButton addCouBtn;
    private JButton addTeaBtn;
    private JButton addStuBtn;
    
    //1. Display department
    private JPanel displayDepartment;
    private JTable departmentTable;
    private DefaultTableModel model;
    private ListSelectionModel model1;
    private TableModel tableModel;
    private ArrayList<Department>departments;

    AdminTable action;
    public AdminPage(){
        //create connection
        try {
            RMIConnectio connection  = new RMIConnectio();
            this.registry = connection.getRegistry();
            this.departmentStub = (departmentInterface) this.registry.lookup("department");
            this.sectionStub = (sectionInterface) this.registry.lookup("section");
            this.courseStub = (courseInterface) this.registry.lookup("course");
            this.teacherStub = (teacherInterface) this.registry.lookup("teacher");
            this.studentStub = (studentInterface) this.registry.lookup("student");
            
        } catch (RemoteException e) {
            System.out.println(e);
        }catch (Exception ea){
            System.out.println(ea);
        }
        action = new AdminTable();
        header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 1200, 50);
        //header.setBackground(Color.blue);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 50, 200, 1200);
        panel.setBackground(Color.yellow);

        addDepBtn = new JButton("Add Department");
        addSecBtn = new JButton("Add Section");
        addCouBtn = new JButton("Add Course");
        addTeaBtn = new JButton("Add Teacher");
        addStuBtn = new JButton("Add Student");
        
        
        addDepBtn.setBounds(20, 100, 120, 30);
        addSecBtn.setBounds(20, 140, 120, 30);
        addCouBtn.setBounds(20, 190, 120, 30);
        addTeaBtn.setBounds(20, 250, 120, 30);  
        addStuBtn.setBounds(20, 300, 120, 30);   

        addDepBtn.addActionListener(this);
        addSecBtn.addActionListener(this);
        addCouBtn.addActionListener(this);
        addTeaBtn.addActionListener(this);
        addStuBtn.addActionListener(this);
        
        
        panel.add(addDepBtn);
        panel.add(addSecBtn);
        panel.add(addCouBtn);
        panel.add(addStuBtn);
        panel.add(addTeaBtn);
        
    }
    public  void actionPerformed(ActionEvent ae){
         if(ae.getSource() == addDepBtn){
           // Border br = BorderFactory.createLineBorder(Color.black);
            // action.getAddStudentPanel().setVisible(false);
            // action.getAddSectionPanel().setVisible(false);
            // action.getAddCoursePanel().setVisible(false);
            Container con = panel.getParent();
            con.removeAll();
            JPanel pan = action.getAddDepartmentPanel();
            pan.setVisible(false);
            con.add(pan);
            con.add(panel);
            pan.setVisible(true);

         }
         else if(ae.getSource() == addSecBtn){
            Container con = panel.getParent();
            con.removeAll();
            JPanel pan = action.getAddSectionPanel();
            pan.setVisible(false);
            con.add(pan);
            con.add(panel);
            pan.setVisible(true);
        }
        else if(ae.getSource() == addCouBtn){
           
            Container con = panel.getParent();
            con.removeAll();
            JPanel pan = action.getAddCoursePanel();
            pan.setVisible(false);
            con.add(pan);
            con.add(panel);
            pan.setVisible(true);
        }
        else if(ae.getSource() == addTeaBtn){
            Container con = panel.getParent();
            con.removeAll();
            JPanel pan = action.getAddTeacherPanel();
            pan.setVisible(false);
            con.add(pan);
            con.add(panel);
            pan.setVisible(true);
            
        }
        else if(ae.getSource() == addStuBtn){
            Container con = panel.getParent();
            con.removeAll();
            JPanel pan = action.getAddStudentPanel();
            pan.setVisible(false);
            con.add(pan);
            con.add(panel);
            pan.setVisible(true);
            
        }
    }
    public JPanel getPanel(){
        return this.panel;
    }
    public JPanel getHeader(){
        return this.header;
    }
    public JPanel getDisplay(){
        displayDepartment = new JPanel();
        displayDepartment.setLayout(null);
        displayDepartment.setSize(500, 500);
        displayDepartment.setBounds(400, 70, 500, 500);
        
       
        try {
            String query = "select * from department ";
            ArrayList<Department> deps = departmentStub.getDepartment(query);
            String[][] data = new String[deps.size()][2];
            String[] headers = {"Department Id","Department Name"};
            model = new DefaultTableModel(headers,0);
            departmentTable = new JTable(model);

            for(Department department: deps){
                model.addRow(new Object[]{
                    department.getDepartmentId(),
                    department.getDepartmentName()
                });
            }

            Color color = new Color(107,106,104);
            departmentTable.setBounds(10, 20, 300, 300);
            departmentTable.setBackground(Color.white);
            departmentTable.setForeground(color);
            departmentTable.setFont(new Font("Serif",Font.BOLD,20));
            departmentTable.setRowHeight(25);
            departmentTable.setAutoCreateRowSorter(true);
            TableColumnModel columnModel = departmentTable.getColumnModel();
            JScrollPane js = new JScrollPane(departmentTable);
            
            
            displayDepartment.add(departmentTable);
            model1 = departmentTable.getSelectionModel();

            model1.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e){
                    if(!model1.isSelectionEmpty()){
                        int row = departmentTable.getSelectedRow();
                        tableModel = departmentTable.getModel();
                        String selectedDepartment = (String)tableModel.getValueAt(row, 0);
                        
                    }
                    
                    System.out.println();
                }
            });
             
        
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        return this.displayDepartment; 
    }
}
