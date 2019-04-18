package dataaccess;

import java.util.List;

import models.UserModel;

public class UserDAO {
	
	// Singleton
	private static UserDAO instance;
	
	public static UserDAO getInstance() {
		if(instance == null) {
			return new UserDAO();
		}
		return instance;
	}
	
	private UserDAO() {
	
	}
	
	public Boolean push(UserModel userModel) {
		System.out.println("User model related field accessed");
		System.out.println("DB connection accessed");
		System.out.println("Related SQL commands runned");
		System.out.println("Success status returned as boolean");
		
		return false;
	}
	
	public List<UserModel> getModels() {
		System.out.println("Make the needed SQL calls get all models");
		System.out.println("Wrap all models into a list and return it");
		
		return null;
	}
	
	public Boolean deleteUser(int userID) {
		System.out.println("Make the needed SQL call delete the user from db");
		System.out.println("Return result of the operation");
		return false;
	}

}
