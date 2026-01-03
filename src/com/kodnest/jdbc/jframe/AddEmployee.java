package com.kodnest.jdbc.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textId;
	private JLabel lblNewLabel_2;
	private JTextField textName;
	private JLabel lblNewLabel_3;
	private JTextField textGender;
	private JLabel lblNewLabel_4;
	private JTextField textSalary;
	private JButton btnNewButton;
	private JButton btnNewButton_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Employee");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(155, 10, 142, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(105, 60, 56, 18);
		contentPane.add(lblNewLabel_1);
		
		textId = new JTextField();
		textId.setBounds(221, 60, 76, 18);
		contentPane.add(textId);
		textId.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Enter name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(105, 91, 76, 18);
		contentPane.add(lblNewLabel_2);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(221, 92, 76, 18);
		contentPane.add(textName);
		
		lblNewLabel_3 = new JLabel("Enter Gender:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(105, 126, 85, 19);
		contentPane.add(lblNewLabel_3);
		
		textGender = new JTextField();
		textGender.setColumns(10);
		textGender.setBounds(221, 127, 76, 18);
		contentPane.add(textGender);
		
		lblNewLabel_4 = new JLabel("Enter Salary: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(105, 165, 76, 19);
		contentPane.add(lblNewLabel_4);
		
		textSalary = new JTextField();
		textSalary.setColumns(10);
		textSalary.setBounds(221, 166, 76, 18);
		contentPane.add(textSalary);
		
		btnNewButton = new JButton("Add Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textId.getText().isEmpty() ||
			            textName.getText().isEmpty() ||
			            textGender.getText().isEmpty() ||
			            textSalary.getText().isEmpty()) {

			            JOptionPane.showMessageDialog(null, "Please fill all fields");
			            return;
			        }

			        int id = Integer.parseInt(textId.getText());
			        String name = textName.getText();
			        String gender = textGender.getText();
			        int salary = Integer.parseInt(textSalary.getText());

			        try {
			            Connection con = DriverManager.getConnection(
			                "jdbc:mysql://localhost:3306/manj",
			                "root",
			                "12345678"
			            );

			            PreparedStatement ps =
			                con.prepareStatement("INSERT INTO Employeee VALUES (?,?,?,?)");

			            ps.setInt(1, id);
			            ps.setString(2, name);
			            ps.setString(3, gender);
			            ps.setInt(4, salary);

			            ps.executeUpdate();

			            JOptionPane.showMessageDialog(null, "Employee Added Successfully");

			            textId.setText("");
			            textName.setText("");
			            textGender.setText("");
			            textSalary.setText("");

			            con.close();

			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(155, 217, 128, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new index().setVisible(true);
		        dispose();
			}
		});
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(335, 230, 80, 21);
		contentPane.add(btnNewButton_1);

	}
}
