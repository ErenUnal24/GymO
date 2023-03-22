package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.*;
import java.awt.Font;


public class PtGUI extends JFrame {
	
	static pt pt = new pt();


	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PtGUI frame = new PtGUI(pt);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * 
	 */
	public PtGUI(pt pt) throws SQLException {
		
        JFrame Pt = new JFrame("Giriş Ekranı");



		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 494);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -11, 334, 477);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnMemberList = new JButton("Member List");
		btnMemberList.setBounds(73, 120, 185, 70);
		btnMemberList.setForeground(new Color(128, 128, 128));
		btnMemberList.setFont(new Font("Osaka", Font.BOLD, 15));
		btnMemberList.setBackground(Color.DARK_GRAY);
		panel.add(btnMemberList);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(73, 18, 185, 57);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon("/Users/a90549/Desktop/Ekran Resmi 2022-01-01 01.16.42.png"));
		panel.add(lblNewLabel);
		
		JButton btnPlan = new JButton("Plan");
		btnPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PtPlan plan = new PtPlan();
				plan.setVisible(true);
				dispose();
				
			}
		});
		btnPlan.setBounds(73, 230, 185, 70);
		btnPlan.setBackground(Color.DARK_GRAY);
		btnPlan.setFont(new Font("Osaka", Font.BOLD, 15));
		btnPlan.setForeground(new Color(128, 128, 128));
		panel.add(btnPlan);
		
				
				JButton btnNewButton = new JButton("Exit");
				btnNewButton.setBounds(105, 398, 117, 50);
				btnNewButton.setBackground(Color.DARK_GRAY);
				btnNewButton.setFont(new Font("Osaka", Font.BOLD, 15));
				btnNewButton.setForeground(new Color(128, 128, 128));
				panel.add(btnNewButton);
				
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {						
						LoginScreenGUI login = new LoginScreenGUI();
						login.setVisible(true);
						dispose();		
					}
				});
				btnBack.setForeground(Color.GRAY);
				btnBack.setFont(new Font("Osaka", Font.BOLD, 15));
				btnBack.setBackground(Color.DARK_GRAY);
				btnBack.setBounds(120, 353, 90, 40);
				panel.add(btnBack);
				
				JLabel lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setBounds(0, 6, 334, 471);
				lblNewLabel_1.setIcon(new ImageIcon("/Users/a90549/Downloads/pexels-ivan-samkov-4164765 (1) (1).jpg"));
				panel.add(lblNewLabel_1);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					
					}
				});
		btnMemberList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberListInPt mList;
				try {
					mList = new MemberListInPt(pt);
					mList.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			
			}
		});
		
			}

	

}
