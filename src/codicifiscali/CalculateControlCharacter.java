package codicifiscali;

public class CalculateControlCharacter {

	/**
	 * calcolare il codice di controllo
	 * 
	 * @param code
	 * @return
	 */
	public String calculateControlCharacter(String code) {

		// Passaggio 1 (suddivisione dispari e pari)
		String pari = UtilsParole.getStringaPari(code);
		String dispari = UtilsParole.getStringaDispari(code);

		// Passaggio 2 (conversione valori)
		int sommaDispari = conversioneCaratteriDispari(dispari);
		int sommaPari = conversioneCaratteriPari(pari);

		// Passaggio 3 (somma, divisione e conversione finale)
		int somma = sommaDispari + sommaPari;
		int resto = (int) somma % 26;
		char convertedRest = conversioneResto(resto);

		if (BuildConfig.DEBUG) {
			Log.d(Constants.LOG, "dispari: " + sommaDispari);
			Log.d(Constants.LOG, "pari: " + sommaPari);
			Log.d(Constants.LOG, "somma: " + somma);
			Log.d(Constants.LOG, "resto: " + resto);
			Log.d(Constants.LOG, "restoConvertito: " + convertedRest);

		}
		return Character.toString(convertedRest);
	}

	/**
	 * conversione dei caratteri dispari per il secondo passaggio della creazione
	 * del condice di controllo
	 * 
	 * @param string
	 * @return
	 */
	private int conversioneCaratteriDispari(String string) {

		int result = 0;

		for (int i = 0; i < string.length(); i++) {
			char carattere = string.charAt(i);
			switch (carattere) {

			case '0':
			case 'A':
				result += 1;
				break;

			case '1':
			case 'B':
				result += 0;
				break;

			case '2':
			case 'C':
				result += 5;
				break;

			case '3':
			case 'D':
				result += 7;
				break;

			case '4':
			case 'E':
				result += 9;
				break;

			case '5':
			case 'F':
				result += 13;
				break;

			case '6':
			case 'G':
				result += 15;
				break;

			case '7':
			case 'H':
				result += 17;
				break;

			case '8':
			case 'I':
				result += 19;
				break;

			case '9':
			case 'J':
				result += 21;
				break;

			case 'K':
				result += 2;
				break;

			case 'L':
				result += 4;
				break;

			case 'M':
				result += 18;
				break;

			case 'N':
				result += 20;
				break;

			case 'O':
				result += 11;
				break;

			case 'P':
				result += 3;
				break;

			case 'Q':
				result += 6;
				break;

			case 'R':
				result += 8;
				break;

			case 'S':
				result += 12;
				break;

			case 'T':
				result += 14;
				break;

			case 'U':
				result += 16;
				break;

			case 'V':
				result += 10;
				break;

			case 'W':
				result += 22;
				break;

			case 'X':
				result += 25;
				break;

			case 'Y':
				result += 24;
				break;

			case 'Z':
				result += 23;
				break;
			}
		}
		return result;

	}

	/**
	 * Conversione dei caratteri pari per il secondo passaggio della creazione del
	 * carattere di controllo.
	 * 
	 * @param string la stringa dei caratteri pari
	 * @return Numero intero convertito (parte pari).
	 */
	private int conversioneCaratteriPari(String string) {
		int risultato = 0;
		for (int i = 0; i < string.length(); i++) {
			char carattere = string.charAt(i);
			int numero = Character.getNumericValue(carattere);
			if (Character.isLetter(carattere)) {
				// Se è una lettera
				numero = carattere - 65;
				risultato += numero;
			}

			else {
				// Se è un numero
				risultato += numero;
			}
			if (BuildConfig.DEBUG) {
				Log.d(Constants.LOG, carattere + " -> " + (numero));
			}
		}
		return risultato;

	}

	/**
	 * Conversione del resto in un carattere per il terzo passaggio della creazione
	 * del carattere di controllo.
	 * 
	 * @param resto il resto da convertire.
	 * @return Resto convertito.
	 */

	private char conversioneResto(int resto) {
		return (char) (resto + 65);
	}

}
