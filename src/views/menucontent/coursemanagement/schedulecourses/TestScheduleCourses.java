package views.menucontent.coursemanagement.schedulecourses;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestScheduleCourses extends Application {
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
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
		
		ScheduleCoursesController a = new ScheduleCoursesController();
		ScheduleController schedule = new ScheduleController();
		a.setSchedule(schedule);
		
		return a;
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
