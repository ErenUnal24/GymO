package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import model.user;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PtPlan extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PtPlan frame = new PtPlan();
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
	public PtPlan() {
		

		String workout1 ="Plan 1:\n"
				+ "Squat: 5x5\n"
				+ "Bench Press: 5x5\n"
				+ "Barbell Row: 5x5\n"
				+ "\n"
				+ "Squat: 5x5\n"
				+ "Ohp: 5x5\n"
				+ "Deadlift: 5x5\n"
				+ "--------------------"
				+ " Plan 2:\n"
				+ "Side Lateral: 4x10\n"
				+ "Shoulder Press: 4x10\n"
				+ "Dumbell Row: 4x8\n"
				+ "Dumbell Shrug: 4x8\n"
				+ "\n"
				+ "Leg Curl: 4x10\n"
				+ "Leg Extension: 4x10\n"
				+ "Barbell Squat: 4x8\n"
				+ "Lunge: 4x8";
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(192, 192, 192));
		textPane.setBounds(102, 61, 133, 326);
		contentPane.add(textPane);
		
		textPane.setText(workout1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnNewButton.setBounds(112, 403, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/a90549/Downloads/pexels-ivan-samkov-4164765 (1) (1).jpg"));
		lblNewLabel.setBounds(0, 0, 335, 466);
		contentPane.add(lblNewLabel);
		
		
	}

}
