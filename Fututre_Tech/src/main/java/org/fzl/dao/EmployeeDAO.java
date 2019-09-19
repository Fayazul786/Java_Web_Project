package org.fzl.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Date;
import org.fzl.controller.Admin_login;
import org.fzl.dto.EmployeeDTO;

public class EmployeeDAO{

	// Get Connect with Database
	public static Connection getConnection() {
		Connection con = null;
		try {
			Properties props = new Properties();
			InputStream is = Admin_login.class.getClassLoader().getResourceAsStream("org/fzl/properties/db.properties");
			props.load(is);
			String driver=props.getProperty("driver");
			String url=props.getProperty("url");
			String username=props.getProperty("username");
			String password=props.getProperty("password");
			// Loads the database driver class
			Class.forName(driver);
			// Establish the Connection
            con=DriverManager.getConnection(url,username,password);
		}
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}//getConnection

	// Save the Employee data into database collected from Sign Up form
	public static int save(EmployeeDTO dto) {
		int status = 0;
		//
		System.out.println("in save(-)");
		try {
			Connection con = EmployeeDAO.getConnection();
			if(con!=null) {
            	PreparedStatement ps=con.prepareStatement("INSERT INTO EMP_SIGNUP(FIRSTNAME,LASTNAME,GENDER,MSTATUS,DOB,EMAIL,PASSWORD,PHONE,DESIGNATION) values (?,?,?,?,?,?,?,?,?)");
            
               if(ps!=null) {
                 ps.setString(1,dto.getfName());  
                 ps.setString(2,dto.getlName());  
                 ps.setString(3,dto.getGender());  
                 ps.setString(4,dto.getmStatus());
                 ps.setDate(5,dto.getDob());
                 ps.setString(6,dto.getEmail());
                 ps.setString(7,dto.getPassword());
                 ps.setLong(8,dto.getPhNum());
                 ps.setString(9,dto.getDegn());
              
               status=ps.executeUpdate();  
               
              }
			}
			con.close();
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/// Write finally() block for releasing all jdbc resources======================================================
		return status;
	}//save

	// Update the Employee data with respect to id 
	public static int update(EmployeeDTO dto) {
		int status=1;  
        try{  
            Connection con=EmployeeDAO.getConnection();  
            if(con!=null) {
            	 PreparedStatement ps=con.prepareStatement("UPDATE EMP_SIGNUP SET FIRSTNAME=?,LASTNAME=?,GENDER=?,MSTATUS=?,DOB=?,EMAIL=?,PASSWORD=?,PHONE=?,DESIGNATION=? WHERE ID=?");  
                
                if(ps!=null) {
                  ps.setString(1,dto.getfName());  
                  ps.setString(2,dto.getlName());  
                  ps.setString(3,dto.getGender());  
                  ps.setString(4,dto.getmStatus());
                  ps.setDate(5, dto.getDob());
                  ps.setString(6,dto.getEmail());
                  ps.setString(7,dto.getPassword());
                  ps.setLong(8,dto.getPhNum());
                  ps.setString(9,dto.getDegn());
                  ps.setInt(10,dto.getId());
                  
                 status=ps.executeUpdate();  
                 System.out.println("In if block of update(-)");
                 System.out.println("Status in update:"+status);
                } 
            }
            
            //
            System.out.println("In DAO update()::");
            System.out.println(dto.getfName()+","+dto.getlName()+","+dto.getGender()+","+dto.getDob());
              
            con.close();  
        }//try
        catch(Exception ex){
        	ex.printStackTrace();
        }  
          
        return status;  
	}//update

	// Delete the Employee data from database according to id
	public static int delete(EmployeeDTO dto) {
		int status=0;  
        try{  
            Connection con=EmployeeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("DELETE FROM EMP_SIGNUP WHERE ID=?");  
            ps.setInt(1,dto.getId());  
            status=ps.executeUpdate();  
              
            con.close();  
        }
        catch(Exception e){
        	e.printStackTrace();
        }  
          
        return status; 
	}//delete

	// Show Employee data according to id
	public static EmployeeDTO getEmployeeById(int id) {
		EmployeeDTO dto=new EmployeeDTO();  
        
        try{  
            Connection con=EmployeeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT ID,FIRSTNAME,LASTNAME,GENDER,MSTATUS,DOB,EMAIL,PASSWORD,PHONE,DESIGNATION FROM EMP_SIGNUP WHERE ID=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                dto.setId(rs.getInt(1));  
                dto.setfName(rs.getString(2));
                dto.setlName(rs.getString(3));
                dto.setGender(rs.getString(4));
                dto.setmStatus(rs.getString(5));
                dto.setDob(rs.getDate(6));
                dto.setEmail(rs.getString(7));
                dto.setPassword(rs.getString(8));  
                dto.setPhNum(rs.getLong(9));
                dto.setDegn(rs.getString(10));
            }  
            con.close();  
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }  
          
        return dto;  
	}//getEmpById

	// Show all Employee Data from DB
	public static List<EmployeeDTO> getAllEmployees() {
		List<EmployeeDTO> dtolist=new ArrayList<EmployeeDTO>();  
        
        try{  
            Connection con=EmployeeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("SELECT ID,FIRSTNAME,LASTNAME,GENDER,MSTATUS,DOB,EMAIL,PASSWORD,PHONE,DESIGNATION FROM EMP_SIGNUP");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                EmployeeDTO dto=new EmployeeDTO();  
                dto.setId(rs.getInt(1));  
                dto.setfName(rs.getString(2));  
                dto.setlName(rs.getString(3));
                dto.setGender(rs.getString(4));
                dto.setmStatus(rs.getString(5));
                dto.setDob(rs.getDate(6));
                dto.setEmail(rs.getString(7));
                dto.setPassword(rs.getString(8));
                dto.setPhNum(rs.getLong(9));
                dto.setDegn(rs.getString(10));
                dtolist.add(dto);  
            }  
            con.close();  
        }
        catch(Exception e){
        	e.printStackTrace();
        }  
          
        return dtolist;  
	}//getAllEmp
	
	// Show Employee data according to email id
		public static EmployeeDTO getEmployeeByEmail(String email) {
			EmployeeDTO dto=new EmployeeDTO();  
	        
	        try{  
	            Connection con=EmployeeDAO.getConnection();  
	            PreparedStatement ps=con.prepareStatement("SELECT ID,FIRSTNAME,LASTNAME,GENDER,MSTATUS,DOB,EMAIL,PASSWORD,PHONE,DESIGNATION FROM EMP_SIGNUP WHERE EMAIL=?");  
	            ps.setString(1,email);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                dto.setId(rs.getInt(1));  
	                dto.setfName(rs.getString(2));
	                dto.setlName(rs.getString(3));
	                dto.setGender(rs.getString(4));
	                dto.setmStatus(rs.getString(5));
	                dto.setDob(rs.getDate(6));
	                dto.setEmail(rs.getString(7));
	                dto.setPassword(rs.getString(8));  
	                dto.setPhNum(rs.getLong(9));
	                dto.setDegn(rs.getString(10));
	            }  
	            con.close();  
	        }
	        catch(Exception ex){
	        	ex.printStackTrace();
	        }  
	          
	        return dto;  
		}//getEmpById

}//class
