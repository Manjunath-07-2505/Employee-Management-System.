package com.kodnest.jdbc.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Fetch extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtId;
	private JTextArea textArea;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fetch frame = new Fetch();
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
	public Fetch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fetch Employee");
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(141, 26, 163, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(92, 82, 93, 17);
		contentPane.add(lblNewLabel_1);
		
		txtId = new JTextField();
		txtId.setBounds(240, 81, 76, 18);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnNewButton = new JButton("Fetch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        int id = Integer.parseInt(txtId.getText());

				        try {
				            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manj","root","12345678");
				            PreparedStatement ps =
				                con.prepareStatement("SELECT * FROM employeee WHERE id=?");

				            ps.setInt(1, id);
				            ResultSet rs = ps.executeQuery();

				            if (rs.next()) {
				                textArea.setText(
				                    "ID: " + rs.getInt("id") + "\n" +
				                    "Name: " + rs.getString("name") + "\n" +
				                    "Gender: " + rs.getString("gender") + "\n" +
				                    "Salary: " + rs.getInt("salary")
				                );
				            } else {
				                JOptionPane.showMessageDialog(null,
				                    "Employee Not Found");
				            }

				            con.close();

				        } catch (Exception ex) {
				            ex.printStackTrace();
				        }
				    }
				});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(164, 130, 80, 21);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(30, 176, 286, 64);
		contentPane.add(textArea);

		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new index().setVisible(true);
		        dispose();
			}
		});
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(346, 219, 80, 21);
		contentPane.add(btnNewButton_1);

	}
}
