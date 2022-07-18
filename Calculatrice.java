package fr.eni.ecole.calculatrice;

import java.math.BigInteger;
import java.util.Scanner;

public class Calculatrice {

	public static Scanner s = new Scanner(System.in); 
	public static final String OPERATEUR = "+-/*%q";
	
	public static void main(String[] args) {
		
		int valeur1 = saisirEntier();
		char operateur; 
		
		do {
			
			operateur = saisirOperateur();
			
			try {
				if(operateur != 'q') {
					int resultat = 0; 
					int valeur2 = saisirEntier();
					switch (operateur) {
					case '+':
					resultat = Operation.ajouter(valeur1, valeur2);
					break;
					case '-':
					resultat = Operation.soustraire(valeur1, valeur2);
					break;
					case '*':
					resultat = Operation.multiplier(valeur1, valeur2);
					break;
					case '/':
					resultat = valeur1 / valeur2;
					break;
					case '%':
					resultat = valeur1 % valeur2;
					break;
					}
					System.out.printf("%d %s %d = %d%n", valeur1,
					operateur, valeur2, resultat);
					valeur1 = resultat;
				}
			} catch (DepassementCapaciteException e){
				System.err.println(e.getMessage()); 
			} catch (ArithmeticException e) {
				System.err.println("La division par zéro n'est pas définie"); 
			}
		
			
		} while (operateur != 'q');

	}
	
	private static int saisirEntier() {
		System.out.println("Saisir un nombre entier");
		int valeur = 0;
		String valS = s.nextLine();
		boolean saisieOk = false;
		do {
		try {
		valeur = Integer.parseInt(valS);
		saisieOk = true;
		} catch (NumberFormatException e) {
		try {
		new BigInteger(valS);
		System.err.println(
		"la valeur saisie dépasse les capacités de cette calculatrice. Réessayez...");
		} catch (NumberFormatException f) {
		System.err.println("Saisie incorrecte. Réessayez...");
		}
		valS = s.nextLine();
		}
		} while (!saisieOk);
		return valeur;
		}
	
	private static char saisirOperateur() {
		char operateur; 
		String saisie; 
		boolean saisieOk; 
		
		do {
			System.out.println("Opérateur ? (+ - * / % ou q pour quitter");
			saisie = s.nextLine();
			saisieOk = saisie.length() == 1 && Calculatrice.OPERATEUR.indexOf(saisie.charAt(0)) != -1 ;
			if (!saisieOk) {
				System.out.println("Opérateur non valide");
			}
		} while (!saisieOk); 
		
		operateur = saisie.charAt(0);
		return operateur;
		
	}

}
