package views.menucontent.usermanagement.popups.users;

import java.util.List;

import models.UserModel;

public class UsersPopupBuilder {
	
	public UsersPopupBuilder() {
		
	}
	
	public UsersPopupController build() {		
		UsersPopupController popup = new UsersPopupController();

		List<UserModel> userModelList = UserModel.getModels();
		for (UserModel userModel : userModelList) {
			UserEntryController entry = new UserEntryController();
			entry.setUserID(Integer.parseInt(userModel.getUserID()));
			entry.setUserEmail(userModel.getUserEmail());
			entry.setNameSurname(userModel.getUserName());
			entry.setUserType(userModel.getUserType());
			
			popup.addItem(entry);
		}
		
		return popup;
	}

}
