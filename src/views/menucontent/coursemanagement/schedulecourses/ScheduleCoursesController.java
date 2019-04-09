package views.menucontent.coursemanagement.schedulecourses;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class ScheduleCoursesController extends VBox {
	
	@FXML private VBox schedule;
	
	public ScheduleCoursesController() {
		loadFXML();
		
		
	}
	
	public ScheduleCoursesController setSchedule(Node sch) {
		schedule.getChildren().add(sch);
		return this;
	}
	
	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ScheduleCourses.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}
}
