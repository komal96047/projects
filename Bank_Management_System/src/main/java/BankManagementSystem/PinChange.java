package BankManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.*;

public class PinChange extends JFrame  implements ActionListener{
	
	JButton change,back;
	JPasswordField pin ,repin;
	JLabel text,pintext ,repintext,image;
	String pinnumber;
	PinChange(String pinnumber)
	{
		this.pinnumber=pinnumber;
		 setLayout(null);

	        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
	        ImageIcon i3 = new ImageIcon(i2);

	         image = new JLabel(i3);
	        image.setBounds(0, 0, 900, 900);
	        add(image);
		
	         text = new JLabel("CHANGE YOUR PIN");
	        text.setForeground(Color.white);
	        text.setFont(new Font("System" ,Font.BOLD ,16));
	        text.setBounds(250,280 , 500, 35);
	        image.add(text);
	        
	         pintext = new JLabel("New PIN :");
	        pintext.setForeground(Color.white);
	        pintext.setFont(new Font("System" ,Font.BOLD ,16));
	        pintext.setBounds(165,320 , 180, 25);
	        image.add(pintext);
	        
	         pin = new JPasswordField();
	        pin.setFont(new Font("Raleway" ,Font.BOLD,25));
	        pin.setBounds(330, 320, 180, 25);
	        image.add(pin);
	        
	         repintext = new JLabel(" RE-Enter New PIN :");
	        repintext.setForeground(Color.white);
	        repintext.setFont(new Font("System" ,Font.BOLD ,16));
	        repintext.setBounds(165,360 , 180, 25);
	        image.add(repintext);
	        
	         repin = new JPasswordField();
	        repin.setFont(new Font("Raleway" ,Font.BOLD,25));
	        repin.setBounds(330, 360, 180, 25);
	        image.add(repin);
	       
	        change=new JButton("CHANGE");
	        change.setBounds(355, 485, 150, 30);
	        change.addActionListener(this);
	        image.add(change);
	        
	        back=new JButton("BACK");
	        back.setBounds(355, 520, 150, 30);
	        back.addActionListener(this);
	        image.add(back);
	        
	        setSize(900, 900);
	        setLocation(300, 0);
	        setUndecorated(true);
	        setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == change)
		{
			try
			{
				String npin =pin.getText();
				String rpin =repin.getText();
				
				if(!npin.equals(rpin))
				{
					JOptionPane.showMessageDialog(null, "Enterd PIN does not match ");
					return;
				}
				
				if(npin.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter The New PIN ");
					return;
				}
				
				if(rpin.equals(""))
				{

					JOptionPane.showMessageDialog(null, "Please Re-Enter The PIN  ");
					return;
				}
				
				Conn conn = new Conn();
				String oldpin = pinnumber;
				
				String query1 = "UPDATE bank SET pinnumber = ? WHERE pinnumber = ?";
				String query2 = "UPDATE login SET pinnumber = ? WHERE pinnumber = ?";
				String query3 = "UPDATE signupthree SET pinnumber = ? WHERE pinnumber = ?";
				
				PreparedStatement ps1 = conn.con.prepareStatement(query1);
				PreparedStatement ps2 = conn.con.prepareStatement(query2);
				PreparedStatement ps3 = conn.con.prepareStatement(query3);
				
				// bank table
				ps1.setString(1, npin);
				ps1.setString(2, oldpin);
				ps1.executeUpdate();

				// login table
				ps2.setString(1, npin);
				ps2.setString(2, oldpin);
				ps2.executeUpdate();

				// signupthree table
				ps3.setString(1, npin);
				ps3.setString(2, oldpin);
				ps3.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
				setVisible(false);
                 new Transactions(rpin).setVisible(true);
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

}
