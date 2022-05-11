import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ManagerHomePage extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton manageEmployeeBtn, changePasswordBtn, viewDetailsBtn, logoutBtn,backBtn,viewCustomerBtn;
	JPanel panel;
	String userId;
	
	public ManagerHomePage(String userId)
	{
		super("Manager Home wondow");
		
		this.userId = userId;
		System.out.println(userId);
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome to manager home page");
		welcomeLabel.setBounds(350, 50,200, 30);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(300,280,85,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn=new JButton("back");
		backBtn.setBounds(400,280,85,30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(300,200,175,30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		manageEmployeeBtn = new JButton("Manage Employee");
		manageEmployeeBtn.setBounds(300,160,175,30);
		manageEmployeeBtn.addActionListener(this);
		panel.add(manageEmployeeBtn);
		
		viewDetailsBtn = new JButton("My Information");
		viewDetailsBtn.setBounds(300,120,175,30);
		viewDetailsBtn.addActionListener(this);
		panel.add(viewDetailsBtn);
		
		viewCustomerBtn = new JButton("Show customer information");
		viewCustomerBtn.setBounds(300,240,175,30);
		viewCustomerBtn.addActionListener(this);
		panel.add(viewCustomerBtn);
		
		
		
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
			EmployeeChangePass mh = new EmployeeChangePass(userId);
			mh.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(manageEmployeeBtn.getText()))
		{
				ManageEmployee me = new ManageEmployee(userId);
				me.setVisible(true);
				this.setVisible(false);
		}
		else if(text.equals(viewDetailsBtn.getText()))
		{
			ManagerInfo mi=new ManagerInfo(userId);
			mi.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(backBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(viewCustomerBtn.getText()))
		{
			System.out.println(userId);
			OwnInfo o=new OwnInfo(userId);
			o.setVisible(true);
			this.setVisible(false);
		}
	}
}