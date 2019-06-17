package models;

import java.util.ArrayList;
import java.util.List;

import dataaccess.EmailDAO;

public class EmailModel {
	
		public static List<String> getEmailLists() {
			System.out.println("EmailDAO object accesed getEmailLists method called");
			List<String> emailLists = EmailDAO.getInstance().getEmailLists();
			
			System.out.println("Finded email lists returned");
			return emailLists;
		}
		
		public static Boolean deleteEmailList(String listName) {
			Boolean status = EmailDAO.getInstance().deleteEmailList(listName);
	
			return status;
		}
		
		public static List<EmailModel> getModels(List<String> groupList) {
			System.out.println("Access DAO Object");
			System.out.println("Call getModels method");
			List<EmailModel> models = EmailDAO.getInstance().getModels(groupList);
			System.out.println("Return getted List<EmailModel>");
			
			return models;
		}
	
		private int emailID;
		private String nameSurname;
		private String email;
		private String grade;
		private List<String> emailGroup;
		
		public EmailModel() {
			emailGroup = new ArrayList<String>();
		}
		
		public Boolean push() {
			return EmailDAO.getInstance().push(this);
		}
		
		public int getEmailID() {
			return emailID;
		}

		public void setEmailID(int emailID) {
			this.emailID = emailID;
		}

		public String getNameSurname() {
			return nameSurname;
		}

		public void setNameSurname(String nameSurname) {
			this.nameSurname = nameSurname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public List<String> getEmailGroup() {
			return emailGroup;
		}
		
}
