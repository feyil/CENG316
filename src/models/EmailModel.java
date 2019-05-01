package models;

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
			System.out.println("Access EmailDAO object");
			System.out.println("Call EmailDAO object deleteEmailList method");
			Boolean status = EmailDAO.getInstance().deleteEmailList(listName);
		
			return status;
		}
	
		private int emailID;
		private String nameSurname;
		private String email;
		private String grade;
		private String emailGroup;
		
		public EmailModel() {
			
		}

		public Boolean push() {
			System.out.println("EmailDAO instance accesed");
			System.out.println("Push method called for EmailDAO");
			EmailDAO.getInstance().push(this);
			
			return false;
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

		public String getEmailGroup() {
			return emailGroup;
		}

		public void setEmailGroup(String emailGroup) {
			this.emailGroup = emailGroup;
		}
		
}
