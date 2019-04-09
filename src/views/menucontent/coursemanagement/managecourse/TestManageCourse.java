package views.menucontent.coursemanagement.managecourse;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestManageCourse extends Application {

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
		ManageCourseController mng = new ManageCourseController();
		
		CourseTableController table = new CourseTableController();
		
		mng.setCourseTable(table);
		
		for(int i = 0; i < 10; i++) {

			CourseEntryController entry = new CourseEntryController();
			
			table.addItem(entry);
		}
		
		
		return mng;
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
