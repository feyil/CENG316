package views.menucontent.notificationmanagement.manageemails;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestManageEmails extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
			// Create app and return it
			Parent container = build();
			  
			Scene scene = new Scene(container,960,480);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Parent build() {
		
		ManageEmailsController mn = new ManageEmailsController();
		Node a = new ImportEmailListController();
		Node b = new EditEmailListsController();
		mn.addSection(a);
		mn.addSection(b);
		
		return mn;
	}
	

	public static void main(String[] args) {
		launch(args);
	}

}
