package ca.sheridancollege.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import ca.sheridancollege.beans.User;
import ca.sheridancollege.beans.dogs;
public class DAO {
	
	public static void adddogs(dogs d) {
		
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/dogs", "root", "dhruvil");
	         
	            String Query = "insert into dog_list (name,ownerName,breed,d_groups,gender,ranking,email) values(?,?,?,?,?,?,?)";
	            
	            PreparedStatement ps = conn.prepareStatement(Query);
	            ps.setString(1,d.getName());
	            ps.setString(2,d.getOwnerName());
	            ps.setString(3,d.getBreed());
	            ps.setString(4,d.getGroups());
	            ps.setString(5,d.getGender());
	            ps.setString(6,d.getRanking());
	            ps.setString(7, d.getEmail());
	            
	            
	            ps.executeUpdate();
	            
	
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
		
	}
	
	public static ArrayList<dogs> getdog() {
		ArrayList<dogs> doggylist = new ArrayList<dogs>();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/dogs", "root", "dhruvil");
	            
	            String Query = "Select * From dog_list";
	           
	            Statement st = conn.createStatement();
	          //  st.executeQuery() --> Get a table
	        //  st.executeUpdate()  --> Modify a table
	            
	           
	            ResultSet rs = st.executeQuery(Query);
	            ResultSetMetaData rsmd  = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();
	            
	            while(rs.next()) {
	            	int id = rs.getInt(1);
	            	String name = rs.getString(2);  
	            	String ownerName = rs.getString(3); 
	            	String breed = rs.getString(4);  
	               	String group = rs.getString(5);
	               	String gender = rs.getString(6);
	               	String ranking = rs.getString(7);
	               	String email = rs.getString(8);
	            	
	            	dogs d = new dogs(id,name,ownerName,breed,group,gender,ranking,email);
	            	doggylist.add(d);
		            }
	            
	            
	            
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
		
		 return doggylist;
	}
	
	
	public static ArrayList<dogs> searchdogbyname(String sname) {
		ArrayList<dogs> doggylist = new ArrayList<dogs>();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/dogs", "root", "dhruvil");
	            
	            System.out.println(sname);
	            
	            String Query = "Select * From dog_list where name='"+sname+"'";
	           
	            Statement st = conn.createStatement();
	         
	            ResultSet rs = st.executeQuery(Query);
	            ResultSetMetaData rsmd  = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();
	            
	            while(rs.next()) {
	            	int id=rs.getInt(1);
	            	String name = rs.getString(2);  
	            	String ownerName = rs.getString(3); 
	            	String breed = rs.getString(4);  
	               	String group = rs.getString(5);
	               	String gender = rs.getString(6);
	               	String ranking = rs.getString(7);
	               	String email = rs.getString(8);
	            	
	            	dogs d = new dogs(id,name,ownerName,breed,group,gender,ranking,email);
	            	doggylist.add(d);
		            }
	            
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
		
		 return doggylist;
	}	
	
	public static ArrayList<dogs> searchdogbyno(String sno) {
		ArrayList<dogs> doggylist = new ArrayList<dogs>();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/dogs", "root", "dhruvil");
	           
	            
	            String Query = "Select * From dog_list where id='"+sno+"'";
	           
	            Statement st = conn.createStatement();
	         
	            ResultSet rs = st.executeQuery(Query);
	            ResultSetMetaData rsmd  = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();
	            
	            while(rs.next()) {
	            	int id=rs.getInt(1);
	            	String name = rs.getString(2);  
	            	String ownerName = rs.getString(3); 
	            	String breed = rs.getString(4);  
	               	String group = rs.getString(5);
	               	String gender = rs.getString(6);
	               	String ranking = rs.getString(7);
	               	String email = rs.getString(8);
	            	
	            	dogs d = new dogs(id,name,ownerName,breed,group,gender,ranking,email);
	            	doggylist.add(d);
		            }
	            
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
		
		 return doggylist;
	}
	
	public static ArrayList<dogs> searchdogbyowner(String s_owner) {
		ArrayList<dogs> doggylist = new ArrayList<dogs>();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/dogs", "root", "dhruvil");
	           
	            
	            String Query = "Select * From dog_list where ownerName='"+s_owner+"'";
	           
	            Statement st = conn.createStatement();
	         
	            ResultSet rs = st.executeQuery(Query);
	            ResultSetMetaData rsmd  = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();
	            
	            while(rs.next()) {
	            	int id=rs.getInt(1);
	            	String name = rs.getString(2);  
	            	String ownerName = rs.getString(3); 
	            	String breed = rs.getString(4);  
	               	String group = rs.getString(5);
	               	String gender = rs.getString(6);
	               	String ranking = rs.getString(7);
	               	String email = rs.getString(8);
	            	
	            	dogs d = new dogs(id,name,ownerName,breed,group,gender,ranking,email);
	            	doggylist.add(d);
		            }
	            
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
		
		 return doggylist;
	}
	
