package appComponentContainer;

import javafx.application.Application;
import javafx.stage.Stage;
import menuNavigation.AccordionMNController;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class TestComponentContainer extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ComponentContainerController root = new ComponentContainerController();
			AccordionMNController a = new AccordionMNController();
			root.addComponent(a, ContainerPosition.LEFT);
			
			
			Scene scene = new Scene((Parent)root,800,600);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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