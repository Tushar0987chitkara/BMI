import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

public class DietNonVeg extends JPanel implements ListSelectionListener
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
	JPanel P1;
	
	public DietNonVeg()
	{
		P1=new JPanel();
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.magenta);
		Ldy=new Vector<>();
		Ldy.addElement("Days");
		//Ldy.setFont(new Font("Monaco", Font.BOLD, 15));
		Ldy.addElement("monday");
		Ldy.addElement("tuesday");
		Ldy.addElement("wednsday");
		Ldy.addElement("thursday");
		Ldy.addElement("friday");
		Ldy.addElement("saturday");
		Ldy.addElement("Sunday");
		
		lsdays=new JList(Ldy);
		P1.add(lsdays);
		lsdays.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		Lme.addElement("Meals");
		Lme.addElement("breakfast");
		Lme.addElement("lunch");
		Lme.addElement("snacks");
		Lme.addElement("dinner");
		lsmeals=new JList(Lme);
		P1.add(lsmeals);
		lsmeals.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		Lbr.addElement("Breakfast");
		Lbr.addElement("boiled 2-3 eggs");
		Lbr.addElement("Idli with coffie(low suger)");
		Lbr.addElement("Daliya and tost");
		Lbr.addElement("sandwich with tea(low suger)");
		Lbr.addElement("Upma with coffie(low suger)");
		Lbr.addElement("dosa with sambhar");
		Lbr.addElement("Cheat meal with fruits");
		lsbreakfast=new JList(Lbr);
		P1.add(lsbreakfast);
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
		P1.add(lslunch);
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
		P1.add(lssnaks);
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
		P1.add(lsdinner);
		lsdinner.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		setLayout(new GridLayout(1,5));
		add(P1);
		
		//lsname.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	//at a time only one item will be selected
	this.setFont(new Font("Monaco", Font.BOLD, 15));
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