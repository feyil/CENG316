package views.poup;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class AbstractInWindowPopupController extends VBox {
	
	public AbstractInWindowPopupController() {
		
	}
	
	public abstract AbstractInWindowPopupController setPoupDestination(StackPane destination);
	public abstract AbstractInWindowPopupController load(VBox poup);
	public abstract AbstractInWindowPopupController show();
	public abstract AbstractInWindowPopupController close();
	public abstract AbstractInWindowPopupController setPopupTitle(String title);
	public abstract String getPopupTitle();
	protected abstract AbstractInWindowPopupController loadFXML();
	
	
}
