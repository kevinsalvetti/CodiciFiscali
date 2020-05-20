package codicifiscali;

public class CalculateNameCode {

	public String calculateNameCode(String name) {

		name = name.replaceAll(" ", "");
		name = name.toLowerCase();

		String newNameCode = "";
		name = name.replaceAll(" ", ""); // Rimuovo eventuali spazi
		name = name.toLowerCase();

		String consonanti = getConsonanti(name); // Ottengo tutte le consonanti e tutte le vocali della nameCode

		String vocali = getVocali(name);

		// Controlla i possibili casi
		if (consonanti.length() == 3) { // La nameCode contiene solo 3 consonanti, quindi ho gia' la modifica
			newNameCode = consonanti;
		}
		// Le consonanti non sono sufficienti, e la stinga e' pi˘ lunga o
		// uguale a 3 caratteri [aggiungo le vocali mancanti]
		else if ((consonanti.length() < 3) && (name.length() >= 3)) {
			newNameCode = consonanti;
			newNameCode = aggiungiVocali(newNameCode, vocali);
		}
		// Le consonanti non sono sufficienti, e la nameCode
		// contiene meno di 3 caratteri [aggiungo consonanti e vocali, e le x]
		else if ((consonanti.length() < 3) && (name.length() < 3)) {
			newNameCode = consonanti;
			newNameCode += vocali;
			newNameCode = aggiungiX(newNameCode);
		}
		// Le consonanti sono in eccesso, prendo solo le
		// prime 3 nel caso del cognome; nel caso del nome la 0, 2, 3
		else if (consonanti.length() > 3) {

			newNameCode = consonanti.charAt(0) + "" + consonanti.charAt(2) + "" + consonanti.charAt(3);
		}

		return newNameCode;
	}

	private String getVocali(String nameCode) {
		nameCode = nameCode.replaceAll("[^aeiou]", "");
		return nameCode;
	}

	private String getConsonanti(String nameCode) {
		nameCode = nameCode.replaceAll("[aeiou]", "");
		return nameCode;
	}

	private String aggiungiX(String nameCode) {
		while (nameCode.length() < 3) {
			nameCode += "x";
		}
		return nameCode;
	}

	private String aggiungiVocali(String nameCode, String vocali) {
		int index = 0;
		while (nameCode.length() < 3) {
			nameCode += vocali.charAt(index);
			index++;
		}

		return nameCode;
	}

}
