package fr.treeptik.shop.runtime;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Client;
import fr.treeptik.shop.service.ClientService;

public class Runtime {

	public static void main(String[] args) throws ServiceException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		
		ClientService bean = context.getBean(ClientService.class);
		
		Client client = new Client();
		
		client.setNom("Dupont");
		client.setPrenom("Paul");
		client.setAdresse("665 Avenue du Prado, Marseille");
		
		
		bean.save(client);
	}
	
}
