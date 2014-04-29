package fr.treeptik.shop.runtime;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.shop.exception.DAOException;
import fr.treeptik.shop.exception.ServiceException;
import fr.treeptik.shop.model.Article;
import fr.treeptik.shop.model.CD;
import fr.treeptik.shop.model.Client;
import fr.treeptik.shop.model.DVD;
import fr.treeptik.shop.model.Livre;
import fr.treeptik.shop.service.ArticleService;
import fr.treeptik.shop.service.ClientService;

public class Runtime {

	public static void main(String[] args) throws ServiceException {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		try {
			dynamicChoice(context);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public static void dynamicChoice(ApplicationContext context)
			throws DAOException {

		String choix = "";
		String entity = "";

		while (!choix.equalsIgnoreCase("q")) {

			System.out.println("");
			System.out.println("1 - CLIENT ");
			System.out.println("2 - ARTICLE ");
			System.out.println("q - Quitter");

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			choix = scanner.nextLine();

			if ("1".equals(choix)) {
				entity = "client";
				chooseAction(context, entity);
			} else if ("2".equals(choix)) {
				entity = "article";
				chooseAction(context, entity);
			}
		}
	}

	public static void chooseAction(ApplicationContext context, String entity) {
		ClientService clientService = context.getBean(ClientService.class);
		ArticleService articleService = context.getBean(ArticleService.class);

		String choix = "";

		while (!choix.equalsIgnoreCase("q")) {
			System.out.println("######## MENU ############");
			System.out.println("");
			System.out.println("1 - Créer");
			System.out.println("2 - Supprimer");
			System.out.println("3 - Modifier");
			System.out.println("4 - Lister");
			System.out.println("5 - Sélectionner");
			System.out.println("q - Quitter");

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			choix = scanner.nextLine();

			if ("1".equals(choix)) {
				switch (entity) {
				case "client":
					Client client = new Client();
					System.out.println("Saisir le nom");
					String nom = scanner.nextLine();
					client.setNom(nom);
					System.out.println("Saisir le prenom");
					String prenom = scanner.nextLine();
					client.setPrenom(prenom);
					System.out.println("Saisir l'adresse");
					String adresse = scanner.nextLine();
					client.setAdresse(adresse);
					try {
						clientService.save(client);
					} catch (ServiceException e) {
						e.printStackTrace();
					}
					try {
						dynamicChoice(context);
					} catch (DAOException e2) {
						e2.printStackTrace();
					}
					break;

				case "article":
					Article article = choixArticle(scanner, context, entity);
					try {
						articleService.save(article);
					} catch (ServiceException e) {
						e.printStackTrace();
					}
					try {
						dynamicChoice(context);
					} catch (DAOException e2) {
						e2.printStackTrace();
					}

				}
			} else if ("2".equals(choix)) {

			} else if ("3".equals(choix)) {

			} else if ("4".equals(choix)) {

			} else if ("5".equals(choix)) {
				switch (entity) {
				case "client":
					try {
						List<Client> findAll = clientService.findAll();
						for (Client client : findAll) {
							System.out.println(client);
						}
					} catch (ServiceException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Saisir l'id du client");
					String idString = scanner.nextLine();
					Integer id = Integer.parseInt(idString);
					try {
						Client client = clientService.findById(id);
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static Article choixArticle(Scanner scanner,
			ApplicationContext context, String entity) {
		System.out.println("Saisir le type d'article");
		System.out.println("1 - Livre");
		System.out.println("2 - CD");
		System.out.println("3 - DVD");
		System.out.println("r - Retour");
		String typeArtice = scanner.nextLine();
		if ("1".equals(typeArtice)) {
			Livre livre = new Livre();
			System.out.println("Saisir le titre");
			String titre = scanner.nextLine();
			livre.setTitre(titre);
			System.out.println("Saisir l'auteur");
			String auteur = scanner.nextLine();
			livre.setAuteur(auteur);
			System.out.println("Saisir le prix");
			String prixString = scanner.nextLine();
			Double prix = Double.parseDouble(prixString);
			livre.setPrix(prix);
			System.out.println("Saisir le nombre de pages");
			String nbPagesString = scanner.nextLine();
			Integer nbPages = Integer.parseInt(nbPagesString);
			livre.setNbPages(nbPages);
			return livre;
		} else if ("2".equals(typeArtice)) {
			CD cd = new CD();
			System.out.println("Saisir le titre");
			String titre = scanner.nextLine();
			cd.setTitre(titre);
			System.out.println("Saisir l'auteur");
			String auteur = scanner.nextLine();
			cd.setAuteur(auteur);
			System.out.println("Saisir le prix");
			String prixString = scanner.nextLine();
			Double prix = Double.parseDouble(prixString);
			cd.setPrix(prix);
			return cd;
		} else if ("3".equals(typeArtice)) {
			DVD dvd = new DVD();
			System.out.println("Saisir le titre");
			String titre = scanner.nextLine();
			dvd.setTitre(titre);
			System.out.println("Saisir le prix");
			String prixString = scanner.nextLine();
			Double prix = Double.parseDouble(prixString);
			dvd.setPrix(prix);
			return dvd;
		} else if ("r".equalsIgnoreCase(typeArtice)) {
			chooseAction(context, entity);
		} else {
			choixArticle(scanner, context, typeArtice);
		}

		return null;
	}

}
