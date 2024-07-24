package com.alpha.userDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alpha.userDto.User;

import ConnectionPool.ConnectionPool;

public class UserDao {

	Connection connection = ConnectionPool.getConnectionObject();

	public User saveUser(User user) {
		String query = "INSERT INTO userinfo (userid, username, useremail, passward, phoneno) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getUserEmail());
			preparedStatement.setString(4, user.getPassward());
			preparedStatement.setString(5, user.getPhoneNo());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User updateUser(User user) {
		String query = "UPDATE userinfo SET username = ?, useremail = ?, passward = ?, phoneno = ? WHERE userid = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserEmail());
			preparedStatement.setString(3, user.getPassward());
			preparedStatement.setString(4, user.getPhoneNo());
			preparedStatement.setInt(5, user.getUserId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean deleteUser(int userId) {
		String query = "DELETE FROM userinfo WHERE userid = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User getUserById(int userId) {
		String query = "SELECT * FROM userinfo WHERE userid = ?";
		User user = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("userid"));
				user.setUserName(resultSet.getString("username"));
				user.setUserEmail(resultSet.getString("useremail"));
				user.setPassward(resultSet.getString("passward"));
				user.setPhoneNo(resultSet.getString("phoneno"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> getAllUsers() {
		String query = "SELECT * FROM userinfo";
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt("userid"));
				user.setUserName(resultSet.getString("username"));
				user.setUserEmail(resultSet.getString("useremail"));
				user.setPassward(resultSet.getString("passward"));
				user.setPhoneNo(resultSet.getString("phoneno"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
}
