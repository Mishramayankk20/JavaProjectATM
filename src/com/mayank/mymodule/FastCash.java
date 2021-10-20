package com.mayank.mymodule;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1, l2,image;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String pin;

    FastCash(String pin) {
    	setTitle("FAST-CASH");
        this.pin = pin;
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.jpg"));
		Image newimg =  icon.getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ImageIcon i3 = new ImageIcon(newimg); 
		image = new JLabel(i3);
		image.setBounds(10,20,250,90);//200,200
		add(image);
		
        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(160, 50, 700, 35);
        add(l1);

        b1.setBounds(120, 100, 150, 35);
        add(b1);

        b2.setBounds(300, 100, 150, 35);
        add(b2);

        b3.setBounds(120, 150, 150, 35);
        add(b3);

        b4.setBounds(300, 150, 150, 35);
        add(b4);

        b5.setBounds(120, 200, 150, 35);
        add(b5);

        b6.setBounds(300, 200, 150, 35);
        add(b6);

        b7.setBounds(200, 250, 150, 35);
        add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
     
        getContentPane().setBackground(Color.gray);
        setSize(600, 400);
        setLocation(500, 0);
       // setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.pst.executeQuery("select * from atm.bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                } else {
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            } String num = "17";
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transaction(pin).setVisible(true);
            }else{
                Date date = new Date();
                c.pst.executeUpdate("insert into bank atm.values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