	public static ArrayList<dogs> searchdogbybreed(String s_breed) {
		ArrayList<dogs> doggylist = new ArrayList<dogs>();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/dogs", "root", "dhruvil");
	           
	            
	            String Query = "Select * From dog_list where breed='"+s_breed+"'";
	           
	            Statement st = conn.createStatement();
	         
	            ResultSet rs = st.executeQuery(Query);
	            ResultSetMetaData rsmd  = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();
	            
	            while(rs.next()) {
	            	int id=rs.getInt(1);
	            	String name = rs.getString(2);  
	            	String ownerName = rs.getString(3); 
	            	String breed = rs.getString(4);  
	               	String group = rs.getString(5);
	               	String gender = rs.getString(6);
	               	String ranking = rs.getString(7);
	               	String email = rs.getString(8);
	            	
	            	dogs d = new dogs(id,name,ownerName,breed,group,gender,ranking,email);
	            	doggylist.add(d);
		            }
	            
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
		
		 return doggylist;
	}
	
	public static ArrayList<dogs> searchdogbygroup(String s_group) {
		ArrayList<dogs> doggylist = new ArrayList<dogs>();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/dogs", "root", "dhruvil");
	           
	            
	            String Query = "Select * From dog_list where d_groups='"+s_group+"'";
	           
	            Statement st = conn.createStatement();
	         
	            ResultSet rs = st.executeQuery(Query);
	            ResultSetMetaData rsmd  = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();
	            
	            while(rs.next()) {
	            	int id=rs.getInt(1);
	            	String name = rs.getString(2);  
	            	String ownerName = rs.getString(3); 
	            	String breed = rs.getString(4);  
	               	String group = rs.getString(5);
	               	String gender = rs.getString(6);
	               	String ranking = rs.getString(7);
	               	String email = rs.getString(8);
	            	
	            	dogs d = new dogs(id,name,ownerName,breed,group,gender,ranking,email);
	            	doggylist.add(d);
		            }
	            
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
		
		 return doggylist;
	}	
	
	
		public static User findUserAccount(String userName) {
			User user = null;
			

			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/dogs", "root", "dhruvil");
				System.out.println("Connection Success");
				String Query = "select * from sec_user where user_name='"+userName+"'";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(Query);
				while(rs.next()) {
					user = new User(rs.getLong(1),rs.getString(2),rs.getString(3));
				}
				
				conn.close();
				
				
			} catch (Exception e) {
				System.out.println("Connection Failed");
				System.out.println(e);
			}
			return user;

		} 
		
		public static ArrayList<String> getRoleName(Long userID){
			ArrayList<String> roles = new ArrayList();
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/drinks", "root", "dhruvil");
				System.out.println("Connection Success");
				String Query = "select user_role.role_id,user_role.user_id,"
						+ "user_role.role_id,sec_role.role_id, "
						+ "sec_role.role_name from user_role,sec_role "
						+ "WHERE sec_role.role_id=user_role.role_id"
						+ "and user_id="+ userID;
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(Query);
				while(rs.next()) {
					roles.add(rs.getString(5));
				}
				st.executeUpdate(Query); 
				conn.close();
				
				
			} catch (Exception e) {
				System.out.println("Connection Failed");
				System.out.println(e);
			}
		
			return roles;
			
		}
		
		
			public static void addUser(String userName,String encrpytedPassword) {
				User user = null;
				

				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = null;
					conn = DriverManager.getConnection("jdbc:mysql://localhost/dogs", "root", "dhruvil");
					System.out.println("Connection Success");
					String Query = "insert into SEC_User (USER_NAME, ENCRYTED_PASSWORD, ENABLED)" + 
							"values (?,?,1)";
					PreparedStatement ps = conn.prepareStatement(Query);
					ps.setString(1, userName);
					ps.setString(2, encrpytedPassword);
					
					ps.executeUpdate(); 
					conn.close();
					
					
				} catch (Exception e) {
					System.out.println("Connection Failed");
					System.out.println(e);
				}
				return;

			} 
			
			public static void addUserRoles(long userId,long roleID) {
				User user = null;
				

				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = null;
					conn = DriverManager.getConnection("jdbc:mysql://localhost/dogs", "root", "dhruvil");
					System.out.println("Connection Success");
					String Query = "insert into user_role (USER_ID,ROLE_ID) " + 
							"values (1,1)";
					PreparedStatement ps = conn.prepareStatement(Query);
					ps.setLong(1, userId);
					ps.setLong(2, roleID);
					
					ps.executeUpdate(Query); 
					conn.close();
					
					
				} catch (Exception e) {
					System.out.println("Connection Failed");
					System.out.println(e);
				}
				return;

			} 
			
			public static void addHandler(dogs d) {
				
				 try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection conn = null;
			            conn = DriverManager.getConnection
			            		("jdbc:mysql://localhost/dogs", "root", "dhruvil");
			         
			            String Query = "insert into handler_list values(?,?,?,?,?,?,?)";
			            
			            PreparedStatement ps = conn.prepareStatement(Query);
			            
			            ps.setString(1,d.getName());
			            ps.setString(2,d.getOwnerName());
			            ps.setString(3,d.getBreed());
			            ps.setString(4,d.getGroups());
			            ps.setString(5,d.getGender());
			            ps.setString(6,d.getRanking());
			            ps.setString(7, d.getEmail());
			            
			           
			            
			            
			            ps.executeUpdate();
			            
			
			            conn.close();
			        } catch (Exception e) {
			            System.out.println("Connection Failed");
			            System.out.println(e);
			        }
				
			}
			
			public static ArrayList<dogs> getHandler() {
				ArrayList<dogs> doggylist = new ArrayList<dogs>();
				 try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection conn = null;
			            conn = DriverManager.getConnection
			            		("jdbc:mysql://localhost/dogs", "root", "dhruvil");
			            
			            String Query = "Select * From handler_list";
			           
			            Statement st = conn.createStatement();
			         
			            
			           
			            ResultSet rs = st.executeQuery(Query);
			            ResultSetMetaData rsmd  = rs.getMetaData();
			            int columnCount = rsmd.getColumnCount();
			            
			            while(rs.next()) {
			            	int id=rs.getInt(1);
			            	String name = rs.getString(2);  
			            	String ownerName = rs.getString(3); 
			            	String breed = rs.getString(4);  
			               	String group = rs.getString(5);
			               	String gender = rs.getString(6);
			               	String ranking = rs.getString(7);
			               	String email = rs.getString(8);
			            	
			            	dogs d = new dogs(id,name,ownerName,breed,group,gender,ranking,email);
			            	doggylist.add(d);
				            }
			            
			            
			            
			            conn.close();
			        } catch (Exception e) {
			            System.out.println("Connection Failed");
			            System.out.println(e);
			        }
				
				 return doggylist;
			}	
			
			public static dogs viewDogsByID(int id) {

				ArrayList<dogs> doggylist = new ArrayList<dogs>();
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = null;
					conn = DriverManager.getConnection("jdbc:mysql://localhost/dogs", "root", "dhruvil");
					System.out.println("Connection Success");
					String Query = "Select * from dog_list where id=" + id;
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(Query);
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();

					while (rs.next()) {
						int id1 = rs.getInt(1);
		            	String name = rs.getString(2);  
		            	String ownerName = rs.getString(3); 
		            	String breed = rs.getString(4);  
		               	String group = rs.getString(5);
		               	String gender = rs.getString(6);
		               	String ranking = rs.getString(7);
		               	String email = rs.getString(8);
		            	
		            	dogs d = new dogs(id1,name,ownerName,breed,group,gender,ranking,email);
		            	doggylist.add(d);
					}
					conn.close();

				} catch (Exception e) {
					System.out.println("Connection Failed");
					System.out.println(e);
				}

				if (doggylist.size() > 0)

					return doggylist.get(0);

				return null;

			}
			
			public static void DeleteDogs(int id) {

				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = null;
					conn = DriverManager.getConnection("jdbc:mysql://localhost/dogs", "root", "dhruvil");
					System.out.println("Connection Success");
					String Query = "DELETE FROM dog_list WHERE id=" + id;
					Statement st = conn.createStatement();
					st.executeUpdate(Query);
					conn.close();

				} catch (Exception e) {
					System.out.println("Connection Failed");
					System.out.println(e);

					return;
				}
			}
			
			public static void Update(dogs d) {
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = null;
					conn = DriverManager.getConnection("jdbc:mysql://localhost/dogs", "root", "dhruvil");
					System.out.println("Connection Success");

					String preparedStatement = "Update dog_list set name=?,ownerName=?,breed=?,d_groups=?,gender=?,ranking=?,email=? where id=?";


					PreparedStatement ps = conn.prepareStatement(preparedStatement);
					ps.setString(1,d.getName());
		            ps.setString(2,d.getOwnerName());
		            ps.setString(3,d.getBreed());
		            ps.setString(4,d.getGroups());
		            ps.setString(5,d.getGender());
		            ps.setString(6,d.getRanking());
		            ps.setString(7, d.getEmail());
		            ps.setInt(8, d.getId());

					ps.executeUpdate();
					conn.close();

				} catch (Exception e) {
					System.out.println("Connection Failed");
					System.out.println(e);

				}
			}
	
}
