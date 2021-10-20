package com.mayank.mymodule;




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    Withdrawl(String pin){
    	setTitle("Withdraw");
        this.pin = pin;
//        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/logo.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l3 = new JLabel(i3);
//        l3.setBounds(0, 0, 960, 1080);
//        add(l3);
        
//        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.jpg"));
//		Image newimg =  icon.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//		ImageIcon i3 = new ImageIcon(newimg); 
//		image = new JLabel(i3);
//		image.setBounds(10,10,150,60);
//		add(image);

        
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(100,50,400,20);
        add(l1);
        
        l2.setBounds(120,100,400,20);
        add(l2);
        
        t1.setBounds(100,150,330,30);
        add(t1);
        
        b1.setBounds(100,200,100,35);
        add(b1);
        
        b2.setBounds(330,200,100,35);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.gray);
        setSize(500,300);
        setLocation(500,0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.pst.executeQuery("select * from atm.bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("mode").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.pst.executeUpdate("insert into atm.bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
}
