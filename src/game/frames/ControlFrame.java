package game.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

public class ControlFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	public JPanel p;

	

	public ControlFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JLabel lb1 = new JLabel("Lithium-(červená)");
		lb1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lb1.setBounds(476, 211, 135, 16);
		p.add(lb1);
		
		JLabel lb2 = new JLabel("Vápník-(oranžová)");
		lb2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lb2.setBounds(476, 171, 135, 16);
		p.add(lb2);
		
		JLabel lb3 = new JLabel("Železo+Uhlík-(zlatá)");
		lb3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lb3.setBounds(476, 131, 155, 16);
		p.add(lb3);
		
		JLabel lb4 = new JLabel("Hořčík-(bílá)");
		lb4.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lb4.setBounds(476, 11, 135, 16);
		p.add(lb4);
		
		JLabel lb5 = new JLabel("Hliník-(Stříbrná)");
		lb5.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lb5.setBounds(476, 51, 135, 16);
		p.add(lb5);
		
		JLabel lb6 = new JLabel("Baryum-(zelená)");
		lb6.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lb6.setBounds(476, 331, 135, 16);
		p.add(lb6);
		
		JLabel lb7 = new JLabel("Sodík-(žlutá)");
		lb7.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lb7.setBounds(476, 91, 135, 16);
		p.add(lb7);
		
		JLabel lb8 = new JLabel("Měď-(modrá)");
		lb8.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lb8.setBounds(476, 291, 135, 16);
		p.add(lb8);
		
		JLabel lb9 = new JLabel("Stroncium+Měd-(Fialová)");
		lb9.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lb9.setBounds(476, 251, 190, 16);
		p.add(lb9);
		
		JLabel soucet = new JLabel("SoučetLátek- 0");
		soucet.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		soucet.setBounds(90,70, 190, 16);
		p.add(soucet);
		
		JSpinner b1 = new JSpinner();
		b1.setBounds(696, 6, 85, 28);
		p.add(b1);
		
		JSpinner b2 = new JSpinner();
		b2.setBounds(696, 46, 85, 28);
		p.add(b2);
		
		JSpinner b3 = new JSpinner();
		b3.setBounds(696, 86, 85, 28);
		p.add(b3);
		
		JSpinner b4 = new JSpinner();
		b4.setBounds(696, 126, 85, 28);
		p.add(b4);
		
		JSpinner b5 = new JSpinner();
		b5.setBounds(696, 166, 85, 28);
		p.add(b5);
		
		JSpinner b6 = new JSpinner();
		b6.setBounds(696, 206, 85, 28);
		p.add(b6);
		
		JSpinner b7 = new JSpinner();
		b7.setBounds(696, 246, 85, 28);
		p.add(b7);
		
		JSpinner b8 = new JSpinner();
		b8.setBounds(696, 286, 85, 28);
		p.add(b8);
		
		JSpinner b9 = new JSpinner();
		b9.setBounds(696, 326, 85, 28);
		p.add(b9);
		
		JLabel lbSparks = new JLabel("Titan-(jiskry)");
		lbSparks.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbSparks.setBounds(476, 397, 135, 16);
		p.add(lbSparks);
		
		JCheckBox smoke = new JCheckBox("Zinek-(Kouřová Stopa)");
		smoke.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		smoke.setBounds(471, 437, 195, 23);
		p.add(smoke);
		
		JSpinner spark = new JSpinner();
		spark.setBounds(696, 392, 85, 28);
		p.add(spark);
		
		
		JTextPane info = new JTextPane();
		info.setText("Maximální Hodnoty\n\nSoučet Látek \t-> 100max\n\nTitan \t\t- > 50max");
		info.setBounds(90, 211, 272, 96); 
		info.setEditable(false);
		p.add(info);
		
		setVisible(true);
		setResizable(false);
	}
}


