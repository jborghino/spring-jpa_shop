package fr.treeptik.shop.runtime;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		String choix = "";
		Scanner scanner = new Scanner(System.in);
		while (!choix.equalsIgnoreCase("q")) {

			choix = scanner.nextLine();

			switch (choix) {
			case "1":
				System.out.println("Traitement case 1");
				continue;
				

			case "2":
				System.out.println("Traitement case 2");
				continue;
				
			default:
				System.out.println("default");
				break;
			}
		}
	}

}
