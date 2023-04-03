package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfusername,tfquestion,tfname,tfanswer,tfpassword;
    JButton search,retrieve,back;
    
    ForgetPassword(){
        setBounds(350,200,900,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,500);
        add(p1);
        
        JLabel lbusername = new JLabel("Username :");
        lbusername.setBounds(40, 20, 100, 25);
        lbusername.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(200, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBackground(Color.gray);
        search.setForeground(Color.white);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lbname = new JLabel("Name :");
        lbname.setBounds(40, 60, 100, 25);
        lbname.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lbquestion = new JLabel("Security Question :");
        lbquestion.setBounds(40, 100, 150, 25);
        lbquestion.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbquestion);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(200, 100, 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lbanswer = new JLabel("Answer :");
        lbanswer.setBounds(40, 140, 100, 25);
        lbanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(200, 140, 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.gray);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lbpassword = new JLabel("Password :");
        lbpassword.setBounds(40, 180, 100, 25);
        lbpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(200, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setBounds(180,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String querry = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(querry);
                while(rs.next()){
                tfname.setText(rs.getString("name"));
                tfquestion.setText(rs.getString("security"));
                
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == retrieve){
            try{
                String querry = "select * from account where answer = '"+tfanswer.getText()+"'AND username = '"+tfusername.getText()+"'";
                
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(querry);
                while(rs.next()){
                tfpassword.setText(rs.getString("password"));
                
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new ForgetPassword();
    }
}
