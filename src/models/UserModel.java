package models;

import dataaccess.UserDAO;

public class UserModel {
	
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
