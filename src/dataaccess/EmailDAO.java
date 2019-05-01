package dataaccess;

import java.util.ArrayList;
import java.util.List;

import models.EmailModel;

public class EmailDAO {
	
	private static EmailDAO instance;
	
	public static EmailDAO getInstance() {
		if(instance == null) {
			instance = new EmailDAO();
		}
		return instance;
	}
	
	private EmailDAO() {
		
	}
	
	public Boolean push(EmailModel emailModel) {
		System.out.println("EmailModel related field accesed");
		System.out.println("DB connection accesed");
		System.out.println("Related SQL Command runned");
		System.out.println("Status returned as boolean");
		
		
		return false;
	}
	
	public List<String> getEmailLists() {
		System.out.println("Necessary data query made to find all emailLists");
		List<String> emailLists = new ArrayList<String>();
		emailLists.add("Junior");
		emailLists.add("Senior");
		emailLists.add("Sophomore");
		System.out.println("List filled and returned");
		
		return emailLists;
	}
	
	public Boolean deleteEmailList(String listName)  {
		System.out.println("Make neccessarily data delete query and delete list from persistence storage");
		System.out.println("Return status of the opeartion as boolean");
		
		return false;
	}
	
	public List<EmailModel> getModels(List<String> groupList) {
		List<EmailModel> models = new ArrayList<EmailModel>();
		System.out.println("Make neccessairly data query to collect all EmailModels(GroupList) in a List<EmailModel>");
		
		EmailModel tmp = new EmailModel();
		tmp.setEmailID(1);
		tmp.setNameSurname("Furkan Emre YILMAZ");
		tmp.setGrade("3");
		tmp.setEmail("furkan54emre@gmail.com");
		
		models.add(tmp);
		
		return models;
	}
}
