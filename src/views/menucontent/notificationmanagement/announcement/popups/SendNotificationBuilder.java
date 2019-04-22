package views.menucontent.notificationmanagement.announcement.popups;

public class SendNotificationBuilder {
	
	public SendNotificationBuilder() {
		
	}
	
	public SendNotificationPopupController build() {
		SendNotificationPopupController a = new SendNotificationPopupController();
		
		System.out.println("Stage by stage access data and build the object");
		
		return a;
	}

}
