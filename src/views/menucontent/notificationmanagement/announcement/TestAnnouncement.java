package views.menucontent.notificationmanagement.announcement;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TestAnnouncement extends Application {
	
	public void start(Stage primaryStage) {
		try {
			
			Parent an = build();
			
			Scene scene = new Scene(an,800,480);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Parent build() {
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
		
		AnnouncementController an = new AnnouncementController();
		an.setEventTable(eventTable);
		
		return an;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
