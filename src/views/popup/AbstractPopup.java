package views.popup;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;


public abstract class AbstractPopup extends VBox {

	public AbstractPopup(String fxmlFileName) {
		loadFXML(fxmlFileName);
	}
	
	private AbstractPopup loadFXML(String fxmlFileName) {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
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
