package views.menucontent.notificationmanagement.announcement;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.menucontent.usermanagement.UserManagementController;

public class TestAnnouncement extends Application {
	
	public void start(Stage primaryStage) {
		try {
			EventEntryController event = new EventEntryController();
			event.setEventName("Some Event")
					.setEventDate("08/04/2019")
					.setEventTime("12:00")
					.setEventLocation("Bursa")
					.setEventSelection(true);
			
			EventTableController eventTable = new EventTableController();
			eventTable.addItem(event);
			
			for(int i = 0; i < 30; i++) {
				EventEntryController event2 = new EventEntryController();
				eventTable.addItem(event2);
			}
			
			
			Scene scene = new Scene(eventTable,800,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
