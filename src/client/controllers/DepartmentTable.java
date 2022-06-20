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

import shared.classes.*;
import shared.remoteInterface.*;

import java.io.*;
import java.util.ArrayList;
public class DepartmentTable  implements ActionListener{

    //1.Display Section
    private JPanel displaySection;
    private JTable sectionTable;
    private DefaultTableModel modelSection;
    private ListSelectionModel secModel;
    private TableModel tableModelSection;
    private ArrayList<Section>sections;

    //2.Display Course
    private JPanel displayCourse;
    private JTable courseTable;
    private DefaultTableModel modelCourse;
    private ListSelectionModel couModel;
    private TableModel tableModelCourse;
    private ArrayList<Course>courses;

    //3.Dispaly Teacher
    private Registry registry;
    private departmentInterface departmentStub;
    private sectionInterface sectionStub;
    private courseInterface courseStub;
    private teacherInterface teacherStub;
    private studentInterface studentStub;
    //4.Side bar
    private JPanel sidePanel;
    private JButton sectionBtn;
    private JButton courseBtn;
    private JButton teacherBtn;


    AdminTable action;
    public  DepartmentTable(){
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
       
    }
    public  void actionPerformed(ActionEvent ae){
         if(ae.getSource() == sectionBtn){
           // Border br = BorderFactory.createLineBorder(Color.black);
            // action.getAddStudentPanel().setVisible(false);
            // action.getAddSectionPanel().setVisible(false);
            // action.getAddCoursePanel().setVisible(false);
            // Container con = panel.getParent();
            // con.removeAll();
            // JPanel pan = action.getAddDepartmentPanel();
            // pan.setVisible(false);
            // con.add(pan);
            // con.add(panel);
            // pan.setVisible(true);

         }
         else if(ae.getSource() == courseBtn){
            // Container con = panel.getParent();
            // con.removeAll();
            // JPanel pan = action.getAddSectionPanel();
            // pan.setVisible(false);
            // con.add(pan);
            // con.add(panel);
            // pan.setVisible(true);
        }
        else if(ae.getSource() == teacherBtn){
           
            // Container con = panel.getParent();
            // con.removeAll();
            // JPanel pan = action.getAddCoursePanel();
            // pan.setVisible(false);
            // con.add(pan);
            // con.add(panel);
            // pan.setVisible(true);
        }
    
    }
    public JPanel getSidePanel(){
        sidePanel = new JPanel();
        sidePanel.setLayout(null);
        sidePanel.setBounds(0, 50, 200, 1200);
        sidePanel.setBackground(Color.yellow);

        sectionBtn = new JButton("Sections");
        courseBtn = new JButton("Courses");
        teacherBtn = new JButton("Teachers");

        sectionBtn.setBounds(20, 100, 120, 30);
        courseBtn.setBounds(20, 140, 120, 30);
        teacherBtn.setBounds(20, 190, 120, 30);
    
        sectionBtn.addActionListener(this);
        courseBtn.addActionListener(this);
        teacherBtn.addActionListener(this);

        sidePanel.add(sectionBtn);
        sidePanel.add(courseBtn);
        sidePanel.add(teacherBtn);
          
        return this.sidePanel;
    }
    // public JPanel getHeader(){
    //     return this.header;
    // }
    public JPanel getDisplaySection(){
     
        displaySection = new JPanel();
        displaySection.setLayout(null);
        displaySection.setSize(500, 500);
        displaySection.setBounds(400, 70, 500, 500);

        try {
            String query = "select * from section ";
            ArrayList<Section> sections = sectionStub.getSection(query);
            //String[][] data = new String[sections.size()][2];
            String[] headers = {"Section Id","Section Name"};
            modelSection = new DefaultTableModel(headers,0);
            sectionTable = new JTable(modelSection);
           
            for(Section section: sections){
                modelSection.addRow(new Object[]{
                    section.getSectionId(),
                    section.getSectionName()
                });
            }

            Color color = new Color(107,106,104);
            sectionTable.setBounds(10, 20, 300, 300);
            sectionTable.setBackground(Color.white);
            sectionTable.setForeground(color);
            sectionTable.setFont(new Font("Serif",Font.BOLD,20));
            sectionTable.setRowHeight(25);
            sectionTable.setAutoCreateRowSorter(true);
            TableColumnModel columnModel = sectionTable.getColumnModel();
            JScrollPane js = new JScrollPane(sectionTable);
             
            displaySection.add(sectionTable);
            secModel = sectionTable.getSelectionModel();

            secModel.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e){
                    if(!secModel.isSelectionEmpty()){
                        int row = sectionTable.getSelectedRow();
                        tableModelSection = sectionTable.getModel();
                        String selectedSection = (String)tableModelSection.getValueAt(row, 0);  
                        System.out.println(selectedSection);
                    }
                    
                    System.out.println();
                }
            });
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println("hello world");
        return this.displaySection; 
    }
    public JPanel getDisplayCourse(){
     
        displayCourse = new JPanel();
        displayCourse.setLayout(null);
        displayCourse.setSize(500, 500);
        displayCourse.setBounds(400, 70, 500, 500);

        try {
            String query = "select * from course ";
            ArrayList<Course> courses = courseStub.getCourse(query);
            //String[][] data = new String[courses.size()][2];
            String[] headers = {"Course Id","Course Name"};
            modelCourse = new DefaultTableModel(headers,0);
            courseTable = new JTable(modelSection);
           
            for(Course course: courses){
                modelSection.addRow(new Object[]{
                    course.getCourseId(),
                    course.getCourseName()
                });
            }

            Color color = new Color(107,106,104);
            courseTable.setBounds(10, 20, 300, 300);
            courseTable.setBackground(Color.white);
            courseTable.setForeground(color);
            courseTable.setFont(new Font("Serif",Font.BOLD,20));
            courseTable.setRowHeight(25);
            courseTable.setAutoCreateRowSorter(true);
            TableColumnModel columnModel = courseTable.getColumnModel();
            JScrollPane js = new JScrollPane(courseTable);
             
            displayCourse.add(courseTable);
            couModel = courseTable.getSelectionModel();

            couModel.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e){
                    if(!couModel.isSelectionEmpty()){
                        int row = courseTable.getSelectedRow();
                        tableModelCourse = courseTable.getModel();
                        String selectedCourse = (String)tableModelCourse.getValueAt(row, 0);  
                        System.out.println(selectedCourse);
                    }
            
                }
            });
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println("hello worlddddddd");
        return this.displayCourse; 
    }

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1200, 1200);
        frame.setTitle("Check Page");

        DepartmentTable table = new DepartmentTable();
        frame.add( table.getSidePanel());
        frame.add(table.getDisplayCourse());
        frame.setVisible(true);
    
    }
}
