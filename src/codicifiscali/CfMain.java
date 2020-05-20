package codicifiscali;

import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class CfMain {

	private static String BENVENUTO = "\nBENVENUTO NEL PROGRAMMA DI CREAZIONE DEL CODICE FISCALE\n";
	private static String TITOLO = "Elenco Funzionalita";
	private static String[] VOCIMENU = { "Avvio del Programma" };
	private static String MESS_USCITA = "Fine Programma";
	private static String MESS_TRYAGAIN = "SELEZIONA UN' ALTRO INPUT";
	private static String MESS_ERRORE = "!!!! ATTENZIONE !!!!\nINPUT NON VALIDO\n";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean fineProgramma = false;

		System.out.println(BENVENUTO);

		ReadXml leggi = new ReadXml();

		MyMenu menuMain = new MyMenu(TITOLO, VOCIMENU);

		do {

			int selezione = menuMain.scegli();
			fineProgramma = eseguiFunzioneScelta(selezione, leggi);

		} while (!fineProgramma);
		System.out.println(MESS_USCITA);
	}

	private static boolean eseguiFunzioneScelta(int selezione, ReadXml leggi) {
		// TODO Auto-generated method stub

		switch (selezione) {

		case 0:
			return InputDati.yesOrNo(MESS_USCITA);
		case 1:
			ArrayList<FiscalCode> persona = new ArrayList<FiscalCode>();
			try {
				leggi.leggiInputPersoneXML(persona);
			} catch (XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			leggi.stampaArray();

			break;
		default:
			System.out.println(MESS_ERRORE);
			System.out.println(MESS_TRYAGAIN);
			break;

		}
		return false;

	}

}
