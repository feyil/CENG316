package views.menucontent.notificationmanagement.manageemails.popups.searchdeleteemail;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import views.menucontent.usermanagement.popups.users.UserEntryController;

public class EmailEntryController extends HBox {
	
	public EmailEntryController()   {
		loadFXML("EmailEntry.fxml");
	}
	
	
	
	private EmailEntryController loadFXML(String fxmlFileName) {
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
