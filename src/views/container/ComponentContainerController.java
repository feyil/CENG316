package views.container;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class ComponentContainerController extends StackPane {
	
	@FXML
	private BorderPane componentContainer; 
	
	public ComponentContainerController() {
		loadFXML();
	
	}
	
	public void addComponent(Node component, ContainerPosition position) {
		
		if(position.equals(ContainerPosition.CENTER)) {
			componentContainer.setCenter(component);
		}
		else if(position.equals(ContainerPosition.TOP)) {
			componentContainer.setTop(component);
		}
		else if(position.equals(ContainerPosition.BOTTOM)) {
			componentContainer.setBottom(component);
		}
		else if(position.equals(ContainerPosition.LEFT)) {
			componentContainer.setLeft(component);
		}
		else if(position.equals(ContainerPosition.RIGHT)) {
			componentContainer.setRight(component);
		}
		else {
			//throw new Exception("Invalid Container Position");
		}
		
		
	}
	
	private ComponentContainerController loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ComponentContainer.fxml"));
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
