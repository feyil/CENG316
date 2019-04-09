package views.menucontent.coursemanagement.schedulecourses;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class ScheduleController extends VBox {

	
	public ScheduleController() {
		loadFXML();
		
	}
	
	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Schedule.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}
}
