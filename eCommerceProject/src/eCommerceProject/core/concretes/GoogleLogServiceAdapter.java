package eCommerceProject.core.concretes;

import eCommerceProject.core.abstracts.GoogleService;
import eCommerceProject.entities.concretes.User;
import google.GoogleLogService;

public class GoogleLogServiceAdapter implements GoogleService{

	@Override
	public void register(User user) {
		GoogleLogService googleLogService = new GoogleLogService();
		googleLogService.register(user);
		
	}

}
