package views.menucontent.notificationmanagement.manageemails.popups;

import application.CENGDesktopWMApp;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.ComponentCommunicator;
import views.container.ComponentContainerController;
import views.menucontent.notificationmanagement.manageemails.popups.searchdeleteemail.EmailEntryController;
import views.menucontent.notificationmanagement.manageemails.popups.searchdeleteemail.SearchDeleteEmailPopupController;
import views.menunavigation.AccordionMNController;

public class TestPopups extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {	
			// Create CENG DesktopWMApp
			Parent container = build();
			Scene scene = new Scene(container,960,480);
			primaryStage.setTitle("CENG Desktop Website Management App (IZTECH)");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();	
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Parent build() {
		EmailEntryController a = new EmailEntryController();
		a.setNameSurname("a")
			.setEmail("abc@cdf")
			.setGrade("3");
		
		SearchDeleteEmailPopupController container = new SearchDeleteEmailPopupController();
		container.addItem(a);
		for(int i = 0; i < 10; i++) {
			container.addItem(new EmailEntryController());
		}
		return container;
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
