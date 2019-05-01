package views.menucontent.notificationmanagement.manageemails.popups.addemail;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.EmailModel;
import views.popup.AbstractPopup;

public class AddEmailPopupController extends AbstractPopup {
	
	@FXML private TextField nameSurname;
	@FXML private TextField email;
	@FXML private TextField grade;
	
	private List<String> groupList;
	
	public AddEmailPopupController() {
		super("AddEmail.fxml");
	}
	
	public void add(ActionEvent event) {
		System.out.println("add clicked.");
		System.out.println("user data catched.");
		EmailModel emailModel = new EmailModel();
		emailModel.setNameSurname(nameSurname.getText());
		emailModel.setEmail(email.getText());
		emailModel.setGrade(grade.getText());
		emailModel.getEmailGroup().add(groupList.get(0));
		System.out.println("email model is ready to go.");
		System.out.println("email model pushed.");
		emailModel.push();
		
	}
	
	public void setClickedGroups(List<String> groupList) {
		this.groupList = groupList;
		
	}

}
