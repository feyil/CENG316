package views.popup;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class InWindowPopupManager extends AbstractInWindowPopupController {
	
	private static AbstractInWindowPopupController instance = null;
	
	public static AbstractInWindowPopupController getInstance() {
		if(instance == null) {
			instance = new InWindowPopupManager();
		}
		return instance;
	}
	
	@FXML private VBox loadedPopup;
	@FXML private Label popupTitle;
	
	private StackPane popupDestination;
	
	private Boolean active;
	private Boolean loaded;
	
	//TODO Singleton Design Pattern Applied
	private InWindowPopupManager()  {
		loadFXML();
		active = false;
		loaded = false;
		//setBackground(Background.EMPTY);
		//setBackground(null);
	}
	
	public Boolean isActive() {
		return active;
	}
	
	public Boolean isLoaded() {
		return loaded;
	}
	
	@Override
	public AbstractInWindowPopupController setPopupTitle(String title) {
		popupTitle.setText(title);
		return this;
	}

	@Override
	public String getPopupTitle() {
		return popupTitle.getText();
	}
	
	@Override
	public AbstractInWindowPopupController setPoupDestination(StackPane destination) {
		popupDestination = destination;
		return this;
	}

	@Override
	public AbstractInWindowPopupController load(VBox popup) {
		if(isLoaded()) {
			loadedPopup.getChildren().remove(0);
		}
		
		loadedPopup.getChildren().add(popup);
		
		return this;
	}

	@Override
	public AbstractInWindowPopupController show() {
		if(!isActive()) {
			popupDestination.getChildren().add(this);
			this.active = true;
		}
		return this;
	}

	@Override
	public AbstractInWindowPopupController close() {
		if(isActive()) {
			popupDestination.getChildren().remove(popupDestination.getChildren().size() - 1);
		}
		return null;
	}
	
	@Override
	protected AbstractInWindowPopupController loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InWindowPoup.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
		
		return this;
	}


}
