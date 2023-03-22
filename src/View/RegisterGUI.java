package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ShortCase.*;
import model.member;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class RegisterGUI extends JFrame {
	
	

	//static member member = new member();
	private JPanel p;
	private JTextField fieldName;
	private JTextField fieldSurname;
	private JTextField fieldSsn;
	private JTextField fieldPassword;
	private member member = new member();

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 494);
		p = new JPanel();
		p.setBackground(Color.LIGHT_GRAY);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(p);
		p.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/a90549/Desktop/Ekran Resmi 2022-01-01 01.16.42.png"));
		lblNewLabel_2.setBounds(39, 16, 262, 48);
		p.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 93, 78, 16);
		p.add(lblNewLabel);
		
		fieldName = new JTextField();
		fieldName.setForeground(Color.WHITE);
		fieldName.setBackground(SystemColor.inactiveCaptionText);
		fieldName.setBounds(65, 109, 207, 36);
		p.add(fieldName);
		fieldName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setForeground(new Color(192, 192, 192));
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setBounds(128, 163, 78, 16);
		p.add(lblSurname);
		
		fieldSurname = new JTextField();
		fieldSurname.setForeground(Color.WHITE);
		fieldSurname.setBackground(SystemColor.inactiveCaptionText);
		fieldSurname.setColumns(10);
		fieldSurname.setBounds(65, 178, 207, 36);
		p.add(fieldSurname);
		
		JLabel lblId = new JLabel("SSN");
		lblId.setForeground(new Color(192, 192, 192));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(128, 234, 78, 16);
		p.add(lblId);
		
		fieldSsn = new JTextField();
		fieldSsn.setForeground(Color.WHITE);
		fieldSsn.setBackground(SystemColor.inactiveCaptionText);
		fieldSsn.setColumns(10);
		fieldSsn.setBounds(65, 248, 207, 36);
		p.add(fieldSsn);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(192, 192, 192));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(128, 296, 78, 16);
		p.add(lblPassword);
		
		fieldPassword = new JTextField();
		fieldPassword.setForeground(Color.WHITE);
		fieldPassword.setBackground(SystemColor.inactiveCaptionText);
		fieldPassword.setColumns(10);
		fieldPassword.setBounds(65, 312, 207, 36);
		p.add(fieldPassword);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginScreenGUI login = new LoginScreenGUI();
				login.setVisible(true);
				dispose();

			}
		});
		btnBack.setBounds(99, 424, 139, 36);
		p.add(btnBack);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldName.getText().length() == 0 || fieldPassword.getText().length() == 0 || 
						fieldSurname.getText().length() == 0 || fieldSsn.getText().length() == 0) {
					ShortCase.showMessage("fill");
				}else {
					
						boolean control = member.register(fieldName.getText(), fieldSurname.getText(), Integer.parseInt(fieldSsn.getText()) , fieldPassword.getText());
						if(control) {
							ShortCase.showMessage("success");
							LoginScreenGUI login = new LoginScreenGUI();
							login.setVisible(true);
							dispose();
							
						}else {
							ShortCase.showMessage("error!! something goes wrong");
						}
				
					}
				}			
		});
		
		btnRegister.setBounds(99, 376, 139, 36);
		p.add(btnRegister);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/a90549/Downloads/pexels-ivan-samkov-4164765 (1) (1).jpg"));
		lblNewLabel_1.setBounds(0, 0, 334, 466);
		p.add(lblNewLabel_1);
		
			}
}
