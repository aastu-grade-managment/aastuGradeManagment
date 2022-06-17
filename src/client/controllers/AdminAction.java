package client.controllers;

import java.awt.Color;
import client.utils.*;
import shared.remoteInterface.*;
import shared.classes.*;

import javax.swing.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class AdminAction  implements ActionListener{
    
    private Registry registry;
    private departmentInterface departmentStub;

    private JPanel addDepartmentPanel;
    private JPanel addSectionPanel;
    private JPanel addCoursePanel;
    private JPanel addTeacherPanel;
    private JPanel addStudentPanel;

    //1.add department
    private JLabel depIdLbl;
    private JLabel depNameLbl;
    private JTextField depIdTxt;
    private JTextField depNameTxt;
    private JButton addDeptBtn;
    private JButton departmentFinish;
    private JLabel departmentHeader;
    
    //2.add section
   
    private JLabel depListLbl;
    private JComboBox departmentList;
    private JLabel sectionIdLbl;
    private JTextField sectionIdTxt;
    private JLabel sectionNameLbl;
    private JTextField sectionNameTxt;
    private JButton addSectionBtn;
    private JButton sectionFinish;
    private JLabel sectionHeader;
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
    private JLabel courseHeader;

    //4.add teacher
    private JLabel teacherDepartmentLbl;
    private JComboBox teacherDepartment;
    private JLabel teacherSectionLbl;
    private JTextField teacherSectionTxt;
    private JLabel teacherCourseLbl;
    private JTextField teacherCourseTxt;
    private JLabel teacherIdLbl;
    private JTextField teacherIdTxt;
    private JLabel teacherFirstNameLbl;
    private JTextField teacherFirstNameTxt;
    private JLabel teacherLastNameLbl;
    private JTextField teacherLastNameTxt;
    private JLabel teacherEmailLbl;
    private JTextField teacherEmailTxt;
    private JButton addTeacherBtn;
    private JButton teacherFinish;
    private JLabel teacherHeader;
    //4.add student
    private JLabel listDepLbl;
    private JComboBox listDep;
    private JLabel studSectionLbl;
    private JTextField studSectionTxt;
    private JLabel studentIdLbl;
    private JTextField studentIdTxt;
    private JLabel studFirstNameLbl;
    private JTextField studFirstNameTxt;
    private JLabel studLastNameLbl;
    private JTextField studLastNameTxt;
    private JButton addStudentBtn;
    private JButton studentFinish;
    private JLabel studentHeader;
    AdminAction(){
        try {
            RMIConnectio connection  = new RMIConnectio();
            this.registry = connection.getRegistry();
            this.departmentStub = (departmentInterface) this.registry.lookup("department");
           
        } catch (RemoteException e) {
            System.out.println(e);
        }catch (Exception ea){
            System.out.println(ea);
        }
    }

    public void addDepartment(){
        if(depIdTxt.getText().isEmpty()){   
            JOptionPane.showMessageDialog(addDepartmentPanel.getParent(),"Department Id is required");
            return;
        }
        if(depNameTxt.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(addDepartmentPanel.getParent(),"Department Name is required");
            return;
        }
        String id = depIdTxt.getText();
        String name = depNameTxt.getText();
        Department dep = new Department(id, name);
        try {
            if(departmentStub.addDepartment(dep)>0){
                JOptionPane.showMessageDialog(addDepartmentPanel.getParent(),"Department added Successfully");
            }
        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(addDepartmentPanel.getParent(),"Some thing wrong");
            // e.printStackTrace();
        }

    }
    public void addSection(){
        System.out.println("Section is added");
    }
    public void addCourse(){
        System.out.println("Course is added");
    }
    public void addTeacher(){
        System.out.println("Teacher is added");
    }
    public void addStudent(){
        System.out.println("Student is added");
    }
    
    public void departmentData(JComboBox box){
        try {
            ArrayList<Department>departments;
            departments = departmentStub.getDepartment("select * from department");
            for(Department department: departments){
                box.addItem(department.getDepartmentName());
            }
           
        } catch (RemoteException e) {
            System.out.println(e);
        }catch (Exception ea){
            System.out.println(ea);
        }
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
        departmentHeader = new JLabel("Add Department");

        departmentHeader.setBounds(80, 20, 300, 30);
        depIdLbl.setBounds(20, 70, 140, 30);
        depIdTxt.setBounds(160, 70, 140, 30);
        depNameLbl.setBounds(20, 105, 140, 30);
        depNameTxt.setBounds(160, 105, 140, 30);
        addDeptBtn.setBounds(20, 140, 90, 30);
        departmentFinish.setBounds(160, 140, 90, 30);

        addDeptBtn.addActionListener(this);
        departmentFinish.addActionListener(this);


        addDepartmentPanel.add(depIdLbl);
        addDepartmentPanel.add(depIdTxt);
        addDepartmentPanel.add(depNameLbl);
        addDepartmentPanel.add(depNameTxt);
        addDepartmentPanel.add(addDeptBtn);
        addDepartmentPanel.add(departmentFinish);
        addDepartmentPanel.add(departmentHeader);

        return this.addDepartmentPanel;
    }
    public JPanel getAddSectionPanel(){
        addSectionPanel = new JPanel();
        addSectionPanel.setLayout(null);
        addSectionPanel.setSize(500, 500);
        addSectionPanel.setBounds(400, 70, 500, 500);

    
        depListLbl = new JLabel("Department");
        departmentList = new JComboBox<>();
        departmentData(departmentList);
        sectionIdLbl = new JLabel("Section Id");
        sectionNameLbl = new JLabel("Section Name");
        sectionIdLbl = new JLabel("Section Id");
        sectionIdTxt = new JTextField();
        sectionNameTxt = new JTextField();
        addSectionBtn = new JButton("Add");
        sectionFinish = new JButton("Finish");
        sectionHeader = new JLabel("Add Section");
        

        sectionHeader.setBounds(80, 20, 300, 30);
        depListLbl.setBounds(20, 70, 140, 30);
        departmentList.setBounds(160, 70, 140, 30);
        sectionIdLbl.setBounds(20, 120, 140, 30);
        sectionIdTxt.setBounds(160, 120, 140, 30);
        sectionNameLbl.setBounds(20, 155, 140, 30);
        sectionNameTxt.setBounds(160, 155, 140, 30);
        addSectionBtn.setBounds(20, 190, 90, 30);
        sectionFinish.setBounds(160, 190, 90, 30);
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
        addSectionPanel.add(sectionHeader);
        

        return this.addSectionPanel;
    }
    public JPanel getAddCoursePanel(){
        addCoursePanel = new JPanel();
        addCoursePanel.setLayout(null);
        addCoursePanel.setSize(500, 500);
        addCoursePanel.setBounds(400, 70, 500, 500);
       
        ListLbl = new JLabel("Department");
        List = new JComboBox<>();
        departmentData(List);
        
        courseIdLbl = new JLabel("Course Id");
        courseIdTxt = new JTextField();
        courseNameLbl = new JLabel("Course Name");
        courseNameTxt = new JTextField();
        creditHourLbl = new JLabel("Credit Hour");
        creditHourTxt = new JTextField();
        addCourseBtn = new JButton("Add");
        courseFinish = new JButton("Finish");
        courseHeader = new JLabel("Add Course");
        
        
        courseHeader.setBounds(80, 20, 300, 30);
        ListLbl.setBounds(20, 70, 140, 30);
        List.setBounds(160, 70, 140, 30);
        courseIdLbl.setBounds(20, 120, 140, 30);
        courseIdTxt.setBounds(160, 120, 140, 30);
        courseNameLbl.setBounds(20, 155, 140, 30);
        courseNameTxt.setBounds(160, 155, 140, 30);
        creditHourLbl.setBounds(20, 190, 140, 30);
        creditHourTxt.setBounds(160, 190, 140, 30);
        addCourseBtn.setBounds(20, 225, 90, 30);
        courseFinish.setBounds(160, 225, 90, 30);
    
        addCourseBtn.addActionListener(this);
        courseFinish.addActionListener(this);

        addCoursePanel.add(courseHeader);
        addCoursePanel.add(ListLbl);
        addCoursePanel.add(List);
        addCoursePanel.add(courseIdLbl);
        addCoursePanel.add(courseIdTxt);
        addCoursePanel.add(courseNameLbl);
        addCoursePanel.add(courseNameTxt);
        addCoursePanel.add(creditHourLbl);
        addCoursePanel.add(creditHourTxt);
        addCoursePanel.add(addCourseBtn);
        addCoursePanel.add(courseFinish);
        return this.addCoursePanel;
    }
    public JPanel getAddStudentPanel(){
        addStudentPanel = new JPanel();
        addStudentPanel.setLayout(null);
        addStudentPanel.setSize(500, 500);
        addStudentPanel.setBounds(400, 70, 500, 500);

        listDepLbl = new JLabel("Department");
        listDep = new JComboBox<>();
        departmentData(listDep);
        studSectionLbl = new JLabel("Section Id");
        studSectionTxt = new JTextField();
        studentIdLbl = new JLabel("Student Id");
        studentIdTxt = new JTextField();
        studFirstNameLbl = new JLabel("First Name");
        studFirstNameTxt = new JTextField();
        studLastNameLbl = new JLabel("Last Name");
        studLastNameTxt = new JTextField();
        addStudentBtn = new JButton("Add");
        studentFinish = new JButton("Finish");
        studentHeader = new JLabel("Add Student");
        
        
        studentHeader.setBounds(80, 20, 300, 30);
        listDepLbl.setBounds(20, 70, 140, 30);
        listDep.setBounds(160, 70, 140, 30);
        studSectionLbl.setBounds(20, 120, 140, 30);
        studSectionTxt.setBounds(160, 120, 140, 30);
        studentIdLbl.setBounds(20, 155, 140, 30);
        studentIdTxt.setBounds(160, 155, 140, 30);
        studFirstNameLbl.setBounds(20, 190, 140, 30);
        studFirstNameTxt.setBounds(160, 190, 140, 30);
        studLastNameLbl.setBounds(20, 225, 140, 30);
        studLastNameTxt.setBounds(160, 225, 140, 30);
        addStudentBtn.setBounds(20, 260, 90, 30);
        studentFinish.setBounds(160, 260, 90, 30);
        addStudentBtn.addActionListener(this);
        studentFinish.addActionListener(this);

        addStudentPanel.add(studentHeader);
        addStudentPanel.add(listDepLbl);
        addStudentPanel.add(listDep);
        addStudentPanel.add(studSectionLbl);
        addStudentPanel.add(studSectionTxt);
        addStudentPanel.add(studentIdLbl);
        addStudentPanel.add(studentIdTxt);
        addStudentPanel.add(studFirstNameLbl);
        addStudentPanel.add(studFirstNameTxt);
        addStudentPanel.add(studLastNameLbl);
        addStudentPanel.add(studLastNameTxt);
        addStudentPanel.add(studentHeader);
        addStudentPanel.add(addStudentBtn);
        addStudentPanel.add(studentFinish);
        return this.addStudentPanel;
    }
    public JPanel getAddTeacherPanel(){
        addTeacherPanel = new JPanel();
        addTeacherPanel.setLayout(null);
        addTeacherPanel.setSize(500, 500);
        addTeacherPanel.setBounds(400, 70, 500, 500);

        teacherDepartmentLbl = new JLabel("Department");
        teacherDepartment = new JComboBox<>();
        departmentData(teacherDepartment);
    
        teacherSectionLbl = new JLabel("Section Id");
        teacherSectionTxt = new JTextField();
        teacherCourseLbl = new JLabel("Course Id");
        teacherCourseTxt = new JTextField();

        teacherIdLbl = new JLabel("Student Id");
        teacherIdTxt = new JTextField();
        teacherFirstNameLbl = new JLabel("First Name");
        teacherFirstNameTxt = new JTextField();
        teacherLastNameLbl = new JLabel("Last Name");
        teacherLastNameTxt = new JTextField();

        teacherEmailLbl = new JLabel("Email");
        teacherEmailTxt = new JTextField();

        addTeacherBtn = new JButton("Add");
        teacherFinish = new JButton("Finish");
        teacherHeader = new JLabel("Add Teacher");
        
        teacherHeader.setBounds(80, 20, 300, 30);
        teacherDepartmentLbl.setBounds(20, 70, 140, 30);
        teacherDepartment.setBounds(160, 70, 140, 30);
        teacherSectionLbl.setBounds(20, 120, 140, 30);
        teacherSectionTxt.setBounds(160, 120, 140, 30);
        teacherCourseLbl.setBounds(20, 155, 140, 30);
        teacherCourseTxt.setBounds(160, 155, 140, 30);
        teacherIdLbl.setBounds(20, 190, 140, 30);
        teacherIdTxt.setBounds(160, 190, 140, 30);
        teacherFirstNameLbl.setBounds(20, 225, 140, 30);
        teacherFirstNameTxt.setBounds(160, 225, 140, 30);
        teacherLastNameLbl.setBounds(20, 260, 140, 30);
        teacherLastNameTxt.setBounds(160, 260, 140, 30);
        teacherEmailLbl.setBounds(20, 295, 140, 30);
        teacherEmailTxt.setBounds(160, 295, 140, 30);
        addTeacherBtn.setBounds(20, 330, 90, 30);
        teacherFinish.setBounds(160, 330, 90, 30);

        addTeacherBtn.addActionListener(this);
        teacherFinish.addActionListener(this);

        addTeacherPanel.add(teacherHeader);
        addTeacherPanel.add(teacherDepartmentLbl);
        addTeacherPanel.add(teacherDepartment);
        addTeacherPanel.add(teacherSectionLbl);
        addTeacherPanel.add(teacherSectionTxt);
        addTeacherPanel.add(teacherCourseLbl);
        addTeacherPanel.add(teacherCourseTxt);
        addTeacherPanel.add(teacherIdLbl);
        addTeacherPanel.add(teacherIdTxt);
        addTeacherPanel.add(teacherFirstNameLbl);
        addTeacherPanel.add(teacherFirstNameTxt);
        addTeacherPanel.add(teacherLastNameLbl);
        addTeacherPanel.add(teacherLastNameTxt);
        addTeacherPanel.add(teacherEmailLbl);
        addTeacherPanel.add(teacherEmailTxt);
        addTeacherPanel.add(addTeacherBtn);
        addTeacherPanel.add(teacherFinish);
        return this.addTeacherPanel;
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
        else if(e.getSource() == addTeacherBtn){
            addTeacher();
        }
        else if(e.getSource() == addStudentBtn){
            addStudent();
        }
        else if(e.getSource() == departmentFinish||e.getSource() == sectionFinish||
        e.getSource() == courseFinish||e.getSource() == teacherFinish||e.getSource() == studentFinish){
            addDepartmentPanel.setVisible(false);
            addSectionPanel.setVisible(false);
            addCoursePanel.setVisible(false);
            addStudentPanel.setVisible(false);
        }
    }
}
