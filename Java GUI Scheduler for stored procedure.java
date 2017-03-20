
//Java code - for Calling DB procedure and running the scheduler from GUI.
package mcproject;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Scheduler extends JFrame implements ActionListener {
	 
private JButton button1;
private JLabel label1;

public Scheduler() {
setLayout(null);
setSize(300,250);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
label1 = new JLabel("Click button to start the scheduler");
label1.setBounds(60,30,220,30);
button1 = new JButton("START");
button1.setBounds(80,80,130,30);
button1.addActionListener(this);
add(button1);
add(label1);
}

public void actionPerformed(ActionEvent et) {

if (et.getSource() == button1) {
	Runnable proccall = new Runnable() {
		public void run(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
			Connection conn = DriverManager.getConnection("------------------------") // Give source database path.
			if(conn != null){
			System.out.println("Connection Established"); 
			PreparedStatement psment = conn.prepareStatement("EXEC [----].[dbo].[UpdateWaitTimes]"); // procedure call name comes in the blank
			psment.setEscapeProcessing(true);
			psment.setQueryTimeout(90);
			try {
			@SuppressWarnings("unused")
			ResultSet rs = psment.executeQuery();
			}
			catch (Exception ex) {  
		      System.out.println(ex.getMessage());
		      }	
			System.out.println("DB Procedure called");
                        System.out.println("WaitTimesArchieve table updated");
			System.out.println("Thread is running");
			}
		
		else {
			System.out.println("Connectivity Error - Please check");
		}
		}
			 catch (Exception e) {  
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	         }
		}
		};

   ScheduledExecutorService sche = Executors.newSingleThreadScheduledExecutor();
   sche.scheduleAtFixedRate(proccall, 0, 30, TimeUnit.MINUTES);
	JOptionPane.showMessageDialog(null,"Scheduler started");
	//System.exit(0);
}
}
    public static void main(String[] args) {
	        Scheduler s = new Scheduler();
	        s.setVisible(true);	
	}
	}
	
