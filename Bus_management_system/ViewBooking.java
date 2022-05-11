import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewBooking extends JFrame implements ActionListener
{
	JLabel stationLabel,destinationLabel,dateLabel,timeLabel,passengerLabel,fareLabel,ampmLabel;
	JButton backBtn,logoutBtn;
	JPanel panel;
	String userId;
	
	public ViewBooking(String s,String d, String t,String b,String a,String p,String np,String ft,String da)
	{
		super("Show Ticket Information");
		
		this.setSize(700, 500);
		this.userId=userId;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(230,370,80, 40);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		stationLabel = new JLabel("From:   "+s);
		stationLabel.setBounds(250,50, 120, 30);
		panel.add(stationLabel);
		
		
		destinationLabel= new JLabel("To:   " +d);
		destinationLabel.setBounds(250,100, 120, 30);
		panel.add(destinationLabel);
		
		dateLabel=new JLabel("Date of Journey: "+da);
		dateLabel.setBounds(250,150,180,30);
		panel.add(dateLabel);
		
		
		
		timeLabel = new JLabel("Departure Time:  " +t+"  "+a);
		timeLabel.setBounds(250,200, 200, 30);
		panel.add(timeLabel);
		
		passengerLabel = new JLabel("No Of Passenger:  "+np);
		passengerLabel.setBounds(250,250, 120, 30);
		panel.add(passengerLabel);
		
		
		
		fareLabel=new JLabel("Total Amount:  " +ft+"Tk");
		fareLabel.setBounds(250,300,180,30);
		panel.add(fareLabel);
		
		
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(330,370,80,40);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
    }
    public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		if(text.equals("Back"))
		{
			CustomerHomePage ch=new CustomerHomePage(userId);
			ch.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals("Logout"))
		{
			Login l=new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		
	}
		
}
	