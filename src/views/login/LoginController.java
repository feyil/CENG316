package views.login;

import application.CENGDesktopWMApp;
import javafx.event.ActionEvent;
import models.UserModel;
import views.menucontent.AbstractMenuContent;

public class LoginController extends AbstractMenuContent {

	public LoginController() {
		super("Login.fxml");
	}
	
	public void login(ActionEvent login) {
		System.out.println("Login Clicked");
		
		UserModel model = new UserModel();
		
		CENGDesktopWMApp.getInstance()
							.loginedAs(model);
	}
}
