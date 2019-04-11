package views;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;
import views.container.ComponentContainerController;
import views.container.ContainerPosition;
import views.menucontent.coursemanagement.managecourse.ManageCourseController;
import views.menucontent.coursemanagement.managecourse.TestManageCourse;
import views.menucontent.coursemanagement.schedulecourses.ScheduleCoursesController;
import views.menucontent.coursemanagement.schedulecourses.TestScheduleCourses;
import views.menucontent.notificationmanagement.announcement.AnnouncementController;
import views.menucontent.notificationmanagement.announcement.TestAnnouncement;
import views.menucontent.notificationmanagement.manageemails.ManageEmailsController;
import views.menucontent.notificationmanagement.manageemails.TestManageEmails;
import views.menucontent.usermanagement.UserManagementController;


public class ComponentCommunicator implements IMenuCommunicator {
	
	private ComponentContainerController container;
	private List<Pane> menuContentList;
	// Pop-up reference can be put here
	
	public ComponentCommunicator() {
		menuContentList = new ArrayList<Pane>();
	}
	
	public void updateSelection(String menuContentID) {
		//TODO How, we can improve it. Using state design pattern
		//TODO Only testing purposes later builder or factories will be introduced
		
		Pane searchResult = searchFor(menuContentID);
		
		if(searchResult == null) {
			if(menuContentID.equals("userManagement")) {
				searchResult = new UserManagementController();
			}
			else if(menuContentID.equals("manageEmails")) {
				searchResult = (Pane) new TestManageEmails().build();
			}
			else if(menuContentID.equals("announcements")) {
				searchResult = (Pane) new TestAnnouncement().build();
			}
			else if(menuContentID.equals("manageCourse")) {
				searchResult = (Pane) new TestManageCourse().build();
			}
			else if(menuContentID.equals("scheduleCourse")) {
				searchResult = (Pane) new TestScheduleCourses().build();
			}
			else {
				//TODO It can be exception
				System.out.println("Please define your menu in updateSelection");
			}
			
			if(searchResult != null) {
				menuContentList.add(searchResult);
			}
		}
		
		container.addComponent(searchResult, ContainerPosition.CENTER);
	}
	
	
	public void addMenuContent(Pane menuContent) {
		
	}
	
	public void removeMenuContent(String menuId) {
		
	}
	
	private Pane searchFor(String menuID) {
		for (Pane pane : menuContentList) {
			String id = pane.getId();
			if(id.equals(menuID)) {
				return pane;
			}
		}
		
		return null;
	}
	
	// Dependency makes me sick, sorry
	public void setComponentContainerController(ComponentContainerController container) {
		this.container = container;
	}
	
	
	

}