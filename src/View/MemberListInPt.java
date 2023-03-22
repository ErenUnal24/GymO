package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import model.*;
import ShortCase.*;
import View.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MemberListInPt extends JFrame {

	private JPanel contentPane;
	private JTable tableMember;

	static pt pt = new pt();
	
	private Object[] memberData = null;
	private DefaultTableModel memberModel = null;
	private JTextField fldName;
	private JTextField fldSurname;
	private JTextField fldAge;
	private JTextField fldHeight;
	private JTextField fldWeight;
	private JTextField fldFat;
	private JTextField fldMuscle;
	private JTextField fldSsn;
	private JTextField fldPassword;
	private JTextField fldDelete;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberListInPt frame = new MemberListInPt(pt);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the frame.
	 */
	

	
	public MemberListInPt(pt pt ) throws SQLException  {
		
		
		
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
		for(int i=0; i < pt.getMemberList().size(); i++) {
			memberData[0] = pt.getMemberList().get(i).getSsn();
			memberData[1] = pt.getMemberList().get(i).getName();
			memberData[2] = pt.getMemberList().get(i).getSurname();
			memberData[3] = pt.getMemberList().get(i).getAge();
			memberData[4] = pt.getMemberList().get(i).getHeight();
			memberData[5] = pt.getMemberList().get(i).getWeight();
			memberData[6] = pt.getMemberList().get(i).getFat();
			memberData[7] = pt.getMemberList().get(i).getMuscle();
			memberData[8] = pt.getMemberList().get(i).getPassword();

			memberModel.addRow(memberData);
			
		}
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Member List");
		lblNewLabel.setBounds(523, 13, 118, 21);
		lblNewLabel.setFont(new Font("Osaka", Font.BOLD, 20));
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollMember = new JScrollPane();
		scrollMember.setBounds(283, 45, 611, 441);
		getContentPane().add(scrollMember);
		
		tableMember = new JTable(memberModel);
		scrollMember.setViewportView(tableMember);
		tableMember.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				
				fldDelete.setText(tableMember.getValueAt(tableMember.getSelectedRow(), 0).toString());
				
				
				
			}
		
		});
		
		tableMember.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectSsn = Integer.parseInt(tableMember.getValueAt(tableMember.getSelectedRow(),0).toString());
					String selectName = tableMember.getValueAt(tableMember.getSelectedRow(),1).toString();
					String selectSurname = tableMember.getValueAt(tableMember.getSelectedRow(),2).toString();
					int selectAge = Integer.parseInt(tableMember.getValueAt(tableMember.getSelectedRow(),3).toString());
					int selectHeight = Integer.parseInt(tableMember.getValueAt(tableMember.getSelectedRow(),4).toString());
					int selectWeight= Integer.parseInt(tableMember.getValueAt(tableMember.getSelectedRow(),5).toString());
					int selectFat = Integer.parseInt(tableMember.getValueAt(tableMember.getSelectedRow(),6).toString());
					int selectMuscle = Integer.parseInt(tableMember.getValueAt(tableMember.getSelectedRow(),7).toString());
					String selectPassword = tableMember.getValueAt(tableMember.getSelectedRow(),8).toString();

					
					try {
						boolean control = pt.editMember(selectSsn, selectName, selectSurname, selectAge, selectHeight, selectWeight, selectFat, selectMuscle, selectPassword);
						if(control) {
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
				}				
			}
		});
	
	

		
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setBounds(10, 29, 61, 16);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2.setBackground(new Color(220, 220, 220));
		lblNewLabel_2.setForeground(new Color(245, 245, 245));
		getContentPane().add(lblNewLabel_2);
		
		fldName = new JTextField();
		fldName.setBounds(92, 15, 179, 45);
		fldName.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		fldName.setForeground(new Color(245, 245, 245));
		fldName.setBackground(new Color(105, 105, 105));
		getContentPane().add(fldName);
		fldName.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Surname:");
		lblNewLabel_2_1.setBounds(10, 74, 74, 16);
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2_1.setBackground(new Color(220, 220, 220));
		lblNewLabel_2_1.setForeground(new Color(245, 245, 245));
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Height:");
		lblNewLabel_2_1_1.setBounds(10, 164, 61, 16);
		lblNewLabel_2_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBackground(new Color(220, 220, 220));
		lblNewLabel_2_1_1.setForeground(new Color(245, 245, 245));
		getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Age:");
		lblNewLabel_2_2.setBounds(10, 119, 61, 16);
		lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2_2.setBackground(new Color(220, 220, 220));
		lblNewLabel_2_2.setForeground(new Color(245, 245, 245));
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Fat (%):");
		lblNewLabel_2_1_2.setBounds(10, 254, 61, 16);
		lblNewLabel_2_1_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBackground(new Color(220, 220, 220));
		lblNewLabel_2_1_2.setForeground(new Color(245, 245, 245));
		getContentPane().add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Weight:");
		lblNewLabel_2_3.setBounds(10, 209, 61, 16);
		lblNewLabel_2_3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2_3.setBackground(new Color(220, 220, 220));
		lblNewLabel_2_3.setForeground(new Color(245, 245, 245));
		getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Muscle (%):");
		lblNewLabel_2_1_2_1.setBounds(10, 299, 84, 16);
		lblNewLabel_2_1_2_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2_1_2_1.setBackground(new Color(220, 220, 220));
		lblNewLabel_2_1_2_1.setForeground(new Color(245, 245, 245));
		getContentPane().add(lblNewLabel_2_1_2_1);
		
		fldSurname = new JTextField();
		fldSurname.setBounds(92, 60, 179, 45);
		fldSurname.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		fldSurname.setForeground(new Color(245, 245, 245));
		fldSurname.setBackground(new Color(105, 105, 105));
		fldSurname.setColumns(10);
		getContentPane().add(fldSurname);
		
		fldAge = new JTextField();
		fldAge.setBounds(92, 105, 179, 45);
		fldAge.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		fldAge.setForeground(new Color(245, 245, 245));
		fldAge.setBackground(new Color(105, 105, 105));
		fldAge.setColumns(10);
		getContentPane().add(fldAge);
		
		fldHeight = new JTextField();
		fldHeight.setBounds(92, 150, 179, 45);
		fldHeight.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		fldHeight.setForeground(new Color(245, 245, 245));
		fldHeight.setBackground(new Color(105, 105, 105));
		fldHeight.setColumns(10);
		getContentPane().add(fldHeight);
		
		fldWeight = new JTextField();
		fldWeight.setBounds(92, 195, 179, 45);
		fldWeight.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		fldWeight.setForeground(new Color(245, 245, 245));
		fldWeight.setBackground(new Color(105, 105, 105));
		fldWeight.setColumns(10);
		getContentPane().add(fldWeight);
		
		fldFat = new JTextField();
		fldFat.setBounds(92, 240, 179, 45);
		fldFat.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		fldFat.setForeground(new Color(245, 245, 245));
		fldFat.setBackground(new Color(105, 105, 105));
		fldFat.setColumns(10);
		getContentPane().add(fldFat);
		
		fldMuscle = new JTextField();
		fldMuscle.setBounds(92, 285, 179, 45);
		fldMuscle.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		fldMuscle.setForeground(new Color(245, 245, 245));
		fldMuscle.setBackground(new Color(105, 105, 105));
		fldMuscle.setColumns(10);
		getContentPane().add(fldMuscle);
		
		fldSsn = new JTextField();
		fldSsn.setBounds(92, 330, 179, 45);
		fldSsn.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		fldSsn.setForeground(new Color(245, 245, 245));
		fldSsn.setBackground(new Color(105, 105, 105));
		fldSsn.setColumns(10);
		getContentPane().add(fldSsn);
		
		fldPassword = new JTextField();
		fldPassword.setBounds(92, 375, 179, 45);
		fldPassword.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		fldPassword.setForeground(new Color(245, 245, 245));
		fldPassword.setBackground(new Color(105, 105, 105));
		fldPassword.setColumns(10);
		getContentPane().add(fldPassword);
		
		JLabel lblNewLabel_2_5 = new JLabel("SSN:");
		lblNewLabel_2_5.setBounds(10, 344, 61, 16);
		lblNewLabel_2_5.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2_5.setBackground(new Color(220, 220, 220));
		lblNewLabel_2_5.setForeground(new Color(245, 245, 245));
		getContentPane().add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Password:");
		lblNewLabel_2_6.setBounds(10, 389, 74, 16);
		lblNewLabel_2_6.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2_6.setBackground(new Color(220, 220, 220));
		lblNewLabel_2_6.setForeground(new Color(245, 245, 245));
		getContentPane().add(lblNewLabel_2_6);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(10, 436, 260, 50);
		btnAdd.setBackground(new Color(211, 211, 211));
		btnAdd.setForeground(new Color(105, 105, 105));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fldName.getText().length() == 0 || fldSurname.getText().length() == 0 || fldSsn.getText().length() == 0 || fldPassword.getText().length() == 0) {
					ShortCase.showMessage("fill");
				} else {
					try {
						boolean control = pt.memberRegister(fldName.getText(), fldSurname.getText(),Integer.parseInt(fldAge.getText()), Integer.parseInt(fldHeight.getText()), Integer.parseInt(fldWeight.getText()), Integer.parseInt(fldFat.getText()),Integer.parseInt(fldMuscle.getText()), Integer.parseInt(fldSsn.getText()) , fldPassword.getText());
						if(control) {
							ShortCase.showMessage("success");
							fldName.setText(null);
							fldSurname.setText(null);
							fldAge.setText(null);
							fldWeight.setText(null);
							fldHeight.setText(null);
							fldFat.setText(null);
							fldMuscle.setText(null);
							fldSsn.setText(null);
							fldPassword.setText(null);
							
							

							updateMemberModel();						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					}
				
				}
							
				
			}
		});
		getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(173, 499, 90, 45);
		btnDelete.setForeground(new Color(105, 105, 105));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fldDelete.getText().length() == 0) {
					JOptionPane.showMessageDialog(btnDelete, "Please select a row!!");
				} else {
					if(ShortCase.confirm("sure")) {
						int selectSsn = Integer.parseInt(fldDelete.getText());
						try {
							boolean control = pt.deleteMember(selectSsn);
							if(control) {
								ShortCase.showMessage("success");
								JOptionPane.showMessageDialog(btnDelete, "Success!!");
								fldDelete.setText(null);
								updateMemberModel();
								}
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					}
				
					}
					
				
				
				
				//	boolean control = pt.deleteMember(Integer.parseInt(fldDelete.getText()));

				
				
				
				
				
				
				/*DefaultTableModel deleteRow = (DefaultTableModel) tableMember.getModel();
				int selectSsn = Integer.parseInt(fldSsn.getText());
				boolean delete = pt.deleteMember(selectSsn);
				if(tableMember.getSelectedRowCount() == 1 && delete) {
					deleteRow.removeRow(tableMember.getSelectedRow());
					
					
				}else {
					if(tableMember.getRowCount() == 0) {
						JOptionPane.showMessageDialog(btnDelete, "Table is empty, select a row!");
					} else {
						JOptionPane.showMessageDialog(btnDelete, "Select single row for delete!");

					}
				}
				
				*/
				
				
				
			}
		});
		getContentPane().add(btnDelete);
		
		fldDelete = new JTextField();
		fldDelete.setBounds(54, 498, 107, 50);
		fldDelete.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		fldDelete.setBackground(new Color(105, 105, 105));
		fldDelete.setForeground(new Color(245, 245, 245));
		fldDelete.setColumns(10);
		getContentPane().add(fldDelete);
		
		JLabel lblNewLabel_1 = new JLabel("SSN:");
		lblNewLabel_1.setBounds(10, 510, 32, 35);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_1.setBackground(new Color(220, 220, 220));
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PtGUI PT = null;
				try {
					PT = new PtGUI(pt );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PT.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(553, 507, 150, 45);
		getContentPane().add(btnNewButton);
		
		JButton btnExt = new JButton("EXIT");
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExt.setBounds(715, 507, 150, 45);
		getContentPane().add(btnExt);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 0, 900, 572);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_3.setBackground(new Color(220, 220, 220));
		lblNewLabel_3.setForeground(new Color(245, 245, 245));
		lblNewLabel_3.setIcon(new ImageIcon("/Users/a90549/Downloads/iloveimg-resized/pexels-victor-freitas-949126.jpg"));
		getContentPane().add(lblNewLabel_3);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
	public void updateMemberModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) tableMember.getModel();
		clearModel.setRowCount(0);
		for(int i=0; i < pt.getMemberList().size(); i++) {
			memberData[0] = pt.getMemberList().get(i).getSsn();
			memberData[1] = pt.getMemberList().get(i).getName();
			memberData[2] = pt.getMemberList().get(i).getSurname();
			memberData[3] = pt.getMemberList().get(i).getAge();
			memberData[4] = pt.getMemberList().get(i).getHeight();
			memberData[5] = pt.getMemberList().get(i).getWeight();
			memberData[6] = pt.getMemberList().get(i).getFat();
			memberData[7] = pt.getMemberList().get(i).getMuscle();
			memberData[8] = pt.getMemberList().get(i).getPassword();
		
			memberModel.addRow(memberData);
			
		}
		
	}
	
	
	
}

