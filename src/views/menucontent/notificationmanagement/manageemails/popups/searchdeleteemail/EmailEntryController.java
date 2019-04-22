package views.menucontent.notificationmanagement.manageemails.popups.searchdeleteemail;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class EmailEntryController extends HBox {
	
	@FXML private Label nameSurname;
	@FXML private Label email;
	@FXML private Label grade;
	
	private int emailID;
	
	public EmailEntryController()   {
		loadFXML("EmailEntry.fxml");
	}
	
	public void deleteEmail(ActionEvent event) {
		System.out.println("Delete Email Clicked");
		
		setDisable(true);
	}
	
	public int getEmailID() {
		return emailID;
	}

	public EmailEntryController setNameSurname(String ns) {
		nameSurname.setText(ns);
		return this;
	}
	
	public EmailEntryController setEmail(String mail) {
		email.setText(mail);
		return this;
	}
	
	public EmailEntryController setGrade(String grd) {
		grade.setText(grd);
		return this;
	}

	public EmailEntryController setEmailID(int emailID) {
		this.emailID = emailID;
		return this;
	}
	
	private EmailEntryController loadFXML(String fxmlFileName) {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
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
