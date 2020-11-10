package VotePackage;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class votesstatus  {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JScrollPane scrollBar=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		f.setContentPane(new JLabel(new ImageIcon("images/blue_pattern.png")));
		f.add(scrollBar);
		//f.setContentPane(pane);
		JLabel votes = new JLabel("Votes Obtained");
		//JButton b = new JButton("Click");
		ImageIcon candidate_icon = new ImageIcon("images/user-3.jpg");
		Image candidate = candidate_icon.getImage();
		Image resizedImage_candidate = candidate.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);
        JLabel photo = new JLabel(new ImageIcon(resizedImage_candidate));
        photo.setBounds(150,220,150,200);
        
        //f.add(photo);
		f.add(votes);
		//f.add(b);
		
		votes.setBounds(300, 20, 250, 50);
		votes.setForeground(new Color(255, 215, 0));
		votes.setFont(votes.getFont().deriveFont(28f));
		
		Connection conn = null;
		try {
		String url = "jdbc:sqlite:CandidateDatabase.db";
		String sqlquery = "SELECT PartyLogo,PartyName,CandidateName,VotingCount FROM CandidateDatabase WHERE ApproveStatus=?";
		conn = DriverManager.getConnection(url);
		
		ResultSet rs = null;
		
		PreparedStatement ps = conn.prepareStatement(sqlquery);
		//ps.setString(1, "PartyLogo");
		ps.setString(1, "Not Approved");
		rs = ps.executeQuery();
		
		BufferedImage image = null;
		int x = 25;
		int y= 120;
		try {
			while(rs.next()) {
				if(x>400) {
				x = 25;
				y = y+220;
				}
				InputStream input = new BufferedInputStream( rs.getBinaryStream("PartyLogo"));
				String partyname =rs.getString("PartyName");
				String Candidatename = rs.getString("CandidateName");
				String Voting = rs.getString("VotingCount");
				JLabel party = new JLabel(partyname);
				party.setBounds(x+160, y+80, 250, 40);
				party.setForeground(new Color(255,215,0));
				party.setFont(party.getFont().deriveFont(28f));
				f.add(party);
				System.out.println("Party logo added");
				JLabel Candidate = new JLabel(Candidatename);
				Candidate.setBounds(x+160, y+110, 250, 40);
				Candidate.setForeground(new Color(255,215,0));
				Candidate.setFont(party.getFont().deriveFont(28f));
				f.add(Candidate);
				System.out.println("Candidate added");
				JLabel voting_count = new JLabel("Voting count:"+Voting);
				voting_count.setBounds(x+160, y+140, 250, 40);
				voting_count.setForeground(new Color(255,215,0));
				voting_count.setFont(voting_count.getFont().deriveFont(28f));
				f.add(voting_count);
				System.out.println("Voting Count added");
				image = ImageIO.read(input);
				ImageIcon background_icon = new ImageIcon(image);
				Image im = background_icon.getImage();
				Image resizedImage = im.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
				JLabel Party_photo = new JLabel(new ImageIcon(resizedImage));
				f.add(Party_photo);
				System.out.println("Image added");
				Party_photo.setBounds(x,y,150,200);
				x=x+350;
				System.out.println(x);
			
				//f.setBackground(new Color(255,255,255));
			}
		}
		catch(IOException e3) {
			System.out.println(e3.getMessage());
		}
		
		
		}
		catch(SQLException e) {
			System.out.println("Connection error");
		}
		f.setLayout(null);
		f.setSize(800, 600);
		f.setVisible(true);
		
			
	}

}
	   
	
	