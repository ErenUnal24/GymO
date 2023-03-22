package View;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ShortCase.ShortCase;
import model.member;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class MemberGUI extends JFrame {

	static member member = new member();
	private JPanel w_pane;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberGUI frame = new MemberGUI(member);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public MemberGUI(member member) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 494);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(w_pane);
		
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome, " + member.getName());
		lblNewLabel.setBounds(114, 83, 196, 34);
		w_pane.add(lblNewLabel);

		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			
			}
		});
		
		btnNewButton.setBounds(111, 394, 117, 50);
		w_pane.add(btnNewButton);
		
		JButton btnInfo = new JButton("Membership Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				
				JOptionPane.showMessageDialog(null, "Expiration day is :" + member.getExpiration()
				+ " Today is : " + timeStamp);
				
				
				
				
			/*	LocalDate d1 = LocalDate.parse(member.getExpiration(), DateTimeFormatter.ISO_LOCAL_DATE);
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				LocalDate d2 = LocalDate.parse(timeStamp, DateTimeFormatter.ISO_LOCAL_DATE);
				Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
				long diffDays = diff.toDays();
				
				System.out.println(diffDays);

*/

				
				
					
				
				//Date diff = new Date(date2.getTime() - date1.getTime());
				
			
			}
		});
		btnInfo.setBounds(80, 127, 185, 55);
		w_pane.add(btnInfo);
		
		JButton btnDetails = new JButton("Personel Details");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberDetails mDetail;
				try {
					mDetail = new MemberDetails(member);
					mDetail.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			
			}
		});
		
				
				
				
			
		btnDetails.setBounds(80, 194, 185, 55);
		w_pane.add(btnDetails);
		
		JButton btnNewButton_1_2 = new JButton("My Workout Plan");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PtPlan plan1 = new PtPlan();
				plan1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setBounds(80, 261, 185, 55);
		w_pane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/a90549/Desktop/Ekran Resmi 2022-01-01 01.16.42.png"));
		lblNewLabel_2.setBounds(39, 6, 261, 42);
		w_pane.add(lblNewLabel_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginScreenGUI login = new LoginScreenGUI();
				login.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(118, 348, 100, 40);
		w_pane.add(btnBack);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/a90549/Downloads/pexels-ivan-samkov-4164765 (1) (1).jpg"));
		lblNewLabel_3.setBounds(0, 0, 345, 466);
		w_pane.add(lblNewLabel_3);
		
			}
}
