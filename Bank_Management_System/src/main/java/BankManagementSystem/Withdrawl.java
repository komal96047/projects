package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	JButton withdrawl,back;
	String pinnumber;
	JTextField amount;
	Withdrawl(String pinnumber)
	{     
		this.pinnumber=pinnumber;
		setLayout(null);
			
	ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
    ImageIcon i3 = new ImageIcon(i2);

    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 900, 900);
    add(image);
	
	JLabel text =new JLabel("Enter the amount to withdrawl");
	text.setForeground(Color.white);
	text.setFont(new Font("System",Font.BOLD,16));
	text.setBounds(170, 300, 400, 20);
	image.add(text);
	
	amount =new JTextField();
	amount.setFont(new Font("Raleway",Font.BOLD,22));
	amount.setBounds(170, 350, 320, 25);
	image.add(amount);
	
	withdrawl =new JButton("withdrawl");
	withdrawl.setBounds(355, 485, 150, 30);
	withdrawl.addActionListener(this);
	image.add(withdrawl);        
	
	back =new JButton("Back");
	back.setBounds(355, 520, 150, 30);
	back.addActionListener(this);
	image.add(back);        
	
	
	
    setSize(900, 900);
	 setLocation(300, 0);
	  setVisible(true);    
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == withdrawl)
		{
			String number = amount.getText();
			Date date= new Date();
			if(number.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdrawl");
			}
			else {
				Conn conn=new Conn();
				String query="INSERT INTO bank " + "(pinnumber, date, type, amount) " +"VALUES (?, ?, ?,?)";
				  try {
					PreparedStatement ps = conn.con.prepareStatement(query);
					ps.setString(1, pinnumber);
					 ps.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
					 ps.setString(3, "withdrawl");
					 ps.setString(4, number);
					 ps.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Rs  "+number+" withdrawl Sucessfully");
					 setVisible(false);
					 new Transactions(pinnumber).setVisible(true);
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
		}
		else if(ae.getSource() == back)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		new Withdrawl("");
	}
	

}
