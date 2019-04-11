package views.menucontent.usermanagement.popups.users;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import views.popup.AbstractPopup;

public class UsersPopupController extends AbstractPopup {
	
	@FXML private VBox usersTable;
	
	public UsersPopupController() {
		super("Users.fxml");
	}
	
	public UsersPopupController addItem(Node item) {
		usersTable.getChildren().add(item);
		return this;
	}

}
