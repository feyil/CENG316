package views.menucontent.usermanagement.popups.users;

import models.UserModel;

public class UsersPopupBuilder {
	
	public UsersPopupBuilder() {
		
	}
	
	public UsersPopupController build() {
		
		UsersPopupController popup = new UsersPopupController();
		System.out.println("Create UserPopupsController object");
		
		System.out.println("get all the UserModel from database how is below:");
		System.out.println("calls UserModel static method getModels for getting models");
		UserModel.getModels();
		
		System.out.println("Create userEntry for each model");
		System.out.println("set userID for each userEntry");
		UserEntryController entry = new UserEntryController();
		entry.setUserID(5);
	
		System.out.println("Add each created userEntry to UserPopupController table");
		popup.addItem(entry);
		
		System.out.println("Return UserPopupController as final");
		
		return popup;
	}

}
