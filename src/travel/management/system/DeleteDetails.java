package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteDetails extends JFrame implements ActionListener {

    JButton back;
    String username;
    
    DeleteDetails(String username) {
        this.username = username;
        setBounds(450, 180, 870, 635);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id :");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setBounds(30, 170, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(30, 230, 150, 25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender :");
        lblgender.setBounds(30, 290, 150, 25);
        add(lblgender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 290, 150, 25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country :");
        lblcountry.setBounds(500, 50, 150, 25);
        add(lblcountry);

        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690, 50, 150, 25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address :");
        lbladdress.setBounds(500, 110, 150, 25);
        add(lbladdress);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(690, 110, 150, 25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone no. :");
        lblphone.setBounds(500, 170, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(690, 170, 150, 25);
        add(labelphone);

        JLabel lblenail = new JLabel("Email i'd :");
        lblenail.setBounds(500, 230, 150, 25);
        add(lblenail);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(650, 230, 150, 25);
        add(labelemail);

        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setBounds(350, 350, 100, 25);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 400, 600, 200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(600, 400, 600, 200);
        add(image1);

        try {
            Conn c = new Conn();
            String query = "select * from customers where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username= '"+username+"'");
            c.s.executeUpdate("delete from customers where username= '"+username+"'");
            c.s.executeUpdate("delete from bookpackages where username= '"+username+"'");
            c.s.executeUpdate("delete from bookhotel where username= '"+username+"'");
            
            JOptionPane.showMessageDialog(null, "Data deleted successfully!");
            System.exit(0);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new DeleteDetails("Abhishek Dixit");
    }
}
