import java.awt.*;

import javax.sound.sampled.Control;
import javax.swing.*;
public class LoginSector{
	static String bg="C:\\Users\\Anil\\eclipse-workspace\\Voting system\\src\\Background.png";
	static String eci = "C:\\Users\\Anil\\eclipse-workspace\\Voting system\\src\\VoteLogin.jpeg";
	public static void create_framel1() {
		JFrame l1 = new JFrame();
		l1.setContentPane(new JLabel(new ImageIcon(bg)));
		JLabel lb1 = new JLabel("Voter ID : ");
		JLabel Title = new JLabel("Login Page");
		JButton OTP = new JButton("Send OTP");
		JLabel ECI = new JLabel(new ImageIcon(eci));
		l1.add(ECI);
		l1.add(lb1);
		l1.add(Title);
		l1.add(OTP);
		ECI.setBounds(100,0,600,80);
		Title.setBounds(350, 100, 200, 50);
		OTP.setBounds(400, 275, 150, 50);
		OTP.setBackground(new Color(76,81,137));
		OTP.setFont(OTP.getFont().deriveFont(18f));
		Title.setForeground(new Color(255, 215, 0));
		//OTP.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		OTP.setForeground(new Color(255, 215, 0));
		Title.setFont(Title.getFont().deriveFont(28f));
		lb1.setBounds(175, 220, 200,50);
		lb1.setFont(lb1.getFont().deriveFont(28f));
		lb1.setForeground(new Color(255, 215, 0));
		JTextField Voter_id = new JTextField();
	    l1.add(Voter_id);
		Voter_id.setBounds(350, 230, 200, 30);
		l1.setLayout(null);
		l1.setSize(800, 600);
		l1.getContentPane().setBackground(new Color(255,255,255));
		l1.setVisible(true);
	}
	public static void main(String[] args) {
		MainPage ob = new MainPage();
		ob.main(args);
		create_framel1();
		create_framel2();
	}
	public static void create_framel2() {
		JFrame admin = new JFrame();
		JLabel ECI = new JLabel(new ImageIcon(eci));
		admin.setContentPane(new JLabel(new ImageIcon(bg)));
		JButton admin_b = new JButton("View Live Status");
		JLabel admin_p = new JLabel("Vote Results");
		admin.add(admin_b);
		admin.add(admin_p);
		admin.add(ECI);
		ECI.setBounds(100,0,600,80);
		admin_p.setBounds(300, 100, 200, 50);
		admin_p.setForeground(new Color(255, 215, 0));
		admin_p.setFont(admin_p.getFont().deriveFont(28f));
		admin_b.setBounds(300, 250, 200, 50);
		admin_b.setFont(admin_b.getFont().deriveFont(20f));
		admin_b.setBackground(new Color(76,81,137));
		admin_b.setForeground(new Color(255, 215, 0));
		admin.setLayout(null);
		admin.setSize(800, 600);
		//admin.getContentPane().setBackground(new Color(255,255,255));
		admin.setVisible(true);
		
	}
	/*public static void create_framel3() {
		JFrame l3 = new JFrame();
	}
	public static void create_framel4() {
		JFrame l4 = new JFrame();
		
	}*/
}
