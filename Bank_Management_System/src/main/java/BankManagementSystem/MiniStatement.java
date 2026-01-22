package BankManagementSystem;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        setTitle("MINI STATEMENT");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 360, 240);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 350, 20);
        add(balance);

        // ---------------- CARD NUMBER ----------------
        try {
            Conn conn = new Conn();
            String query = "SELECT cardnumber FROM login WHERE pinnumber = ?";
            PreparedStatement ps = conn.con.prepareStatement(query);
            ps.setString(1, pinnumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String cardNo = rs.getString("cardnumber");

                if (cardNo != null && cardNo.length() >= 16) {
                    card.setText("Card Number: "
                            + cardNo.substring(0, 4)
                            + "XXXXXXXX"
                            + cardNo.substring(12));
                }
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ---------------- MINI STATEMENT + BALANCE ----------------
        try {
            Conn conn = new Conn();
            int bal = 0;

            String query =
                "SELECT date, type, amount FROM bank WHERE pinnumber = ? ORDER BY date";
            PreparedStatement ps = conn.con.prepareStatement(query);
            ps.setString(1, pinnumber);

            ResultSet rs = ps.executeQuery();

            mini.setText("<html>");

            while (rs.next()) {

                String date = rs.getString("date");
                String type = rs.getString("type");
                int amount = rs.getInt("amount");

                mini.setText(mini.getText()
                        + date + "&nbsp;&nbsp;&nbsp;"
                        + type + "&nbsp;&nbsp;&nbsp;"
                        + amount + "<br><br>");

                // balance calculation
                if (type.equalsIgnoreCase("Deposit")) {
                    bal += amount;
                } else if (type.equalsIgnoreCase("Withdraw")) {
                    bal -= amount;
                }
            }

            mini.setText(mini.getText() + "</html>");


            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        // ✅ Pass a real pin number
        new MiniStatement("1234");
    }
}
