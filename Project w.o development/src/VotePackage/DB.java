package VotePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.email.durgesh.Email;

public class DB {
	private static int length; 
	private static ArrayList<Integer> ob = new ArrayList<Integer>();
	private static int count = 0;
		public static void insert(String Name,String Dob,String MailId,String PhoneNumber,String AadharNumber,String VoterId,File VoterPhoto){
			Connection conn =null;
			ByteArrayOutputStream bos1 = null;
			try{

				String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/voter_registration.db";
				conn = DriverManager.getConnection(url);
				System.out.println("Connection Built successfully");
				System.out.println("Inside Insertion");

				String sql = "INSERT INTO VoterRegistration(Name,Dob,MailId,PhoneNumber,AadharNumber,VoterId,VoterPhoto) VALUES(?,?,?,?,?,?,?)";
				try{
					InputStream fis1 = new FileInputStream(VoterPhoto);
					byte[] buffer1 = new byte[1024];
					bos1 = new ByteArrayOutputStream();
					for (int len; (len = fis1.read(buffer1)) != -1;) {
						bos1.write(buffer1, 0, len);
					}
			
					PreparedStatement pstmt = conn.prepareStatement(sql);            
					pstmt.setString(1, Name);
					pstmt.setString(2, Dob);
					pstmt.setString(3, MailId);
					pstmt.setString(4, PhoneNumber);
					pstmt.setString(5, AadharNumber);
					pstmt.setString(6, VoterId);
					pstmt.setBytes(7,bos1.toByteArray());
					pstmt.executeUpdate();
					System.out.println("Finished Insertion");
				}
				catch(IOException e){
					System.out.println(e.getMessage());
				}
	        } catch (SQLException e){
	          	System.out.println(e.getMessage());
	          	System.out.println("error @Insertion");
	        }
	        try{
	        	conn.close();
	        }
	        catch(Exception e){
	        	System.out.println(e);
	        }
		}

		public static Boolean checkExistance(String AadharNumber){
				Connection conn =null;
				String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/voter_registration.db";
			 try{
			 	conn = DriverManager.getConnection(url);
	         	System.out.println("Connection Built successfully");
	        	Statement stmt = conn.createStatement();
	        	String sql = "SELECT * FROM VoterRegistration WHERE AadharNumber = "+AadharNumber;
	        	ResultSet rs = stmt.executeQuery(sql);
	        	rs.getString("Name");
	         	System.out.println("Person already registared as:-");
	         	System.out.println(rs.getString("Name"));
	         	System.out.println(rs.getString("Dob"));
	         	System.out.println(rs.getString("MailId"));
	         	System.out.println(rs.getString("PhoneNumber"));
	         	System.out.println(rs.getString("VoterId"));
				try{
	        		conn.close();
	        	}
	        	catch(Exception e1){
	        		System.out.println(e1);
	        	}         	
	         	return true;
			 }catch(SQLException e2){
			 	System.out.println(e2.getMessage());
			 	try{
	        		conn.close();
	        	}
	        	catch(Exception e3){
	        		System.out.println(e3);
	        	}   
			 	return false;
			 	
			 }

		}
		
