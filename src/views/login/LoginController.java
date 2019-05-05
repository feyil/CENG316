package views.login;

import application.CENGDesktopWMApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.UserModel;
import views.menucontent.AbstractMenuContent;

public class LoginController extends AbstractMenuContent {

	@FXML private TextField userEmail;
	@FXML private TextField userPassword;
	@FXML private Label failureDisplay;
	
	public LoginController() {
		super("Login.fxml");
	}
	
	public void login(ActionEvent login) {
		System.out.println("Login Clicked");
		System.out.println("Password Hashed");
		String hashedPassword = hash("raw passsword passed");
		
		System.out.println("User Model static login method called with creditentals");
		UserModel loginedAs = UserModel.login(userEmail.getText(), hashedPassword);
		
		if(loginedAs != null) {
			System.out.println("CENGDesktopWMApp instance accesed");
			System.out.println("loginedAs method called for CENGDestktopWMApp");
			CENGDesktopWMApp.getInstance()
								.loginedAs(loginedAs);
			System.out.println("Login successgful");
		} else {
			// Declare failure to UI
			System.out.println("Login failure");
			failureDisplay.setText("-> Login unsuccessful try again.");
		}
	}
	
	private String hash(String password) {
		System.out.println("hashed password returned");
		
		//TODO just for fun
		return userPassword.getText();
	}
}
