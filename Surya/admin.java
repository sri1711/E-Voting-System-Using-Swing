import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.sql.*;

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

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

class admin{

    public static void main(String[] args) {
        System.out.println("Welcome!!");
        r_frame01();
        //r_frame01();
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
        //frame.getContentPane().setBackground(new Color(248,248,248));

        JLabel title = new JLabel("Approvals required");
        //Dimension title_size = title.getPreferredSize();
        title.setBounds(290,150,350,50);
        title.setForeground(new Color(255, 215, 0));
        title.setOpaque(false);
        title.setFont(new Font("Serif",Font.PLAIN,45));
        frame.add(title);
        backend(frame);


    }
    public static void backend(JFrame frame){
        Connection con =null;
        try{
        String url = "jdbc:sqlite:D:/Java/mini_project/Surya/data/CandidateDatabase.db";
         con = DriverManager.getConnection(url);
         System.out.println("Connection Built successfully");

         Statement stmt = con.createStatement();
         String sql = "SELECT * FROM CandidateDatabase WHERE ApproveStatus = 'Not Approved'";
            // PreparedStatement pstmt = conn.prepareStatement(sql);            
            // pstmt.setString(1, Name);
            // pstmt.setString(2, Dob);
            // pstmt.setString(3, MailId);
            // pstmt.setString(4, PhoneNumber);
            // pstmt.setString(5, AadharNumber);
            // pstmt.setString(6, VoterId);
            // pstmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            // int colmns = rs.getColumnCount();
            // for(int i=0;i<colmns;++i){
            // //     System.out.println(rs.getString(i));
            // // }
            // int rows = 0;
            // if(rs.last()){
            //     rows = rs.getRow();
            //     rs.beforeFirst();
            // }
        //     while(rs.next()){
        //         System.out.println(rs.getString("CandidateName"));
        //         JPanel panel = new JPanel();
        //         frame.add(panel);
        //         panel.setBackground(Color.blue);
        //         panel.setSize(300,300);
        //         panel.setLayout(new GridLayout(3,3));
        //         addToApprovalList(frame,panel);
        //         panel.add(new JButton("Button 1"));
        //         panel.add(new JButton("Button 1"));
        //         panel.add(new JButton("Button 1"));
        //         panel.add(new JButton("Button 1"));
        //         panel.add(new JButton("Button 1"));
        //         panel.add(new JButton("Button 1"));
        //     }

        //     // for(int i=1;i<rows+1;++i){
        //     //     System.out.print(rs.getString(i));
        //     //     System.out.println("");
        //     // }
        //     //System.out.println(rs.getString(2));
        //     // System.out.println("Results:-");
        //     // System.out.println(rs.getString("CandidateName"));
        //     // System.out.println(rs.getString("CandidateId"));
        //     // System.out.println(rs.getString("CandidateImage"));
        //     // System.out.println(rs.getString("PartyName"));
        //     // System.out.println(rs.getString("PartyEmail"));
        //     // System.out.println(rs.getString("ApproveStatus"));
            try{
            
                BufferedImage image = null;
                int x = 110;
                while(rs.next()){
                    InputStream input = new BufferedInputStream( rs.getBinaryStream("PartyLogo"));
                    //byte[] buffer = new byte[1024];
                    
                        image = ImageIO.read(input);
                        ImageIcon background_icon = new ImageIcon(image);
                        Image im = background_icon.getImage();
                        Image resizedImage = im.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
                        JLabel Party_photo = new JLabel(new ImageIcon(resizedImage));
                        frame.add(Party_photo);
                        Party_photo.setBounds(x,150,200,400);
                        frame.setBackground(new Color(255,255,255));

                        String party_name = rs.getString("PartyName") ;
                        String candidate_name = rs.getString("CandidateName");

                        JLabel PartyName = new JLabel(party_name);
                        JLabel CandidateName = new JLabel(candidate_name);
                        // System.out.println(rs.getString("PartyName"));
                        // System.out.println(rs.getString("CandidateName"));

                        PartyName.setBounds(x+220,250,100,30);
                        CandidateName.setBounds(x+220,280,300,30);

                        PartyName.setFont(new Font("Serif",Font.PLAIN,35));
                        PartyName.setForeground(new Color(255, 215, 0));
                        frame.add(PartyName);
                        
                        CandidateName.setFont(new Font("Serif",Font.PLAIN,20));
                        CandidateName.setForeground(new Color(255, 215, 0));
                        frame.add(CandidateName);

                        JButton accept = new JButton("Accept");
                        JButton reject = new JButton("Reject");
                        accept.setBounds(x+220,320,100,40);
                        frame.add(accept);
                        reject.setBounds(x+220,370,100,40);
                        frame.add(reject);

                        accept.setForeground(new Color(255, 215, 0));
                        accept.setBackground(new Color(76,81,137));

                        reject.setForeground(new Color(255, 215, 0));
                        reject.setBackground(new Color(76,81,137));

                        accept.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae){
                                // frame.remove(PartyName);
                                 
                                try{
                                //String sql_accept = "UPDATE CandidateDatabase"+ "SET ApproveStatus='Approved' WHERE PartyName =" + party_name;
                                PartyName.setVisible(false);
                                CandidateName.setVisible(false);
                                accept.setVisible(false);
                                reject.setVisible(false);
                                Party_photo.setVisible(false);
                                String sql_accept = "UPDATE CandidateDatabase SET ApproveStatus='Approved' WHERE PartyName ="+ "\""+party_name+"\"";
                                ResultSet rs_accept = stmt.executeQuery(sql_accept);
                                //PartyName.setVisible(false);
                                //CandidateName.setVisible(false);
                                }
                                catch(Exception sqlExcept){
                                    System.out.println(sqlExcept);
                                }
                            }
                        });


                        reject.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae){
                                try{
                                    PartyName.setVisible(false);
                                CandidateName.setVisible(false);
                                accept.setVisible(false);
                                reject.setVisible(false);
                                Party_photo.setVisible(false);
                                String sql_reject = "DELETE FROM CandidateDatabase " +"WHERE PartyName ="+ "\""+party_name+"\"";
                                ResultSet rs_reject = stmt.executeQuery(sql_reject);
                                }
                                catch(Exception sqlExcept){
                                    System.out.println(sqlExcept);
                                }
                            }
                        });



                        x= x+380;
                    
                }
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // public static void addToApprovalList(Jframe frame,JPanel panel){
    //     panel.
    // }
}