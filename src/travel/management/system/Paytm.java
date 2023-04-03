package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Paytm extends JFrame implements ActionListener {

    JButton back;

    Paytm() {
        setBounds(450, 150, 800, 600);
        setLayout(null);

        JLabel text = new JLabel("Any Payment and UPI on this no.");
        text.setBounds(100, 10, 500, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 24));
        text.setForeground(Color.red);
        add(text);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);

        back = new JButton("Back");
        back.setBounds(30, 500, 80, 40);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Payment();
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
