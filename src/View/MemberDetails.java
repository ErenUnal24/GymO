package View;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


import model.*;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberDetails extends JFrame {

	
	static member member = new member();

	
	
	private Object[] memberData = null;
	private DefaultTableModel memberModel = null;
	
	
	
	
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberDetails frame = new MemberDetails(member);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberDetails(member member) throws SQLException {
		
		
		memberModel = new DefaultTableModel();
		Object[] colMemberName = new Object[9];
		colMemberName[0] = "SSN";
		colMemberName[1] = "Name";
		colMemberName[2] = "Surname";
		colMemberName[3] = "Age";
		colMemberName[4] = "Height";
		colMemberName[5] = "Weight";
		colMemberName[6] = "Fat";        
		colMemberName[7] = "Muscle";
		colMemberName[8] = "Password";

		
		memberModel.setColumnIdentifiers(colMemberName);
		memberData = new Object[9];
		for(int i=0; i < member.getMember(i).size(); i++) {
			memberData[0] = member.getMember(0).get(i).getSsn();
			memberData[1] = member.getMember(1).get(i).getName();
			memberData[2] = member.getMember(2).get(i).getSurname();
			memberData[3] = member.getMember(3).get(i).getAge();
			memberData[4] = member.getMember(4).get(i).getHeight();
			memberData[5] = member.getMember(5).get(i).getWeight();
			memberData[6] = member.getMember(6).get(i).getFat();
			memberData[7] = member.getMember(7).get(i).getMuscle();
			memberData[8] = member.getMember(8).get(i).getPassword();
			
			memberModel.addRow(memberData);
			
		}
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 482, 74);
		contentPane.add(scrollPane);
		
		table = new JTable(memberModel);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberGUI mGUI = new MemberGUI(member);
				mGUI.setVisible(true);
				dispose();		
				
			}
		});
		btnNewButton.setBounds(139, 162, 117, 29);
		contentPane.add(btnNewButton);
		
	}
}
