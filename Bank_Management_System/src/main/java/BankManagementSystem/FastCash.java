package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposite,withdrawl,ministatement,pinchange,balanceenquriy,exit,fastcash;
	String pinnumber;
	FastCash(String pinnumber) 
	 {
		 this.pinnumber=pinnumber;
	        setLayout(null);

	        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
	        ImageIcon i3 = new ImageIcon(i2);

	        JLabel image = new JLabel(i3);
	        image.setBounds(0, 0, 900, 900);
	        add(image);
	        
	        JLabel text= new JLabel(" SELECT WITHDRAWL AMOUNT");
	        text.setBounds(210, 300, 7000, 35);
	        text.setForeground(Color.white);
	        text.setFont(new Font("System",Font.BOLD,16));
	        image.add(text);
	        
	        deposite= new JButton("Rs 100");
	        deposite.setBounds(170, 415, 150, 30);
	        deposite.addActionListener(this);
	        image.add(deposite);
	        
	        withdrawl= new JButton("Rs 200");
	        withdrawl.setBounds(355, 415, 150, 30);
	        withdrawl.setBounds(355, 415, 150, 30);
	        withdrawl.addActionListener(this);
	        image.add(withdrawl);
	        
	        
	        ministatement = new JButton("Rs 500");
	        ministatement .setBounds(355, 450, 150, 30);
	        ministatement.addActionListener(this);
	        image.add(ministatement);
	        
	        pinchange = new JButton("Rs 1000 ");
	        pinchange .setBounds(170, 450, 150, 30);
	        pinchange.addActionListener(this);
	        image.add(pinchange);
	        
	        fastcash = new JButton("Rs 2000");
	        fastcash .setBounds(170, 485, 150, 30);
	        fastcash.addActionListener(this);
	        image.add(fastcash);
	        
	        balanceenquriy = new JButton("Rs 100000 ");
	        balanceenquriy .setBounds(355, 485, 150, 30);
	        balanceenquriy.addActionListener(this);
	        image.add(balanceenquriy);
	        
	        exit = new JButton("back");
	        exit .setBounds(355, 520, 150, 30);
	        exit.addActionListener(this);
	        image.add(exit);
	        

	        setSize(900, 900);
	        setLocation(300, 0);
	        setUndecorated(true);
	        setVisible(true);
//	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	
	@Override
	public void actionPerformed(ActionEvent ae) {

	    if (ae.getSource() == exit) {
	        setVisible(false);
	        new Transactions(pinnumber).setVisible(true);
	        return;
	    }

	    String amountText = ((JButton) ae.getSource()).getText();
	    int amount = Integer.parseInt(amountText.replace("Rs", "").trim());

	    Conn conn = new Conn();

	    try {
	        // 1️⃣ Calculate balance
	        String query = "SELECT * FROM bank WHERE pinnumber = ?";
	        PreparedStatement ps = conn.con.prepareStatement(query);
	        ps.setString(1, pinnumber);

	        ResultSet rs = ps.executeQuery();

	        int balance = 0;
	        while (rs.next()) {
	        	// ✅ balance calculation INSIDE loop
                if (rs.getString("type").equalsIgnoreCase("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
	        }

	        // 2️⃣ Insufficient balance check
//	        if (balance < amount) {
//	            JOptionPane.showMessageDialog(null, "Insufficient Balance");
//	            return;
//	        }

	        // 3️⃣ Insert withdrawal correctly
	        String insertQuery =
	                "INSERT INTO bank (pinnumber, date, type, amount) VALUES (?, ?, ?, ?)";

	        PreparedStatement ps1 = conn.con.prepareStatement(insertQuery);
	        ps1.setString(1, pinnumber.trim());
	        ps1.setDate(2, new java.sql.Date(new Date().getTime()));
	        ps1.setString(3, "Withdraw");
	        ps1.setString(4, String.valueOf(amount));

	        ps1.executeUpdate();

	        JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdraw Successfully");
	        setVisible(false);
	        new Transactions(pinnumber).setVisible(true);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public static void main(String[] args) {
		new FastCash("");
	}
}
