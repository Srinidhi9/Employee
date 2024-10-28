package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.EmployeeData;


public class Dao {
		Connection  connection;
		PreparedStatement preparedstatement;
		ResultSet resultset;

		public Dao() {
			connection = My_SQL_connections.getInstance();
		}

		public int insertDataWithpreparedStatement(EmployeeData s) {
			int result = 0;
			String query = "insert into student_details values(?,?,?,?,?,?,?,?,?,?,?)";
			try {
				preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1, s.getEmployeeId());
				preparedstatement.setString(2, s.getFirstName());
				preparedstatement.setString(3, s.getLastName());
				preparedstatement.setString(4, s.getDOB());
				preparedstatement.setString(5, s.getEmail());
				preparedstatement.setString(6, s.getPhone());
				preparedstatement.setString(7, s.getGender());
				preparedstatement.setString(8, s.getEmployeeType());
				preparedstatement.setString(9, s.getEducation());
				preparedstatement.setString(10, s.getSkills());
				preparedstatement.setString(11, s.getExperience());
				result = preparedstatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;
		}

			public int deleteDataWithpreparedStatement(EmployeeData s) {
				int result1 = 0;
				String query = "delete from EmployeeData where EmployeeId=?";
				try {
					preparedstatement = connection.prepareStatement(query);
					preparedstatement.setString(1, s.getEmployeeId());
					result1 = preparedstatement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return result1;
			
			}		

			public int updateData(EmployeeData s,String field, String value,String EmployeeID) {
				int result1 = 0;
				String query = "update EmployeeData set "+field+"="+value+" where EmployeeID="+EmployeeID;
				try {
					preparedstatement = connection.prepareStatement(query);
					result1 = preparedstatement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return result1;



			}
		}
		


