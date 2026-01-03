package com.kodnest.jdbc.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FetchAll extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FetchAll frame = new FetchAll();
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
	public FetchAll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fetch All Employee");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(138, 27, 182, 20);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 72, 330, 123); // increased height
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] { "ID", "Name", "Gender", "Salary" }
		));

		scrollPane.setViewportView(table); // ⭐ VERY IMPORTANT
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index ind = new index();
		        ind.setVisible(true);
		        dispose();
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(329, 230, 80, 21);
		contentPane.add(btnNewButton);
		 try {
		        Connection con = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/manj",
		            "root",
		            "12345678"
		        );

		        PreparedStatement ps =
		            con.prepareStatement("SELECT * FROM Employeee");

		        ResultSet rs = ps.executeQuery();

		        DefaultTableModel model =
		            (DefaultTableModel) table.getModel();

		        while (rs.next()) {
		            model.addRow(new Object[] {
		                rs.getInt("id"),
		                rs.getString("name"),
		                rs.getString("gender"),
		                rs.getInt("salary")
		            });
		        }

		        con.close();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
}
