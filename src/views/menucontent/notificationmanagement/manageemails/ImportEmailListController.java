package views.menucontent.notificationmanagement.manageemails;

import java.io.File;


import application.CENGDesktopWMApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import models.EmailModel;
import views.menucontent.AbstractMenuContent;

public class ImportEmailListController extends AbstractMenuContent {
	
	@FXML TextField listFile;
	
	public ImportEmailListController() {
		super("ImportEmailList.fxml");
		
	}

	public void importList(ActionEvent event) {
		System.out.println("Import List Clicked");
		System.out.println("Open File Chooser");
		File selectedList = openFileChooser();
		System.out.println("Parse the readed file and store somewhere(db or local file system)");
		parse(selectedList);
		
		System.out.println("App refleshed");
		CENGDesktopWMApp.getInstance().reflesh();
	}
	
	private File openFileChooser() {
		Stage browserStage =  new Stage();
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		fileChooser.setTitle("Select Email List");
			
		File selectedFile = fileChooser.showOpenDialog(browserStage);
		
		setListFile(selectedFile.getPath());
		
		return selectedFile;
	}
	
	private void parse(File selectedFile) {
		System.out.println("Read each line in file and split it to nameSurname, email, grade, fields");
		System.out.println("Get Filename as email groupName set it for all lines");
		System.out.println("For each line create a emailModel set needed fields of it.");
		System.out.println("Push each emailModel to the storage");
		
		EmailModel emailModel = new EmailModel();
		emailModel.getEmailGroup().add(selectedFile.getName());
		emailModel.push();
	}
	
	private void setListFile(String text) {
		listFile.setText(text);
	}
	
	private String getListFile() {
		return listFile.getText();
	}
	
}
