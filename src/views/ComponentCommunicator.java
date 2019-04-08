package views;

import java.util.List;

import javafx.scene.layout.Pane;
import views.container.ComponentContainerController;


public class ComponentCommunicator implements IMenuCommunicator {
	
	private ComponentContainerController container;
	private List<Pane> menuContentList;
	// Pop-up reference can be put here
	
	public ComponentCommunicator() {
		
	}
	
	public void updateSelection(String selection) {
		updateContainerMenuContent();
	}
	
	public void addMenuContent(Pane menuContent) {
		
	}
	
	public void removeMenuContent(String menuId) {
		
	}
	
	private void updateContainerMenuContent() {
		
	}
	
	
	

}
