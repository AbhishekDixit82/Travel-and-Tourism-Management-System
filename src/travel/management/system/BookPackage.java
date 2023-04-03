package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tfpersons;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;
    String username;

    BookPackage(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 24));
        text.setForeground(Color.red);
        add(text);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 50, 700, 300);
        add(la1);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(40, 70, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 100, 25);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Package :");
        lblpackage.setBounds(40, 110, 150, 25);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(200, 110, 200, 25);
        add(cpackage);

        JLabel lblperson = new JLabel("Total Person :");
        lblperson.setBounds(40, 150, 150, 25);
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblperson);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(200, 150, 200, 25);
        add(tfpersons);

        JLabel lblid = new JLabel("I'D :");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(44, 190, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 190, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 230, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone no. :");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 270, 150, 25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 150, 25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price :");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40, 310, 150, 25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 310, 150, 25);
        add(labelprice);

        try {
            Conn c = new Conn();
            String query = "select * from customers where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")) {
                cost += 12000;
            } else if (pack.equals("Silver Package")) {
                cost += 25000;
            } else {
                cost += 32000;
            }

            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs. " + cost);
        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                String query = "insert into bookpackages values('" + labelusername.getText() + "','" + cpackage.getSelectedItem() + "','" + tfpersons.getText() + "','" + labelid.getText() + "','" + labelnumber.getText() + "','" + labelphone.getText() + "','" + labelprice.getText() + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("Abhishek Dixit");
    }
}
