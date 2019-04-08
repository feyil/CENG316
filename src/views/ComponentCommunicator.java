package views;

import java.util.List;

import javafx.scene.layout.Pane;
import views.container.ComponentContainerController;
import views.container.ContainerPosition;
import views.menucontent.usermanagement.UserManagementController;


public class ComponentCommunicator implements IMenuCommunicator {
	
	private ComponentContainerController container;
	private List<Pane> menuContentList;
	// Pop-up reference can be put here
	
	public ComponentCommunicator() {
		
	}
	
	public void updateSelection(String selection) {
		if(selection.equals("userManagement")) {
			container.addComponent(new UserManagementController(), ContainerPosition.CENTER);
		}
	}
	
	public void addMenuContent(Pane menuContent) {
		
	}
	
	public void removeMenuContent(String menuId) {
		
	}
	
	private void updateContainerMenuContent() {
		
	}
	
	// Dependency makes me sick, sorry
	public void setComponentContainerController(ComponentContainerController container) {
		this.container = container;
	}
	
	
	

}
