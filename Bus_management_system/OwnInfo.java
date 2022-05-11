import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class OwnInfo extends JFrame implements ActionListener
{
	JLabel nameLabel,idLable,phnLabel,mailLabel;
	JTextField nameTF,idTF,phnTF1,phnTF2,mailTF;
    JButton backbtn,Logoutbtn;
	JPanel panel;
	String userId;
	
	public OwnInfo(String userId)
	{
		super ("View OwnInfo");
		this.userId=userId;
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		nameLabel=new JLabel("Name :" );
		nameLabel.setBounds(250,50,150,40);
	    panel.add(nameLabel);
		
		 
		idLable=new JLabel("Id:");
		idLable.setBounds(250,100,150,40);
		panel.add(idLable);
		
		
		phnLabel=new JLabel("Phone no:");
		phnLabel.setBounds(250,150,150,40);
	    panel.add(phnLabel);
		
		nameTF=new JTextField();
		nameTF.setBounds(350,50,150,40);
		//nameTF.setEnable(false);
		panel.add(nameTF);
		
		idTF=new JTextField();
		idTF.setBounds(350,100,150,40);
		//idTF.setEnable(false);
		panel.add(idTF);
		
		phnTF1=new JTextField("+880");
		phnTF1.setBounds(350,150,50,40);
		//phnTF1.setEnable(false);
		panel.add(phnTF1);
		
		phnTF2=new JTextField();
		phnTF2.setBounds(400,150,150,40);
		//phnTF2.setEnable(false);
		panel.add(phnTF2);
		
		mailLabel=new JLabel("Email id:");
		mailLabel.setBounds(250,200,150,40);
		panel.add(mailLabel);
		
		mailTF=new JTextField();
		mailTF.setBounds(350,200,150,40);
		//mailTF.setEnable(false);
		panel.add(mailTF);
		
		backbtn=new JButton("Back");
		backbtn.setBounds(250,250,100,30);
		backbtn.addActionListener(this);
		panel.add(backbtn);
		
        
		Logoutbtn=new JButton("Logout");
		Logoutbtn.setBounds(400,250,100, 30);
		Logoutbtn.addActionListener(this);
		panel.add(Logoutbtn);
		
     	loadFromDB();
		this.add(panel);
	}
	
	public void loadFromDB()
	{
		String query = "SELECT * from customer where userId ='"+this.userId+"';";
		
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
			String mail=null;
						
			while(rs.next())
			{
                userName  = rs.getString("userName");
				userId=rs.getString("userId");
				phone_no = rs.getString("Phone_no");
				mail=rs.getString("mail");
				System.out.println(userName+" "+userId);
				
				flag=true;
				
				nameTF.setText(userName);
				idTF.setText(userId);
				phnTF1.setText("+880");
				phnTF2.setText(phone_no);
				mailTF.setText(mail);
				
				
			}
			if(!flag)
			{
				nameTF.setText("");
				idTF.setText("");
				phnTF1.setText("");
				phnTF2.setText("");
				mailTF.setText("");
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
		
		
		if(text.equals(backbtn.getText()))
		{
			 CustomerHomePage ch = new CustomerHomePage(userId);
			ch.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(Logoutbtn.getText()))
		{
			 this.setVisible(false);
             Login li =new Login();
             li.setVisible(true);
		}
		
		else{}
	}
}
