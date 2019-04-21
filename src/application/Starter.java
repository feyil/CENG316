package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import views.ComponentCommunicator;
import views.container.ComponentContainerController;
import views.menunavigation.AccordionMNController;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Starter extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {	
			// Create CENG DesktopWMApp
			CENGDesktopWMApp app = CENGDesktopWMApp.getInstance();
			
			Parent container = app.setContainer(new ComponentContainerController())
									.setNavigation(new AccordionMNController())
									.setMenuCommunicator(new ComponentCommunicator())
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
