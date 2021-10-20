package com.mayank.mymodule;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3;
    String pin;
    Pin(String pin){
    	setTitle("PIN--CHANGE");
    	
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(60, 0, 150, 60);
        add(l4);
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 38));
        l1.setForeground(Color.WHITE);
        
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);
        
        l1.setBounds(180,10,800,35);
        add(l1);
        
        l2.setBounds(100,100,150,35);
        add(l2);
        
        l3.setBounds(100,150,200,35);
        add(l3);
        
        t1.setBounds(400,100,180,25);
        add(t1);
        
        t2.setBounds(400,150,180,25);
        add(t2);
        
        b1.setBounds(270,200,150,35);
        add(b1);
        
        b2.setBounds(270,250,150,35);
        add(b2);
        
        getContentPane().setBackground(Color.gray);
        setSize(700,400);
        setLocation(500,0);
        //setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = t1.getText();
            String rpin = t2.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn c1 = new Conn();
                String q1 = "update atm.bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update atm.login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update atm.signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

                c1.pst.executeUpdate(q1);
                c1.pst.executeUpdate(q2);
                c1.pst.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            
            }else if(ae.getSource()==b2){
                new Transaction(pin).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}
