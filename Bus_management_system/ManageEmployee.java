import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ManageEmployee extends JFrame implements ActionListener
{
	JButton addEmployeeBtn, viewEmployeeBtn, backBtn, logoutBtn;
	JPanel panel;
	
	String userId;
	
	public ManageEmployee(String userId)
	{
		super("Bus Management System - Manage Employee Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		addEmployeeBtn = new JButton("Add Employee");
		addEmployeeBtn.setBounds(50, 120, 150, 30);
		addEmployeeBtn.addActionListener(this);
		panel.add(addEmployeeBtn);
		
		viewEmployeeBtn = new JButton("View Employee");
		viewEmployeeBtn.setBounds(220, 120, 150, 30);
		viewEmployeeBtn.addActionListener(this);
		panel.add(viewEmployeeBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(400, 120, 150, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
			
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			ManagerHomePage mh = new ManagerHomePage(userId);
			mh.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(addEmployeeBtn.getText()))
		{
			AddEmployee a = new AddEmployee(userId);
			a.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(viewEmployeeBtn.getText()))
		{
			ViewEmployee ve = new ViewEmployee(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
}