package views.menucontent.usermanagement.popups;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.menucontent.usermanagement.popups.users.UserEntryController;
import views.menucontent.usermanagement.popups.users.UsersPopupController;

public class TestPopups extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			
			Parent an = build();
			
			Scene scene = new Scene(an,960,480);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Parent build() {
		UsersPopupController users = new UsersPopupController();
		
		for(int i = 0; i < 10; i++) {
			users.addItem(new UserEntryController());
		}
	
		return users;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
