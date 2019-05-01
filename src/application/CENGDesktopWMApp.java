package application;

import models.UserModel;
import views.ComponentCommunicator;
import views.container.ComponentContainerController;
import views.container.ContainerPosition;
import views.login.LoginController;
import views.menunavigation.AccordionMNController;
import views.popup.AbstractInWindowPopupController;
import views.popup.InWindowPopupManager;
import views.statusbar.StatusBarController;

public class CENGDesktopWMApp {
	
	private static CENGDesktopWMApp instance;
	
	public static CENGDesktopWMApp getInstance() {
		if(instance == null) {
			instance = new CENGDesktopWMApp();
		}
		return instance;
	}
	
	private Boolean loginRequired = false;
	private UserModel loggedUser;
	private ComponentContainerController container;
	private AccordionMNController navigation;
	private ComponentCommunicator communicator;
	private StatusBarController statusBar;

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
	
	public CENGDesktopWMApp setStatusBar(StatusBarController statusBar) {
		this.statusBar = statusBar;
		return this;
	}
	
	public CENGDesktopWMApp reflesh() {
		communicator.reflesh();
		return this;
	}
	
	public CENGDesktopWMApp loginRequired() {
		loginRequired = true;
		return this;
	}
	
	public CENGDesktopWMApp loginedAs(UserModel user) {
		container.addComponent(null, ContainerPosition.CENTER);	
		container.addComponent(navigation, ContainerPosition.LEFT);
		container.addComponent(statusBar, ContainerPosition.TOP);
		
		setLoggedUser(user);
		return this;
	}
	
	private CENGDesktopWMApp login() {
		container.addComponent(new LoginController(), ContainerPosition.CENTER);
		return this;
	}
	
	public CENGDesktopWMApp logout() {
		System.out.println("App State Cleared");
		container.reset();
		loggedUser = null;
		
		System.out.println("Private login method called");
		login();
	
		return this;
	}
	
	public ComponentContainerController build() {
		communicator.setComponentContainerController(container);
		navigation.setMenuCommunicator(communicator);
		
		if(loginRequired) {
			login();
		}
		else {
			container.addComponent(navigation, ContainerPosition.LEFT);
			container.addComponent(statusBar, ContainerPosition.TOP);
		}
		
		initializePopupManager();
		
		return container;
	}

	public UserModel getLoggedUser() {
		return loggedUser;
	}

	private void setLoggedUser(UserModel loggedUser) {
		this.loggedUser = loggedUser;
	}
}
