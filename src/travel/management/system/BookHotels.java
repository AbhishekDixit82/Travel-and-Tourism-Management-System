package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BookHotels extends JFrame implements ActionListener {

    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookhotel, back;
    String username;

    BookHotels(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK HOTELS");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 24));
        text.setForeground(Color.red);
        add(text);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(480, 50, 600, 400);
        add(la1);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(40, 70, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 150, 25);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Hotels :");
        lblpackage.setBounds(40, 110, 150, 25);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 25);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblperson = new JLabel("Total Person :");
        lblperson.setBounds(40, 150, 150, 25);
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblperson);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        JLabel lbldays = new JLabel("No. of days :");
        lbldays.setBounds(40, 190, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);

        JLabel lblroom = new JLabel("AC/Non-AC :");
        lblroom.setBounds(40, 230, 150, 25);
        lblroom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblroom);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 25);
        add(cac);

        JLabel lblfood = new JLabel("Food Included :");
        lblfood.setBounds(40, 270, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 25);
        add(cfood);

        JLabel lblid = new JLabel("I'D :");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(44, 310, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 310, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 350, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone no. :");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 390, 150, 25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 150, 25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price :");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40, 430, 150, 25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 150, 25);
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
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.black);
        bookhotel.setForeground(Color.white);
        bookhotel.setBounds(200, 490, 120, 25);
        bookhotel.addActionListener(this);
        add(bookhotel);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name='" + chotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodinclude"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acsel = cac.getSelectedItem();
                    String foodsel = cfood.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acsel.equals("AC") ? ac : 0;
                        total += foodsel.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs. " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == bookhotel){
            try {
                Conn c = new Conn();
                String query = "insert into bookhotel values('" + labelusername.getText() + "','" + chotel.getSelectedItem() + "','" + tfpersons.getText() + "','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','" + labelnumber.getText() + "','" + labelphone.getText() + "','" + labelprice.getText() + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotels("Abhishek Dixit");
    }
}
