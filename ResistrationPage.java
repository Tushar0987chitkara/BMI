import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ResistrationPage extends JPanel implements ActionListener
{
	JLabel lbname,lbage,lbno,lbheight,lbweight,lbid,lbthing,lbpass;
	JTextField txname,txage,txno,txheight,txweight,txid,txthing,txpass;
	JButton btresister,btcancel;
	JPanel P1,P2;
	
	public ResistrationPage()
	{
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.magenta);
		lbname = new JLabel("Enter your name");
		txname = new JTextField(20);
		lbname.setFont(new Font("Monaco", Font.BOLD, 15));
		txname.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbage= new JLabel("Enter your age ");
		txage = new JTextField(20);
		lbage.setFont(new Font("Monaco", Font.BOLD, 15));
		txage.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbno= new JLabel("Enter your phone number ");
		lbno.setFont(new Font("Monaco", Font.BOLD, 15));
		txno = new JTextField(20);
		txno.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbheight = new JLabel("Enter your height ");
		lbheight.setFont(new Font("Monaco", Font.BOLD, 15));
		txheight = new JTextField(20);
		txheight.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbweight= new JLabel("Enter your weight ");
		lbweight.setFont(new Font("Monaco", Font.BOLD, 15));
		txweight = new JTextField(20);
		txweight.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbid = new JLabel("Enter your ID ");
		lbid.setFont(new Font("Monaco", Font.BOLD, 15));
		txid = new JTextField(20);
		txid.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbpass = new JLabel("Enter your password");
		lbpass.setFont(new Font("Monaco", Font.BOLD, 15));
		txpass = new JTextField(20);
		txpass.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbthing = new JLabel("Enter thing that you like ");
		lbthing.setFont(new Font("Monaco", Font.BOLD, 15));
		txthing = new JTextField(20);
		txthing.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btresister = new JButton("resister");
		btresister.setBackground(Color.LIGHT_GRAY);
		btresister.setFont(new Font("Monaco", Font.BOLD, 15));
		btcancel= new JButton("cancel");
		btcancel.setBackground(Color.magenta);
		btcancel.setForeground(Color.orange);
		btcancel.setFont(new Font("Monaco", Font.BOLD, 15));
		
		P1=new JPanel();
		P1.setLayout(new GridLayout(16,2));
		P1.add(lbname);
		P1.add(txname);
		P1.add(lbage);
		P1.add(txage);
		P1.add(lbno);
		P1.add(txno);
		P1.add(lbheight);
		P1.add(txheight);
		P1.add(lbweight);
		P1.add(txweight);
		P1.add(lbid);
		P1.add(txid);
		P1.add(lbpass);
		P1.add(txpass);
		P1.add(lbthing);
		P1.add(txthing);
		
		P2=new JPanel();
		P2.setLayout(new GridLayout(1,2));
		P2.add(btresister);
		P2.add(btcancel);
		
		setLayout(new GridLayout(2,1));
		add(P1);
		add(P2);
		
		btresister.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object src=ae.getSource();
		if(src==btresister)
		{
		String nm=txname.getText();
		int age=Integer.parseInt(txage.getText());
		String no=txno.getText();
		float weight=Float.parseFloat(txweight.getText());
		float height=Float.parseFloat(txheight.getText());
		String id=txid.getText();
		String pass=txpass.getText();
		String thing=txthing.getText();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BMI","root", "");
			
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create table if not exists dataTB"+"(name varchar(50),age int,number varchar(20),height float,weight float,id varchar(50),password varchar(50),things varchar(50))");
			String sqlCmd="Insert into dataTB(name,age,number,height,weight,id,password,things) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sqlCmd);
			
			pstmt.setString(1, nm);
			pstmt.setInt(2, age);
			pstmt.setString(3, no);
			pstmt.setFloat(4, height);
			pstmt.setFloat(5, weight);
			pstmt.setString(6, id);
			pstmt.setString(7, pass);
			pstmt.setString(8, thing);
			
			pstmt.executeUpdate();
			
			con.close();
			} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		}
	}
}
