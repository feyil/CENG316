package views.menucontent.notificationmanagement.manageemails.popups.searchdeleteemail;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import views.menucontent.usermanagement.popups.users.UsersPopupController;
import views.popup.AbstractPopup;

public class SearchDeleteEmailPopupController extends AbstractPopup {
	
	@FXML private VBox emailTable;
	
	private List<String> groupList;
	
	public SearchDeleteEmailPopupController() {
		super("SearchDeleteEmail.fxml");
	}
	
	public SearchDeleteEmailPopupController addItem(Node item) {
		emailTable.getChildren().add(item);
		return this;
	}
	
	public SearchDeleteEmailPopupController setSelectedGroups(List<String> groups) {
		groupList = groups;
		return this;
	}
	
}
