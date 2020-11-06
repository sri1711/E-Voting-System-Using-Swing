import javax.swing.*;

import java.awt.Color;
class MainPage {
	public void main(String[] args) {
		String url ="C:\\Users\\Anil\\eclipse-workspace\\Voting system\\src\\RegVote.jpg";
		String eci = "C:\\Users\\Anil\\eclipse-workspace\\Voting system\\src\\ECI.png";
		String bg="C:\\Users\\Anil\\eclipse-workspace\\Voting system\\src\\Background.png";
		JFrame f = new JFrame();
		f.setContentPane(new JLabel(new ImageIcon(bg)));
		JButton RegB = new JButton("Register");
		JButton LogB = new JButton("Login");
		JButton AdminB = new JButton("Admin");
		JLabel Title = new JLabel("Welcome to e-Voting");
		JLabel image = new JLabel(new ImageIcon(url));
		JLabel ECI = new JLabel(new ImageIcon(eci));
		f.add(ECI);
		f.add(image);
		f.add(Title);
		f.add(RegB);
		f.add(LogB);
		f.add(AdminB);
		image.setBounds(0, 150, 400, 400);
		ECI.setBounds(150,0,500,80);
		Title.setBounds(250,70,600,80);
		Title.setForeground(new Color(255, 215, 0));
		RegB.setForeground(new Color(255, 215, 0));
		LogB.setForeground(new Color(255, 215, 0));
		AdminB.setForeground(new Color(255, 215, 0));
		AdminB.setBackground(new Color(76,81,137));
		RegB.setBackground(new Color(76,81,137));
		LogB.setBackground(new Color(76,81,137));
		RegB.setFont(RegB.getFont().deriveFont(20f));
		LogB.setFont(LogB.getFont().deriveFont(20f));
		AdminB.setFont(LogB.getFont().deriveFont(20f));
		Title.setFont(Title.getFont().deriveFont(30f));
		RegB.setBounds(465, 200, 180, 70);
		LogB.setBounds(465, 300, 180, 70);
		AdminB.setBounds(465, 400, 180, 70);
		f.setSize(800,600);
		f.setLayout(null);
		f.getContentPane().setBackground(new Color(248,248,248));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
