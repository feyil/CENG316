package views.menucontent.coursemanagement.managecourse;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class CourseTableController extends VBox {
	
	@FXML private VBox table;
	
	public CourseTableController() {
		loadFXML();
		
	}
	
	public CourseTableController addItem(CourseEntryController entry) {
		table.getChildren().add(entry);
		return this;
	}
	
	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseTable.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}

}
