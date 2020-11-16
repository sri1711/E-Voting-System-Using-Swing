package VotePackage; 

import javax.swing.*;
import VotePackage.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
class MainPage {
	public static void main(String[] args) {
		String url ="D:/Eclipse/workspace/Elite Voting System/images/RegVote.jpg";
		String eci = "D:/Eclipse/workspace/Elite Voting System/images/EC_India.jpeg"
				+ "";
		String bg="D:/Eclipse/workspace/Elite Voting System/images/Background.png";
		JFrame f = new JFrame();
		f.setContentPane(new JLabel(new ImageIcon(bg)));
		JButton RegB = new JButton("Register");
		JButton LogB = new JButton("Login");
		JButton AdminB = new JButton("Admin");
		JButton exit = new JButton("Exit");
		JLabel Title = new JLabel("Welcome to e-Voting");
		JLabel image = new JLabel(new ImageIcon(url));
		JLabel ECI = new JLabel(new ImageIcon(eci));
		f.add(ECI);
		f.add(image);
		f.add(Title);
		f.add(RegB);
		f.add(LogB);
		f.add(AdminB);
		f.add(exit);
		image.setBounds(0, 150, 400, 400);
		ECI.setBounds(150,15,500,80);
		Title.setBounds(250,85,600,80);
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
		exit.setBounds(710,510,60,40);
		exit.setForeground(new Color(255, 215, 0));
		exit.setBackground(new Color(76,81,137));
		f.setSize(800,600);
		f.setLayout(null);
		f.getContentPane().setBackground(new Color(248,248,248));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		System.out.println(f.getComponentCount());
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.dispose();
			}
		});
		
		RegB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				RegisterSector reg = new RegisterSector();
				f.dispose();
				reg.r_frame01();
				
			}
		});
		AdminB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.dispose();
				Admin.admin_username_frame();
			}
		});
		LogB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(DB.getCountCandidateDaabase() >= 2 ){
					f.dispose();
					LoginSector.voter_username_frame();
				}
				else{
					JOptionPane.showMessageDialog(f, "No Party is yet competing with other.");
					
				}
			}
		});
	}
	
}
