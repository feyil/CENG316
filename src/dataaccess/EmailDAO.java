package dataaccess;

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
}
