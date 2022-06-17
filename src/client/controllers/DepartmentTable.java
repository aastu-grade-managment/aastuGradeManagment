// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package client.controllers;
// /**
//  *
//  * @author holy
//  */


// import java.util.*;
// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;

// import java.rmi.registry.LocateRegistry;
// import java.rmi.registry.Registry;

// public class DepartmentTable extends JFrame{
   
//     private JLabel EmployeeIdLbl;
//     private JLabel fnameLbl;
//     private JLabel lnameLbl;
//     private JLabel emailLbl;
//     private JLabel phoneLbl;
//     private JLabel salaryLbl;
//     private JLabel hireDateLbl;
//     private JLabel departmentLbl;
    
//     private JButton addBtn;
//     private JButton finishBtn;
//     private JComboBox sortBox;
//     private JComboBox searchBox;
//     private JLabel sortJLabel;
//     private JLabel searchLbl;
//     private JTable table;
//     private JLabel searchValueLbl;
//     private JTextField searchValueTxt;

//     private JLabel  minSalaryLbl;
//     private JLabel  maxSalaryLbl;
//     private JTextField minSalaryTxt;
//     private JTextField maxSalaryTxt;
    
//     public DepartmentTable(){
        
//         setSize(1000,1000);
//         setLayout(null);
//         setTitle("Display Employee");
//         EmployeeIdLbl = new JLabel("EmpId");
//         fnameLbl = new JLabel("First Name");
//         lnameLbl = new JLabel("Last Name");
//         emailLbl = new JLabel("Email");
//         phoneLbl = new JLabel("Phone No");
//         salaryLbl = new JLabel("Salary");
//         hireDateLbl = new JLabel("Hire Date");
//         departmentLbl = new JLabel("Department");

       
//         addBtn = new JButton("Show");
//         finishBtn = new JButton("Back");
//         finishBtn.addActionListener(this);
//         sortJLabel = new JLabel("Sort By");
//         searchLbl = new JLabel("Search By");
//         searchValueLbl = new JLabel("Value");
//         minSalaryLbl = new JLabel("Min Salary");
//         maxSalaryLbl = new JLabel("Max Salary");
//         minSalaryTxt = new JTextField();
//         maxSalaryTxt = new JTextField();

        

//         String items[] = {"EmpID","First Name","Last Name","Email","Phone","Salary","Department","Hire Date"};
//         String values[] = {"EmpID","First Name","Last Name","Email","Phone","Department"};
//         sortBox = new JComboBox(items);
//         searchBox = new JComboBox(values);
//         searchValueTxt = new JTextField();
        

       
//         // message = new JLabel();
    
       
//         // finishBtn.addActionListener(this);
    
//         addBtn.setBounds(10, 250, 100, 20);
//         searchLbl.setBounds(170, 250, 60, 20);
//         searchBox.setBounds(235, 250, 100, 20);
//         searchValueLbl.setBounds(170, 275, 60, 20);
//         searchValueTxt.setBounds(235, 275, 100, 20);
//         sortJLabel.setBounds(360, 250, 60, 20);
//         sortBox.setBounds(425, 250, 100, 20);

//         minSalaryLbl.setBounds(550, 250, 100, 20);
//         minSalaryTxt.setBounds(550, 275, 100, 20);
//         maxSalaryLbl.setBounds(670, 250, 100, 20);
//         maxSalaryTxt.setBounds(670, 275, 100, 20);

//         finishBtn.setBounds(800, 250, 100, 20);
        



//         EmployeeIdLbl.setBounds(10, 10, 100, 20);
//         fnameLbl.setBounds(115, 10, 100, 20);
//         lnameLbl.setBounds(220, 10, 100, 20);
//         emailLbl.setBounds(325, 10, 100, 20);
//         phoneLbl.setBounds(430, 10, 100, 20);
//         salaryLbl.setBounds(535, 10, 100, 20);
//         hireDateLbl.setBounds(640, 10, 100, 20);
//         departmentLbl.setBounds(745, 10, 100, 20);
       
        
    
//         // addBtn.setBounds(20, 240, 90, 20);
//         // finishBtn.setBounds(115, 240, 90, 20);

       
//         getContentPane().add(searchLbl);
//         getContentPane().add(searchBox);
//         getContentPane().add(searchValueLbl);
//         getContentPane().add(searchValueTxt);

//         getContentPane().add(minSalaryLbl);
//         getContentPane().add(minSalaryTxt);
//         getContentPane().add(maxSalaryLbl);
//         getContentPane().add(maxSalaryTxt);

