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

public class DeleteEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtId;
	private JButton btnDelete;
	private JButton btnBack;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee frame = new DeleteEmployee();
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
	public DeleteEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Employee");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(155, 10, 143, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Id: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(126, 60, 96, 20);
		contentPane.add(lblNewLabel_1);
		
		txtId = new JTextField();
		txtId.setBounds(221, 60, 76, 18);
		contentPane.add(txtId);

		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtId.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter Employee ID");
		            return;
		        }

		        int id = Integer.parseInt(txtId.getText());

		        try {
		            Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/manj",
		                "root",
		                "12345678"
		            );

		            PreparedStatement ps =
		                con.prepareStatement(
		                    "DELETE FROM Employeee WHERE id=?"
		                );

		            ps.setInt(1, id);

		            int count = ps.executeUpdate();

		            if (count > 0) {
		                JOptionPane.showMessageDialog(
		                    null,
		                    "Employee Deleted Successfully"
		                );
		                txtId.setText("");
		            } else {
		                JOptionPane.showMessageDialog(
		                    null,
		                    "Employee ID Not Found"
		                );
		            }

		            con.close();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(172, 120, 80, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new index().setVisible(true);
		        dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(333, 230, 80, 21);
		contentPane.add(btnNewButton_1);

	}

}
