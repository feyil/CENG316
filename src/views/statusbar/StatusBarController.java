package views.statusbar;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import views.menucontent.AbstractMenuContent;

public class StatusBarController extends HBox {
	
	public StatusBarController() {
		loadFXML("StatusBar.fxml");
	}

	
	private void loadFXML(String fxmlFileName) {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}
}
