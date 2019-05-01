package views.menucontent.notificationmanagement.manageemails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.CENGDesktopWMApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import models.EmailModel;
import views.menucontent.AbstractMenuContent;
import views.menucontent.notificationmanagement.manageemails.popups.addemail.AddEmailPopupController;
import views.menucontent.notificationmanagement.manageemails.popups.searchdeleteemail.SearchDeleteEmailPopupBuilder;
import views.popup.InWindowPopupManager;

public class EditEmailListsController extends AbstractMenuContent { 

	@FXML private VBox emailList;
	
	public EditEmailListsController() {
		super("EditEmailLists.fxml");
		System.out.println("Display EmailList called");
		displayEmailLists();
	}
	
	public void deleteList(ActionEvent event) {
		System.out.println("Delete List clicked");
		
		for(int i = 0; i < emailList.getChildren().size(); i++) {
			CheckBox a = (CheckBox) emailList.getChildren().get(i);
			if(a.isSelected()) {
				System.out.println(a.getText());
				a.setDisable(true);
			}
		}
	}
	
	public void addEmail(ActionEvent event) {
		System.out.println("Add Email Clicked");
		
		AddEmailPopupController addEmailPopup = new AddEmailPopupController();
		
		addEmailPopup.setClickedGroups(getSelectedGroups());
		
	
	
		InWindowPopupManager.getInstance()
								.setPopupTitle("Add Email")
								.load(addEmailPopup)
								.show();
		
		// TODO proof of concept code snippet 
		for(int i = 0; i < emailList.getChildren().size(); i++) {
			CheckBox a = (CheckBox) emailList.getChildren().get(i);
			if(a.isSelected()) {
				System.out.println(a.getText());
			}
		}
	}
	
	private List<String> getSelectedGroups(){
		List<String> tmp = new ArrayList<String>();
		
		for(int i = 0; i < emailList.getChildren().size(); i++) {
			CheckBox a = (CheckBox) emailList.getChildren().get(i);
			if(a.isSelected()) {
				tmp.add(a.getText());
			}
		}
		
		return tmp;
	}
	
	public void searchDelete(ActionEvent event) {
		System.out.println("Search Clicked");
		
		InWindowPopupManager.getInstance()
								.setPopupTitle("Search & Delete Email")
								.load(new SearchDeleteEmailPopupBuilder().build())
								.show();
	}
	
	private void displayEmailLists() {
		System.out.println("EmailModel static getEmailLists method called");
		List<String> emailList = EmailModel.getEmailLists();
		
		System.out.println("EmailList obtained");
		
		System.out.println("For each item of the list a checkbox added to lists table with name setted as item of list");
		for(int i = 0; i < emailList.size(); i++) {
			CheckBox checkBox = new CheckBox();
			checkBox.setText(emailList.get(i));
			
			this.emailList.getChildren().add(checkBox);
		}
		
		
	}
	
}
