package com.mayank.mymodule;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;

//        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/logo.jpg\""));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l3 = new JLabel(i3);
//        l3.setBounds(0, 0, 960, 1080);
//        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(100, 100, 400, 35);
        add(l1);

        b1.setBounds(200, 200, 150, 35);
        add(b1);
        int balance = 0;
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.pst.executeQuery("select * from atm.bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs "+balance);
        l1.setFont(new Font("oswarld", Font.BOLD, 18));

        b1.addActionListener(this);
        
        getContentPane().setBackground(Color.gray);
        setSize(700, 400);
        //setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
