package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ShortCase.*;
import model.*;


public class LoginScreenGUI extends JFrame{

	 private JPanel panel1;
     private JTextPane textPane1;
     private JButton button1;
     private JButton button2;
     private JButton button3;
     private JTextField textField1;
     private JPasswordField passwordField1;
     
     
     private dbConnection connDb = new dbConnection();
     private JTextField fieldPtId;
     private JPasswordField fieldPtPassword;
     
/*
    public static Connection connect() {

        final String url = "jdbc:postgresql://localhost/postgres";
        final String user = "postgres";
        final String password = "123456";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    
    
    //private dbConnection con = new dbConnection();
    
*/

    public LoginScreenGUI(){
    	
        JFrame f = new JFrame("Giriş Ekranı");
        f.setSize(993,799);
        f.getContentPane().setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(258, 389, 400, 270);
        f.getContentPane().add(tabbedPane);
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(220, 220, 220));
        panel.setBackground(new Color(51, 51, 51));
        tabbedPane.addTab("Üye Girişi", null, panel, null);
        panel.setLayout(null);
        
        JButton btnLog1 = new JButton("Login");
        
        btnLog1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
			@Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(textField1.getText().length() == 0 || passwordField1.getText().length() == 0) {
            		ShortCase.showMessage("fill");
            	}else {
            		try {
                		Connection con = connDb.conn();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM member");
						while(rs.next()) {
							if(textField1.getText().equals(rs.getString("ssn")) && passwordField1.getText().equals(rs.getString("password"))) {
								
								member uye = new member ();
								
								uye.setPassword(rs.getString("password"));
								uye.setAge(rs.getInt("age"));
								uye.setName(rs.getString("name"));
								uye.setSurname(rs.getString("surname"));
								uye.setHeight(rs.getInt("height"));
								uye.setWeight(rs.getInt("weight"));
								uye.setFat(rs.getInt("fat"));
								uye.setMuscle(rs.getInt("muscle"));
								uye.setPayment(rs.getString("payment"));
								uye.setExpiration(rs.getString("expiration"));								
								uye.setSsn(rs.getInt("ssn"));
							
								MemberGUI mGUI = new MemberGUI(uye);
								mGUI.setVisible(true);
								f.dispose();							
							}else {
						        System.out.println("something goes wrong");														
							}				
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            } // end of action event
        }); //end of actionListeneer
               			       			      		       		       
        btnLog1.setBounds(187, 147, 100, 35);
        btnLog1.setForeground(Color.BLACK);
        btnLog1.setFont(new Font("Osaka", Font.PLAIN, 16));
        btnLog1.setBackground(Color.BLACK);
       panel.add(btnLog1);
        
