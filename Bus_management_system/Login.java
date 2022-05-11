import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
	JLabel title, userLabel, passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn,regBtn;
	JPanel panel;
	
	public Login()
	{
		super("Bus Management System");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Bus Management System");
		title.setBounds(300, 50, 350, 30);
		panel.add(title);
		
		userLabel = new JLabel("User ID:");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password:");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		panel.add(passPF);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		regBtn=new JButton("Register");
		regBtn.setBounds(350,250,100,30);
		regBtn.addActionListener(this);
		panel.add(regBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(loginBtn.getText()))
		{
			checkLogin();
		}
		else if(text.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(text.equals(regBtn.getText()))
		{
			Registration r = new Registration();
			r.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void checkLogin()
	{
		String query = "select userid,password,status from login";    
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1_b13","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			rs = st.executeQuery(query);
			System.out.println("results received");
			
			boolean flag = false;			
			while(rs.next())
			{
                String userId = rs.getString("userId");
				String password = rs.getString("password");
				int status = rs.getInt("status");
				if(userId.equals(userTF.getText()) && password.equals(passPF.getText()))
				{
					flag=true;
					if(status==2)
					{
						EmployeeHome eh = new EmployeeHome(userId);
						eh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==1)
					{
						CustomerHomePage ch = new CustomerHomePage(userId);
						ch.setVisible(true);
						this.setVisible(false);
					}
					else if(status==0)
					{
						ManagerHomePage mh=new ManagerHomePage(userId);
						mh.setVisible(true);
						this.setVisible(false);
					}
				}
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
}