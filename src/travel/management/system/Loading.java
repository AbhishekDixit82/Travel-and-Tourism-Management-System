package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {

    Thread t;
    JProgressBar bar;
    String username;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();

                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);

                    
                }
                Thread.sleep(50);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        
        t = new Thread(this);
        this.username = username;
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, Please wait...");
        loading.setBounds(230, 130, 150, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        JLabel lusername = new JLabel("Welcome  "+username+" !");
        lusername.setBounds(20, 310, 400, 40);
        lusername.setForeground(Color.RED);
        lusername.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lusername);

        t.start();
        
        setVisible(true);
    }
    

    public static void main(String[] args) {
        new Loading("");
    }
}
