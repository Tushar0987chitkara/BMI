import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Dietveg extends JPanel implements ListSelectionListener
{
	JList<Vector> lsdays;
	Vector<String>Ldy;
	
	JList<String> lsbreakfast;
	DefaultListModel<String> Lbr=new DefaultListModel<>();
	
	JList<String> lsmeals;
	DefaultListModel<String> Lme=new DefaultListModel<>();
	
	JList<String> lslunch;
	DefaultListModel<String> Lln=new DefaultListModel<>();
	
	JList<String> lsdinner;
	DefaultListModel<String> Ldi=new DefaultListModel<>();
	
	JList<String> lssnaks;
	DefaultListModel<String> Lsn=new DefaultListModel<>();
	
	JList<Vector>SelectedList;
	Vector<String>L;
	
	public Dietveg()
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
		lsdays.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		Lme.addElement("Meals");
		Lme.addElement("breakfast");
		Lme.addElement("lunch");
		Lme.addElement("snacks");
		Lme.addElement("dinner");
		lsmeals=new JList(Lme);
		lsmeals.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		Lbr.addElement("Breakfast");
		Lbr.addElement("Poha with milk(low suger)");
		Lbr.addElement("Idli with coffie(low suger)");
		Lbr.addElement("Daliya and tost");
		Lbr.addElement("sandwich with tea(low suger)");
		Lbr.addElement("Upma with coffie(low suger)");
		Lbr.addElement("dosa with sambhar");
		Lbr.addElement("Cheat meal with fruits");
		lsbreakfast=new JList(Lbr);
		lsbreakfast.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		Lln.addElement("Lunch");
		Lln.addElement("yellow dal with 2-3 roti");
		Lln.addElement("dal makhni with rice");
		Lln.addElement("kofta");
		Lln.addElement("sandwich with tea(low suger)");
		Lln.addElement("Upma with coffie(low suger)");
		Lln.addElement("dosa with sambhar");
		Lln.addElement("Cheat meal with fruits");
		lslunch=new JList(Lln);
		lslunch.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		Lsn.addElement("Snaks");
		Lsn.addElement("black coffie");
		Lsn.addElement("Idli with coffie(low suger)");
		Lsn.addElement("Daliya and tost");
		Lsn.addElement("sandwich with tea(low suger)");
		Lsn.addElement("Upma with coffie(low suger)");
		Lsn.addElement("dosa with sambhar");
		Lsn.addElement("Cheat meal with fruits");
		lssnaks=new JList(Lsn);
		lssnaks.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		Ldi.addElement("Dinner");
		Ldi.addElement("fruit salad");
		Ldi.addElement("alu sabzi with 2-3 roti");
		Ldi.addElement("Daliya and tost");
		Ldi.addElement("sandwich with tea(low suger)");
		Ldi.addElement("Upma with coffie(low suger)");
		Ldi.addElement("dosa with sambhar");
		Ldi.addElement("Cheat meal with fruits");
		lsdinner=new JList(Ldi);
		lsdinner.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		setLayout(new FlowLayout());
		add(lsmeals);
		add(lsdays);
		add(lsbreakfast);
		add(lslunch);
		add(lssnaks);
		add(lsdinner);
		//lsname.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	//at a time only one item will be selected
		
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
		
		lsbreakfast.setSelectedIndices(indices);
		lslunch.setSelectedIndices(indices);
		lssnaks.setSelectedIndices(indices);
		lsdinner.setSelectedIndices(indices);
		
		
		for(int i=0;i<indices.length;i++)
			L.addElement(lsdays.getSelectedValues()[i].toString()+","+lsbreakfast.getSelectedValues()[i].toString()
					+","+lslunch.getSelectedValues()[i].toString()
					+","+lssnaks.getSelectedValues()[i].toString()
					+","+lsdinner.getSelectedValues()[i].toString());
		
	}
	
	}