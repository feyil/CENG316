package application;
	
import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import views.ComponentCommunicator;
import views.container.ComponentContainerController;
import views.menunavigation.AccordionMNController;
import views.statusbar.StatusBarController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;



public class Starter extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {	
			// Create CENG DesktopWMApp
			CENGDesktopWMApp app = CENGDesktopWMApp.getInstance();
			
			StackPane root = new StackPane();
			
			Parent container = app.setContainer(new ComponentContainerController())
									.setNavigation(new AccordionMNController())
									.setMenuCommunicator(new ComponentCommunicator())
									.setStatusBar(new StatusBarController())
									.loginRequired()
									.build();
			
			
			loadSplashScreen(root, container);
			
			Scene scene = new Scene(root,960,480);
			scene.getStylesheets().add("app.css");
			primaryStage.setTitle("CENG Desktop Website Management App (IZTECH)");
		
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();	
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadSplashScreen(StackPane root, Parent container) {
		try {
			// Taken from https://www.genuinecoder.com/javafx-splash-screen-loading-screen/
			StackPane pane = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
			root.getChildren().setAll(pane);
			
			 //Load splash screen with fade in effect
	        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
	        fadeIn.setFromValue(0);
	        fadeIn.setToValue(1);
	        fadeIn.setCycleCount(1);
	        
	        //Finish splash with fade out effect
	        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
	        fadeOut.setFromValue(1);
	        fadeOut.setToValue(0);
	        fadeOut.setCycleCount(1);
	        
	        //After fade in, start fade out
	        fadeIn.setOnFinished((e) -> {
	            fadeOut.play();
	        });
	        
	        //After fade out, start whatever is next
	        fadeOut.setOnFinished((e) -> {
	        	root.getChildren().setAll(container);
	        	
	        });
	 
	        fadeIn.play();
	        		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
