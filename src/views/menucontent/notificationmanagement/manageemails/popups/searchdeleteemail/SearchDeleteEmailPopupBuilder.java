package views.menucontent.notificationmanagement.manageemails.popups.searchdeleteemail;

import java.util.List;

import models.EmailModel;

public class SearchDeleteEmailPopupBuilder {
	
	private SearchDeleteEmailPopupController instance;
	private List<String> groupList;
	
	public SearchDeleteEmailPopupBuilder() {
		instance = new SearchDeleteEmailPopupController();
	}
	
	public SearchDeleteEmailPopupController build() {
		System.out.println("Call EmailModel static getModels method given groupList");
		List<EmailModel> models = EmailModel.getModels(groupList);
		System.out.println("All EmailModels obtained");
		
		System.out.println("Foeach item of models List create EmailListEntry");
		System.out.println("Set neccesarily field of EmailEntry");
		System.out.println("Add entry to popup instance");
		
		for(int i = 0; i < models.size(); i++) {
			EmailEntryController tmp = new EmailEntryController();
			
			tmp.setEmailID(models.get(i).getEmailID())
					.setEmail(models.get(i).getEmail())
					.setGrade(models.get(i).getGrade());
			
			instance.addItem(tmp);
		}
	
		return instance;
	}
	
	public SearchDeleteEmailPopupBuilder setSelectedGroups(List<String> groups) {
		instance.setSelectedGroups(groups);
		groupList = groups;
		return this;
	}
}

