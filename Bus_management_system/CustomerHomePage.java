import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerHomePage extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton changePasswordBtn,logoutBtn,ownInfoBtn,ticketBtn,backBtn;
	JPanel panel;
	String userId;
	public CustomerHomePage(String userId)
	{
		super("Bus Management System - Customer Home Window");
		this.userId=userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome to customer home page");
		welcomeLabel.setBounds(350, 50, 200, 30);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(300, 240,85, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(300,200,175,30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		ownInfoBtn = new JButton("My Info");
		ownInfoBtn.setBounds(300, 120, 175, 30);
		ownInfoBtn.addActionListener(this);
		panel.add(ownInfoBtn);
		
		ticketBtn = new JButton("Ticket");
		ticketBtn.setBounds(300, 160, 175, 30);
        ticketBtn.addActionListener(this);
		panel.add(ticketBtn);
		
		backBtn=new JButton("Back");
		backBtn.setBounds(400,240,85,30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		if(text.equals("Logout"))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals("Change Password"))
		{
			ChangePassword cp = new ChangePassword(userId);
			cp.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals("My Info"))
		{
			
				OwnInfo me = new OwnInfo(userId);
				me.setVisible(true);
				this.setVisible(false);
		}
		else if(text.equals("Ticket"))
		{
			TicketInfo tf = new TicketInfo();
		    tf.setVisible(true);
		    this.setVisible(false);
		}
		else if(text.equals("Back"))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		
		else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
	}
}