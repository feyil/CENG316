package views.menucontent.coursemanagement.schedulecourses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ScheduleController extends VBox {

	// For Monday
	@FXML private Label m1;
	@FXML private Label m2;
	@FXML private Label m3;
	@FXML private Label m4;
	@FXML private Label m5;
	@FXML private Label m6;
	@FXML private Label m7;
	@FXML private Label m8;
	
	private List<Label> monday; 
	
	// For Tuesday
	@FXML private Label tu1;
	@FXML private Label tu2;
	@FXML private Label tu3;
	@FXML private Label tu4;
	@FXML private Label tu5;
	@FXML private Label tu6;
	@FXML private Label tu7;
	@FXML private Label tu8;
	
	private List<Label> tuesday;
	
	public ScheduleController() {
		loadFXML();
		monday = new ArrayList<Label>(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8));
		tuesday = new ArrayList<Label>(Arrays.asList(tu1, tu2, tu3, tu4, tu5, tu6, tu7, tu8));
	}
		
	public List<Label> getScheduleOf(ScheduleDay day) {
		//TODO conceptually
		if(day.equals(ScheduleDay.MONDAY)) {
			return monday;
		}
		else if(day.equals(ScheduleDay.TUESDAY)) {
			return tuesday;
		}
		
		return null;
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
