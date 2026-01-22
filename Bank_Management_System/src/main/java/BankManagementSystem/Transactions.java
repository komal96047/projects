package BankManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposite,withdrawl,ministatement,pinchange,balanceenquriy,exit,fastcash;
	String pinnumber;
	 Transactions(String pinnumber) 
	 {
		 this.pinnumber=pinnumber;
	        setLayout(null);

	        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
	        ImageIcon i3 = new ImageIcon(i2);

	        JLabel image = new JLabel(i3);
	        image.setBounds(0, 0, 900, 900);
	        add(image);
	        
	        JLabel text= new JLabel(" Please Select Your Transaction");
	        text.setBounds(210, 300, 7000, 35);
	        text.setForeground(Color.white);
	        text.setFont(new Font("System",Font.BOLD,16));
	        image.add(text);
	        
	        deposite= new JButton("Deposite");
	        deposite.setBounds(170, 415, 150, 30);
	        deposite.addActionListener(this);
	        image.add(deposite);
	        
	        withdrawl= new JButton("Cash withdrawl");
	        withdrawl.setBounds(355, 415, 150, 30);
	        withdrawl.setBounds(355, 415, 150, 30);
	        withdrawl.addActionListener(this);
	        image.add(withdrawl);
	        
	        
	        ministatement = new JButton("Mini Statement");
	        ministatement .setBounds(355, 450, 150, 30);
	        ministatement.addActionListener(this);
	        image.add(ministatement);
	        
	        pinchange = new JButton("pin change ");
	        pinchange .setBounds(170, 450, 150, 30);
	        pinchange.addActionListener(this);
	        image.add(pinchange);
	        
	        fastcash = new JButton("fast cash ");
	        fastcash .setBounds(170, 485, 150, 30);
	        fastcash.addActionListener(this);
	        image.add(fastcash);
	        
	        balanceenquriy = new JButton("balance Enquriy ");
	        balanceenquriy .setBounds(355, 485, 150, 30);
	        balanceenquriy.addActionListener(this);
	        image.add(balanceenquriy);
	        
	        exit = new JButton("Exit");
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
		public void actionPerformed(ActionEvent ae) 
	 {
			if(ae.getSource()==exit)
			{
				System.exit(0);
			}else if (ae.getSource()== deposite)
			{
				setVisible(false);
				new Deposite(pinnumber).setVisible(true);
			}else if(ae.getSource()==withdrawl)
			{
				setVisible(false);
				new Withdrawl(pinnumber).setVisible(true);
			}else if(ae.getSource() == pinchange)
			{
				setVisible(false);
				new PinChange(pinnumber).setVisible(true);
			}else if(ae.getSource() == balanceenquriy)
			{
				setVisible(false);
				new BalanceEnquiry(pinnumber).setVisible(true);
			}else if (ae.getSource() == ministatement)
			{
//				setVisible(false);
				new MiniStatement(pinnumber).setVisible(true);
			}else if(ae.getSource() == fastcash)
			{
				setVisible(false);
				new  FastCash(pinnumber).setVisible(true);
			}
	}
	public static void main(String[] args) {
		new Transactions("");
	}


	

}