        JButton btnReg1 = new JButton("Register");
        btnReg1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		RegisterGUI rGUI = new RegisterGUI();
        		rGUI.setVisible(true);
        		dispose();     		
        	}
        });
        btnReg1.setBounds(197, 182, 80, 29);
        btnReg1.setForeground(Color.BLACK);
        btnReg1.setBackground(Color.BLACK);
        panel.add(btnReg1);
        
        textField1 = new JTextField();
        textField1.setBounds(134, 47, 210, 35);
        textField1.setForeground(Color.WHITE);
        textField1.setBackground(SystemColor.inactiveCaption);
        panel.add(textField1);
        
        JLabel l1_1 = new JLabel("Username:");
        l1_1.setBounds(25, 53, 97, 23);
        l1_1.setForeground(Color.WHITE);
        l1_1.setFont(new Font("Osaka", Font.PLAIN, 18));
        panel.add(l1_1);
        
        JLabel l1_2 = new JLabel("Password:");
        l1_2.setBounds(25, 106, 97, 23);
        l1_2.setForeground(Color.WHITE);
        l1_2.setFont(new Font("Osaka", Font.PLAIN, 18));
        panel.add(l1_2);
        
        passwordField1 = new JPasswordField();
        passwordField1.setBounds(134, 99, 210, 36);
        passwordField1.setBackground(SystemColor.inactiveCaption);
        panel.add(passwordField1);
        
        JLabel lblNewLabel = new JLabel("Member Login");
        lblNewLabel.setFont(new Font("Osaka", Font.BOLD, 17));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(142, 6, 128, 35);
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setForeground(new Color(245, 245, 245));
        panel_1.setBackground(new Color(51, 51, 51));
        
        tabbedPane.addTab("Pt Girişi", null, panel_1, null);
        
        JButton btnPtLogin = new JButton("Login");
        btnPtLogin.setBounds(175, 142, 100, 35);
        btnPtLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(fieldPtId.getText().length() == 0 || fieldPtPassword.getText().length() == 0) {
            		ShortCase.showMessage("fill");
            	}else {
            		try {
                		Connection con = connDb.conn();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM member");
						while(rs.next()) {
							if(fieldPtId.getText().equals(rs.getString("ssn")) && fieldPtPassword.getText().equals(rs.getString("password"))) {
								
								pt ptn = new pt();
								
								ptn.setPassword(rs.getString("password"));
								ptn.setAge(rs.getInt("age"));
								ptn.setName(rs.getString("name"));
								ptn.setSurname(rs.getString("surname"));
								ptn.setHeight(rs.getInt("height"));
								ptn.setWeight(rs.getInt("weight"));
								ptn.setFat(rs.getInt("fat"));
								ptn.setMuscle(rs.getInt("muscle"));
								ptn.setPayment(rs.getString("payment"));
								ptn.setExpiration(rs.getString("expiration"));								
								ptn.setSsn(rs.getInt("ssn"));
								//ptn.setPosition(rs.getString("pt"));
							
								PtGUI pGUI = new PtGUI(ptn);
								pGUI.setVisible(true);
								f.dispose();
							
							}else {
						        System.out.println("something goes wrong");
														
							}
				
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}        		
        	}
        });
        panel_1.setLayout(null);
        btnPtLogin.setForeground(new Color(220, 220, 220));
        btnPtLogin.setFont(new Font("Osaka", Font.PLAIN, 16));
        btnPtLogin.setBackground(new Color(105, 105, 105));
        panel_1.add(btnPtLogin);
        
        fieldPtId = new JTextField();
        fieldPtId.setBounds(130, 48, 210, 35);
        fieldPtId.setForeground(Color.WHITE);
        fieldPtId.setBackground(SystemColor.inactiveCaption);
        panel_1.add(fieldPtId);
        
        JLabel l1_1_1 = new JLabel("Username:");
        l1_1_1.setBounds(27, 54, 91, 23);
        l1_1_1.setForeground(Color.WHITE);
        l1_1_1.setFont(new Font("Osaka", Font.PLAIN, 18));
        panel_1.add(l1_1_1);
        
        JLabel l1_2_1 = new JLabel("Password:");
        l1_2_1.setBounds(27, 101, 91, 23);
        l1_2_1.setForeground(Color.WHITE);
        l1_2_1.setFont(new Font("Osaka", Font.PLAIN, 18));
        panel_1.add(l1_2_1);
        
        fieldPtPassword = new JPasswordField();
        fieldPtPassword.setBounds(130, 95, 210, 35);
        fieldPtPassword.setBackground(SystemColor.inactiveCaption);
        panel_1.add(fieldPtPassword);
        
        JButton btnReg1_1 = new JButton("Register");
        btnReg1_1.setBounds(185, 177, 80, 29);
        btnReg1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		RegisterGUI rGUI = new RegisterGUI();
        		rGUI.setVisible(true);
        		dispose();
  		
        	}
        });
        btnReg1_1.setForeground(new Color(211, 211, 211));
        btnReg1_1.setBackground(new Color(105, 105, 105));
        panel_1.add(btnReg1_1);
        
        JLabel lblPtLogin = new JLabel("PT Login");
        lblPtLogin.setBounds(158, 6, 85, 35);
        lblPtLogin.setForeground(Color.WHITE);
        lblPtLogin.setFont(new Font("Osaka", Font.BOLD, 17));
        panel_1.add(lblPtLogin);
                
        JLabel lblLogo = new JLabel("GYMNASIUM");
        lblLogo.setBounds(40, 67, 332, 156);
        lblLogo.setForeground(new Color(176, 59, 40));
        lblLogo.setFont(new Font("Rockwell", Font.BOLD, 40));
        f.getContentPane().add(lblLogo);
        
        JLabel imageLabel = new JLabel("New label");
        imageLabel.setBounds(0, 0, 993, 772);
        imageLabel.setIcon(new ImageIcon("/Users/a90549/Desktop/gymimages/LoginImage (1).png"));
        f.getContentPane().add(imageLabel);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }   
}