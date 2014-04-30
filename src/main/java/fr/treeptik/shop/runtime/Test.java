package fr.treeptik.shop.runtime;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.CD;
import fr.treeptik.shop.service.CDService;

public class Test {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		CDService cdService = context.getBean(CDService.class);
		
		System.out.println("pattern : ");
		String choix="";
		Scanner scanner = new Scanner(System.in);
		choix = scanner.nextLine();
		
		try {
			List<CD> recherche = cdService.recherche(choix);
			for (CD cd : recherche) {
				System.out.println(cd);
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
