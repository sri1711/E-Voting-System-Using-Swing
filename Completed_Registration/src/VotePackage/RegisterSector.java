package VotePackage;


import java.awt.Color;
//import edu.duke.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RegisterSector {
	
	
	private static String getCandidateId(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    }  
	
	
	public static void Candidate_register_frame(){
		JFrame frame  =  new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
		
		
		// Setting BackGroundColor of frame
		frame.getContentPane().setBackground(new Color(248,248,248));
		
		// To add Election Commission Logo
		String url = "D:/Eclipse/workspace/Elite Voting System/images/ElectionComm-top-image.jpeg";
		JLabel image = new JLabel(new ImageIcon(url));
		Dimension image_size = image.getPreferredSize();
		image.setBounds(200, 25, image_size.width, image_size.height);
		
		// To add Title of this Frame
		JLabel frame_title = new JLabel("Candidate Registration");
		Dimension frame_title_size = frame_title.getPreferredSize();
		frame_title.setFont(frame_title.getFont().deriveFont(26f));
		frame_title.setBounds(250,125, frame_title_size.width*26, frame_title_size.height+26);
		frame_title.setForeground(new Color(255, 215, 0));
		frame.add(frame_title);
		
		
        JButton upload = new JButton("upload Candidate photo");
        upload.setBounds(150, 420, 150, 30);
        frame.add(upload);
        upload.setBackground(new Color(76,81,137));
        upload.setForeground(new Color(255, 215, 0));
        
        // To create space to upload photo
        ImageIcon candidate_icon = new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/user-3.jpg");
		Image candidate = candidate_icon.getImage();
		Image resizedImage_candidate = candidate.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);
        JLabel photo = new JLabel(new ImageIcon(resizedImage_candidate));
        photo.setBounds(150,220,150,200);
        frame.add(photo);
        
        // To create Labels for inputs in frame
        JLabel Party_name        = new JLabel("Party Name*     : ");
        JLabel Candidate_name    = new JLabel("Candidate Name* : ");
        JLabel Party_sym         = new JLabel("Party_Image*    : ");
        JLabel Party_Email       = new JLabel("Party Email Id* : ");
        
        JButton Party_image      = new JButton("Upload");
        Party_image.setBounds(480,320,100,25);
        Party_image.setBackground(new Color(76,81,137));
        Party_image.setForeground(new Color(255, 215, 0));
        


        // Setting coordinates,width and height of labels in frame
        Party_name.setBounds(320,230,300,25);
        Candidate_name.setBounds(320,260,300,25);
        Party_Email.setBounds(320, 290, 300,25);
        Party_sym.setBounds(320,320,300,25);
       
        

        // Setting font for labels
        Party_name.setFont(new Font("Serif",Font.PLAIN,20));
        Party_name.setForeground(new Color(255, 215, 0));
        Candidate_name.setFont(new Font("Serif",Font.PLAIN,20));
        Candidate_name.setForeground(new Color(255, 215, 0));
        Party_sym.setFont(new Font("Serif",Font.PLAIN,20));
        Party_sym.setForeground(new Color(255, 215, 0));
        Party_Email.setFont(new Font("Serif",Font.PLAIN,20));
        Party_Email.setForeground(new Color(255, 215, 0));
        
        // adding labels to frame
        frame.add(image);
        frame.add(Party_name);
        frame.add(Candidate_name);
        frame.add(Party_sym);
        frame.add(Party_image);
        frame.add(Party_Email);

        // Textfield creation
        JTextField Party_name_tf = new JTextField("");
        JTextField Candidate_name_tf = new JTextField("");
        JTextField Party_Email_tf = new JTextField("");

        // Adding Textfield to frame 
        frame.add(Party_name_tf);
        frame.add(Candidate_name_tf);
        frame.add(Party_Email_tf);

        // setting coordinates ,width and height of textfields in frame
        Party_name_tf.setBounds(480,230,150,25);
        Candidate_name_tf.setBounds(480,260,150,25);
        Party_Email_tf.setBounds(480,290,150,25);
        
        
        	
        
        
        Party_name_tf.setFont(new Font("Serif",Font.PLAIN,16));
        Party_name_tf.setForeground(new Color(255, 215, 0));
        Party_name_tf.setBackground(new Color(76,81,137));
        Candidate_name_tf.setFont(new Font("Serif",Font.PLAIN,16));
        Candidate_name_tf.setForeground(new Color(255, 215, 0));
        Candidate_name_tf.setBackground(new Color(76,81,137));
        Party_Email_tf.setFont(new Font("Serif",Font.PLAIN,16));
        Party_Email_tf.setForeground(new Color(255, 215, 0));
        Party_Email_tf.setBackground(new Color(76,81,137));
        
        
        Candidate_name_tf.setMargin(new Insets(2,10,2,10));
        Party_name_tf.setMargin(new Insets(2,10,2,10));
        Party_Email_tf.setMargin(new Insets(2,10,2,10));
        
        ArrayList<JLabel> labels_photo = new ArrayList<JLabel>();
        ArrayList<JLabel> labels_party_image = new ArrayList<JLabel>();
        
        
        ArrayList<File>  Candidate_photo = new ArrayList<File>();
        ArrayList<File>  Party_photo_list = new ArrayList<File>();

        //JButton Event Listener
        upload.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		photo.setVisible(true);
        		upload.setText("upload candidate photo");
        		
        		JFileChooser fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);

                int option = fileChooser.showOpenDialog(frame);
                JLabel label = new JLabel();
                if(option == JFileChooser.APPROVE_OPTION){
                	try{
                		
                		File file = fileChooser.getSelectedFile();
                		Candidate_photo.add(file);
                		BufferedImage bi = ImageIO.read(file);
                		ImageIcon background_icon = new ImageIcon(bi);
                		Image im = background_icon.getImage();
                		Image resizedImage = im.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);
                		JLabel Cphoto = new JLabel(new ImageIcon(resizedImage));
                		upload.setText(file.getName());
                		photo.setVisible(false);
                		frame.add(Cphoto);
                		labels_photo.add(Cphoto);
                		Cphoto.setBounds(150, 220, 150, 200);
                		if(labels_photo.size() > 1){
                			JLabel Cphoto_temp = labels_photo.get(0);
                			frame.remove(Cphoto_temp);
                			labels_photo.remove(0);
                			Candidate_photo.remove(0);
                		}
                		
                		
                		
                	}
                	catch(Exception el){
                		el.printStackTrace();
                	}
    	   		   
                  
                }else{
                   label.setText("Open command canceled");
                }   
        	}
        });
        
        Party_image.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		Party_image.setText("Upload");
        		JFileChooser fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);
                int option = fileChooser.showOpenDialog(frame);
                JLabel label = new JLabel();
                if(option == JFileChooser.APPROVE_OPTION){
                	try{
                		File file = fileChooser.getSelectedFile();
                		Party_photo_list.add(file);
                		BufferedImage bi = ImageIO.read(file);
                		ImageIcon background_icon = new ImageIcon(bi);
                		Image im = background_icon.getImage();
                		Image resizedImage = im.getScaledInstance(90, 100, java.awt.Image.SCALE_SMOOTH);
                		JLabel Party_photo = new JLabel(new ImageIcon(resizedImage));
                		Party_image.setText(file.getName());
                		frame.add(Party_photo);
                		labels_party_image.add(Party_photo);
                		Party_photo.setBounds(640, 300, 100, 100);
                		if(labels_party_image.size() > 1){
                			JLabel Party_photo_temp = labels_party_image.get(0);
                			frame.remove(Party_photo_temp);
                			labels_party_image.remove(0);
                			Party_photo.remove(0);
                		}
                		
                	}
                	catch(Exception el){
                		el.printStackTrace();
                	}
    	   		   
                  
                }else{
                   label.setText("Open command canceled");
                }   
        	}
        });
        
        JButton Submit_button = new JButton("Submit");
        frame.add(Submit_button);
        Submit_button.setBounds(500, 400 , 100, 35);
        Submit_button.setBackground(new Color(76,81,137));
        Submit_button.setForeground(new Color(255, 215, 0));
        //Submit_button.setBorder(new Border());
        
        Submit_button.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		System.out.println("Clicked Submit Button");
        		if(!(Candidate_name_tf.getText().equals("")) && !(Party_name_tf.getText().equals("")) && labels_photo.size()!= 0 && labels_party_image.size()!=0 && !(Party_Email_tf.getText().equals(""))){
        			if((Party_Email_tf.getText()).contains("@")){
        				String candidate_id = getCandidateId(6);
        				DB.Candidate_database(candidate_id,Candidate_name_tf.getText(),Party_name_tf.getText(),Candidate_photo.get(0),Party_photo_list.get(0),Party_Email_tf.getText());
        				
        				Candidate_name_tf.setText("");
        				Party_name_tf.setText("");
        				Party_Email_tf.setText("");
        				photo.setVisible(true);
        				(labels_party_image.get(0)).setVisible(false);
        			}
        			else{
        				JOptionPane.showMessageDialog(null, "Check Your Email Id");
        			}
        		}
        		else{
        			JOptionPane.showMessageDialog(null, "All fields are Mandatory");
        		}
        		
        	}
        });
        
        
        JButton back_button = new JButton("Back");
        back_button.setBounds(350, 400 , 100, 35);
        back_button.setBackground(new Color(76,81,137));
        back_button.setForeground(new Color(255, 215, 0));
        frame.add(back_button);
        
        back_button.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ae){
        		frame.dispose();
        		r_frame01();
        	}
        });
		
		frame.setLayout(null);
		frame.setSize(800,600);
		frame.setVisible(true);
	}
	
	
	
	public static void r_frame02(){
		JFrame frame  = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setSize(900,600);

		JLabel logo = new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/EC_India.jpeg"));
		Dimension image_size = logo.getPreferredSize();		
		frame.add(logo);
		logo.setBounds(250,50,image_size.width,image_size.height);

		JLabel title = new JLabel("Provide your data");
		title.setBounds(330,130,250,50);
		title.setForeground(new Color(255, 215, 0));
		title.setOpaque(false);
		title.setFont(new Font("Serif",Font.PLAIN,32));
		frame.add(title);
		
		ImageIcon candidate_icon = new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/user-3.jpg");
		Image candidate = candidate_icon.getImage();
		Image resizedImage_candidate = candidate.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);
        JLabel photo = new JLabel(new ImageIcon(resizedImage_candidate));
        photo.setBounds(200,220,150,200);
        frame.add(photo);

		JButton upload = new JButton("Click to upload \nyour photo");
		upload.setBounds(200,420,150,30);
		frame.add(upload);
		upload.setForeground(new Color(255, 215, 0));
		upload.setBackground(new Color(76,81,137));

		

		JLabel name  = new JLabel("Name : ");
		JLabel dob  = new JLabel("DOB : ");
		JLabel mail  = new JLabel("Mail : ");
		JLabel phone  = new JLabel("Phone : ");
		JLabel aadhar = new JLabel("Aadhar no : ");
		JLabel voterid = new JLabel("Voter ID : ");

		frame.add(name);
		frame.add(dob);
		frame.add(mail);
		frame.add(phone);
		frame.add(aadhar);
		frame.add(voterid);

		name.setForeground(new Color(255, 215, 0));
		dob.setForeground(new Color(255, 215, 0));
		mail.setForeground(new Color(255, 215, 0));
		phone.setForeground(new Color(255, 215, 0));
		aadhar.setForeground(new Color(255, 215, 0));
		voterid.setForeground(new Color(255, 215, 0));


		name.setFont(new Font("Serif",Font.PLAIN,20));
		dob.setFont(new Font("Serif",Font.PLAIN,20));
		mail.setFont(new Font("Serif",Font.PLAIN,20));
		phone.setFont(new Font("Serif",Font.PLAIN,20));
		aadhar.setFont(new Font("Serif",Font.PLAIN,20));
		voterid.setFont(new Font("Serif",Font.PLAIN,20));

		name.setBounds(380,230,80,25);
		dob.setBounds(380,260,80,25);
		mail.setBounds(380,290,80,25);
		phone.setBounds(380,320,80,25);
		aadhar.setBounds(380,350,100,25);
		voterid.setBounds(380,380,100,25);


		JTextField name_tf = new JTextField("");
		JTextField dob_tf = new JTextField("");
		JTextField mail_tf = new JTextField("");
		JTextField phone_tf = new JTextField("");
		JTextField aadhar_tf = new JTextField("");
		JTextField voterid_tf = new JTextField("");

		frame.add(name_tf);
		frame.add(dob_tf);
		frame.add(mail_tf);
		frame.add(phone_tf);
		frame.add(aadhar_tf);
		frame.add(voterid_tf);

		name_tf.setBackground(new Color(76,81,137));
		dob_tf.setBackground(new Color(76,81,137));
		mail_tf.setBackground(new Color(76,81,137));
		phone_tf.setBackground(new Color(76,81,137));
		aadhar_tf.setBackground(new Color(76,81,137));
		voterid_tf.setBackground(new Color(76,81,137));

		name_tf.setForeground(new Color(255, 215, 0));
		dob_tf.setForeground(new Color(255, 215, 0));
		mail_tf.setForeground(new Color(255, 215, 0));
		phone_tf.setForeground(new Color(255, 215, 0));
		aadhar_tf.setForeground(new Color(255, 215, 0));
		voterid_tf.setForeground(new Color(255, 215, 0));
		

		name_tf.setMargin(new Insets(2,10,2,10));
		dob_tf.setMargin(new Insets(2,10,2,10));
		mail_tf.setMargin(new Insets(2,10,2,10));
		phone_tf.setMargin(new Insets(2,10,2,10));
		aadhar_tf.setMargin(new Insets(2,10,2,10));
		voterid_tf.setMargin(new Insets(2,10,2,10));

		name_tf.setBounds(490,230,120,25);
		dob_tf.setBounds(490,260,120,25);
		mail_tf.setBounds(490,290,120,25);
		phone_tf.setBounds(490,320,120,25);
		aadhar_tf.setBounds(490,350,120,25);
		voterid_tf.setBounds(490,380,120,25);
		

		JButton submit = new JButton("Submit");
		submit.setBounds(550, 420 , 100, 35);
		frame.add(submit);
		//submit.setFont(new Font("Serif", Font.PLAIN, 25));
		submit.setForeground(new Color(255, 215, 0));
		submit.setBackground(new Color(76,81,137));
	
		JButton back_button = new JButton("Back");
        back_button.setBounds(400, 420 , 100, 35);
        back_button.setBackground(new Color(76,81,137));
        back_button.setForeground(new Color(255, 215, 0));
        frame.add(back_button);
        
        
        ArrayList<JLabel> labels_photo = new ArrayList<JLabel>();
        ArrayList<File> labels_photo_file = new ArrayList<File>();
        
        
        upload.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		photo.setVisible(true);
        		upload.setText("upload candidate photo");
        		
        		JFileChooser fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);

                int option = fileChooser.showOpenDialog(frame);
                JLabel label = new JLabel();
                if(option == JFileChooser.APPROVE_OPTION){
                	try{
                		
                		File file = fileChooser.getSelectedFile();
                		labels_photo_file.add(file);
                		BufferedImage bi = ImageIO.read(file);
                		ImageIcon background_icon = new ImageIcon(bi);
                		Image im = background_icon.getImage();
                		Image resizedImage = im.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);
                		JLabel Cphoto = new JLabel(new ImageIcon(resizedImage));
                		upload.setText(file.getName());
                		photo.setVisible(false);
                		frame.add(Cphoto);
                		labels_photo.add(Cphoto);
                		Cphoto.setBounds(200, 220, 150, 200);
                		if(labels_photo.size() > 1){
                			JLabel Cphoto_temp = labels_photo.get(0);
                			frame.remove(Cphoto_temp);
                			labels_photo.remove(0);
                		}
                		
                		
                	}
                	catch(Exception el){
                		el.printStackTrace();
                	}
    	   		   
                  
                }else{
                   label.setText("Open command canceled");
                }   
        	}
        });
        
        
		submit.addActionListener(new ActionListener(){
   			public void actionPerformed(ActionEvent ae){
   				String test="";
   					String[] s = {name_tf.getText(),dob_tf.getText(),mail_tf.getText(),phone_tf.getText(),aadhar_tf.getText(),voterid_tf.getText()};
   					for(int i=0;i<6;++i){  						
  						System.out.println("Inside for loop : ");
   						System.out.print(i);
   						if(s[i].isEmpty()==true){
   							 JOptionPane.showMessageDialog(frame, "Please enter all the valid data");
   							 test = "flagged";
   							 break;
   						}
   					}
   					if(test!="flagged"){
   						System.out.println("Checking Existance!");
   						if(DB.checkExistance(aadhar_tf.getText())==false){
   							System.out.println("Inserting now");
							DB.insert(name_tf.getText(),dob_tf.getText(),mail_tf.getText(),phone_tf.getText(),aadhar_tf.getText(),voterid_tf.getText(),labels_photo_file.get(0));
							System.out.println("Done!");
   						}
   					else{
   					 	JOptionPane.showMessageDialog(frame, "User name already exists!");
   						}
   					}
   			//DB.insert(name_tf.getText(),dob_tf.getText(),phone_tf.getText(),aadhar_tf.getText(),voterid_tf.getText(),name_tf.getText());
   			}
		});
		
        back_button.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ae){
        		frame.dispose();
        		r_frame01();
        	}
        });

	}


	
	
	
	
	public static void r_frame01(){
		JFrame frame  = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
		JLabel logo = new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/EC_India.jpeg"));
		Dimension image_size = logo.getPreferredSize();		
		frame.add(logo);
		frame.setVisible(true);
		logo.setBounds(270,50,image_size.width,image_size.height);
		frame.setLayout(null);
		frame.setSize(900,600);

		JLabel title = new JLabel("Choose your role");
		//Dimension title_size = title.getPreferredSize();
		title.setBounds(290,150,350,50);
		title.setForeground(new Color(255, 215, 0));
		title.setOpaque(false);
		title.setFont(new Font("Serif",Font.PLAIN,45));
		frame.add(title);
		
		JButton candidate_register_button  = new JButton("Candidate");
		candidate_register_button.setBounds(250,300,180,80);
		candidate_register_button.setFont(new Font("Serif", Font.PLAIN,25));
		candidate_register_button.setBackground(new Color(76,81,137));
		candidate_register_button.setForeground(new Color(255, 215, 0));
		frame.add(candidate_register_button);

		JButton voter_register_button  = new JButton("Voter");
		voter_register_button.setBounds(460,300,180,80);
		voter_register_button.setFont(new Font("Serif", Font.PLAIN, 25));
		voter_register_button.setBackground(new Color(76,81,137));
		voter_register_button.setForeground(new Color(255, 215, 0));
		frame.add(voter_register_button);
		
		
		JButton main_menu_button = new JButton("Main Menu");
		main_menu_button.setBounds(355,400,180,80);
		main_menu_button.setFont(new Font("Serif", Font.PLAIN, 25));
		main_menu_button.setBackground(new Color(76,81,137));
		main_menu_button.setForeground(new Color(255, 215, 0));
		frame.add(main_menu_button);
		
		candidate_register_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				frame.dispose();
				Candidate_register_frame();
			}
		});
		
		voter_register_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				frame.dispose();
				r_frame02();
			}
		});
		
		
		main_menu_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				frame.dispose();
				MainPage.main(null);
			}
		});

	}
	
	
	
	
	
	public static void main(String[] args){
		//Candidate_register_frame();
		r_frame01();
		
	}

}
