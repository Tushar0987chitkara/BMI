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

public class ForgetPass extends JPanel implements ActionListener
{
	JLabel lbid,lbthing,lbpass;
	JTextField txid,txpass,txthing;
	JButton btlogin,btback;
	JPanel P1,P2;
	
	public ForgetPass()
	{
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.magenta);
		lbid = new JLabel("Enter your ID ");
		lbid.setFont(new Font("Monaco", Font.BOLD, 15));
		txid = new JTextField(20);
		txid.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbpass = new JLabel("Enter new password");
		lbpass.setFont(new Font("Monaco", Font.BOLD, 15));
		txpass = new JTextField(8);
		txpass.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbthing = new JLabel("Enter your fav. thing");
		lbthing.setFont(new Font("Monaco", Font.BOLD, 15));
		txthing = new JTextField(20);
		txthing.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btlogin = new JButton("Login");
		btlogin.setBackground(Color.pink);
		btlogin.setFont(new Font("Monaco", Font.BOLD, 15));
		btback = new JButton("back");
		btback.setBackground(Color.magenta);
		btback.setForeground(Color.orange);
		btback.setFont(new Font("Monaco", Font.BOLD, 15));
		
		P1 = new JPanel();
		P1.setLayout(new GridLayout(6,1));
		P1.add(lbid);
		P1.add(txid);
		P1.add(lbthing);
		P1.add(txthing);
		P1.add(lbpass);
		P1.add(txpass);
		
		P2 = new JPanel();
		P2.setLayout(new GridLayout(1,2));
		P2.add(btlogin);
		P2.add(btback);
		
		setLayout(new GridLayout(2,1));
		add(P1);
		add(P2);
		
		btlogin.addActionListener(this);
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
				String ething=txthing.getText();
				String p=txpass.getText();
			
				PreparedStatement stmt=con.prepareStatement("Select count(*) from dataTB where id=? and things = ?");
				stmt.setString(1, eid);
				stmt.setString(2, ething);
				ResultSet rs=stmt.executeQuery();
				int c=0;
				rs.next();
				c=rs.getInt(1);
				if(c==1)
				{
						PreparedStatement pstmt=con.prepareStatement("update datatb set password=? where id=?");
						pstmt.setString(1, p);
						pstmt.setString(2, eid);
						pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"pass changed");
				}
				else
					JOptionPane.showMessageDialog(null, "type correct mail id and things");
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
