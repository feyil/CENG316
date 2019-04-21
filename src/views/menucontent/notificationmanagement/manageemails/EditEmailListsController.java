package views.menucontent.notificationmanagement.manageemails;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import views.menucontent.AbstractMenuContent;
import views.menucontent.notificationmanagement.manageemails.popups.addemail.AddEmailPopupController;
import views.popup.InWindowPopupManager;

public class EditEmailListsController extends AbstractMenuContent { 

	@FXML private VBox emailList;
	
	public EditEmailListsController() {
		super("EditEmailLists.fxml");
	}
	
	public void addEmail(ActionEvent event) {
		System.out.println("Add Email Clicked");
		
		InWindowPopupManager.getInstance()
								.setPopupTitle("Add Email")
								.load(new AddEmailPopupController())
								.show();
		
		// TODO proof of concept code snippet 
		for(int i = 0; i < emailList.getChildren().size(); i++) {
			CheckBox a = (CheckBox) emailList.getChildren().get(i);
			if(a.isSelected()) {
				System.out.println(a.getText());
			}
		}
	}
	
}
