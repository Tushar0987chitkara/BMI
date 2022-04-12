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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class LoginForm extends JPanel implements ActionListener
{
	JLabel lbid,lbpass;
	JTextField txid,txpass;
	JButton btlogin,btcancel,btforpass;
	JPanel P1,P2,Pplan;
	public static float wt,ht;
	public static String mail_id,nm;
	
	public LoginForm()
	{
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.magenta);
		lbid = new JLabel("Enter your Email ID ");
		lbid.setFont(new Font("Monaco", Font.BOLD, 15));
		txid = new JTextField();
		txid.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbpass = new JLabel("Enter password");
		lbpass.setFont(new Font("Monaco", Font.BOLD, 15));
		txpass = new JTextField();
		txpass.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btlogin = new JButton("Login");
		btlogin.setBackground(Color.DARK_GRAY);
		btlogin.setForeground(Color.white);
		btlogin.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btforpass = new JButton("Forget Password");
		btforpass.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btcancel = new JButton("cancel");
		btcancel.setBackground(Color.magenta);
		btcancel.setForeground(Color.orange);
		btcancel.setFont(new Font("Monaco", Font.BOLD, 15));
		
		P1 = new JPanel();
		P1.setLayout(new GridLayout(4,2));
		P1.add(lbid);
		P1.add(txid);
		P1.add(lbpass);
		P1.add(txpass);
		
		P2 = new JPanel();
		P2.setLayout(new GridLayout(1,3));
		P2.add(btlogin);
		P2.add(btforpass);
		P2.add(btcancel);
		
		Pplan=new JPanel();
		
		setLayout(new GridLayout(2,1));
		add(P1);
		add(P2);
		
		btlogin.addActionListener(this);
		btforpass.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object src=ae.getSource();
		if(src==btlogin)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BMI","root", "");
				
				String eid=txid.getText();
				String epass=txpass.getText();
				PreparedStatement pstmt=con.prepareStatement("Select count(*) from dataTB where id=? and password = ?");
				pstmt.setString(1, eid);
				pstmt.setString(2, epass);
				
				ResultSet rs=pstmt.executeQuery();
				int c=0;
				rs.next();
				c=rs.getInt(1);
				if(c==1)
				{
					pstmt=con.prepareStatement("Select name,weight,height from dataTB where id=?");
					pstmt.setString(1, eid);
					
					ResultSet rs1=pstmt.executeQuery();
					rs1.next();
					nm=rs1.getString(1);
					wt=rs1.getFloat(2);
					ht=rs1.getFloat(3);
					HomePage.status=true;
					JOptionPane.showMessageDialog(null, "Succuessfully login now click on calculate BMI");
					HomePage.Pc.remove(1);
					HomePage.Pc.validate();
					
					HomePage.Pc.add("BMI Calculater",new BmiPage(wt,ht,nm));
					HomePage.Pc.validate();
					
					
					
				}
				else
					JOptionPane.showMessageDialog(null, "bye");
				
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
