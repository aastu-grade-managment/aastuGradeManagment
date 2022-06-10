package client.controllers;

import java.awt.Color;

import javax.swing.*;
import java.awt.event.*;

public class AdminAction  implements ActionListener{
    private JPanel addDepartmentPanel;
    private JPanel addSectionPanel;
    private JPanel addCoursePanel;
    private JPanel addStudentPanel;

    //1.add department
    private JLabel depIdLbl;
    private JLabel depNameLbl;
    private JTextField depIdTxt;
    private JTextField depNameTxt;
    private JButton addDeptBtn;
    private JLabel label;
    private JButton departmentFinish;
    
    //2.add section
   
    private JLabel depListLbl;
    private JComboBox departmentList;
    private JLabel sectionIdLbl;
    private JTextField sectionIdTxt;
    private JLabel sectionNameLbl;
    private JTextField sectionNameTxt;
    private JButton addSectionBtn;
    private JButton sectionFinish;
    //3.add course
    private JLabel ListLbl;
    private JComboBox List;
    private JLabel courseIdLbl;
    private JTextField courseIdTxt;
    private JLabel courseNameLbl;
    private JTextField courseNameTxt;
    private JLabel creditHourLbl;
    private JTextField creditHourTxt;
    private JButton addCourseBtn;
    private JButton courseFinish;
    //4.add student
    private JButton addStudentBtn;
    private JButton studentFinish;
    AdminAction(){
        
    }
    public void addDepartment(){
        System.out.println("Department is added");
    }
    public void addSection(){
        System.out.println("Section is added");
    }
    public void addCourse(){
        System.out.println("Course is added");
    }
    public void addStudent(){
        System.out.println("Student is added");
    }

    public JPanel getAddDepartmentPanel(){
        addDepartmentPanel = new JPanel();
        addDepartmentPanel.setLayout(null);
        addDepartmentPanel.setSize(500, 500);
        addDepartmentPanel.setBounds(400, 70, 500, 500);

        depIdLbl = new JLabel("Department Id");
        depIdTxt = new JTextField();
        depNameLbl = new JLabel("Department Name");
        depNameTxt = new JTextField();
        addDeptBtn = new JButton("Add");
        departmentFinish = new JButton("Finish");
        label = new JLabel("Add Department");

        label.setBounds(180, 20, 300, 30);
        depIdLbl.setBounds(20, 70, 140, 30);
        depIdTxt.setBounds(160, 70, 140, 30);
        depNameLbl.setBounds(20, 105, 140, 30);
        depNameTxt.setBounds(160, 105, 140, 30);
        addDeptBtn.setBounds(20, 140, 90, 30);
        departmentFinish.setBounds(130, 140, 90, 30);
        addDeptBtn.addActionListener(this);
        departmentFinish.addActionListener(this);


        addDepartmentPanel.add(depIdLbl);
        addDepartmentPanel.add(depIdTxt);
        addDepartmentPanel.add(depNameLbl);
        addDepartmentPanel.add(depNameTxt);
        addDepartmentPanel.add(addDeptBtn);
        addDepartmentPanel.add(departmentFinish);
        addDepartmentPanel.add(label);

        return this.addDepartmentPanel;
    }
    public JPanel getAddSectionPanel(){
        addSectionPanel = new JPanel();
        addSectionPanel.setLayout(null);
        addSectionPanel.setSize(500, 500);
        addSectionPanel.setBounds(400, 70, 500, 500);

        depListLbl = new JLabel("Department");
        departmentList = new JComboBox<>();
        sectionIdLbl = new JLabel("Section Id");
        sectionNameLbl = new JLabel("Department Name");
        sectionIdLbl = new JLabel("Section Id");
        sectionIdTxt = new JTextField();
        sectionNameTxt = new JTextField();
        addSectionBtn = new JButton("Add");
        sectionFinish = new JButton("Finish");
        
        
        
        depListLbl.setBounds(200, 200, 90, 30);
        departmentList.setBounds(300, 200, 90, 30);
        sectionIdLbl.setBounds(200, 240, 90, 30);
        sectionIdTxt.setBounds(350, 240, 90, 30);
        sectionNameLbl.setBounds(200, 280, 90, 30);
        sectionNameTxt.setBounds(350, 280, 90, 30);
        addSectionBtn.setBounds(300, 280, 90, 30);
        sectionFinish.setBounds(400, 280, 90, 30);
        addSectionBtn.addActionListener(this);
        sectionFinish.addActionListener(this);

        addSectionPanel.add(depListLbl);
        addSectionPanel.add(departmentList);
        addSectionPanel.add(sectionIdLbl);
        addSectionPanel.add(sectionIdTxt);
        addSectionPanel.add(sectionNameLbl);
        addSectionPanel.add(sectionNameTxt);
        addSectionPanel.add(addSectionBtn);
        addSectionPanel.add(sectionFinish);

        return this.addSectionPanel;
    }
    public JPanel getAddCoursePanel(){
        addCoursePanel = new JPanel();
        addCoursePanel.setLayout(null);
        addCoursePanel.setSize(500, 500);
        addCoursePanel.setBounds(400, 70, 500, 500);
        addCoursePanel.setBackground(Color.gray);

        courseFinish = new JButton("Finish");
        addCourseBtn = new JButton("Add");
        addCourseBtn.addActionListener(this);
        courseFinish.addActionListener(this);
        addCourseBtn.setBounds(200, 200, 80, 80);
        courseFinish.setBounds(290, 200, 80, 80);

        addCoursePanel.add(courseFinish);
        addCoursePanel.add(addCourseBtn);
        return this.addCoursePanel;
    }
    public JPanel getAddStudentPanel(){
        addStudentPanel = new JPanel();
        addStudentPanel.setLayout(null);
        addStudentPanel.setSize(500, 500);
        addStudentPanel.setBackground(Color.green);
        addStudentPanel.setBounds(400, 70, 500, 500);

        addStudentBtn = new JButton("Add");
        studentFinish = new JButton("Finish");
        addStudentBtn.addActionListener(this);
        studentFinish.addActionListener(this);
        addStudentBtn.setBounds(200, 200, 80, 40);
        studentFinish.setBounds(290, 200, 80, 40);

        addStudentPanel.add(addStudentBtn);
        addStudentPanel.add(studentFinish);
        return this.addStudentPanel;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addDeptBtn){
            addDepartment();
        }
        else if(e.getSource() == addSectionBtn){
            addSection();
        }
        else if(e.getSource() == addCourseBtn){
            addCourse();
        }
        else if(e.getSource() == addStudentBtn){
            System.out.println("Helllo student");
            addStudent();
        }
        else if(e.getSource() == departmentFinish||e.getSource() == sectionFinish||
        e.getSource() == courseFinish||e.getSource() == studentFinish){
            addDepartmentPanel.setVisible(false);
            addSectionPanel.setVisible(false);
            addCoursePanel.setVisible(false);
            addStudentPanel.setVisible(false);
        }
    }
}
