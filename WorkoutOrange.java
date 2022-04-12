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

public class WorkoutOrange extends JPanel implements ListSelectionListener 
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
	
	public WorkoutOrange()
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
		lbtext=new JLabel("Your BMI is in the range of 25-30 which is mainly for overweighted people but you dont have to be worry if you follow our diet and workout plan and mainly belive in your self you can be in a great shape ");
		lbtext.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		Lgm.addElement("gym");
		Lgm.addElement("Barbell push press (6 reps x 4 sets)");
		Lgm.addElement("Goblet squat (6 reps x 4 sets)");
		Lgm.addElement("Dumbbell single arm row (6 reps x 4 sets)");
		Lgm.addElement("Bench press (6 reps x 4 sets)");
		Lgm.addElement("Pull ups/assisted pull ups (6 reps x 4 sets)");
		Lgm.addElement("Shoulder lateral raise (6 reps x 4 sets)");
		Lgm.addElement("rest dAY");
		lsgym=new JList(Lgm);
		lsgym.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		Lyg.addElement("yoga");
		Lyg.addElement("Tadasana. The 'mountain pose'");
		Lyg.addElement("Uttanasana");
		Lyg.addElement("rest day");
		Lyg.addElement("Bhujangasana");
		Lyg.addElement("Baddha Konasana");
		Lyg.addElement("rest day");
		Lyg.addElement("Shavasana");
		lsyoga=new JList(Lyg);
		lsyoga.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		
		P1=new JPanel();
		P1.setLayout(new GridLayout(1,1));
		P1.add(lbtext);
		
		P2=new JPanel();
		P2.setLayout(new GridLayout(1,3));
		P2.add(lsdays);
		P2.add(lsyoga);
		P2.add(lsgym);
		
		setLayout(new GridLayout(1,3));
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
