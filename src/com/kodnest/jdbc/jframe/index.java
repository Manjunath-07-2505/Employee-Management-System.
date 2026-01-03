package com.kodnest.jdbc.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
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
	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Management System");
		lblNewLabel.setBounds(100, 20, 270, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Fetch Employee");
		btnNewButton.setBounds(23, 82, 177, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fetch().setVisible(true);
		        dispose();
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Employee");
		btnNewButton_1.setBounds(23, 148, 177, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEmployee().setVisible(true);
		        dispose();
			}
		});
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fetch All Employee");
		btnNewButton_2.setBounds(235, 82, 167, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        new FetchAll().setVisible(true);
		        dispose(); 
			}
		});
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete Employee");
		btnNewButton_3.setBounds(235, 148, 167, 21);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteEmployee().setVisible(true);
		        dispose();
			}
		});
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update Employee");
		btnNewButton_4.setBounds(134, 209, 157, 21);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateEmployee().setVisible(true);
		        dispose();
			}
		});
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton_4);

	}
}
