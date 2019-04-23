package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import views.ComponentCommunicator;
import views.container.ComponentContainerController;
import views.login.LoginController;
import views.menucontent.notificationmanagement.manageemails.popups.TestPopups;
import views.menucontent.notificationmanagement.manageemails.popups.searchdeleteemail.SearchDeleteEmailPopupController;
import views.menunavigation.AccordionMNController;
import views.popup.AbstractInWindowPopupController;
import views.popup.InWindowPopupManager;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Starter extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {	
			// Create CENG DesktopWMApp
			CENGDesktopWMApp app = CENGDesktopWMApp.getInstance();
			
			Parent container = app.setContainer(new ComponentContainerController())
									.setNavigation(new AccordionMNController())
									.setMenuCommunicator(new ComponentCommunicator())
									.loginRequired()
									.build();
			
		
			Scene scene = new Scene(container,960,480);
			primaryStage.setTitle("CENG Desktop Website Management App (IZTECH)");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();	
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
