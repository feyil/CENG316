package models;

import java.util.List;

import dataaccess.UserDAO;

public class UserModel {
	
	public static List<UserModel> getModels() {	
		return UserDAO.getInstance().getModels();
	}
	
	public static Boolean deleteUser(int userID) {
		UserDAO.getInstance().deleteUser(userID);
		return false;
	}
	
	public static UserModel login(String userEmail, String hashedPassword) {
		System.out.println("Acces UserDAO object");
		System.out.println("Call login for UserDAO");
		UserModel loginedAs = UserDAO.getInstance().login(userEmail, hashedPassword);
		
		return loginedAs;
	}
	
	private String userID;
	private String userEmail;
	private String userName;
	private String userTitle;
	private String userType;
	private String userPassword;
	
	public UserModel() {
		
	}
	
	public Boolean push() {	
		return UserDAO.getInstance().push(this);
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTitle() {
		return userTitle;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public void setUserPassword(String password) {
		//TODO hash the password
		this.userPassword = password;
	}
	
	public String getUserPassword() {
		return this.userPassword;
	}

}
