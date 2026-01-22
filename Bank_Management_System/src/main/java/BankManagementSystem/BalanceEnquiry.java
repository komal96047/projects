//package BankManagementSystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//import javax.swing.*;
//
//public class BalanceEnquiry extends JFrame implements ActionListener {
//
//    JLabel image, balanceText;
//    JButton back;
//    String pinnumber;
//
//    BalanceEnquiry(String pinnumber) {
//        this.pinnumber = pinnumber;
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
//        ImageIcon i3 = new ImageIcon(i2);
//
//        image = new JLabel(i3);
//        image.setBounds(0, 0, 900, 900);
//        add(image);
//
//        back = new JButton("BACK");
//        back.setBounds(355, 520, 150, 30);
//        back.addActionListener(this);
//        image.add(back);
//
//        int balance = 0;   // ✅ moved outside
//
//        try {
//            Conn conn = new Conn();
//
//            String query ="SELECT * FROM bank WHERE pinnumber = ? ORDER BY date";
//
//            PreparedStatement ps = conn.con.prepareStatement(query);
//            ps.setString(1, pinnumber);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                String type = rs.getString("type");
//                int amount = rs.getInt("amount");
//
//                if (type.equalsIgnoreCase("Deposit")) {
//                    balance += amount;
//                } else if (type.equalsIgnoreCase("Withdraw")) {
//                    balance -= amount;
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // ✅ Label created ONCE (after calculation)
//        balanceText = new JLabel("Your Current Balance is Rs " + balance);
//        balanceText.setForeground(Color.WHITE);
//        balanceText.setFont(new Font("System", Font.BOLD, 16));
//        balanceText.setBounds(170, 300, 400, 30);
//        image.add(balanceText);
//
//        setSize(900, 900);
//        setLocation(300, 0);
//        setUndecorated(true);
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        setVisible(false);
//        new Transactions(pinnumber).setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new BalanceEnquiry("");
//    }
//}

package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel image, balanceText;
    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        int balance = 0;

        try {
            Conn conn = new Conn();

            String query =
                "SELECT type, amount FROM bank WHERE pinnumber = ?";
            PreparedStatement ps = conn.con.prepareStatement(query);
            ps.setString(1, pinnumber);

            ResultSet rs = ps.executeQuery();

//            while (rs.next()) {
//                String type = rs.getString("type");
//                int amount = rs.getInt("amount");
//
//                if (type.equalsIgnoreCase("Deposit")) {
//                    balance += amount;
//                } else if (type.equalsIgnoreCase("Withdraw")) {
//                    balance -= amount;
//                }
//            }
            
//	        while (rs.next())
//	        {
//	        	// ✅ balance calculation INSIDE loop
//                if (rs.getString("type").equalsIgnoreCase("Deposit")) {
//                    balance += Integer.parseInt(rs.getString("amount"));
//                } else {
//                    balance -= Integer.parseInt(rs.getString("amount"));
//                }
//	        }

            
            while (rs.next()) {

                String type = rs.getString("type").trim();
                int amount = rs.getInt("amount");

                switch (type.toLowerCase()) {
                    case "deposit":
                        balance += amount;
                        break;

                    case "withdraw":
                        balance -= amount;
                        break;

                    default:
                        // ignore
                }
            }

            balance = Math.max(balance, 0);

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        balanceText = new JLabel("Your Current Balance is Rs " + balance);
        balanceText.setForeground(Color.WHITE);
        balanceText.setFont(new Font("System", Font.BOLD, 16));
        balanceText.setBounds(170, 300, 400, 30);
        image.add(balanceText);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry(""); // pass valid pin
    }
}

