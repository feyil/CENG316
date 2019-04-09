package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import views.ComponentCommunicator;
import views.container.ComponentContainerController;
import views.container.ContainerPosition;
import views.menucontent.coursemanagement.managecourse.ManageCourseController;
import views.menucontent.coursemanagement.managecourse.TestManageCourse;
import views.menucontent.coursemanagement.schedulecourses.TestScheduleCourses;
import views.menucontent.notificationmanagement.announcement.TestAnnouncement;
import views.menucontent.notificationmanagement.manageemails.TestManageEmails;
import views.menucontent.usermanagement.UserManagementController;
import views.menunavigation.AccordionMNController;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class CENGDesktopWMApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Create app and return it
			Parent container = createCENGDesktopApp();
			  
			Scene scene = new Scene(container,960,480);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Parent createCENGDesktopApp() {
		ComponentContainerController container = new ComponentContainerController();
		ComponentCommunicator cmn = new ComponentCommunicator();
		cmn.setComponentContainerController(container);
		
		AccordionMNController menuNavigation = new AccordionMNController();
		menuNavigation.setMenuCommunicator(cmn);
		
	//	TestAnnouncement a = new TestAnnouncement();
	//	Parent an = a.build();
		
	//	TestManageEmails a = new TestManageEmails();
	//	Parent an = a.build();
		
	//	TestScheduleCourses a = new TestScheduleCourses();
	//	Parent an = a.build();
		
		TestManageCourse a = new TestManageCourse();
		Parent an = a.build();
		
		
		
		container.addComponent(an, ContainerPosition.CENTER);
		container.addComponent(menuNavigation, ContainerPosition.LEFT);		
		return container;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
