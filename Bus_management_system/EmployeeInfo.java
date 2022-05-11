import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class EmployeeInfo extends JFrame implements ActionListener
{
	private JLabel userLabel ,salaryLabel, roleLabel, phnLabel;
	private JTextField userTF, salaryTF, roleTF, phnTF1,phnTF2;
	private JButton autoPassBtn, backBtn, logoutBtn;
	private JPanel panel;
	String userId;
	
	public EmployeeInfo(String userId)
	{
		super("Employee Information");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		userLabel = new JLabel("User Name: ");
		userLabel.setBounds(200, 50, 150, 40);
		panel.add(userLabel);
		
		salaryLabel = new JLabel("Salary : ");
		salaryLabel.setBounds(200, 100, 150, 40);
		panel.add(salaryLabel);
		
		phnLabel = new JLabel("Phone No. : ");
		phnLabel.setBounds(200, 150, 150, 40);
		panel.add(phnLabel);
		
	    roleLabel = new JLabel();
		roleLabel.setBounds(200, 200, 150, 40);
		panel.add(roleLabel);
		
		userTF = new JTextField();
		userTF.setBounds(300, 50, 150, 40);
		panel.add(userTF);
			
		
		salaryTF = new JTextField();
		salaryTF.setBounds(300, 100, 150, 40);
		panel.add(salaryTF);
		
		phnTF1 = new JTextField("+880");
		phnTF1.setBounds(300, 150, 50, 40);
		phnTF1.setEnabled(false);
		panel.add(phnTF1);
		
		phnTF2 = new JTextField();
		phnTF2.setBounds(350, 150, 150, 40);
		panel.add(phnTF2);
		
		roleTF = new JTextField();
		roleTF.setBounds(250, 200, 150, 40);
		panel.add(roleTF);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(200, 300, 150 ,40);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(300, 300, 150, 40);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		loadFromDB();
		this.add(panel);
	}
	
	public void loadFromDB()
	{
		String query = "SELECT * from employee where userId ='"+this.userId+"'";
		
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1_b13","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			boolean flag = false;
			String userName = null;
			String phone_no = null;
			String role = null;
			double salary = 0.0;			
			while(rs.next())
			{
                userName  = rs.getString("userName");
				phone_no = rs.getString("phone_no");
				salary = rs.getDouble("salary");
				role = rs.getString("role");
				flag=true;
				
				userTF.setText(userName);
				phnTF1.setText("+880");
				phnTF2.setText(phone_no);
				salaryTF.setText(""+salary);
				roleTF.setText(""+role);
				
				
			}
			if(!flag)
			{
				userTF.setText("");
				phnTF1.setText("");
				phnTF2.setText("");
				salaryTF.setText("");
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
			EmployeeHome eh = new EmployeeHome(userId);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
             Login li =new Login();
             li.setVisible(true);
			 this.setVisible(false);
		}
		
		else{}
	}
	
		
		
		
	
	
	
}