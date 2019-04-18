package views.menucontent.usermanagement.popups.users;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class UserEntryController extends HBox {
	
	@FXML private Label nameSurname;
	@FXML private Label email;
	@FXML private Label userType;
	
	private int userID;
	
	public UserEntryController() {
		loadFXML("UserEntry.fxml");
	}

	public int getUserID() {
		return userID;
	}

	public UserEntryController setUserID(int userID) {
		this.userID = userID;
		
		return this;
	}
	
	public UserEntryController setNameSurname(String userNameSurname) {
		nameSurname.setText(userNameSurname);
		return this;
	}
	
	public UserEntryController setUserEmail(String userEmail) {
		email.setText(userEmail);
		return this;
	}
	
	public UserEntryController setUserType(String uType) {
		userType.setText(uType);
		return this;
	}
 	
	private UserEntryController loadFXML(String fxmlFileName) {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
		return this;
	}
}
