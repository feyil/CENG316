package application;

import views.ComponentCommunicator;
import views.container.ComponentContainerController;
import views.container.ContainerPosition;
import views.menunavigation.AccordionMNController;
import views.popup.AbstractInWindowPopupController;
import views.popup.InWindowPopupManager;

public class CENGDesktopWMApp {
	
	private static CENGDesktopWMApp instance;
	
	public static CENGDesktopWMApp getInstance() {
		if(instance == null) {
			instance = new CENGDesktopWMApp();
		}
		return instance;
	}
	
	private ComponentContainerController container;
	private AccordionMNController navigation;
	private ComponentCommunicator communicator;

	private CENGDesktopWMApp() {
		
	}
	
	public CENGDesktopWMApp setContainer(ComponentContainerController cnt) {
		container = cnt;
		return this;
	}
	
	public CENGDesktopWMApp setNavigation(AccordionMNController nvg) {
		navigation = nvg;
		return this;
	}
	
	private CENGDesktopWMApp initializePopupManager() {
		AbstractInWindowPopupController popup = InWindowPopupManager.getInstance();
		popup.setPoupDestination(container);
		
		return this;
	}
	
	public CENGDesktopWMApp setMenuCommunicator(ComponentCommunicator cmn) {
		communicator = cmn;
		return this;
	}
	
	public void reflesh() {
		communicator.reflesh();
	}
	
	public ComponentContainerController build() {
		communicator.setComponentContainerController(container);
		navigation.setMenuCommunicator(communicator);
		
		container.addComponent(navigation, ContainerPosition.LEFT);
		
		initializePopupManager();
		
		return container;
	}
}
