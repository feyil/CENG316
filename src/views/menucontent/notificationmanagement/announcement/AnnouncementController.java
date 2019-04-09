package views.menucontent.notificationmanagement.announcement;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class AnnouncementController extends VBox {
	
	@FXML private VBox finalEventTable;
	
	public AnnouncementController() {
		loadFXML();
	}
	
	public AnnouncementController setEventTable(EventTableController eventTable) {
		finalEventTable.getChildren().add(eventTable);
		return this;
	}
	
	public void syncEvents(ActionEvent clicked) {
		System.out.println("Sync Events");
	}
	
	public void sendNotification(ActionEvent clicked) {
		System.out.println("Send Notification");
	}
	
	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Announcement.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}

}
