package views.menucontent.notificationmanagement.manageemails;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EmailListChooser extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		FileChooser fileChoser = new FileChooser();
		fileChoser.setTitle("Import Email List File");
		fileChoser.showOpenDialog(stage);
	}

}
