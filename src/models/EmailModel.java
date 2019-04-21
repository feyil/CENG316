package models;

import dataaccess.EmailDAO;

public class EmailModel {
	
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
