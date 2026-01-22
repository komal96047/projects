package BankManagementSystem;
import java.awt.*;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame  implements ActionListener{
	
	JTextField pannoTextFeild ,aadharTextFeild;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox Religion ,Category,Income,Education,Occupation;
	String formno;
	
	SignupTwo(String formno)
	{	
		this.formno=formno;
		
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
	
		JLabel additionalDetails =new JLabel("pageb 2 : Additional Details");
		additionalDetails .setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails .setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel religion =new JLabel("Religion:");
		religion.setFont(new Font("Raleway",Font.BOLD,20));
		religion.setBounds(110, 140, 100, 30);
		add(religion);
		
		String ValReligion[]={"Hindu" ,"Muslim" ,"sikh","Christian","other"};
		 Religion = new JComboBox(ValReligion);
		Religion.setBounds(300, 140, 400, 30);
		Religion.setBackground(Color.white);
		add(Religion);
		
		
		JLabel category =new JLabel("  Category:");
		category.setFont(new Font("Raleway",Font.BOLD,20));
		category.setBounds(100, 190, 200, 30);
		add(category);
		
		String Valcategory[]={"General","OBC","SC","ST","NT","VJNT"};
		 Category = new JComboBox(Valcategory);
		Category.setBounds(300, 190, 400, 30);
		Category.setBackground(Color.white);
		add(Category);
		
		
		JLabel income =new JLabel("Income:");
		income.setFont(new Font("Raleway",Font.BOLD,20));
		income.setBounds(100, 240, 200, 30);
		add(income);
		
		String valincome[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto10,00,000"};
		 Income = new JComboBox(valincome);
		Income.setBounds(300, 240, 400, 30);
		Income.setBackground(Color.white);
		add(Income);
		
		JLabel education =new JLabel("Educational:");
		education.setFont(new Font("Raleway",Font.BOLD,20));
		education.setBounds(100, 290, 200, 30);
		add(education);
		
		
		JLabel qulifaction=new JLabel("Qulifaction:");
		qulifaction.setFont(new Font("Raleway",Font.BOLD,20));
		qulifaction.setBounds(100, 315, 200, 30);
		add(qulifaction);
		
		String valeducation[]={"Non-Graduation","Graduate","Post-Graduate","Doctrate","Other"};
		 Education = new JComboBox(valeducation);
		Education.setBounds(300, 315, 400, 30);
		Education.setBackground(Color.white);
		add(Education);
		
		
		JLabel occupation=new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);
		
		
		String valoccupation[]={"Salaride","Self-Emplyoyed","Bussiness","Student","Retried","Other"};
		 Occupation = new JComboBox(valoccupation);
		Occupation.setBounds(300, 390, 400, 30);
		Occupation.setBackground(Color.white);
		add(Occupation);
		
		
		JLabel panno=new JLabel("PAN Number:");
		panno.setFont(new Font("Raleway",Font.BOLD,20));
		panno.setBounds(100, 440, 200, 30);
		add(panno);
		
		 pannoTextFeild=new JTextField();
		 pannoTextFeild.setFont(new Font("Raleway",Font.BOLD,14));
		 pannoTextFeild.setBounds(300, 440, 400, 30);
		add(pannoTextFeild);
		
		JLabel adhar=new JLabel("Aadhar Number:");
		adhar.setFont(new Font("Raleway",Font.BOLD,20));
		adhar.setBounds(100, 490, 200, 30);
		add(adhar);
		
		aadharTextFeild=new JTextField();
		aadharTextFeild.setFont(new Font("Raleway",Font.BOLD,14));
		aadharTextFeild.setBounds(300, 490, 400, 30);
		add(aadharTextFeild);
		
		JLabel senior=new JLabel("Senior Citizer:");
		senior.setFont(new Font("Raleway",Font.BOLD,20));
		senior.setBounds(100, 540, 200, 30);
		add(senior);
		
		    syes= new JRadioButton("Yes");
		    syes.setBounds(300, 540, 60, 30);
		    syes.setBackground(Color.white);
			add(syes);
			
			 sno =new JRadioButton("No");
			 sno.setBounds(450, 540, 120, 30);
			 sno.setBackground(Color.white);
			add(sno);
			
			ButtonGroup seniorgroup = new ButtonGroup();
			seniorgroup.add(syes);
			seniorgroup.add(sno);
		
		JLabel existingaccount=new JLabel(" Existing Account:");
		existingaccount.setFont(new Font("Raleway",Font.BOLD,20));
		existingaccount.setBounds(100, 590, 200, 30);
		add(existingaccount);
		
		 eyes= new JRadioButton("Yes");
		    eyes.setBounds(300, 590, 60, 30);
		    eyes.setBackground(Color.white);
			add(eyes);
			
			 eno =new JRadioButton("No");
			 eno.setBounds(450, 590, 120, 30);
			 eno.setBackground(Color.white);
			add(eno);
			
			ButtonGroup existinggroup = new ButtonGroup();
			existinggroup.add(syes);
			existinggroup.add(sno);
		
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
	  String fromno;// long
		String sreligion =(String)Religion.getSelectedItem(); // settext
		String scategory =(String)Category.getSelectedItem();
		String sincome =(String)Income.getSelectedItem();
		String seducation =(String)Education.getSelectedItem();
		String soccupation =(String)Occupation.getSelectedItem();

		String ssenior=null;
		if(syes.isSelected())
		{
			ssenior="Yes";
		} else if(sno.isSelected())
		{
			ssenior="No";
		}
		
	String sexistingaccount =null;
	if(eyes.isSelected())
	{
		sexistingaccount="Yes";
	}
	else if(eno.isSelected())
	{
		sexistingaccount="No";
	}
	
	
	String span= pannoTextFeild.getText();
	String saadhar =aadharTextFeild.getText();
	try 
	{
		    Conn c = new Conn();

		    String query =
		        "INSERT INTO signuptwo " +
		        "(formno, sreligion, scategory, sincome, seducation, soccupation, span, saadhar, sexistingaccount, ssenior) " +
		        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		    PreparedStatement ps = c.con.prepareStatement(query);

		    ps.setString(1, formno);
		    ps.setString(2, sreligion);
		    ps.setString(3, scategory);
		    ps.setString(4, sincome);
		    ps.setString(5, seducation);
		    ps.setString(6, soccupation);
		    ps.setString(7, span);
		    ps.setString(8, saadhar);
		    ps.setString(9, sexistingaccount);
		    ps.setString(10, ssenior);
		
		    ps.executeUpdate();

		    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
		    
		    // object of signup3
		    setVisible(false);
		    new SignupThree(formno).setVisible(true);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	public static void main(String[] args) {
		new SignupTwo("");
	}

}

