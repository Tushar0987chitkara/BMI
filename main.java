import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HomePage extends JApplet implements ActionListener
{
	JLabel lbtext;
	JPanel P1;
	public static JPanel Pc;
	CardLayout clo;
	JButton btbmi,btlogin,btresister,btclose,btcpass,btfpass;
	public static boolean status=false;
	
	public void init()
	{
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.magenta);
		lbtext=new JLabel("Hii welcome to our site check how fit you are");
		lbtext.setForeground(Color.magenta);
		lbtext.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btbmi=new JButton("Calculate BMI");
		btbmi.setBackground(Color.cyan);
		btbmi.setFont(new Font("Ubuntu Sans Mono", Font.BOLD, 15));
		
		btlogin=new JButton("Login");
		btlogin.setBackground(Color.DARK_GRAY);
		btlogin.setForeground(Color.white);
		btlogin.setFont(new Font("Ubuntu Sans Mono", Font.BOLD, 15));
		
		btresister=new JButton("Resister");
		btresister.setBackground(Color.gray);
		btresister.setFont(new Font("Ubuntu Sans Mono", Font.BOLD, 15));
		
		
		btclose=new JButton("Close");
		btclose.setBackground(Color.magenta);
		btclose.setForeground(Color.orange);
		btclose.setFont(new Font("Ubuntu Sans Mono", Font.BOLD, 15));
		
		btcpass=new JButton("Change pass");
		btcpass.setBackground(Color.pink);
		btcpass.setFont(new Font("Ubuntu Sans Mono", Font.BOLD, 15));
		
		btfpass=new JButton("Forget pass");
		btfpass.setBackground(Color.orange);
		btfpass.setFont(new Font("Ubuntu Sans Mono", Font.BOLD, 15));
		this.setBackground(Color.LIGHT_GRAY);
		
		P1=new JPanel();
		P1.setLayout(new GridLayout(2,8));
		P1.add(lbtext);
		P1.add(btbmi);
		P1.add(btlogin);
		P1.add(btresister);
		P1.add(new JLabel());
		P1.add(btcpass);
		P1.add(btfpass);
		P1.add(btclose);
		
		add(P1,BorderLayout.NORTH);
		
		Pc=new JPanel();
		
		clo=new CardLayout();
		Pc.setLayout(clo);
		Pc.add("",new JPanel());
		Pc.add("Resistration",new ResistrationPage());
		Pc.add("Login",new LoginForm());
		Pc.add("BMI Calculater",new BmiPage());
		//Pc.add("Plans",new PlanPage());
		Pc.add("change pass",new ChangePassword());
		Pc.add("Forget pass",new ForgetPass());
		
		
		add(Pc);
		
		btresister.addActionListener(this);
		btlogin.addActionListener(this);
		btbmi.addActionListener(this);
		btcpass.addActionListener(this);
		btfpass.addActionListener(this);
		btclose.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object src=ae.getSource();
		if(src==btresister)
			clo.show(Pc, "Resistration");
		else
			if(src==btlogin)
				clo.show(Pc, "Login");
			else
				if(src==btbmi)
				{
					JOptionPane.showMessageDialog(null, " If you havent resistered please resistrer soon");
					clo.show(Pc,"BMI Calculater");
			}
				else
						if(src==btclose)
						{
							System.exit(-1);
						}
							else 
								if(src==btcpass)
									clo.show(Pc,"change pass");
								else 
									if(src==btfpass)
										clo.show(Pc,"Forget pass");
	}
}