//         getContentPane().add(sortJLabel);
//         getContentPane().add(sortBox);
//         getContentPane().add(addBtn);
//         getContentPane().add(finishBtn);
//         getContentPane().add(EmployeeIdLbl);
//         getContentPane().add(fnameLbl);
//         getContentPane().add(lnameLbl);
//         getContentPane().add(emailLbl);
//         getContentPane().add(phoneLbl);
//         getContentPane().add(salaryLbl);
//         getContentPane().add(hireDateLbl);
//         getContentPane().add(departmentLbl);
//         setVisible(true);
//         setBackground(Color.WHITE);
//     }
//     // public  void actionPerformed(ActionEvent ae){
//     //    if(ae.getSource()==addBtn){
//     //     try{  
            
           
//     //         String query = "select * from employee";
//     //         if(searchBox.getSelectedIndex()<6&&searchBox.getSelectedIndex()>0&&!searchValueTxt.getText().isEmpty()){
//     //             if(searchBox.getSelectedIndex()==1)
//     //                 query = query+" where first_name like '%"+searchValueTxt.getText()+"%'";
//     //             else if(searchBox.getSelectedIndex()==2)
//     //             query = query+" where last_name like '%"+searchValueTxt.getText()+"%'";
//     //             else if(searchBox.getSelectedIndex()==3)
//     //             query = query+" where email like '%"+searchValueTxt.getText()+"%'";
//     //             else if(searchBox.getSelectedIndex()==4)
//     //             query = query+" where phoneNo like '%"+searchValueTxt.getText()+"%'";
//     //             else if(searchBox.getSelectedIndex()==5)
//     //             query = query+" where  department like '%"+searchValueTxt.getText()+"%'";
//     //                getContentPane().remove(table);  
//     //         }
    
//     //         if(!minSalaryTxt.getText().isEmpty()&&!maxSalaryTxt.getText().isEmpty()){
//     //             if(searchBox.getSelectedIndex()<6&&searchBox.getSelectedIndex()>0&&searchValueTxt.getText()!=null){
//     //                 query = query + " and salary between "+ Double.parseDouble(minSalaryTxt.getText())+" and " +Double.parseDouble(maxSalaryTxt.getText());
//     //             }
//     //             else
//     //                 query = query + " where salary between "+ Double.parseDouble(minSalaryTxt.getText())+" and " +Double.parseDouble(maxSalaryTxt.getText());
//     //             getContentPane().remove(table);
//     //         }
//     //         else if(!minSalaryTxt.getText().isEmpty()){
//     //             if(searchBox.getSelectedIndex()<6&&searchBox.getSelectedIndex()>0&&searchValueTxt.getText()!=null){
//     //                 query = query + " and salary >="+ Double.parseDouble(minSalaryTxt.getText());
//     //             }
//     //             else
//     //                 query = query + " and salary >="+ Double.parseDouble(minSalaryTxt.getText());
//     //             getContentPane().remove(table);
//     //         }
//     //         else if(!maxSalaryTxt.getText().isEmpty()){
//     //             if(searchBox.getSelectedIndex()<6&&searchBox.getSelectedIndex()>0&&searchValueTxt.getText()!=null){
//     //                 query = query + " and salary <="+ Double.parseDouble(maxSalaryTxt.getText());
//     //             }
//     //             else
//     //                 query = query + " and salary <="+ Double.parseDouble(maxSalaryTxt.getText());
//     //             getContentPane().remove(table);
//     //         }

//     //         if(sortBox.getSelectedIndex()<6&&sortBox.getSelectedIndex()>0){
//     //             if(sortBox.getSelectedIndex()==1)
//     //                 query = query+" order by first_name";
//     //             else if(sortBox.getSelectedIndex()==2)
//     //                 query = query+" order by last_name";
//     //             else if(sortBox.getSelectedIndex()==3)
//     //                 query = query+" order by email";
//     //             else if(sortBox.getSelectedIndex()==4)
//     //                 query = query+" order by phoneNo";
//     //             else if(sortBox.getSelectedIndex()==5)
//     //                 query = query+" order by salary";
//     //             else if(sortBox.getSelectedIndex()==6)
//     //                 query = query+" order by phoneNo";
//     //             else if(sortBox.getSelectedIndex()==7)
//     //                 query = query+" order by hire_date";
//     //             System.out.println(sortBox.getSelectedItem());
//     //             getContentPane().remove(table);
//     //         }

            
            

//     //         String[][] data = new String[10][8];
//     //         String[] headers = {"EmpId","First Name","Last Name","Email","Phone No","Salary","Hire Date","Department"};
//     //        int k=0;
//     //         for( int i = 0;i<employees.size();i++){
//     //             data[i][0] = employees.get(i).empId+"";
//     //             data[i][1] = employees.get(i).frist_name;
//     //             data[i][2] = employees.get(i).last_name;
//     //             data[i][3] = employees.get(i).email;
//     //             data[i][4] = employees.get(i).phoneNo;
//     //             data[i][5] = employees.get(i).salary+"";
//     //             data[i][6] = employees.get(i).hire_date;
//     //             data[i][7] = employees.get(i).department;
//     //             System.out.println(i);
//     //             System.out.println(data[i][1]);
//     //             k++;
//     //         }   
//     //         table = new JTable(data,headers);
//     //         table.setBounds(10, 30, 835, k*19);
//     //         table.setBackground(Color.white);
//     //         table.setForeground(Color.blue);
//     //         getContentPane().add(table);
            
//     //     }
//     //     catch(Exception e){  
//     //         //message.setText(e.getMessage());
//     //         System.out.println(e);
//     //     }   
      
//     //   }
//     //   if(ae.getSource() == finishBtn){
//     //       new runClient();
//     //     dispose();
//     // }
//     // }
    
//      public static void main(String[] args) {
//         DepartmentTable eml = new DepartmentTable();
//     }
     
// }
