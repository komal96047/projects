package BankManagementSystem;
import java.awt.*;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame  implements ActionListener{
	
	long random;
	JTextField nameTextFeild,fnameTextFeild,dobTextFeild,emailTextFeild,addressTextFeild ,cityTextFeild,stateTextFeild, pincodeTextFeild;
	JButton next;
	JRadioButton male,female,other,marride ,unmarride;
	JDateChooser dateChooser;
	
	
	SignupOne()
	{	setLayout(null);
		Random ram =new Random();
		 random=Math.abs((ram.nextLong()%9000L)+1000L);
		
		JLabel formno =new JLabel("APPLICATION FORM NO."+random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		
		JLabel personDetails =new JLabel("pageb 1 : Personal Details");
		personDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);
		
		JLabel name =new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(110, 140, 100, 30);
		add(name);
		
		nameTextFeild=new JTextField();
		nameTextFeild.setFont(new Font("Raleway",Font.BOLD,14));
		nameTextFeild.setBounds(300, 140, 400, 30);
		add(nameTextFeild);
		
		
		JLabel fname =new JLabel(" Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		 fnameTextFeild=new JTextField();
		fnameTextFeild.setFont(new Font("Raleway",Font.BOLD,14));
		fnameTextFeild.setBounds(300, 190, 400, 30);
		add(fnameTextFeild);
		
		JLabel dob =new JLabel(" Date of Brith:");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105,105,105) );
		add(dateChooser);
		
		JLabel gender =new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		 male= new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.white);
		add(male);
		
		 female =new JRadioButton("Female");
		female.setBounds(450, 290, 120, 30);
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(female);
		gendergroup.add(male);
		
		
		JLabel email=new JLabel("Email Address:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailTextFeild=new JTextField();
		emailTextFeild.setFont(new Font("Raleway",Font.BOLD,14));
		emailTextFeild.setBounds(300,340, 400, 30);
		add(emailTextFeild);
		
		JLabel marital=new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		 marride= new JRadioButton("marride");
		marride.setBounds(300, 390, 100, 30);
		marride.setBackground(Color.white);
		add(marride);
		
		 unmarride =new JRadioButton("unmarride");
		unmarride.setBounds(450, 390, 100, 30);
		unmarride.setBackground(Color.white);
		add(unmarride);
		
		 other =new JRadioButton("other");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.white);
		add(other);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(unmarride);
		maritalgroup.add(marride);
		maritalgroup.add(other);
		
		JLabel address=new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		 addressTextFeild=new JTextField();
		addressTextFeild.setFont(new Font("Raleway",Font.BOLD,14));
		addressTextFeild.setBounds(300, 440, 400, 30);
		add(addressTextFeild);
		
		JLabel city=new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		 cityTextFeild=new JTextField();
		cityTextFeild.setFont(new Font("Raleway",Font.BOLD,14));
		cityTextFeild.setBounds(300, 490, 400, 30);
		add(cityTextFeild);
		
		JLabel state=new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		 stateTextFeild=new JTextField();
		stateTextFeild.setFont(new Font("Raleway",Font.BOLD,14));
		stateTextFeild.setBounds(300, 540, 400, 30);
		add(stateTextFeild);
		
		JLabel pincode=new JLabel("Pin code:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		 pincodeTextFeild=new JTextField();
		pincodeTextFeild.setFont(new Font("Raleway",Font.BOLD,14));
		pincodeTextFeild.setBounds(300, 590, 400, 30);
		add(pincodeTextFeild);
		
		 next= new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont( new Font("Raleway", Font.BOLD,14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		
		setSize(850,800);
		setVisible(true);
		setLocation(350,10);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String formno =""+random;// long
		String name =nameTextFeild.getText(); // settext
		String fname =fnameTextFeild.getText();
//		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected())
		{
			gender="Male";
		} else if(female.isSelected())
		{
			gender="Female";
		}
		
	String email= emailTextFeild.getText();
	String marital =null;
	if(marride.isSelected())
	{
		marital="Marride";
	}
	else if(unmarride.isSelected())
	{
		marital="unmarried";
	}
	else if(other.isSelected())
	{
		marital="Other";
	}
	
	String address= addressTextFeild.getText();
	String city =cityTextFeild.getText();
	String state= stateTextFeild.getText();
	String pin= pincodeTextFeild.getText();
	
	try 
	{
		if(name.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Name is Requried");
		}
		else {
		    Conn c = new Conn();

		    String query =
		        "INSERT INTO signup " +
		        "(formno, name, fname, dob, gender, email, marital, address, city, state, pin) " +
		        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		    PreparedStatement ps = c.con.prepareStatement(query);

		    ps.setString(1, formno);
		    ps.setString(2, name);
		    ps.setString(3, fname);
		    java.util.Date utilDate = dateChooser.getDate();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    ps.setDate(4, sqlDate);
		    ps.setString(5, gender);
		    ps.setString(6, email);
		    ps.setString(7, marital);
		    ps.setString(8, address);
		    ps.setString(9, city);
		    ps.setString(10, state);
		    ps.setString(11, pin);

		    ps.executeUpdate();

		    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");

		    setVisible(false);
		    
		     new SignupTwo(formno).setVisible(true);  // for next page if you want
		}

	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	public static void main(String[] args) {
		new SignupOne();
	}

}
