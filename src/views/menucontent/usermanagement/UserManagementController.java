package views.menucontent.usermanagement;


import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.UserModel;
import views.menucontent.AbstractMenuContent;
import views.menucontent.usermanagement.popups.users.UsersPopupBuilder;
import views.menucontent.usermanagement.popups.users.UsersPopupController;
import views.popup.AbstractInWindowPopupController;
import views.popup.InWindowPopupManager;


public class UserManagementController extends AbstractMenuContent {
	
	@FXML private ComboBox<String> userType;
	@FXML private TextField email;
	@FXML private TextField nameSurname;
	@FXML private TextField title;
	
	@FXML private PasswordField password;
	@FXML private PasswordField passwordAgain;
	
	@FXML private Button showUsers;
	@FXML private Button createUser;
 	
	
	public UserManagementController() {
		super("UserManagement.fxml");
		setUserTypeOption();
	}
	
	@FXML
	public void showUsers(ActionEvent clickedEvent) {
		UsersPopupBuilder usersPopup = new UsersPopupBuilder();
		UsersPopupController ct = usersPopup.build();
			
		AbstractInWindowPopupController pm = InWindowPopupManager.getInstance();
		pm.setPopupTitle("Show Users");
		pm.load(ct);
		pm.show();
	}
	
	@FXML
	public void createUser(ActionEvent clickedEvent) {
		// TODO make validation
	
		UserModel userModel = new UserModel();
		
		userModel.setUserEmail(email.getText());
		userModel.setUserPassword(password.getText());
		userModel.setUserType(userType.getValue());
		userModel.setUserName(nameSurname.getText());
		userModel.setUserTitle(title.getText());
		
		// TODO handle false return with popup
		userModel.push();
		
		// TODO clear all field of the form
		
		// TODO give response with popup to the user
	}
	
	private void setUserTypeOption() {
		List<String> userTypes = new ArrayList<String>();
		
		userTypes.add("Admin");
		userTypes.add("Content Manager");
		
		this.userType.getItems().addAll(userTypes);
	}
		
}
