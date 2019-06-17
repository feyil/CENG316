package views.menucontent.notificationmanagement.manageemails;

import java.util.ArrayList;
import java.util.List;

import application.CENGDesktopWMApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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
		List<String> selected = findSelectedEmaiLists();
		
		for(int i = 0; i < selected.size(); i++) {
			// TODO handle the status with popup
			Boolean status = EmailModel.deleteEmailList(selected.get(i));
		}
		
		CENGDesktopWMApp.getInstance().reflesh();
	}
	
	private List<String> findSelectedEmaiLists() {
		List<String> selectedEmailLists = new ArrayList<String>();
		
		for(int i = 0; i < emailList.getChildren().size(); i++) {
			CheckBox selected = (CheckBox) emailList.getChildren().get(i);
			if(selected.isSelected()) {
				//System.out.println(a.getText());
				selectedEmailLists.add(selected.getText());
				
				System.out.println("Disable Selected List");
				selected.setDisable(true);
			}
		}
		System.out.println("Return selected email lists as List<String>");
		return selectedEmailLists;
	}
	
	public void addEmail(ActionEvent event) {
		System.out.println("Add Email Clicked");
		
		System.out.println("AddEmail Popup Created");
		AddEmailPopupController addEmailPopup = new AddEmailPopupController();
		System.out.println("Popup Notified about selected groups");
		addEmailPopup.setClickedGroups(getSelectedGroups());
		
		System.out.println("InWindowPopupManager Accesed Popup intialized");
		InWindowPopupManager.getInstance()
								.setPopupTitle("Add Email")
								.load(addEmailPopup)
								.show();
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
		
		SearchDeleteEmailPopupBuilder popupBuilder = new SearchDeleteEmailPopupBuilder();
		System.out.println("Popup Notified about selected groups");
		popupBuilder.setSelectedGroups(getSelectedGroups());
		
		System.out.println("InWindowPopupManager accesed and popup intialized");
		InWindowPopupManager.getInstance()
								.setPopupTitle("Search & Delete Email")
								.load(popupBuilder.build())
								.show();
	}
	
	private void displayEmailLists() {
		List<String> emailList = EmailModel.getEmailLists();
		
		for(int i = 0; i < emailList.size(); i++) {
			CheckBox checkBox = new CheckBox();
			checkBox.setText(emailList.get(i));
			
			this.emailList.getChildren().add(checkBox);
		}
	}
	
}
