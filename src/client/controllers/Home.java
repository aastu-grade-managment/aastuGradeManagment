
package client.controllers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Home implements ActionListener {
    JPanel panel1;
    JPanel panel2;
    JButton p1;
    JButton p2;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JFrame frame ;
    Home(){
        this.frame = new JFrame();
        this.frame.setLayout(null);
        this.panel1 = new JPanel();
        this.panel2 = new JPanel();

        panel1.setBounds(20,100,400,400);
        panel2.setBounds(20,100,400,400);
        panel1.setBackground(Color.green);
        panel2.setBackground(Color.blue);
        p1 = new JButton("Page1");
        p2 = new JButton("Page2");

        button1 = new JButton("Button1");
        button1.setBounds(200, 200, 80, 80);
        button2 = new JButton("Button2");
        button3 = new JButton("Button3");
        button4 = new JButton("Button4");

        this.panel1.setLayout(null);
        this.panel1.add(button1);
        this.panel1.add(button2);
        this.frame.add(this.panel1);
        panel1.setVisible(false);

        this.panel2.setLayout(new FlowLayout());
        this.panel2.add(button3);
        this.panel2.add(button4);
        this.frame.add(this.panel2);
        panel2.setVisible(false);

        
        p1.addActionListener(this);
        p2.addActionListener(this);

        p1.setBounds(50, 50, 80, 20);
        p2.setBounds(150, 50, 80, 20);

        this.frame.add(p1);
        this.frame.add(p2);
        this.frame.setSize(700, 700);
    }

    public void setPanel1() {
        
    }

    public void setPanel2() {
      
    }
    public void actionPerformed(ActionEvent ea){
        if(ea.getSource() == p1){
            this.panel1.setVisible(true);
            panel2.setVisible(false);
            System.out.println("page1 is clicked");
        }
        else if(ea.getSource() == p2){
            this.panel2.setVisible(true);
            panel1.setVisible(false);
            System.out.println("page2 is clicked");
        }
    }
    public static void main(String[] args) {
        Home h = new Home();
        h.frame.setVisible(true);
    }
}

