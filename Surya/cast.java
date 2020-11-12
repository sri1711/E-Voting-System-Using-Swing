import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.sql.*;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;  
import javax.swing.SwingUtilities;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

class cast{
    static int length = 0;
    public static void main(String[] args) {
        System.out.println("Welcome!!");
        r_frame01();
    }

    public static void r_frame01(){
        JFrame frame  = new JFrame();
        frame.setContentPane(new JLabel(new ImageIcon("data/blue_pattern.png")));
        JLabel logo = new JLabel(new ImageIcon("data/EC_India.jpeg"));
        Dimension image_size = logo.getPreferredSize();     
        frame.add(logo);
        frame.setVisible(true);
        logo.setBounds(270,50,image_size.width,image_size.height);
        frame.setLayout(null);
        frame.setSize(900,600);

        JLabel title = new JLabel("Cast your vote");
        title.setBounds(290,150,350,50);
        title.setForeground(new Color(255, 215, 0));
        title.setOpaque(false);
        title.setFont(new Font("Serif",Font.PLAIN,40));
        frame.add(title);


        castVote(frame);


    }
    public static void castVote(JFrame frame){
        int i = 0;
        Connection con =null;
        try{
        String url = "jdbc:sqlite:D:/Java/mini_project/Surya/data/CandidateDatabase.db";
         con = DriverManager.getConnection(url);
         System.out.println("Connection Built successfully");

         Statement stmt = con.createStatement();
         String sql = "SELECT * FROM CandidateDatabase";
            ResultSet rs = stmt.executeQuery(sql);
            try{
            
                BufferedImage image = null;
                int x = 110;
                int y  = 230;

                while(rs.next()){
                    ++length;
                    ++i;
                    InputStream input = new BufferedInputStream( rs.getBinaryStream("PartyLogo"));
                    
                        image = ImageIO.read(input);
                        ImageIcon background_icon = new ImageIcon(image);
                        Image im = background_icon.getImage();
                        Image resizedImage = im.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                        JLabel Party_photo = new JLabel(new ImageIcon(resizedImage));
                        frame.add(Party_photo);
                        Party_photo.setBounds(x-40,y-20,100,200);
                        frame.setBackground(new Color(255,255,255));

                        String party_name = rs.getString("PartyName") ;
                        String candidate_name = rs.getString("CandidateName");

                        JLabel PartyName = new JLabel(party_name);
                        JLabel CandidateName = new JLabel("|  "+candidate_name);

                        PartyName.setBounds(x-40,y-2,100,30);
                        CandidateName.setBounds(x+70,y,300,30);

                        PartyName.setFont(new Font("Serif",Font.PLAIN,30));
                        PartyName.setForeground(new Color(255, 215, 0));
                        frame.add(PartyName);
                        
                        CandidateName.setFont(new Font("Serif",Font.PLAIN,15));
                        CandidateName.setForeground(new Color(255, 215, 0));
                        frame.add(CandidateName);

                        JButton cast_vote = new JButton("vote");
                        cast_vote.setBounds(x+70,y+40,100,40);
                        frame.add(cast_vote);

                        cast_vote.setFont(new Font("Serif",Font.PLAIN,25));
                        cast_vote.setForeground(new Color(255, 215, 0));
                        cast_vote.setBackground(new Color(76,81,137));

                        cast_vote.addActionListener(new ActionListener(){

                            public void actionPerformed(ActionEvent ae){                     
                                int a=JOptionPane.showConfirmDialog(frame,"Are you sure?");  
                                if(a==JOptionPane.YES_OPTION){  
                                    System.out.println("Your vote speaks!");
                                    JOptionPane.showMessageDialog(frame,"Your vote speaks!");
                                    try{
                                        length= length-1;
                                        String sql_candidate_updation = "UPDATE CandidateDatabase SET VotingCount = VotingCount + 1 WHERE PartyName = "+ "\""+party_name+"\"";
                                        stmt.executeQuery(sql_candidate_updation);
                                    }catch(Exception sqlExcept){
                                            System.out.println(sqlExcept);
                                        }
                                    frame.dispose();
                                   }
                                else{
                                    System.out.println("Choose your option wisely!");
                                }  
                           }
                        });

                        x= x+280;
                        if(i%3 == 0){
                            y+= 160;
                            x = 110;
                        }                        
                }
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }

            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("length :: "+length);
    }
}