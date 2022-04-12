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

public class ChangePassword extends JPanel implements ActionListener
{
	JLabel lbid,lbthing,lbpass;
	JTextField txid,txpass,txoldpass;
	JButton btchange,btback;
	JPanel P1,P2;
	
	public ChangePassword()
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
		
		lbthing = new JLabel("Enter old pass");
		lbthing.setFont(new Font("Monaco", Font.BOLD, 15));
		txoldpass = new JTextField(20);
		txoldpass.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btchange = new JButton("new pass");
		btchange.setBackground(Color.pink);
		btchange.setFont(new Font("Monaco", Font.BOLD, 15));
		btback = new JButton("back");
		btback.setBackground(Color.magenta);
		btback.setForeground(Color.orange);
		btback.setFont(new Font("Monaco", Font.BOLD, 15));
		
		P1 = new JPanel();
		P1.setLayout(new GridLayout(6,1));
		P1.add(lbid);
		P1.add(txid);
		P1.add(lbthing);
		P1.add(txoldpass);
		P1.add(lbpass);
		P1.add(txpass);
		
		P2 = new JPanel();
		P2.setLayout(new GridLayout(1,2));
		P2.add(btchange);
		P2.add(btback);
		
		setLayout(new GridLayout(2,1));
		add(P1);
		add(P2);
		
		btchange.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object src=ae.getSource();
		if(src==btchange)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BMI","root", "");
				
				String eid=txid.getText();
				String op=txoldpass.getText();
				String np=txpass.getText();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select id,password from dataTB");
				
				boolean status=false;
				while(rs.next())
				{
					String q=rs.getString(1);
					String w=rs.getString(2);
					if(q.equals(eid) && w.equals(op))
					{
						String query="update datatb set password=? where id=?";
						PreparedStatement pstmt=con.prepareStatement(query);
						pstmt.setString(1, np);
						pstmt.setString(2, eid);
						pstmt.executeUpdate();
						status=true;
						break;
					}
				}
				if(status)
					JOptionPane.showInputDialog("true");
				else
					JOptionPane.showInputDialog("false");
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
