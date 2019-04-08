package views.menucontent.notificationmanagement.announcement;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class EventTableController extends VBox {
	
	@FXML private VBox eventTable;
	
	public EventTableController() {
		loadFXML();
	}
	
	public EventTableController addItem(EventEntryController eventEntry) {
		eventTable.getChildren().add(eventEntry);
		return this;
	}
	
	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EventTable.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}

}
