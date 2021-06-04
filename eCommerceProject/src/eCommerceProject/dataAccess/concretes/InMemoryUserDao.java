package eCommerceProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	 public static ArrayList<User> userDb = new ArrayList<User>();
     public static ArrayList<String> mail = new ArrayList<String>();
     
    
    public boolean existUser(User user) {
    	
    	for (String mails : mail) {
    		if(mails == user.getEmail())
    			user.setVerify(false);
		        return false;
    		
    	}
			 
    	return true;
			}
	
	
	@Override
	public void register(User user) {
    	 if (user.isVerify()==true) {
 			 mail.add(user.getEmail());
    		 userDb.add(user);
 			System.out.println("Basariyla kayýt oldunuz- " + user.getFirstName() + " " + user.getLastName());
 			
 		}else {
 			
 			System.out.println("Kayýt basarýsýz- " + user.getFirstName() + " " + user.getLastName());
 		}

	}

	@Override
	public void login(User user) {
		
		if(InMemoryUserDao.userDb.contains(user)){
			System.out.println("Zaten giris yaptýnýz- " + user.getFirstName() + " " + user.getLastName()); return;
        }
		else if(!InMemoryUserDao.userDb.contains(user)){
            System.out.println("Giris yapmanýz için kayýt olmalýsýnýz"); return;
        }else {
        System.out.println("Yanlýþ email ya da þifre");
        }
	}

	@Override
	public void update(User user) {
		User updateUser = getUser(user.getEmail());
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setPassword(user.getPassword());
		System.out.println("Baþarýyla güncellendi- " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public void deleted(User user) {
		InMemoryUserDao.userDb.remove(user);
		System.out.println("Baþarýyla silindi- " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public User getUser(String _eMail) {
		for (User user : userDb) {
			
			if (user.getEmail().equals(_eMail)) {
				return user;
			}
		}
		return null;
	
	}
	
	@Override
	public List<User> getAll() {
		return InMemoryUserDao.userDb;
	}
	
}