package com.mayank.mymodule;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transaction extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    Transaction(String pin){
    	setTitle("Transaction");
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
//        l2.setBounds(0, 0, 960, 1080);
        l2.setBounds(40,4,250,90);
        add(l2);
        
        l1 = new JLabel("SELECT OPTION");
        l1.setForeground(Color.black);
        l1.setFont(new Font("System", Font.BOLD, 20));
        
       
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");
        
        setLayout(null);
        
        l1.setBounds(220,20,200,50);
        l1.setBackground(Color.black);
        l1.setForeground(Color.black);
        add(l1);
        
        b1.setBounds(200,100,200,50);
        b1.setFont(new Font("System", Font.BOLD, 16));
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        add(b1);
        
        b2.setBounds(200,160,200,50);
        b2.setFont(new Font("System", Font.BOLD, 16));
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        add(b2);
        
        b3.setBounds(200,220,200,50);
        b3.setFont(new Font("System", Font.BOLD, 16));
        b3.setBackground(Color.white);
        b3.setForeground(Color.black);
        add(b3);
        
        b4.setBounds(200,280,200,50);
        b4.setFont(new Font("System", Font.BOLD, 16));
        b4.setBackground(Color.white);
        b4.setForeground(Color.black);
        add(b4);
        
        b5.setBounds(200,340,200,50);
        b5.setFont(new Font("System", Font.BOLD, 16));
        b5.setBackground(Color.white);
        b5.setForeground(Color.black);
        add(b5);
        
        b6.setBounds(200,400,200,50);
        b6.setFont(new Font("System", Font.BOLD, 16));
        b6.setBackground(Color.white);
        b6.setForeground(Color.black);
        add(b6);
        
        b7.setBounds(200,460,200,50);
        b7.setFont(new Font("System", Font.BOLD, 16));
        b7.setBackground(Color.white);
        b7.setForeground(Color.black);
        add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        getContentPane().setBackground(Color.gray);
        
        setSize(640,700);
        setLocation(300,20);
        //setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()==b3){ 
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()==b4){ 
            new MiniStatement(pin).setVisible(true);
        }else if(ae.getSource()==b5){ 
            setVisible(false);
            new Pin(pin).setVisible(true);
        }else if(ae.getSource()==b6){ 
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()==b7){ 
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new Transaction("").setVisible(true);
    }
}
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class Transaction extends JFrame implements ActionListener{
//
//    JLabel l1;
//    JButton b1,b2,b3,b4,b5,b6,b7;
//    String pin;
//    Transaction(String pin){
//        this.pin = pin;
////        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/logo.jpg"));
////        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
////        ImageIcon i3 = new ImageIcon(i2);
////        JLabel l2 = new JLabel(i3);
////        l2.setBounds(0, 0, 200, 200);
////        add(l2);
//        
//       
//        
//        l1 = new JLabel("Please Select Your Transaction");
//        l1.setForeground(Color.BLACK);
//        l1.setFont(new Font("System", Font.BOLD, 16));
//        
//        
//       
//        b1 = new JButton("DEPOSIT");
//        b1.setActionCommand("b1");
//		b1.setToolTipText("DEPOSIT");
//		b1.setBackground(Color.BLACK);
//		b1.setForeground(Color.white);
//		//b1.setPreferredSize(new Dimension(100, 100));
//		b1.addActionListener(this);
//		
//        b2 = new JButton("CASH WITHDRAWL");
//        b2.setActionCommand("b2");
//		b2.setToolTipText("WITHDRAW");
//		b2.setBackground(Color.BLACK);
//		b2.setForeground(Color.white);
//		b2.addActionListener(this);
//        
//        b3 = new JButton("FAST CASH");
//        b3.setActionCommand("b3");
//		b3.setToolTipText("FAST CASH");
//		b3.setBackground(Color.BLACK);
//		b3.setForeground(Color.white);
//		b3.addActionListener(this);
//		
//        b4 = new JButton("MINI STATEMENT");
//        b4.setActionCommand("b4");
//		b4.setToolTipText("STATEMENT");
//		b4.setBackground(Color.BLACK);
//		b4.setForeground(Color.white);
//		b4.addActionListener(this);
//        
//        b5 = new JButton("PIN CHANGE");
//        b5.setActionCommand("b5");
//		b5.setToolTipText("CHANGE");
//		b5.setBackground(Color.BLACK);
//		b5.setForeground(Color.white);
//		b5.addActionListener(this);
//        
//        b6 = new JButton("BALANCE ENQUIRY");
//        b6.setActionCommand("b6");
//		b6.setToolTipText("CHECK");
//		b6.setBackground(Color.BLACK);
//		b6.setForeground(Color.white);
//		b6.addActionListener(this);
//        
//        b7 = new JButton("EXIT");
//        b7.setActionCommand("b7");
//		b7.setBackground(Color.BLACK);
//		b7.setForeground(Color.white);
//		b7.setBounds(0,0,100,100);
//		//b7.setPreferredSize(new Dimension(100, 100));
//		b7.addActionListener(this);
//        
//       JPanel p = new JPanel( new GridLayout(6,1,20,20));
//   
//        p.add(b1);
//        p.add(b2);
//        p.add(b3);
//        p.add(b4);
//        p.add(b5);
//        p.add(b6);
//        p.setBackground(Color.white);
//        
//        JPanel p1 = new JPanel(new FlowLayout());
//        p1.setBackground(Color.white);
//        p1.add(b7);
//        
//        
//   
//        
//        JPanel mainpanel = new JPanel(new BorderLayout(10,10));
//        add(mainpanel);
//        
//        
//        mainpanel.add(l1,BorderLayout.NORTH);
//        mainpanel.add(p,BorderLayout.CENTER);
//        mainpanel.add(p1,BorderLayout.SOUTH);
//        
//        mainpanel.setBackground(Color.white);
//        
//       
//        
//        
//    }
//    
//    public static void main(String[] args){
//    	JFrame frame = new JFrame("Transaction");
//		frame.setFont(new Font("System",Font.BOLD,22));
//		frame.setContentPane(new Transaction(""));
//		frame.getContentPane().setBackground(Color.white);
//		frame.setBounds(10, 10, 500, 400);
//		frame.setLocation(200, 0);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//    
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==b1){ 
//            //setVisible(false);
//          //  new Deposit(pin).setVisible(true);
//        }else if(ae.getSource()==b2){ 
//            //setVisible(false);
//            //new Withdrawl(pin).setVisible(true);
//        }else if(ae.getSource()==b3){ 
//            //setVisible(false);
//            //new FastCash(pin).setVisible(true);
//        }else if(ae.getSource()==b4){ 
//            //new MiniStatement(pin).setVisible(true);
//        }else if(ae.getSource()==b5){ 
//            //setVisible(false);
//            //new Pin(pin).setVisible(true);
//        }else if(ae.getSource()==b6){ 
//            //this.setVisible(false);
//            //new BalanceEnquiry(pin).setVisible(true);
//        }else if(ae.getSource()==b7){ 
//            System.exit(0);
//        }
//    }
//    
// 
//}
