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
    static int length = 0;
    public static void main(String[] args) {
        System.out.println("Welcome!!");
        r_frame01();
    }

    public static void request_frame(){
        JFrame frame  = new JFrame();
        frame.setContentPane(new JLabel(new ImageIcon("data/blue_pattern.png")));
        JLabel logo = new JLabel(new ImageIcon("data/EC_India.jpeg"));
        Dimension image_size = logo.getPreferredSize();     
        frame.add(logo);
        frame.setVisible(true);
        logo.setBounds(270,50,image_size.width,image_size.height);
        frame.setLayout(null);
        frame.setSize(900,600);

        JLabel title = new JLabel("Approvals required");
        title.setBounds(290,150,350,50);
        title.setForeground(new Color(255, 215, 0));
        title.setOpaque(false);
        title.setFont(new Font("Serif",Font.PLAIN,45));
        frame.add(title);

        JLabel no_approvals_text = new JLabel("No pending Approvals");
        no_approvals_text.setBounds(330,280,350,50);
        no_approvals_text.setForeground(new Color(255, 215, 0));
        no_approvals_text.setVisible(false);
        no_approvals_text.setFont(new Font("Serif",Font.PLAIN,25));
        frame.add(no_approvals_text);

        backend(frame,no_approvals_text);


    }
    public static void backend(JFrame frame,JLabel no_approvals_text){
                int i = 0;
        Connection con =null;
        try{
        String url = "jdbc:sqlite:D:/Java/mini_project/Surya/data/CandidateDatabase.db";
         con = DriverManager.getConnection(url);
         System.out.println("Connection Built successfully");

         Statement stmt = con.createStatement();
         String sql = "SELECT * FROM CandidateDatabase WHERE ApproveStatus = 'Not Approved'";
<<<<<<< HEAD

            ResultSet rs = stmt.executeQuery(sql);

=======
            ResultSet rs = stmt.executeQuery(sql);
>>>>>>> 234f6f8db9ee57e5d4bee5ecabe8573a25335882
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

                        JButton accept = new JButton("Accept");
                        JButton reject = new JButton("Reject");
                        accept.setBounds(x+70,y+40,100,40);
                        frame.add(accept);
                        reject.setBounds(x+70,y+90,100,40);
                        frame.add(reject);

                        accept.setForeground(new Color(255, 215, 0));
                        accept.setBackground(new Color(76,81,137));

                        reject.setForeground(new Color(255, 215, 0));
                        reject.setBackground(new Color(76,81,137));

                        accept.addActionListener(new ActionListener(){

                            public void actionPerformed(ActionEvent ae){                     

                                try{
                                length= length-1;
                                no_approvals_text.setVisible(length == 0); 
                                PartyName.setVisible(false);
                                CandidateName.setVisible(false);
                                accept.setVisible(false);
                                reject.setVisible(false);
                                Party_photo.setVisible(false);
                                String sql_accept = "UPDATE CandidateDatabase SET ApproveStatus='Approved' WHERE PartyName ="+ "\""+party_name+"\"";
                                ResultSet rs_accept = stmt.executeQuery(sql_accept);
                                //  if(length == 0){
                                //     JOptionPane.showMessageDialog(null, "No Pending approvals");
                                // }
                                }
                                catch(Exception sqlExcept){
                                    System.out.println(sqlExcept);
                                }
                            }
                        });


                        reject.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae){
                    
                                try{
                                length = length-1;
                                no_approvals_text.setVisible(length == 0);  
                                PartyName.setVisible(false);
                                CandidateName.setVisible(false);
                                accept.setVisible(false);
                                reject.setVisible(false);
                                Party_photo.setVisible(false);
                                String sql_reject = "DELETE FROM CandidateDatabase " +"WHERE PartyName ="+ "\""+party_name+"\"";
                                ResultSet rs_reject = stmt.executeQuery(sql_reject);
                                // if(length == 0){
                                //     JOptionPane.showMessageDialog(null, "No Pending approvals");
                                // }
                                }
                                catch(Exception sqlExcept){
                                    System.out.println(sqlExcept);
                                }
                            }
                        });



                        x= x+280;
                        if(i%3 == 0){
                            y+= 160;
                            x = 110;
                        }
                        
                         no_approvals_text.setVisible(length == 0); 
                        
                }
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        no_approvals_text.setVisible(length == 0);
        System.out.println("length :: "+length);
        // if(length == 0){
        //                             JOptionPane.showMessageDialog(null, "No Pending approvals");
        //                         }

    }
}