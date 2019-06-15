package dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.UserModel;

public class UserDAO {
	
	// Singleton
	private static UserDAO instance;
	
	public static UserDAO getInstance() {
		if(instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	private UserDAO() {
	
	}
	
	public Boolean push(UserModel userModel) {	
		String email = userModel.getUserEmail();
		String password = userModel.getUserPassword();
		String type = userModel.getUserType();
		String name = userModel.getUserName();
		String title = userModel.getUserTitle();
		
		Statement statement = DBBase.createStatement();
		String sql = String.format("INSERT INTO USER(UEMAIL, UPASSWORD, UTYPE, UNAMESURNAME, UTITLE)"
				+ "VALUES('%1$s', '%2$s', '%3$s', '%4$s', '%5$s');", email, password, type, name, title);
	
		try {
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("SQL statement can not be executed. Loc: UserDAO:push");
			return false;
		}		
	}
	
	public List<UserModel> getModels() {	
		List<UserModel> userModelList = new ArrayList<UserModel>();
		
		Statement statement = DBBase.createStatement();
		String sql = "SELECT * FROM USER";
		
		try {
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				UserModel userModel = new UserModel();
				System.out.println(result.getString("ID"));
				userModel.setUserID(result.getString("ID"));
				userModel.setUserEmail(result.getString("UEMAIL"));
				userModel.setUserType(result.getString("UTYPE"));
				userModel.setUserName(result.getString("UNAMESURNAME"));
				userModel.setUserTitle(result.getString("UTITLE"));
				
				userModelList.add(userModel);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL statement can not be executed. Loc: UserDAO:getModels");
		}
		
		return userModelList;
	}
	
	public Boolean deleteUser(int userID) {		
		Statement statement = DBBase.createStatement();
		String sql = String.format("DELETE FROM USER WHERE ID=%1$s", userID);
		
		try {
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("SQL statement can not be executed. Loc: UserDAO:deleteUser");
			return false;
		}
	}

	public UserModel login(String userEmail, String hashedPassword) {
		System.out.println("Make the needed SQL calls to find matching UserModel");
		System.out.println("Return if UserModel found or return null to indicate failure");
		
		if(userEmail.equals("app@ceng.com") && hashedPassword.equals("123456")) {
			return new UserModel();
		}
		
		return null;
	}
}
