package views.menucontent.notificationmanagement.announcement.popups;

import javafx.event.ActionEvent;
import views.popup.AbstractPopup;

public class SendNotificationPopupController extends AbstractPopup {
	
	public SendNotificationPopupController() {
		super("SendNotification.fxml");
	}
	
	public void send(ActionEvent event) {
		System.out.println("Send Clicked");
	}

}
