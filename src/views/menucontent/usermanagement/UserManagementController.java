package views.menucontent.usermanagement;


import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import views.menucontent.AbstractMenuContent;


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
		System.out.println("Show Users");
		System.out.println(userType.getValue());
	}
	
	@FXML
	public void createUser(ActionEvent clickedEvent) {
		System.out.println("Create User");
	}
	
	private void setUserTypeOption() {
		List<String> userTypes = new ArrayList<String>();
		
		userTypes.add("Admin");
		userTypes.add("Content Manager");
		
		this.userType.getItems().addAll(userTypes);
	}
		
}
