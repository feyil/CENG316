package views.menucontent.notificationmanagement.manageemails;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class ManageEmailsController extends VBox {
	
	@FXML VBox importEmailList;
	@FXML VBox editEmailLists;
	
	
	public ManageEmailsController() {
		loadFXML();
	}
	
	public ManageEmailsController addSection(Node section) {
		getChildren().add(section);
		return this;
	}

	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageEmails.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}
}
