package views.menucontent.notificationmanagement.manageemails;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import models.EmailModel;

public class ImportEmailListController extends VBox {
	
	@FXML TextField listFile;
	
	public ImportEmailListController() {
		loadFXML();
		
	}

	public void importList(ActionEvent event) {
		System.out.println("Import List Clicked");
		System.out.println("Open File Chooser");
		File selectedList = openFileChooser();
		System.out.println("Parse the readed file and store somewhere(db or local file system)");
		parse(selectedList);
		
	
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
		emailModel.setEmailGroup(selectedFile.getName());
		emailModel.push();
	}
	
	private void setListFile(String text) {
		listFile.setText(text);
	}
	
	private String getListFile() {
		return listFile.getText();
	}

	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ImportEmailList.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}
	
}
