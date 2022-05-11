import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame implements ActionListener
{
	private JLabel nameLabel,passLabel,phnLabel,mailLabel,idLabel;
	private JTextField nameText,phnText,mailText,idText;
	private JPasswordField passText;
	private JButton backbtn,confirmbtn;
	private JPanel panel;
	
	public Registration()
	{
		super ("Registration");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		idLabel=new JLabel("Enter Id:");
		idLabel.setBounds(250,10,120,30);
		panel.add(idLabel);
		
		idText=new JTextField("");
		idText.setBounds(400,10,120,30);
		panel.add(idText);
		
		nameLabel=new JLabel("Enter Name :");
		nameLabel.setBounds(250,50,120,30);
		panel.add(nameLabel);
		
		passLabel=new JLabel("Enter Password :");
		passLabel.setBounds(250,100,120,30);
		panel.add(passLabel);
		
		phnLabel=new JLabel("Enter phone no:");
		phnLabel.setBounds(250,150,120,30);
		panel.add(phnLabel);
		
		mailLabel=new JLabel("Enter email id:");
		mailLabel.setBounds(250,200,120,30);
		panel.add(mailLabel);
		
		nameText=new JTextField("");
		nameText.setBounds(400,50,120,30);
		//nameText.addMouseListener(this);
		panel.add(nameText);
		
		passText=new JPasswordField();
		passText.setEchoChar('*');
        passText.setBounds(400, 100, 120, 30);
        panel.add(passText);
		
		phnText=new JTextField("+880");
		phnText.setBounds(400,150,120,30);
		//phnText.addMouseListener(this);
		panel.add(phnText);
		
        mailText=new JTextField("");
		mailText.setBounds(400,200,120,30);
		//mailText.addMouseListener(this);
		panel.add(mailText);
		
		backbtn=new JButton("Back");
		backbtn.setBounds(400,250,100,30);
		backbtn.addActionListener(this);
		panel.add(backbtn);
		
		confirmbtn=new JButton("Confirm");
		confirmbtn.setBounds(250,250,100,30);
		confirmbtn.addActionListener(this);
		panel.add(confirmbtn);
		
		this.add(panel);
	}
   public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backbtn.getText()))
		{
			this.setVisible(false);
             Login li =new Login();
             li.setVisible(true);
		}
		
		else if(text.equals(confirmbtn.getText()))
		{
			insertIntoDB();
		}
		else{}
	}
	public void insertIntoDB()
	{
		 boolean flag=true;
		 
		String userId = idText.getText();
		String password = passText.getText();
		String userName = nameText.getText();
		String mail=mailText.getText();
		String phone_no=phnText.getText();
		int status = 1;
	    String query1 = "INSERT INTO customer(userId, userName, mail, phone_no) VALUES ('"+userId+"','"+userName+"','"+mail+"','"+phone_no+"');";
		String query2 = "INSERT INTO login(userid, password, status) VALUES ('"+userId+"','"+password+"','"+status+"');";
		System.out.println(query1);
		System.out.println(query2);
		
        if(flag){
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1_b13", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
			 this.setVisible(false);
             Login li =new Login();
             li.setVisible(true);
			
		}
        catch(Exception ex)
		{
			
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
    }
	}
}	