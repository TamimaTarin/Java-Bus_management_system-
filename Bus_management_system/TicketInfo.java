import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class TicketInfo extends JFrame implements ActionListener

{
	JLabel stationLabel,destinationLabel,dateLabel,timeLabel,busServiceLabel,passengerLabel,fareLabel,paymentLabel;
	JButton confirmBtn, backBtn,logoutBtn,calculateBtn;
	JComboBox stationCombo, destinationCombo,timeCombo,ampmCombo,busServiceCombo,paymentCombo;
	JTextField passengerTF,fareTF,dateTF;
	JPanel panel;
	String userId;
	public TicketInfo()
	{
		super("Ticket Information");
		this.userId = userId;
		this.setSize(750,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		confirmBtn=new JButton("Confirm");
		confirmBtn.setBounds(50,350,80,40);
		confirmBtn.addActionListener(this);
		panel.add(confirmBtn);
		
		backBtn=new JButton("Back");
		backBtn.setBounds(150,350,80,40);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn=new JButton("Logout");
		logoutBtn.setBounds(250,350,80,40);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		calculateBtn=new JButton("Calculate Fare");
		calculateBtn.setBounds(350,350,180,40);
		calculateBtn.addActionListener(this);
		panel.add(calculateBtn);
		
		stationLabel=new JLabel("Station :");
		stationLabel.setBounds(50,20,200,40);
		panel.add(stationLabel);
		
		destinationLabel=new JLabel("Destination :");
		destinationLabel.setBounds(400,20,200,40);
		panel.add(destinationLabel);
		
		dateLabel=new JLabel("Date :");
		dateLabel.setBounds(50,80,100,40);
		panel.add(dateLabel);
		
		timeLabel=new JLabel("Time :");
		timeLabel.setBounds(320,80,100,40);
		panel.add(timeLabel);
		
		busServiceLabel=new JLabel("Available Bus Service:");
		busServiceLabel.setBounds(50,140,250,40);
		panel.add(busServiceLabel);
		
		passengerLabel=new JLabel("No.of Passenger:");
		passengerLabel.setBounds(50,190,250,40);
		panel.add(passengerLabel);
		
		fareLabel=new JLabel("Total Fare:");
		fareLabel.setBounds(50,240,200,40);
		panel.add(fareLabel);
		
		paymentLabel=new JLabel("Payment Method:");
		paymentLabel.setBounds(50,300,300,40);
		panel.add(paymentLabel);
		
	    String station[]=new String[]{"Dhaka","Chittagong","Sylhet"};
		stationCombo=new JComboBox(station);
		stationCombo.setBounds(100,20,200,40);
		panel.add(stationCombo);
		
		String destination[]=new String[]{"Dhaka","Chittagong","Sylhet"};
		destinationCombo= new JComboBox(destination);
		destinationCombo.setBounds(500,20,200,40);
		panel.add(destinationCombo);
		
		String time[]=new String[]{"6","9","12"};
		timeCombo=new JComboBox(time);
		timeCombo.setBounds(370,80,50,40);
		panel.add(timeCombo);
		
		String ampm[]=new String[]{"AM","PM"};
		ampmCombo=new JComboBox(ampm);
		ampmCombo.setBounds(500,80,50,40);
		panel.add(ampmCombo);
		
		String busService[]=new String[]{"Kallol Paribahan", "Tarin Paribahan","Anisha Paribahan"};
		busServiceCombo=new JComboBox(busService);
		busServiceCombo.setBounds(200,140,350,40);
		panel.add(busServiceCombo);
		
		String payment[]=new String[]{"VISA","BKASH"};
		paymentCombo=new JComboBox(payment);
		paymentCombo.setBounds(200,300,200,40);
		panel.add(paymentCombo);
		
		passengerTF=new JTextField("");
		passengerTF.setBounds(200,190,100,40);
		panel.add(passengerTF);
		
	    fareTF=new JTextField("");
		fareTF.setBounds(200,240,200,40);
		panel.add(fareTF);
		dateTF=new JTextField("");
		dateTF.setBounds(100,80,100,40);
		panel.add(dateTF);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		  String temp = ae.getActionCommand();
		  String s=stationCombo.getSelectedItem().toString();
		  String d=destinationCombo.getSelectedItem().toString();
		  String t = timeCombo.getSelectedItem().toString();
		  String b = busServiceCombo.getSelectedItem().toString();
		  String a = ampmCombo.getSelectedItem().toString();
		  String p = paymentCombo.getSelectedItem().toString();
		  String np = passengerTF.getText();
		  String ft = fareTF.getText();
		  String da = dateTF.getText();
		  if(temp.equals("Confirm")){
		  
		  ViewBooking vb= new ViewBooking(s,d,t,b,a,p,np,ft,da);
		  vb.setVisible(true);
		  this.setVisible(false);
		}
		
		else if(temp.equals("Back"))
		{
			CustomerHomePage ch=new CustomerHomePage(userId);
			ch.setVisible(true);
			this.setVisible(false);
		}
		else if(temp.equals("Logout"))
		{
			
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(temp.equals("Calculate Fare"))
		{
		    String ptf = passengerTF.getText();
			Double x = Double.parseDouble(ptf);
			String bsc = busServiceCombo.getSelectedItem().toString();
			if(bsc.equals("Kallol Paribahan"))
			{
				if(s.equals("Dhaka")&&d.equals("Chittagong")){
				Double f=500*x;
				String fare = Double.toString(f);
				fareTF.setText(fare);}
				else if(s.equals("Dhaka")&&d.equals("Sylhet")){
					Double f=400*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}else if(s.equals("Chittagong")&&d.equals("Sylhet"))
				{
					Double f=450*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}
				else if(s.equals("Chittagong")&&d.equals("Dhaka"))
				{
					Double f=500*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}
				else if(s.equals("Sylhet")&&d.equals("Dhaka"))
				{
					Double f=400*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}
				else if(s.equals("Sylhet")&&d.equals("Chittagong"))
				{
					Double f=450*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}
			}
			if(bsc.equals("Anisha Paribahan"))
			{
				if(s.equals("Dhaka")&&d.equals("Chittagong")){
				Double f=700*x;
				String fare = Double.toString(f);
				fareTF.setText(fare);}
				else if(s.equals("Dhaka")&&d.equals("Sylhet")){
					Double f=650*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}else if(s.equals("Chittagong")&&d.equals("Sylhet"))
				{
					Double f=600*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}
				else if(s.equals("Chittagong")&&d.equals("Dhaka"))
				{
					Double f=500*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}
				else if(s.equals("Sylhet")&&d.equals("Dhaka"))
				{
					Double f=400*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}
			}
			if(bsc.equals("Tarin Paribahan"))
			{
				if(s.equals("Dhaka")&&d.equals("Chittagong")){
				Double f=800*x;
				String fare = Double.toString(f);
				fareTF.setText(fare);}
				else if(s.equals("Dhaka")&&d.equals("Sylhet")){
					Double f=700*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}else if(s.equals("Chittagong")&&d.equals("Sylhet"))
				{
					Double f=600*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}
				else if(s.equals("Chittagong")&&d.equals("Dhaka"))
				{
					Double f=500*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}
				else if(s.equals("Sylhet")&&d.equals("Dhaka"))
				{
					Double f=400*x;
					String fare=Double.toString(f);
					fareTF.setText(fare);
				}
		    }
	 	 }
	}
}