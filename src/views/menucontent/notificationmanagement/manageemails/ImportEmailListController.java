package views.menucontent.notificationmanagement.manageemails;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
		File selectedList = openFileChooser();
		
		// Parse the read file and store
		parse(selectedList);
		
		// Reflesh the app to sync db conent with views
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
		/*
		 * Read each line in file and split it to nameSurname, email, grade, fields
		 * Get Filename as email groupName set it for all lines
		 * For each line create a emailModel set needed fields of it.
		 * Push each emailModel to the storage
		 */
		
		try {
			Scanner reader = new Scanner(selectedFile);
			
			String groupName = selectedFile.getName().split("\\.")[0];
			
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
								
				String[] splitedLine = line.split(",");
				
				String nameSurname = splitedLine[0];
				String email = splitedLine[1];
				String grade = splitedLine[2];
				
				EmailModel emailModel = new EmailModel();
				
				emailModel.setNameSurname(nameSurname);
				emailModel.setEmail(email);
				emailModel.setGrade(grade);
				emailModel.getEmailGroup().add(groupName);
				
				emailModel.push();
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
	
	private void setListFile(String text) {
		listFile.setText(text);
	}
		
}
