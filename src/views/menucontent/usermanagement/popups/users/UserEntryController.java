package views.menucontent.usermanagement.popups.users;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class UserEntryController extends HBox {
	
	
	
	public UserEntryController() {
		loadFXML("UserEntry.fxml");
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
