package fr.eni.ecole.calculatrice;

public class Operation {

	public static int ajouter(int a, int b) throws DepassementCapaciteException {
		int resInt = a + b;
		long resLong = (long) a + b; 
		if (resInt != resLong) {
			throw new DepassementCapaciteException("Le résultat dépasse la capacité de la calculatrice"); 
		}
		return resInt;
	}
	
	public static int soustraire(int a, int b) throws DepassementCapaciteException {
		int resInt = a - b;
		long resLong = (long) a - b; 
		if (resInt != resLong) {
			throw new DepassementCapaciteException("Le résultat dépasse la capacité de la calculatrice"); 
		}
		return resInt;
	}
	
	public static int multiplier(int a, int b) throws DepassementCapaciteException {
		int resInt = a * b;
		long resLong = (long) a * b; 
		if (resInt != resLong) {
			throw new DepassementCapaciteException("Le résultat dépasse la capacité de la calculatrice"); 
		}
		return resInt;
	}
}
