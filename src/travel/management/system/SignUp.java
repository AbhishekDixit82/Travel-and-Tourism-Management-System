package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener {

    JButton create, back;
    JTextField tfuser, tfname, tfpassword, tfanswer;
    Choice security;
    JPanel p1;
    JLabel lusername, sname, spassword, lsecurity, lanswer;
    ImageIcon i1;

    SignUp() {
        setBounds(350, 200, 1000, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        lusername = new JLabel("Username :");
        lusername.setFont(new Font("Tamoha", Font.BOLD, 14));
        lusername.setBounds(50, 20, 125, 25);
        p1.add(lusername);

        tfuser = new JTextField();
        tfuser.setBounds(190, 20, 180, 25);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfuser);

        sname = new JLabel("Name :");
        sname.setFont(new Font("Tamoha", Font.BOLD, 14));
        sname.setBounds(50, 60, 125, 25);
        p1.add(sname);

        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        spassword = new JLabel("Password :");
        spassword.setFont(new Font("Tamoha", Font.BOLD, 14));
        spassword.setBounds(50, 100, 125, 25);
        p1.add(spassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        lsecurity = new JLabel("Security Question:");
        lsecurity.setFont(new Font("Tamoha", Font.BOLD, 14));
        lsecurity.setBounds(50, 140, 125, 25);
        p1.add(lsecurity);

        security = new Choice();
        security.add("School Name");
        security.add("Childhood Name");
        security.add("Favourite City");
        security.add("Favourite Movie");
        security.add("Your Fathers Name");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);

        lanswer = new JLabel("Answer :");
        lanswer.setFont(new Font("Tamoha", Font.BOLD, 14));
        lanswer.setBounds(50, 180, 125, 25);
        p1.add(lanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        create = new JButton("Create");
        create.setBackground(Color.white);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80, 250, 100, 30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(250, 250, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String username = tfuser.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();

            String querry = "insert into account values('" + username + "','" + name + "','" + password + "','" + question + "','" + answer + "')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(querry);
                JOptionPane.showMessageDialog(null, "Account Successfully Created.");

                setVisible(false);
                new Login();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
