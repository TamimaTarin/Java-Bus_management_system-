import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ManagerInfo extends JFrame implements ActionListener
{
	private JLabel userLabel,salaryLabel,roleLabel, phnLabel,idLabel;
	private JTextField userTF,salaryTF, roleTF, phnTF1,phnTF2,idTF;
	private JButton autoPassBtn, backBtn, logoutBtn;
	private JPanel panel;
	String userId;
	
	public ManagerInfo(String userId)
	{
		super("Manager Home Page");
		
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		userLabel = new JLabel("User Name: ");
		userLabel.setBounds(250,50,150,40);
		panel.add(userLabel);
		
		idLabel=new JLabel("user id");
		idLabel.setBounds(250,100,150,40);
		panel.add(idLabel);
		
		salaryLabel = new JLabel("Salary : ");
		salaryLabel.setBounds(250,150,150,40);
		panel.add(salaryLabel);
		
		phnLabel = new JLabel("Phone No. : ");
		phnLabel.setBounds(250,200,150,40);
		panel.add(phnLabel);
		
		roleLabel = new JLabel("Role");
		roleLabel.setBounds(250, 250, 150, 40);
		panel.add(roleLabel);
		
	    userTF = new JTextField();
		userTF.setBounds(350, 50, 150, 40);
		panel.add(userTF);
		
		idTF=new JTextField();
		idTF.setBounds(350,100,150,40);
		panel.add(idTF);
		
		salaryTF = new JTextField();
		salaryTF.setBounds(350, 150, 150, 40);
		panel.add(salaryTF);
		
		phnTF1 = new JTextField("+880");
		phnTF1.setBounds(350,200,50,40);
		phnTF1.setEnabled(false);
		panel.add(phnTF1);
		
		phnTF2 = new JTextField();
		phnTF2.setBounds(400,200,150,40);
		panel.add(phnTF2);
		
		roleTF = new JTextField();
		roleTF.setBounds(350, 250, 150, 40);
		roleTF.setEnabled(false);
		panel.add(roleTF);
		
		
		backBtn = new JButton("Back");
	    backBtn.setBounds(200,300,150, 40);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(400,300, 150, 40);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		loadFromDB();
		this.add(panel);
	}
	
	public void loadFromDB()
	{
		String query = "SELECT * from employee where userId ='"+this.userId+"'";
		
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
			String userName = null;
			String userid=null;
			String phone_no = null;
			double salary = 0.0;
            String role=null;			
			while(rs.next())
			{
                userName  = rs.getString("userName");
				userId=rs.getString("userId");
				phone_no = rs.getString("Phone_no");
				salary = rs.getDouble("salary");
				role=rs.getString("role");
				flag=true;
				
				userTF.setText(userName);
				idTF.setText(userId);
				phnTF1.setText("+880");
				phnTF2.setText(phone_no);
				salaryTF.setText(""+salary);
				roleTF.setText(role);
				
				
			}
			if(!flag)
			{
				userTF.setText("");
				idTF.setText("");
				phnTF1.setText("");
				phnTF2.setText("");
				salaryTF.setText("");
				roleTF.setText("");
				JOptionPane.showMessageDialog(this,"Invalid ID"); 
			}
		}
        catch(Exception e)
		{
			System.out.println(e.getMessage());
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
            catch(Exception e)
			{
				
				System.out.println(e.getMessage());
			}
        }
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		
		if(text.equals(backBtn.getText()))
		{
			ManagerHomePage eh = new ManagerHomePage(userId);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			 this.setVisible(false);
             Login li =new Login();
             li.setVisible(true);
		}
		
		else{}
	}
}