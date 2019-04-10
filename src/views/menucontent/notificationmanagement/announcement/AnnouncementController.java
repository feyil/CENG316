package views.menucontent.notificationmanagement.announcement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import views.menucontent.AbstractMenuContent;

public class AnnouncementController extends AbstractMenuContent {
	
	@FXML private VBox finalEventTable;
	
	public AnnouncementController() {
		super("Announcement.fxml");
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
	
}
