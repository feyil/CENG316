package views.menucontent.notificationmanagement.announcement;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class EventEntryController extends HBox {
	
	@FXML private Label eventName;
	@FXML private Label eventDate;
	@FXML private Label eventTime;
	@FXML private Label eventLocation;
	@FXML private CheckBox eventSelection;
	
	public EventEntryController() {
		loadFXML();
	}
	
	public EventEntryController setEventName(String name) {
		eventName.setText(name);
		return this;
	}
	
	public String getEventName() {
		return eventName.getText();
	}
	
	public EventEntryController setEventDate(String date) {
		eventDate.setText(date);
		return this;
	}
	
	public String getEventDate() {
		return eventDate.getText();
	}
	
	public EventEntryController setEventTime(String time) {
		eventTime.setText(time);
		return this;
	}
	
	public String getEventTime() {
		return eventTime.getText();
	}
	
	public EventEntryController setEventLocation(String location) {
		eventLocation.setText(location);
		return this;
	}
	
	public String getEventLocation() {
		return eventLocation.getText();
	}
	
	public EventEntryController setEventSelection(Boolean option) {
		eventSelection.setSelected(option);
		return this;
	}
	
	public Boolean getEventSelection() {
		return eventSelection.isSelected();
	}
	
	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EventEntry.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}
}
