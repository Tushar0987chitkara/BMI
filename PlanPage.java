import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
public class PlanPage extends JPanel implements ActionListener
{
	JButton btdiet,btveg,btwork,btclose;
	JPanel P1,P2,Pc;
	JLabel lbbmi;
	JTextField txbmi;
	CardLayout clo;
	
	public PlanPage(String bmi)
	{
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.magenta);
		lbbmi=new JLabel("your bmi is not so good but you can definatly do better");
		lbbmi.setFont(new Font("Monaco", Font.BOLD, 15));
		txbmi=new JTextField(bmi);
		
		txbmi.setFont(new Font("Monaco", Font.BOLD, 15));
		txbmi.setRequestFocusEnabled(false);
		txbmi.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btdiet = new JButton("non-veg Diet");
		btdiet.setBackground(Color.red);
		btdiet.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btveg = new JButton("veg diet");
		btveg.setBackground(Color.green);
		btveg.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btwork = new JButton("Workut Plan");
		btwork.setBackground(Color.gray);
		btwork.setFont(new Font("Monaco", Font.BOLD, 15));
		
		btclose = new JButton("close");
		btclose.setBackground(Color.magenta);
		btclose.setForeground(Color.orange);
		btclose.setFont(new Font("Monaco", Font.BOLD, 15));
		
		P1=new JPanel();
		P1.setLayout(new GridLayout(2,1));
		P1.add(lbbmi);
		P1.add(txbmi);
		
		P2=new JPanel();
		P2.setLayout(new GridLayout(4,1));
		P2.add(btdiet);
		P2.add(btveg);
		P2.add(btwork);
		P2.add(btclose);
		
		setLayout(new GridLayout(2,1));
		add(P1);
		add(P2);
		
		
		Pc=new JPanel();
		clo=new CardLayout();
		Pc.setLayout(clo);
		Pc.add("",new JPanel());
		Pc.add("Diet Plan",new DietNonVeg());
		Pc.add("veg diet",new Dietveg());
		Pc.add("Workut Plan",new WorkoutOrange());
		add(Pc);
		
		btdiet.addActionListener(this);
		btwork.addActionListener(this);
		btveg.addActionListener(this);
		btclose.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object src=ae.getSource();
		if(src==btclose)
		{
			System.exit(-1);
		}
		else 
			if(src==btwork)
			{
				clo.show(Pc, "Workut Plan");
			}
			else
				if(src==btdiet)
					clo.show(Pc, "Diet Plan");
				else
					if(src==btveg)
						clo.show(Pc, "veg diet");
	}
}
