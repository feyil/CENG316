package views.menunavigation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.input.MouseEvent;
import views.IMenuCommunicator;

public class AccordionMNController extends Accordion {
	
	private IMenuCommunicator menuCommunicator;
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
		
		menuCommunicator.updateSelection(getSelection());
	}
	
	public String getSelection() {
		return this.navigationSelection;
	}
	
	public void setMenuCommunicator(IMenuCommunicator menuCommunicator) {
		this.menuCommunicator = menuCommunicator;
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
