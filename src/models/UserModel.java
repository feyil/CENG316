package models;

import java.util.List;

import dataaccess.UserDAO;

public class UserModel {
	
	public static List<UserModel> getModels() {
		System.out.println("Access DAO Object");
		System.out.println("Call getModels method");
		UserDAO.getInstance().getModels();
		System.out.println("Return getted List<UserModel>");
		
		return null;
	}
	
	public static Boolean deleteUser(int userID) {
		System.out.println("Access UserDAO object");
		System.out.println("Call necessary method delete Method for UserDAO");
		UserDAO.getInstance().deleteUser(5);
		return false;
	}
	
	private String userID;
	private String userEmail;
	private String userName;
	private String userTitle;
	private String userType;
	
	public UserModel() {
		
	}
	
	public Boolean push() {
		System.out.println("UserDAO object accessed");

		
		System.out.println("User Model passed as parameter to push method of UserDAO");
		
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

}
