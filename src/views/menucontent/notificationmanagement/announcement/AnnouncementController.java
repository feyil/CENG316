package views.menucontent.notificationmanagement.announcement;

import application.CENGDesktopWMApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import views.menucontent.AbstractMenuContent;
import views.menucontent.notificationmanagement.announcement.popups.SendNotificationBuilder;
import views.popup.InWindowPopupManager;

public class AnnouncementController extends AbstractMenuContent {
	
	@FXML private VBox finalEventTable;
	
	public AnnouncementController() {
		super("Announcement.fxml");
	}
	
	public AnnouncementController setEventTable(EventTableController eventTable) {
		finalEventTable.getChildren().add(eventTable);
		return this;
	}
	
	public void syncEvents(ActionEvent event) {
		System.out.println("Sync Events Clicked");
		
		// Indirectly sync the data with the website
		CENGDesktopWMApp.getInstance().reflesh();
	}
	
	public void sendNotification(ActionEvent event) {
		System.out.println("Send Notification Clicked");
		
		InWindowPopupManager.getInstance()
								.setPopupTitle("Send Notification to Email Lists")
								.load(new SendNotificationBuilder().build())
								.show();
	}
	
}
