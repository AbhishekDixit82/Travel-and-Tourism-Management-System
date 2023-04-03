package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JPanel p1,p2;
    JTextField tfuser,tfpassword;
    JButton login,signup,fpassword;
    
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
                
        p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0 , 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);
        
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);
        
        JLabel username = new JLabel("Username ");
        username.setBounds(60, 20, 100, 25);
        username.setFont(new Font("SAN SARIF",Font.PLAIN,20));
        p2.add(username);
        
        tfuser = new JTextField();
        tfuser.setBounds(60,60,300,30);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfuser);
        
        JLabel password = new JLabel("Password ");
        password.setBounds(60, 110, 100, 25);
        password.setFont(new Font("SAN SARIF",Font.PLAIN,20));
        p2.add(password);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Login Now");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Sign Up");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.white);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        p2.add(signup);
        
        fpassword = new JButton("Forgot Password");
        fpassword.setBounds(140, 250, 130, 30);
        fpassword.setBackground(new Color(133,193,233));
        fpassword.setForeground(Color.white);
        fpassword.setBorder(BorderFactory.createEmptyBorder());
        fpassword.addActionListener(this);
        p2.add(fpassword);
        
        JLabel text = new JLabel("Trouble in Login...");
        text.setBounds(300,270,150,20);
        text.setForeground(Color.red);
        p2.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tfuser.getText();
                String password = tfpassword.getText();
                
                String querry = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(querry);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                    
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignUp();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
