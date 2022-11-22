package presentation_Layer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BussinessLogic_Layer.BussinessLogic;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField txtPleasePressA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Interface() {
		setBackground(new Color(95, 158, 160));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setForeground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Mutants");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BussinessLogic obj=new BussinessLogic();
				txtPleasePressA.setText("Mutants Are Generated Please Wait");
				BussinessLogic.MUtants_GN();
				txtPleasePressA.setText("Please wait");
				obj.InsertData();
				txtPleasePressA.setText("Data Inserted SuccesFully ThankYou");
				
			}
		});
		btnNewButton.setBounds(317, 196, 187, 49);
		contentPane.add(btnNewButton);
		
		txtPleasePressA = new JTextField();
		txtPleasePressA.setText("Please Press a Button to generate Muttants");
		txtPleasePressA.setEditable(false);
		txtPleasePressA.setBounds(256, 271, 338, 39);
		contentPane.add(txtPleasePressA);
		txtPleasePressA.setColumns(10);
	}
}