		public static void Candidate_database(String CandidateId, String Candidate_name,String Party_name,File Candidate_image,File Party_logo,String Party_email){
			Connection conn = null;
			ByteArrayOutputStream bos1 = null;
			ByteArrayOutputStream bos2 = null;
			try{
				
				//Url of DataBase
				String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/CandidateDatabase.db";
				
				//Connecting Database 
				conn = DriverManager.getConnection(url);
				System.out.println("\n Connected");
				
				//Sql Query to execute
				String sqlquery = "INSERT INTO CandidateDatabase(CandidateId,CandidateName,PartyName,PartyLogo,CandidateImage,PartyEmail) VALUES(?,?,?,?,?,?)";
				
				
				PreparedStatement ps = conn.prepareStatement(sqlquery);
				try
				{
					InputStream fis1 = new FileInputStream(Candidate_image);
					byte[] buffer1 = new byte[1024];
					bos1 = new ByteArrayOutputStream();
					for (int len; (len = fis1.read(buffer1)) != -1;) {
						bos1.write(buffer1, 0, len);
					}
					
					InputStream fis2 = new FileInputStream(Party_logo);
					byte[] buffer2 = new byte[1024];
					bos2 = new ByteArrayOutputStream();
					for (int len; (len = fis2.read(buffer2)) != -1;) {
						bos2.write(buffer2, 0, len);
					}

				
					ps.setString(1,CandidateId);
					ps.setString(2,Candidate_name);
					ps.setString(3,Party_name);
					ps.setBytes(5,bos1.toByteArray());
					ps.setBytes(4,bos2.toByteArray());
					ps.setString(6,Party_email);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				// Executing Sql Query
				ps.executeUpdate();
				System.out.println("Added");
				JOptionPane.showMessageDialog(null, "Registered Successfully");
				
						
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			finally{
				try{
					conn.close();
				}
				catch(SQLException se){
					System.out.println(se.getMessage());
				}
				
			}
			
		}
		
		
		public static void get_Voter_Image(JFrame frame, String VoterId){
			Connection conn = null;
			try{				
				//Connecting Database
				String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/voter_registration.db";
				conn = DriverManager.getConnection(url);
				System.out.println("\n Connected");
				
				//Sql Query to execute
				String sqlquery = "SELECT * FROM VoterRegistration WHERE VoterId=?";
				
				ResultSet rs = null;
				
				PreparedStatement ps = conn.prepareStatement(sqlquery);
				ps.setString(1,VoterId);
				rs = ps.executeQuery();
				System.out.println("Outside Loop");
				try{
					System.out.print(1);
					while(rs.next()){
						InputStream input = new BufferedInputStream(rs.getBinaryStream("VoterPhoto"));
						System.out.println(input);
						BufferedImage image = ImageIO.read(input);
						ImageIcon background_icon = new ImageIcon(image);
						Image im = background_icon.getImage();
						Image resizedImage = im.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
							
						JLabel Voter_photo = new JLabel(new ImageIcon(resizedImage));
						JLabel VoterName = new JLabel("NAME      : "+rs.getString("Name"));
						JLabel VoterDob  = new JLabel("VOTER DOB : "+rs.getString("DOB"));
						JLabel AadharNo  = new JLabel("AADHAR NO : "+rs.getString("AadharNumber"));
						JLabel Voter_id  = new JLabel("VOTER ID  : "+rs.getString("VoterId"));
						
						frame.add(Voter_photo);
						frame.add(Voter_id);
						frame.add(VoterName);
						frame.add(AadharNo);
						frame.add(VoterDob);							

						VoterName.setForeground(new Color(255, 215, 0));
						Voter_id.setForeground(new Color(255, 215, 0));
						AadharNo.setForeground(new Color(255, 215, 0));
						VoterDob.setForeground(new Color(255, 215, 0));


						VoterName.setFont(new Font("Serif",Font.PLAIN,20));
						Voter_id.setFont(new Font("Serif",Font.PLAIN,20));
						AadharNo.setFont(new Font("Serif",Font.PLAIN,20));
						VoterDob.setFont(new Font("Serif",Font.PLAIN,20));

						Voter_photo.setBounds(200, 220, 150, 200);
						VoterName.setBounds(380,230,225,25);
						Voter_id.setBounds(380,270,225,25);
						AadharNo.setBounds(380,310,275,25);
						VoterDob.setBounds(380,350,225,25);

					}
				}
				catch(IOException e){
					System.out.println(e.getMessage());
				}		
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			finally{
				try{
					conn.close();
					
				}
				catch(SQLException se){
					System.out.println(se.getMessage());
				}
				
			}

		}
		
	    public static void request_backend(JFrame frame,JLabel no_approvals_text){
	    	int i = 0;
	    	Connection con =null;
	    	try{
	    		String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/CandidateDatabase.db";
	    		con = DriverManager.getConnection(url);
	    		System.out.println("Connection Built successfully");

	    		Statement stmt = con.createStatement();
	    		String sql = "SELECT * FROM CandidateDatabase WHERE ApproveStatus = 'Not Approved'";
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
                    				stmt.executeQuery(sql_accept);
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
                    				
                    				stmt.executeQuery(sql_reject);
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
	    	finally{
				try{
					con.close();
					
				}
				catch(SQLException se){
					System.out.println(se.getMessage());
				}
				
			}
	    	no_approvals_text.setVisible(length == 0);
	    	System.out.println("length :: "+length);
	    }		
	    
	    
		public static void LiveStatusDb(JFrame f){
			Connection conn = null;
			try {
			String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/CandidateDatabase.db";
			String sqlquery = "SELECT PartyLogo,PartyName,CandidateName,VotingCount FROM CandidateDatabase";
			conn = DriverManager.getConnection(url);
			
			ResultSet rs = null;
			
			PreparedStatement ps = conn.prepareStatement(sqlquery);
			//ps.setString(1, "PartyLogo");
			//ps.setString(1, "Approved");
			rs = ps.executeQuery();
			
			BufferedImage image = null;
			int x = 15;
			int y= 120;
			try {
				while(rs.next()) {
					if(x>400) {
					x = 15;
					y = y+220;
					}
					InputStream input = new BufferedInputStream( rs.getBinaryStream("PartyLogo"));
					String partyname =rs.getString("PartyName");
					String Candidatename = rs.getString("CandidateName");
					int Voting = rs.getInt("VotingCount");
					ob.add(Voting);
					JLabel party = new JLabel(partyname);
					party.setBounds(x+145, y+80, 250, 40);
					party.setForeground(new Color(255,215,0));
					//party.setFont(party.getFont().deriveFont(18f));
					party.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
					f.add(party);
					System.out.println("Party logo added");
					JLabel Candidate = new JLabel(Candidatename);
					Candidate.setBounds(x+145, y+110, 250, 40);
					Candidate.setForeground(new Color(255,215,0));
					//Candidate.setFont(party.getFont().deriveFont(18f));
					Candidate.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
					f.add(Candidate);
					System.out.println("Candidate added");
					JLabel voting_count = new JLabel("voting count :: "+Voting);
					voting_count.setBounds(x+145, y+140, 250, 40);
					voting_count.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
					voting_count.setForeground(new Color(254, 134, 0));
					f.add(voting_count);
					System.out.println("Voting Count added");
					image = ImageIO.read(input);
					ImageIcon background_icon = new ImageIcon(image);
					Image im = background_icon.getImage();
					Image resizedImage = im.getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH);
					JLabel Party_photo = new JLabel(new ImageIcon(resizedImage));
					f.add(Party_photo);
					System.out.println("Image added");
					Party_photo.setBounds(x,y+20,125,200);
					x=x+350;
					System.out.println(x);
				
				}
			}
			catch(IOException e3) {
				System.out.println(e3.getMessage());
			}			
			
			}
			catch(SQLException e) {
				System.out.println("Connection error");
			}
			finally{
				try{
					conn.close();
					
				}
				catch(SQLException se){
					System.out.println(se.getMessage());
				}
				
			}
			
		}
		

		@SuppressWarnings("finally")
		public static ResultSet getEmail(String Voter_id){
			ResultSet rs = null;
			try {
				Connection conn = null;
				String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/voter_registration.db";
				
				conn = DriverManager.getConnection(url);
				String sqlquery = "SELECT * FROM VoterRegistration WHERE VoterId = ?";
				PreparedStatement ps =conn.prepareStatement(sqlquery);
				ps.setString(1, Voter_id);						
				rs = ps.executeQuery();
				
			}
			catch(SQLException e ) {
				System.out.println(e.getMessage());
			}
			return rs;
		}
		
		
	    public static void castVote(JFrame frame,String Voter_id){
	        int i = 0;
	        Connection con =null;
	        try{
	         String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/CandidateDatabase.db";
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
	                                    
	                                    try{
	                                        length= length-1;
	                                        updateCountStatus(party_name);
	                                        updateVoteStatus(Voter_id);
	                                        JOptionPane.showMessageDialog(frame,"Your vote speaks!\n Thank You For Voting.");
	                                        
	                                    }
	                                    catch(Exception sqlExcept){
	                                    	System.out.println("1");
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
	            	System.out.println("2");
	                System.out.println(e.getMessage());
	            }
	        } catch (SQLException e){
	        	System.out.println("3");
	            System.out.println(e.getMessage());
	        }
	        finally{
				try{
					con.close();
					
				}
				catch(SQLException se){
					System.out.println("4");
					System.out.println(se.getMessage());
				}
				
			}
	        System.out.println("length :: "+length);
	    }
	    
	    
	    private  static void  updateVoteStatus(String Voter_id){
	    	Connection conn =null;
            try {
            	String url_voter = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/voter_registration.db";
				conn = DriverManager.getConnection(url_voter);
				Statement stmt_2 = conn.createStatement();
				System.out.println("Connection Built successfully");
				String sql_voter_updation = "UPDATE VoterRegistration SET VoteStatus = \"Voted\" WHERE VoterId = \"" + Voter_id + "\"";
                stmt_2.executeQuery(sql_voter_updation);
			} catch (SQLException e) {
				System.out.println("6");
				System.out.println(e.getMessage());
			}
            finally{
            	try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("7");
					System.out.println(e.getMessage());
				}
            }
            
            
	    }
		
	    private static void updateCountStatus(String party_name){
	    	Connection conn = null;
	    	try{
	    		 String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/CandidateDatabase.db";
		         conn = DriverManager.getConnection(url);
		         System.out.println("Connection Built successfully");
		         Statement stmt = conn.createStatement();
		         
	    		String sql_candidate_updation = "UPDATE CandidateDatabase SET VotingCount = VotingCount + 1 WHERE PartyName = "+ "\""+party_name+"\"";
	    		stmt.executeQuery(sql_candidate_updation);
	    	}
	    	catch(SQLException e){
	    		System.out.println(e.getMessage());
	    	}
	    	finally{
	    		try{
	    			conn.close();
	    		}
	    		catch(SQLException e){
	    			System.out.println(e.getMessage());
	    		}
	    	}
	    }
	    
	    public static String getVoteCountStatus(JFrame frame){
	    	System.out.println("In the function"); 	
	    	String Party_name = "";
	    	Connection conn = null;
	    	try {
				ResultSet rs2 = null;
				String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/CandidateDatabase.db";
		        conn = DriverManager.getConnection(url); 
				String sql = "SELECT PartyName FROM CandidateDatabase WHERE VotingCount = ?";
				PreparedStatement ps2 = conn.prepareStatement(sql);
				ps2.setInt(1, Collections.max(ob));
				rs2 = ps2.executeQuery();
			    
				while(rs2.next()) {
					count++;
				}
				
				if(count<=1){
					rs2 = ps2.executeQuery();
					Party_name = rs2.getString("PartyName");
				}

			    System.out.println("In GetCo" + Collections.max(ob));
				conn.close();
				
				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	    	return Party_name;
	    }

}
