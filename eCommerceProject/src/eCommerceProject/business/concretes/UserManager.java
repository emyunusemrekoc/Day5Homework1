package eCommerceProject.business.concretes;

import java.util.List;
import java.util.Scanner;

import eCommerceProject.business.abstracts.UserService;
import eCommerceProject.core.abstracts.LogService;
import eCommerceProject.core.concretes.GoogleLogServiceAdapter;
import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.entities.concretes.User;

public class UserManager implements UserService{
	private UserDao userDao;
	private GoogleLogServiceAdapter googleLogServiceAdapter;
	private LogService logService;


	public UserManager(UserDao userDao, GoogleLogServiceAdapter googleLogServiceAdapter ,LogService logService) {
		super();
		this.userDao = userDao;
		this.logService = logService;
		this.googleLogServiceAdapter = googleLogServiceAdapter;
	}



	@Override
	public void register(User user) {
		
		Scanner info = new Scanner(System.in);
		System.out.println("FirstName: ");
		user.setFirstName(info.next());
		System.out.println("Lastname: ");
		user.setLastName(info.next());
		System.out.println("E-Mail Address: ");
		user.setEmail(info.next());
		System.out.println("Password: ");
		user.setPassword(info.next());
		
		
	    if((AuthManager.nameFormat(user.getFirstName()) || AuthManager.nameFormat(user.getLastName()))) {
	    	System.out.println("Name or surname cannot be less than 2 characters");
	    	user.setVerify(false);
	    	
	    }
	    if(!(AuthManager.eMailFormat(user.getEmail()))) {
			System.out.println("ERROR- Enter in e-mail format");
			user.setVerify(false);
	    }
	    if(AuthManager.passwordFormat(user.getPassword())) {
	    	System.out.println("Password cannot be less than 6 characters");
	    	user.setVerify(false);
	    }
	    	
	    	  else {
	  	    	
	 	    	 
	  	    	if(userDao.getUser(user.getEmail()) != null){
	  	             System.out.println("This E-Mail is Used- "+user.getEmail());   
	  	         }
	  	    	else {
	  	        	 userDao.register(user);
	  		    	 logService.sendVerificationMail(user.getEmail(),user);
	  	        	 System.out.println("E-Mail Confirmed- "+user.getEmail());
	  	         }
	  	    	
	  	 	    }
	    }
	  
	    


	@Override
	public void login(User user) {
		
		Scanner info = new Scanner(System.in);
		System.out.println("E-Mail Address: ");
		user.setEmail(info.next());
		System.out.println("Password: ");
		user.setPassword(info.next());
		
		
		if(user.getEmail().equals("gokcenaysu@gmail.com") && user.getPassword().equals("147852")) {
			userDao.login(user);
		}
		else {
			System.out.println("Wrong e-Mail or password");
		}
	}

	@Override
	public void update(User user) {
		
		Scanner info = new Scanner(System.in);
		System.out.println("E-Mail Address: ");
		user.setEmail(info.next());
		System.out.println("Password: ");
		user.setPassword(info.next());
		if(!(user.getEmail().equals("gokcenaysu@gmail.com") && user.getPassword().equals("147852"))) {
			System.out.println("Wrong e-Mail or password");
	    }else {
			System.out.println("New E-Mail Address: ");
			user.setEmail(info.next());
			System.out.println("New Password: ");
			user.setPassword(info.next());
		userDao.update(user);
	    }
	}

	@Override
	public void delete(User user) {
		
		Scanner info = new Scanner(System.in);
		System.out.println("E-Mail Address: ");
		user.setEmail(info.next());
		System.out.println("Password: ");
		user.setPassword(info.next());
		
		if(!(user.getEmail().equals("gokcenaysu@gmail.com") && user.getPassword().equals("147852"))) {
			System.out.println("Wrong e-Mail or password");
			
	    }
		else {
			System.out.println("E-Mail Address confirm: ");
			user.setEmail(info.next());
			System.out.println("Password confirm: ");
			user.setPassword(info.next());
			userDao.deleted(user);
	
		}
	}

	@Override
	public User getUser(String _eMail) {
		return userDao.getUser(_eMail);	
	}
	
	@Override
	public List<User> getAll() {
		for(User user: userDao.getAll()) {
			System.out.println(user.getId() + "- " + user.getFirstName() + "- "
					+ user.getLastName() + "- " + user.getEmail()); 
		}
		return userDao.getAll();
	}


	@Override
	public void registerWithGoogle( User user) {
		googleLogServiceAdapter.register(user);
		logService.sendVerificationMail(user.getEmail(),user);
		
	}

	

}
