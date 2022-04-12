import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class WorkoutRed extends JApplet implements ListSelectionListener 
{
	JLabel lbtext;
	JPanel P1,P2;
	
	JList<Vector> lsdays;
	Vector<String>Ldy;
	
	JList<String> lsgym;
	DefaultListModel<String> Lgm=new DefaultListModel<>();
	
	JList<String> lsyoga;
	DefaultListModel<String> Lyg=new DefaultListModel<>();
	
	JList<Vector>SelectedList;
	Vector<String>L;
	
	public void init()
	{
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.magenta);
		Ldy=new Vector<>();
		Ldy.addElement("Days");
		Ldy.addElement("monday");
		Ldy.addElement("tuesday");
		Ldy.addElement("wednsday");
		Ldy.addElement("thursday");
		Ldy.addElement("friday");
		Ldy.addElement("saturday");
		Ldy.addElement("Sunday");
		lsdays=new JList(Ldy);
		
		lbtext=new JLabel("Your BMI is in the range of 30-40 which is mainly for obese people but you dont have to be worry if you follow our diet and workout plan and mainly belive in your self you can be in a great shape ");
		lbtext.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		Lgm.addElement("gym");
		Lgm.addElement("Poha with milk(low suger)");
		Lgm.addElement("Idli with coffie(low suger)");
		Lgm.addElement("Daliya and tost");
		Lgm.addElement("sandwich with tea(low suger)");
		Lgm.addElement("Upma with coffie(low suger)");
		Lgm.addElement("dosa with sambhar");
		Lgm.addElement("Cheat meal with fruits");
		lsgym=new JList(Lgm);
		
		Lyg.addElement("yoga");
		Lyg.addElement("yellow dal with 2-3 roti");
		Lyg.addElement("dal makhni with rice");
		Lyg.addElement("kofta");
		Lyg.addElement("sandwich with tea(low suger)");
		Lyg.addElement("Upma with coffie(low suger)");
		Lyg.addElement("dosa with sambhar");
		Lyg.addElement("Cheat meal with fruits");
		lsyoga=new JList(Lyg);
		
		P1=new JPanel();
		P1.setLayout(new GridLayout(1,1));
		P1.add(lbtext);
		
		P2=new JPanel();
		P2.setLayout(new GridLayout(1,3));
		P2.add(lsdays);
		P2.add(lsyoga);
		P2.add(lsgym);
		
		setLayout(new GridLayout(3,1));
		add(P1);
		add(P2);
		
		lsdays.addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent le)
	{
		if(SelectedList !=null)
			remove(SelectedList);
		validate();
		
		L=new Vector<>();
		int [] indices=lsdays.getSelectedIndices();
		
		lsgym.setSelectedIndices(indices);
		lsyoga.setSelectedIndices(indices);
		for(int i=0;i<indices.length;i++)
			L.addElement(lsdays.getSelectedValues()[i].toString()+","+lsgym.getSelectedValues()[i].toString()
					+","+lsyoga.getSelectedValues()[i].toString());
	}

}
