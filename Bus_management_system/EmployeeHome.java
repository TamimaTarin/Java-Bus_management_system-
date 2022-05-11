import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class EmployeeHome extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton manageEmployeeBtn,changePasswordBtn,viewDetailsBtn,logoutBtn,backBtn,customerInfoBtn;
	JPanel panel;
	String userId;
	
	public EmployeeHome(String userId)
	{
		super("Employee Home Page");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome to employee home page ");
		welcomeLabel.setBounds(350, 50, 200, 30);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(300,240,85,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn=new JButton("Back");
		backBtn.setBounds(300,240,85,30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(300,200,175,30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		
		viewDetailsBtn = new JButton("My Information");
		viewDetailsBtn.setBounds(300,120,175,30);
		viewDetailsBtn.addActionListener(this);
		panel.add(viewDetailsBtn);
		
		customerInfoBtn=new JButton("Customer Info");
		customerInfoBtn.setBounds(300,160,175,30);
		customerInfoBtn.addActionListener(this);
		panel.add(customerInfoBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(changePasswordBtn.getText()))
		{
			EmployeeChangePass mp = new EmployeeChangePass(userId);
			mp.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(viewDetailsBtn.getText()))
		{
			EmployeeInfo ef=new EmployeeInfo(userId);
			ef.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(customerInfoBtn.getText()))
		{
			OwnInfo oi=new OwnInfo(userId);
			oi.setVisible(true);
			this.setVisible(false);
		}
	}
	
	
}