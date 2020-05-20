package codicifiscali;

public class CalculateSurenameCode {

	public String calculateSurenameCode(String surename) {

		surename = surename.replaceAll(" ", "");
		surename = surename.toLowerCase();

		String newSurenameCode = "";
		surename = surename.replaceAll(" ", ""); // Rimuovo eventuali spazi
		surename = surename.toLowerCase();

		String consonanti = getConsonanti(surename); // Ottengo tutte le consonanti e tutte le vocali della
														// surenameCode

		String vocali = getVocali(surename);

		// Controlla i possibili casi
		if (consonanti.length() == 3) { // La surenameCode contiene solo 3 consonanti, quindi ho gia' la modifica
			newSurenameCode = consonanti;
		}
		// Le consonanti non sono sufficienti, e la stinga e' pi˘ lunga o
		// uguale a 3 caratteri [aggiungo le vocali mancanti]
		else if ((consonanti.length() < 3) && (surename.length() >= 3)) {
			newSurenameCode = consonanti;
			newSurenameCode = aggiungiVocali(newSurenameCode, vocali);
		}
		// Le consonanti non sono sufficienti, e la surenameCode
		// contiene meno di 3 caratteri [aggiungo consonanti e vocali, e le x]
		else if ((consonanti.length() < 3) && (surename.length() < 3)) {
			newSurenameCode = consonanti;
			newSurenameCode += vocali;
			newSurenameCode = aggiungiX(newSurenameCode);
		}
		// Le consonanti sono in eccesso, prendo solo le
		// prime 3 nel caso del cognome; nel caso del nome la 0, 2, 3
		else if (consonanti.length() > 3) {
			// true indica il nome e false il cognome

			newSurenameCode = consonanti.substring(0, 3);
		}

		return newSurenameCode;
	}

	private String getVocali(String surenameCode) {
		surenameCode = surenameCode.replaceAll("[^aeiou]", "");
		return surenameCode;
	}

	private String getConsonanti(String surenameCode) {
		surenameCode = surenameCode.replaceAll("[aeiou]", "");
		return surenameCode;
	}

	private String aggiungiX(String surenameCode) {
		while (surenameCode.length() < 3) {
			surenameCode += "x";
		}
		return surenameCode;
	}

	private String aggiungiVocali(String surenameCode, String vocali) {
		int index = 0;
		while (surenameCode.length() < 3) {
			surenameCode += vocali.charAt(index);
			index++;
		}

		return surenameCode;
	}

}
