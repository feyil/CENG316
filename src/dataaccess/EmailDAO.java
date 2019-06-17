package dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public void updateGroups(List<String> groupList, String email) {
		Statement statement = DBBase.createStatement();
		
		for (String groupName : groupList) {
			String sql = String.format("INSERT INTO EMAIL_GROUP(NAME) "
					+ "VALUES('%1$s');", groupName);
			
			// It is not an clever implementation
			try {
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				// Group already exist.
			}
		}
		
		for (String groupName  : groupList) {
			String sql = String.format("INSERT INTO EMAIL_MEMBER_GROUP(MEMBER_EMAIL, GROUP_NAME)"
					+ "VALUES('%1$s', '%2$s');", email, groupName);
			
			try {
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				// Not an clever implementation
			}
		}
	}
	
	public Boolean push(EmailModel emailModel) {

		String nameSurname = emailModel.getNameSurname();
		String email = emailModel.getEmail();
		String grade = emailModel.getGrade();
		
		List<String> groupList = emailModel.getEmailGroup();
		updateGroups(groupList, email);
		
		Statement statement = DBBase.createStatement();
		
		String sql = String.format("INSERT INTO EMAIL_MEMBER(NAMESURNAME, EMAIL, GRADE)"
				+ "VALUES('%1$s', '%2$s', %3$s);", nameSurname, email, grade);
		
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// not an clever implementation but our case it will work fine.
		}
			
		return false;
	}
	
	public List<String> getEmailLists() {
		List<String> emailLists = new ArrayList<String>();
		
		Statement statement = DBBase.createStatement();
		String sql = "SELECT * FROM EMAIL_GROUP";
		
		try {
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				String groupName = result.getString("NAME");
				emailLists.add(groupName);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
				
		return emailLists;
	}
	
	public Boolean deleteEmailList(String listName)  {	
		Statement statement = DBBase.createStatement();
		
		String sql = String.format("SELECT MEMBER_EMAIL FROM EMAIL_MEMBER_GROUP WHERE GROUP_NAME='%1$s'", listName);
		
		try {
			ResultSet result = statement.executeQuery(sql);
			
			Statement deleteEmailSt = DBBase.createStatement();
			while(result.next()) {
				String deleteEmailSQL = String.format("DELETE FROM EMAIL_MEMBER WHERE EMAIL='%1$s'", result.getString("MEMBER_EMAIL"));
				
				deleteEmailSt.executeUpdate(deleteEmailSQL);
			}
			
			String deleteEmailGroupMemberSQL = String.format("DELETE FROM EMAIL_MEMBER_GROUP WHERE GROUP_NAME='%1$s'", listName);
			statement.executeUpdate(deleteEmailGroupMemberSQL);
			
			String deleteEmailGroup = String.format("DELETE FROM EMAIL_GROUP WHERE NAME='%1$s'", listName);
			statement.executeUpdate(deleteEmailGroup);
			
			return true;
			
		} catch (SQLException e) {
			return false;
		}
	}
	
	public List<EmailModel> getModels(List<String> groupList) {
		List<EmailModel> models = new ArrayList<EmailModel>();
		
		Statement statement = DBBase.createStatement();
		
		String groupNames = "";
		for (String groupName : groupList) {
			if(groupNames.equals("") == false) {
				groupNames += " or ";
			}
			String groupSQL = String.format("GROUP_NAME='%1$s'", groupName);
			groupNames += groupSQL;
		}
		
		String sql = String.format("SELECT * FROM EMAIL_MEMBER inner join email_member_group on EMAIL=MEMBER_EMAIL WHERE %1$s;", groupNames);
		try {
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				EmailModel tmp = new EmailModel();
				
				tmp.setEmail(result.getString("EMAIL"));
				tmp.setGrade(result.getString("GRADE"));
				tmp.setNameSurname(result.getString("NAMESURNAME"));
				
				models.add(tmp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return models;
	}
}
