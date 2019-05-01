package views.statusbar;

import java.io.IOException;

import application.CENGDesktopWMApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class StatusBarController extends HBox {
	
	public StatusBarController() {
		loadFXML("StatusBar.fxml");
	}

	public void logout(ActionEvent event) {
		System.out.println("Logout Clicked");
		
		System.out.println("CENGDektopWMApp instance accessed and logout method called");
		CENGDesktopWMApp.getInstance()
							.logout();
		System.out.println("Logout Successfull");
	}
	
	public void publish(ActionEvent event) {
		System.out.println("Publish Clicked");
	}
	
	private void loadFXML(String fxmlFileName) {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}
}
