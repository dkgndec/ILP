package controller_last;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.*;

import beans.LoginBean;
import beans.PatientBean;
import beans.UserBean;

public class UserDaoConnection {


	public int insertUser(PatientBean mybean)
	{
		int count = 0,count1=0;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		try
		{
			DatabaseConnection = UserDAO.getDatabaseConnection();
			String query1="select max(opd_no) from hms_patient";
			stmt = DatabaseConnection.createStatement();
	        ResultSet rs = stmt.executeQuery(query1);
	        while (rs.next()) {
	        	count=rs.getInt(1);
	        	if(count==0){
	        		count=1;
	        	}
	        	else{
	        		count++;
	        	}
	        }
	        System.out.println(count);
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mmm/yyyy"); 
	        Date dob=null;
	        try{
	        	 dob = dateFormat.parse(mybean.getDateofBirth());
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
		    java.sql.Date sqlDOB = new java.sql.Date(dob.getTime());
		    System.out.println(sqlDOB);
			String query = "INSERT INTO A76C.HMS_PATIENT (OPD_NO, FIRST_NAME, MIDDLE_NAME," +
					" LAST_NAME, FATHER_SPOUSE_NAME, DOB, BLOOD_GROUP, GENDER, CONTACT_NO," +
					" CONTACT_ADDRESS, EMAIL_ID, DOCTOR_OBSERVATION, MEDICINE_PROVIDED," +
					" EARLIER_VISIT, WARD_ISSUED, PATIENT_TYPE)VALUES" +
					" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			System.out.println("t");
			ps = DatabaseConnection.prepareStatement(query);
			ps.setInt(1,count);
			ps.setString(2,mybean.getFirstName());
			ps.setString(3,mybean.getMiddleName());
			ps.setString(4, mybean.getLastName());
			ps.setString(5,mybean.getFatherName());
			ps.setDate(6,sqlDOB);
			ps.setString(7,mybean.getBloodGroup());
			ps.setString(8,mybean.getGender());
			ps.setDouble(9,mybean.getContactNumber());
			ps.setString(10,mybean.getContactAddress());
			ps.setString(11,mybean.getEmailId());
			ps.setString(12,mybean.getDoctorObservation());
			ps.setString(13,mybean.getMedicineProvided());
			ps.setString(14,mybean.getEarlierVisited());
			ps.setString(15,mybean.getWardissued());
			ps.setString(16,mybean.getPatientType());
			count1 = ps.executeUpdate();
			System.out.println("No of rows updated:" + count1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps != null)
				{
					ps.close();
				}
				UserDAO.closeConnection();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//database insertion completed
		return count;
	}
	public int updateUser(PatientBean mybean)
	{
		int count=0;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		try
		{
			DatabaseConnection = UserDAO.getDatabaseConnection();
			ps = DatabaseConnection.
			prepareStatement("Update HMS_PATIENT set EMAIL_ID=?, contact_no=?, contact_address=? where opd_no=?");
			ps.setString(1, mybean.getEmailId());
			ps.setDouble(2,mybean.getContactNumber());
			ps.setString(3, mybean.getContactAddress());
			ps.setDouble(4,mybean.getOpdNumber());
			count = ps.executeUpdate();
			System.out.println("No of rows updated:" + count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps != null)
				{
					ps.close();
				}
				UserDAO.closeConnection();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public int deleteUser(PatientBean mybean)
	{
		int count=0;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		try
		{
			DatabaseConnection = UserDAO.getDatabaseConnection();
			ps = DatabaseConnection.
			prepareStatement("DELETE FROM HMS_PATIENT where opd_no=?");
			ps.setDouble(1,mybean.getOpdNumber());
			count = ps.executeUpdate();
			System.out.println("No of rows updated:" + count);
		}catch (Exception e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps != null)
				{
					ps.close();
				}
				UserDAO.closeConnection();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public boolean checkUser(LoginBean lBean)
	{
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try
		{
			DatabaseConnection = UserDAO.getDatabaseConnection();
			if(lBean.getType().equals("01"))
			{
				ps = DatabaseConnection.
				prepareStatement("select * from HMS_ADMIN_LOGIN");
				rs = ps.executeQuery();
				while(rs.next())
				{
					if((lBean.getUserName().equals(rs.getString(1))) && (lBean.getPassword().equals(rs.getString(2)))) 
							{
								return true;
							}
				}
				
			}
			if(lBean.getType().equals("02"))
			{
				ps = DatabaseConnection.
				prepareStatement("select * from HMS_DOCTOR_LOGIN");
				rs = ps.executeQuery();
				while(rs.next())
				{
					if((lBean.getUserName().equals(rs.getString(1))) && (lBean.getPassword().equals(rs.getString(2)))) 
							{
								return true;
							}
				}
			}
			if(lBean.getType().equals("03"))
			{
				ps = DatabaseConnection.
				prepareStatement("select * from HMS_FOM_LOGIN");
				rs = ps.executeQuery();
				while(rs.next())
				{
					if((lBean.getUserName().equals(rs.getString(1))) && (lBean.getPassword().equals(rs.getString(2)))) 
							{
								
								return true;
							}
				}
			}
			if(lBean.getType().equals("04"))
			{
				ps = DatabaseConnection.
				prepareStatement("select * from HMS_WARD_MANAGER_LOGIN");
				rs = ps.executeQuery();
				while(rs.next())
				{
					if((lBean.getUserName().equals(rs.getString(1))) && (lBean.getPassword().equals(rs.getString(2)))) 
							{
								return true;
							}
				}
			}
			
		}catch (Exception e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps != null)
				{
					ps.close();
				}
				UserDAO.closeConnection();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public int updateUserAppointment(PatientBean mybean)
	{
		int count=0;
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		try
		{
			DatabaseConnection = UserDAO.getDatabaseConnection();
			ps = DatabaseConnection.
			prepareStatement("Update HMS_PATIENT set doctor_observation=?,medicine_provided=?,ward_issued=?,blood_group=?," +
					"patient_type=? where opd_no=?");
			ps.setString(1, mybean.getDoctorObservation());
			ps.setString(2,mybean.getMedicineProvided());
			ps.setString(3, mybean.getWardissued());
			ps.setString(4, mybean.getBloodGroup());
			ps.setString(5, mybean.getPatientType());
			ps.setDouble(6,mybean.getOpdNumber());
			count = ps.executeUpdate();
			System.out.println("No of rows updated:" + count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps != null)
				{
					ps.close();
				}
				UserDAO.closeConnection();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public ArrayList searchAppointment(java.sql.Date sqlDOB,String userName)
	{
		ArrayList ar=new ArrayList();
		Connection DatabaseConnection = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		double opd=0;
		try
		{
			DatabaseConnection = UserDAO.getDatabaseConnection();
			ps = DatabaseConnection.
			prepareStatement("SELECT * FROM HMS_DOCTOR_APPOINTMENT WHERE VISITING_DATE=? AND DOCTOR_ID=?");
			ps.setDate(1, sqlDOB);
			ps.setString(2, userName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				opd=rs.getDouble(1);
				ar.add(rs.getDouble(1));
				ar.add(rs.getString(2));
				ar.add(rs.getDate(5));
				ar.add(rs.getTime(6));
				ar.add(rs.getTime(7));
				ps1 = DatabaseConnection.
				prepareStatement("SELECT * FROM HMS_Patient WHERE opd_no=?");
				ps1.setDouble(1, opd);
				ResultSet rs1=ps.executeQuery();
				while(rs1.next())
				{
					String pName=rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4);
					ar.add(pName);
					ar.add(rs1.getDate(6));
					ar.add(rs1.getString(7));
					ar.add(rs1.getString(8));
					ar.add(rs1.getString(16));
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps != null)
				{
					ps.close();
				}
				UserDAO.closeConnection();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(ar.isEmpty());
		return ar;
	}

	public int addAdmitDetails(UserBean bean)
	{
		int count = 0;
		Connection DatabaseConnection = null;
		PreparedStatement ps4 = null;
		
		DatabaseConnection = UserDAO.getDatabaseConnection();
		try
		{
		String query = "INSERT INTO HMS_WARD_ADMIT (SR_NO, OPD_NO, DEPT_NO, ADMIT_DATE, ADMIT_TIME, ROOM_NO, BED_NO, DESCRIPTION, DISCHARGE_DATE, DISCHARGE_TIME, STATUS) VALUES " +
					"(hms_ward.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";

		ps4 = DatabaseConnection.prepareStatement(query);
		ps4.setString(1, bean.opd_no);
		ps4.setString(2,bean.dept_no);
		ps4.setDate(3, bean.admit_date);
		ps4.setString(4, bean.admit_time);
		ps4.setString(5,bean.room_no);
		ps4.setString(6, bean.bed_no);
		ps4.setString(7, bean.desc);
		ps4.setString(8, "12-dec-2012");
		ps4.setString(9, "123");
		ps4.setString(10, "admitted");		
		
		
		

		count = ps4.executeUpdate();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			if(ps4 != null)
			{
				ps4.close();
			}
			UserDAO.closeConnection();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//database insertion completed

		
		
		return count;
	}

	public int addDischargeDetails(UserBean bean) 
	{
		int count = 0;
		Connection DatabaseConnection = null;
		PreparedStatement ps5 = null;
		
		DatabaseConnection = UserDAO.getDatabaseConnection();
		try
		{
		String query6 = "update hms_ward_admit set discharge_date = ?,discharge_time=?,status=? where opd_no= ?";

		ps5 = DatabaseConnection.prepareStatement(query6);
		
		ps5.setString(4,bean.opd_no);
		ps5.setDate(1,bean.discharge_date);
		ps5.setString(2,bean.discharge_time);
		ps5.setString(3,"discharged");
		
		count = ps5.executeUpdate();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			if(ps5 != null)
			{
				ps5.close();
			}
			UserDAO.closeConnection();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//database insertion completed

		
		
		return count;
	}

	public int updateAdmitDetails(UserBean bean)
	{
		int count = 0;
		Connection DatabaseConnection = null;
		PreparedStatement ps6 = null;
		
		DatabaseConnection = UserDAO.getDatabaseConnection();
		try
		{
		String query6 = "update hms_ward_admit set room_no = ?,bed_no=? ,description= ? where opd_no= ?";

		ps6 = DatabaseConnection.prepareStatement(query6);
		ps6.setString(1, bean.room_no);
		ps6.setString(2,bean.bed_no);
		ps6.setString(3, bean.desc);
		ps6.setString(4, bean.opd_no);

		count = ps6.executeUpdate();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			if(ps6 != null)
			{
				ps6.close();
			}
			UserDAO.closeConnection();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//database insertion completed

		
		
		return count;
	}

	public  int selectDoctorDetails(UserBean bean)
	{
		ResultSet rs1 = null;
		Connection DatabaseConnection = null;
		PreparedStatement ps5=null;
		DatabaseConnection = UserDAO.getDatabaseConnection();
		int fees=0;
		
		try
		{
		
		ps5 = DatabaseConnection.prepareStatement("SELECT CONSULTATION_FEE FROM HMS_DOCTOR where doctor_id = ?");

		ps5.setInt(1, Integer.parseInt(bean.doctor_id));
		
		rs1 = ps5.executeQuery();
		while(rs1.next())
		{
			fees = rs1.getInt(1);
			
		
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			if(ps5 != null)
			{
				ps5.close();
			}
			UserDAO.closeConnection();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	return fees;
	}

	public  double selectRoomDetails(UserBean bean)
	
	{
		ResultSet rs1 = null;
		Connection DatabaseConnection = null;
		PreparedStatement ps5=null;
		DatabaseConnection = UserDAO.getDatabaseConnection();
		double room_fee=0;
		
		try
		{
		
		ps5 = DatabaseConnection.prepareStatement("SELECT room_cost FROM hms_room where urn=?");
		rs1 = ps5.executeQuery();
		while(rs1.next())
		{
			
			room_fee = Double.parseDouble(rs1.getString(1));			
	
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			if(ps5 != null)
			{
				ps5.close();
			}
			UserDAO.closeConnection();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	return room_fee;
	}
	
	public  ArrayList<UserBean> selectPatientDetails(UserBean bean)
	{
		ResultSet rs1 = null;
		Connection DatabaseConnection = null;
		PreparedStatement ps5=null;
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		DatabaseConnection = UserDAO.getDatabaseConnection();
		
		try
		{
		
		ps5 = DatabaseConnection.prepareStatement("SELECT * FROM hms_ward_admit where opd_no=?");
		ps5.setString(1, bean.opd_no);
		rs1 = ps5.executeQuery();
		while(rs1.next())
		{
			UserBean user = new UserBean();
			user.sr_no=rs1.getInt(1);
			user.opd_no = rs1.getString(2);
			user.dept_no=rs1.getString(3);
			user.admit_date = rs1.getDate(4);
			user.admit_time=rs1.getString(5);
			user.room_no=rs1.getString(6);
			user.bed_no=rs1.getString(7);
			user.desc=rs1.getString(8);
			user.discharge_date=rs1.getDate(9);
			user.discharge_time=rs1.getString(10);
			user.status=rs1.getString(11);
			users.add(user);
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			if(ps5 != null)
			{
				ps5.close();
			}
			UserDAO.closeConnection();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	return users;
	}

}
