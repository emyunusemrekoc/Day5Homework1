package eCommerceProject;

import java.util.Scanner;

import eCommerceProject.business.abstracts.UserService;
import eCommerceProject.business.concretes.UserManager;
import eCommerceProject.core.abstracts.LogService;
import eCommerceProject.core.concretes.GoogleLogServiceAdapter;
import eCommerceProject.core.concretes.LogManager;
import eCommerceProject.dataAccess.concretes.InMemoryUserDao;
import eCommerceProject.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		InMemoryUserDao repository = new InMemoryUserDao();
		GoogleLogServiceAdapter googleLogServiceAdapter = new GoogleLogServiceAdapter();
		LogManager logManager = new LogManager();
		LogService logService = new LogManager();

		UserService userService = new UserManager(repository, googleLogServiceAdapter, logManager);

		User user1 = new User();
		User user2 = new User();

		System.out.println("\n**** KAYDOL****");

		System.out.println("Nasýl kayýt olmak istersiniz?\n" + "1 Kendi Mail Adresimle - 2 Google Hesabýmla");

		Scanner info = new Scanner(System.in);
		int choose = info.nextInt();

		switch (choose) {
		case 1:
			userService.register(user1);
			break;
		case 2:
			userService.registerWithGoogle(user1);
			
		}

		System.out.println("\n**** KAYDOL****");
		userService.register(user2);

		System.out.println("\n**** GÝRÝS YAP ****");
		userService.login(user1);

		System.out.println("\n**** GUNCELLE ****");
		userService.update(user1);

		System.out.println("\n**** SIL ****");
		userService.delete(user1);

	}

}
