package menuNavigation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.input.MouseEvent;

public class AccordionMNController extends Accordion {
	
	private String navigationSelection;
	
	//TODO Observable think about observable option
	
	public AccordionMNController() {
		loadFXML();
	}
	
	public void selection(MouseEvent mouseEvent) {
		// Get the clicked item then read its id to identify it.
		Node clickedItem = (Node)mouseEvent.getSource();
		
		setNavigationSelection(clickedItem.getId());
	}
	
	private void setNavigationSelection(String selection) {
		this.navigationSelection = selection;
	}
	
	public String getSelection() {
		return this.navigationSelection;
	}
	
	private AccordionMNController loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccordionMenuNavigation.fxml"));
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
