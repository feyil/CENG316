package views.menucontent.usermanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class UserManagementController extends AnchorPane {
	
	@FXML private ComboBox<String> userType;
	@FXML private TextField email;
	@FXML private TextField nameSurname;
	@FXML private TextField title;
	
	@FXML private PasswordField password;
	@FXML private PasswordField passwordAgain;
	
	@FXML private Button showUsers;
	@FXML private Button createUser;
 	
	
	public UserManagementController() {
		loadFXML();
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
	
	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserManagement.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}

}
