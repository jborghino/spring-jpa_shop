package fr.treeptik.shop.runtime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import fr.treeptik.shop.model.Commande;
import fr.treeptik.shop.model.DVD;
import fr.treeptik.shop.model.Livre;
import fr.treeptik.shop.service.ArticleService;
import fr.treeptik.shop.service.CDService;
import fr.treeptik.shop.service.ClientService;
import fr.treeptik.shop.service.CommandeService;
import fr.treeptik.shop.service.DVDService;
import fr.treeptik.shop.service.LivreService;

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

			switch (choix) {
			case "1":
				entity = "client";
				chooseAction(context, entity);
				break;

			case "2":
				entity = "article";
				chooseAction(context, entity);
				break;

			default:
				System.out.println("Choix inconnu");
				;
			}

		}
	}

	public static void chooseAction(ApplicationContext context, String entity) {
		ClientService clientService = context.getBean(ClientService.class);
		ArticleService articleService = context.getBean(ArticleService.class);
		CDService cdService = context.getBean(CDService.class);
		DVDService dvdService = context.getBean(DVDService.class);
		LivreService livreService = context.getBean(LivreService.class);

		String choix = "";

		while (!choix.equalsIgnoreCase("q")) {
			System.out.println("######## MENU ############");
			System.out.println("");
			System.out.println("1 - Créer");
			System.out.println("2 - Supprimer");
			System.out.println("3 - Modifier");
			System.out.println("4 - Lister");
			System.out.println("5 - Sélectionner");
			System.out.println("6 - Chercher");
			System.out.println("q - Quitter");

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
				switch (entity) {
				case "client":
					try {
						List<Client> findAll = clientService.findAll();
						for (Client client : findAll) {
							System.out.println(client);
						}
						System.out
								.println("Sélectionner le client à supprimer");
						String idString = scanner.nextLine();
						Integer id = Integer.parseInt(idString);
						Client client = clientService.findById(id);
						clientService.remove(client);
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "article":
					break;
				}

			} else if ("3".equals(choix)) {

			} else if ("4".equals(choix)) {
				switch (entity) {
				case "client":
					try {
						List<Client> findAll = clientService.findAll();
						for (Client client : findAll) {
							System.out.println(client);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

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
						if (!client.equals(null)) {
							clientChoice(client, scanner, context, entity);
						}

					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if ("6".equals(choix)) {
				switch (entity) {
				case "client":
					break;

				case "article":
					System.out.println("Choisir le type d'article : (CD/DVD/Livre/All)");
					String typeArticle = scanner.nextLine();

					System.out.println("Organiser la recherche par ordre alphabetique ? (y/n)");
					String ordreAlphabetique = scanner.nextLine();

					switch (typeArticle) {
					case "CD":
						System.out.println("Recherche par nom : ");
						String searchCD = scanner.nextLine();
						if ("n".equalsIgnoreCase(ordreAlphabetique)) {
							try {
								List<CD> recherche = cdService.recherche(searchCD);
								for (CD cd : recherche) {
									System.out.println(cd);
								}
							} catch (ServiceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else if ("y".equalsIgnoreCase(ordreAlphabetique)) {
							try {
								List<CD> rechercheTrie = cdService.rechercheTrie(searchCD);
								for (CD cd : rechercheTrie) {
									System.out.println(cd);
								}
							} catch (ServiceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							continue;
						}
						break;

					case "DVD":
						System.out.println("Recherche par nom : ");
						String searchDVD = scanner.nextLine();
						if ("n".equalsIgnoreCase(ordreAlphabetique)) {
							try {
								List<DVD> recherche = dvdService.recherche(searchDVD);
								for (DVD dvd : recherche) {
									System.out.println(dvd);
								}
							} catch (ServiceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else if ("y".equalsIgnoreCase(ordreAlphabetique)) {
							try {
								List<DVD> rechercheTrie = dvdService.rechercheTrie(searchDVD);
								for (DVD dvd : rechercheTrie) {
									System.out.println(dvd);
								}
							} catch (ServiceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							continue;
						}
						break;

					case "Livre":
						System.out.println("Recherche par nom : ");
						String searchLivre = scanner.nextLine();
						if ("n".equalsIgnoreCase(ordreAlphabetique)) {
							try {
								List<Livre> recherche = livreService.recherche(searchLivre);
								for (Livre livre : recherche) {
									System.out.println(livre);
								}
							} catch (ServiceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else if ("y".equalsIgnoreCase(ordreAlphabetique)) {
							try {
								List<Livre> rechercheTrie = livreService.rechercheTrie(searchLivre);
								for (Livre livre : rechercheTrie) {
									System.out.println(livre);
								}
							} catch (ServiceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							continue;
						}
						break;

					case "All":
						System.out.println("Recherche par nom : ");
						String searchArticle = scanner.nextLine();
						if ("n".equalsIgnoreCase(ordreAlphabetique)) {
							try {
								List<Article> recherche = articleService.recherche(searchArticle);
								for (Article article : recherche) {
									System.out.println(article);
								}
							} catch (ServiceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else if ("y".equalsIgnoreCase(ordreAlphabetique)) {
							try {
								List<Article> rechercheTrie = articleService.rechercheTrie(searchArticle);
								for (Article article : rechercheTrie) {
									System.out.println(article);
								}
							} catch (ServiceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							continue;
						}
						break;
					default:
						break;
					}
					break;
				}

			}
		}
	}

	public static void clientChoice(Client client, Scanner scanner,
			ApplicationContext context, String entity) {
		ArticleService articleService = context.getBean(ArticleService.class);
		Commande commande = new Commande();
		List<Article> listArticle = new ArrayList<>();

		String choix = "";
		System.out.println("#########");
		System.out.println("Client sélectionner : " + client);

		while (!choix.equalsIgnoreCase("q")) {
			System.out.println("Choix :");
			System.out.println("1 - Ajouter des articles");
			System.out.println("2 - Valider la commande");
			System.out.println("q - Quitter");
			choix = scanner.nextLine();

			switch (choix) {
			case "1":
				commande = ajouterArticleCommande(scanner, context,
						articleService, listArticle, commande);
				//
				// System.out.println("Ajout d'articles");
				// System.out.println("v - Valider la commande");
				// System.out.println("a - Annuler la commande");
				// System.out.println("N'importe quelle touche pour ajouter d'autre article");
				// String decision;
				// decision = scanner.nextLine();
				//
				// if("v".equalsIgnoreCase(decision)){
				//
				// } else if("a".equalsIgnoreCase(decision)){
				//
				// } else {
				// ajouterArticleCommande(scanner, context, articleService,
				// listArticle, commande);
				// }
				break;

			case "2":

				if (commande == null) {
					System.out.println("Votre commande est vide");
				} else {
					System.out.println("validation de la commande");
					List<Article> articles = commande.getArticles();
					for (Article article : articles) {
						System.out.println(article);
					}
					validerCommande(scanner, context, commande, client);
					commande = null;
				}

				break;
			default:
				break;
			}

		}
	}

	public static Commande ajouterArticleCommande(Scanner scanner,
			ApplicationContext context, ArticleService articleService,
			List<Article> listArticle, Commande commande) {
		System.out.println("Press q pour sortir de la sélection des articles");
		String choix = "";

		try {
			List<Article> articles = articleService.findAll();
			for (Article article : articles) {
				System.out.println(article);
			}

			while (!choix.equalsIgnoreCase("q")) {
				System.out.println("Sélectionner l'id de l'article à ajouter");
				choix = scanner.nextLine();
				Integer id = 0;
				try {
					id = Integer.parseInt(choix);
				} catch (Exception e) {
					// TODO: handle exception
				}
				Article article = articleService.findById(id);
				if (article != null) {
					listArticle.add(article);
				}

			}
			
			Double prix = 0.0;
			for (Article article : listArticle) {
				prix += article.getPrix();
			}
			
			commande.setTotal(prix);

			commande.setArticles(listArticle);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return commande;
	}

	public static Commande validerCommande(Scanner scanner,
			ApplicationContext context, Commande commande, Client client) {
		CommandeService commandeService = context
				.getBean(CommandeService.class);
		ClientService clientService = context.getBean(ClientService.class);

		System.out.println("Saisir l'adresse de livraison");
		String adresse = scanner.nextLine();
		commande.setAdresse(adresse);

		System.out.println("Saisir la date de livraison (format : JJ/MM/AAAA)");
		System.out.println("Exemple : 01/01/2000");
		String dateLivraisonString = scanner.nextLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = dateFormat.parse(dateLivraisonString);
			commande.setDateLivraison(date);
		} catch (ParseException e) {
			e.printStackTrace();
			try {
				throw new Exception("Erreur saisie");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		try {
			List<Commande> commandes = new ArrayList<>();
			commandes.add(commande);
			client.setCommandes(commandes);
			commandeService.save(commande);
			clientService.update(client);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return commande;
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
