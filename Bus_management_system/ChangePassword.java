import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePassword extends JFrame implements ActionListener
{
	JLabel oldPassLabel, newPassLabel, newConLabel;
	JTextField oldPassTF, newPassTF,newConTF;
	JButton confirmBtn, backBtn, logoutBtn;
	JPanel panel;
	String userId;
	String status;
    int access=0;
	
	public ChangePassword(String userId)
	{
		super("Change Password");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		oldPassLabel=new JLabel("Enter old password:");
		oldPassLabel.setBounds(50,50,700,40);
		panel.add(oldPassLabel);
		
		newPassLabel=new JLabel("Enter new password:");
		newPassLabel.setBounds(50,100,700,40);
		panel.add(newPassLabel);
		
		newConLabel=new JLabel("Re-type new password:");
		newConLabel.setBounds(50,150,700,40);
		panel.add(newConLabel);
		
		oldPassTF=new JTextField("");
		oldPassTF.setBounds(200,50,200,40);
		panel.add(oldPassTF);
		
		newPassTF=new JTextField("");
		newPassTF.setBounds(200,100,200,40);
		panel.add(newPassTF);
		
		newConTF=new JTextField("");
		newConTF.setBounds(200,150,200,40);
		panel.add(newConTF);
		
		confirmBtn=new JButton("Confirm");
		confirmBtn.setBounds(200,200,200,40);
		confirmBtn.addActionListener(this);
		panel.add(confirmBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(150, 250, 150, 40);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(360,250,150,40);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		
		if(text.equals(backBtn.getText()))
		{
			CustomerHomePage ch = new CustomerHomePage(userId);
			ch.setVisible(true);
			this.setVisible(false);
		}
		
		if(text.equals(logoutBtn.getText()))
		{
			 this.setVisible(false);
             Login li =new Login();
             li.setVisible(true);
		}
		
		if(text.equals(confirmBtn.getText()))
		{
			confirmFromDB();
			if(access==1){
				updateInDB();
				
				access = 0;
			}
			else if(access==0){
				JOptionPane.showMessageDialog(this," Old password didn't match!");
			}
		}
	
	}
	
	public void confirmFromDB()
	
	{

		 String query = "SELECT password,`status`  FROM Login where `userId`='"+userId+"';";
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
			while(rs.next()){
				String password = rs.getString("password");
				status = rs.getString("status");
				if(password.equals(oldPassTF.getText()))
				{
					access = 1;
					System.out.println("pass: "+password);
				}
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
	
	public void updateInDB()
	{
        Connection con=null;
        Statement st = null;
        
		String newPass = newPassTF.getText();
		
		String oldPass = oldPassTF.getText();
		
		 boolean flag=true;
		 
		 if(newPass==oldPass)
		{
		JOptionPane.showMessageDialog(null,"This is your Old  password ");
          flag=false;
		  	
		}
		
		 
		
		if(newPass.length()==0)
		{
		JOptionPane.showMessageDialog(null,"You must provide new password ");
          flag=false;
		  	
		}
		
		
		 if(flag){
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1_b13","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			String query = "UPDATE login SET password='"+newPassTF.getText()+"' where `userId`='"+userId+"';";
			st.executeUpdate(query);
			System.out.println(query);
			st.close();
			con.close();
			
			JOptionPane.showMessageDialog(this,"new password has been changed successfuly!");
			
			 this.setVisible(false);
             Login li =new Login();
             li.setVisible(true);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			}
			}
	}
}