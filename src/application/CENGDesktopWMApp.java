package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import views.container.ComponentContainerController;
import views.container.ContainerPosition;
import views.menucontent.usermanagement.UserManagementController;
import views.menunavigation.AccordionMNController;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class CENGDesktopWMApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Create app and return it
			Parent container = createCENGDesktopApp();
			  
			Scene scene = new Scene(container,800,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Parent createCENGDesktopApp() {
		ComponentContainerController container = new ComponentContainerController();
		Parent menuNavigation = new AccordionMNController();
		Parent menuContent = new UserManagementController();
		
		
		container.addComponent(menuNavigation, ContainerPosition.LEFT);
		container.addComponent(menuContent, ContainerPosition.CENTER);
		
		return container;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
