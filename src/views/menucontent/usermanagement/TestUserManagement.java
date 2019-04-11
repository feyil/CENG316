package views.menucontent.usermanagement;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class TestUserManagement extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = new UserManagementController();
		
			Scene scene = new Scene((Parent) root,400,400);
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