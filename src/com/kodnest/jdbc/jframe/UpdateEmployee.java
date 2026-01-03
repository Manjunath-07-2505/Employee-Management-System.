package com.kodnest.jdbc.jframe;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UpdateEmployee extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtGender;
    private JTextField txtSalary;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateEmployee frame = new UpdateEmployee();
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
    public UpdateEmployee() {
        setTitle("Update Employee");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 320);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Update Employee Details");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(150, 15, 250, 25);
        contentPane.add(lblTitle);

        JLabel lblId = new JLabel("Enter ID:");
        lblId.setBounds(90, 60, 80, 20);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(200, 60, 100, 20);
        contentPane.add(txtId);

        JLabel lblName = new JLabel("Enter Name:");
        lblName.setBounds(90, 100, 100, 20);
        contentPane.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(200, 100, 100, 20);
        contentPane.add(txtName);

        JButton btnUpdateName = new JButton("Update Name");
        btnUpdateName.setBackground(Color.CYAN);
        btnUpdateName.setBounds(320, 100, 130, 23);
        contentPane.add(btnUpdateName);

        JLabel lblGender = new JLabel("Enter Gender:");
        lblGender.setBounds(90, 140, 100, 20);
        contentPane.add(lblGender);

        txtGender = new JTextField();
        txtGender.setBounds(200, 140, 100, 20);
        contentPane.add(txtGender);

        JButton btnUpdateGender = new JButton("Update Gender");
        btnUpdateGender.setBackground(Color.CYAN);
        btnUpdateGender.setBounds(320, 140, 130, 23);
        contentPane.add(btnUpdateGender);

        JLabel lblSalary = new JLabel("Enter Salary:");
        lblSalary.setBounds(90, 180, 100, 20);
        contentPane.add(lblSalary);

        txtSalary = new JTextField();
        txtSalary.setBounds(200, 180, 100, 20);
        contentPane.add(txtSalary);

        JButton btnUpdateSalary = new JButton("Update Salary");
        btnUpdateSalary.setBackground(Color.CYAN);
        btnUpdateSalary.setBounds(320, 180, 130, 23);
        contentPane.add(btnUpdateSalary);

        JButton btnBack = new JButton("Back");
        btnBack.setBackground(Color.BLUE);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(200, 230, 100, 25);
        contentPane.add(btnBack);

        // ================= UPDATE NAME =================
        btnUpdateName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateField("name", txtName.getText());
                txtName.setText("");
            }
        });

        // ================= UPDATE GENDER =================
        btnUpdateGender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateField("gender", txtGender.getText());
                txtGender.setText("");
            }
        });

        // ================= UPDATE SALARY =================
        btnUpdateSalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateField("salary", txtSalary.getText());
                txtSalary.setText("");
            }
        });

        // ================= BACK BUTTON =================
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new index().setVisible(true);
                dispose();
            }
        });
    }

    // ================= COMMON UPDATE METHOD =================
    private void updateField(String column, String value) {

        if (txtId.getText().isEmpty() || value.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter ID and value");
            return;
        }

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/manj",
                    "root",
                    "12345678"
            );

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE Employeee SET " + column + "=? WHERE id=?"
            );

            if (column.equals("salary")) {
                ps.setInt(1, Integer.parseInt(value));
            } else {
                ps.setString(1, value);
            }

            ps.setInt(2, Integer.parseInt(txtId.getText()));

            int count = ps.executeUpdate();

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Employee Updated Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Employee ID Not Found");
            }

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
