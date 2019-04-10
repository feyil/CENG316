package views.menucontent.notificationmanagement.manageemails;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import views.menucontent.AbstractMenuContent;


public class ManageEmailsController extends AbstractMenuContent {
	
	@FXML VBox importEmailList;
	@FXML VBox editEmailLists;
	
	
	public ManageEmailsController() {
		super("ManageEmails.fxml");
	}
	
	public ManageEmailsController addSection(Node section) {
		getChildren().add(section);
		return this;
	}

}
