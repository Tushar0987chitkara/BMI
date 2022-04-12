import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BmiPage extends JPanel implements ActionListener,ItemListener
{
	JLabel lbweight,lbheight,lbbmi;
	JTextField txweight,txheight,txbmi;
	JButton btcalculate,btrefresh,btclose,btplan;
	JPanel P1,P2,Pplan,Pmain;
	
	void page()
	{
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.magenta);
		
		lbweight = new JLabel("Enter weight(in kg)");
		lbweight.setFont(new Font("Monaco", Font.BOLD, 15));
		txweight = new JTextField();
		txweight.setFont(new Font("Monaco", Font.BOLD, 15));
		
		lbheight = new JLabel("Enter height(in feet)");
		lbheight.setFont(new Font("Monaco", Font.BOLD, 15));
		txheight = new JTextField();
		txheight.setFont(new Font("Monaco", Font.BOLD, 15));
		
		/*JOptionPane.showMessageDialog(null, HomePage.status+"");
		if(HomePage.status)
		{
			txweight.setText(LoginForm.wt+"");
			txheight.setText(LoginForm.ht+"");
			txweight.setEnabled(false);
			txheight.setEnabled(false);
		}*/
		lbbmi = new JLabel("Your BMI is");
		lbbmi.setFont(new Font("Monaco", Font.BOLD, 15));
		txbmi = new JTextField();
		txbmi.setFont(new Font("Monaco", Font.BOLD, 15));
		txbmi.setEnabled(false);
		
		btcalculate = new JButton("calculate");
		btcalculate.setBackground(Color.gray);
		btcalculate.setFont(new Font("Monaco", Font.BOLD, 15));
		btclose = new JButton("close");
		btclose.setBackground(Color.magenta);
		btclose.setForeground(Color.orange);
		btclose.setFont(new Font("Monaco", Font.BOLD, 15));
		btrefresh = new JButton("refresh");
		btrefresh.setBackground(Color.pink);
		btrefresh.setFont(new Font("Monaco", Font.BOLD, 15));
		
		P1 = new JPanel();
		P1.setLayout(new GridLayout(3,2));
		P1.add(lbweight);
		P1.add(txweight);
		P1.add(lbheight);
		P1.add(txheight);
		P1.add(lbbmi);
		P1.add(txbmi);
		
		P2 = new JPanel();
		P2.setLayout(new GridLayout(1,3));
		P2.add(btcalculate);
		P2.add(btrefresh);
		P2.add(btclose);
		
		Pplan=new JPanel();
		
		Pmain=new JPanel();
		Pmain.setLayout(new GridLayout(2,1));
		Pmain.add(P1);
		Pmain.add(P2);
		
		//add(Pplan);
		setLayout(new GridLayout(1,1));
		add(Pmain);
		
		btrefresh.addActionListener(this);
		btclose.addActionListener(this);
		btcalculate.addActionListener(this);
	}
	//private void setFont(Font font) {
		// TODO Auto-generated method stub
		
	//}
	public BmiPage(float weight,float height,String name)
	{
		page();
		txweight.setText(weight+"");
		txheight.setText(height+"");
		txweight.setEnabled(false);
		txheight.setEnabled(false);
	}
	public BmiPage()
	{
		page();
	}

	@Override
	public void itemStateChanged(ItemEvent ie)
	{
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object src=ae.getSource();
		
		if(src==btcalculate && btcalculate.getActionCommand().equalsIgnoreCase("calculate"))
		{
			float a=Float.parseFloat(txweight.getText());
			float b=(float) (Float.parseFloat(txheight.getText()));
			b=b*30;
			float c=(a/(b*b))*10000;
			
			txbmi.setText(Float.toString(c));
			if(c<25 && c>18.5)
			{
				txbmi.setBackground(Color.green);
			}
			if(c>25 && c<30)
			{
				txbmi.setBackground(Color.orange);
				btcalculate.setText("plan");
			}
			if(c<40 && c>30)
			{
				txbmi.setBackground(Color.red);
				btcalculate.setText("plan");
			}
			
		}
		else
			if(src==btcalculate  && btcalculate.getActionCommand().equalsIgnoreCase("plan")) 
			{
				remove(Pmain);
				validate();
				Pmain=new PlanPage(txbmi.getText());
				add(Pmain);
				validate();
			}
		else
			if(src==btrefresh)
			{
				
				txweight.setText("");
				txheight.setText("");
				txbmi.setText("");
				txweight.requestFocus();
			}
			else
			{
				if(src==btclose)
				{
					System.exit(-1);
				}
	}
}
}