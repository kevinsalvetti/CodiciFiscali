package codicifiscali;

import java.io.*;
import java.util.ArrayList;

import javax.xml.stream.*;

public class ReadXml {

	private static String TROVATO_NOME = "nome";
	private static String TROVATO_COGNOME = "cognome";
	private static String TROVATO_COMUNE = "comune_nascita";
	private static String TROVATO_DATA = "data_nascita";
	private static String TROVATO_SEX = "sesso";

	CalculateNameCode calcolaNome = new CalculateNameCode();
	CalculateSurenameCode calcolaCognome = new CalculateSurenameCode();
	CalculateCommuneCode calcolaComune = new CalculateCommuneCode();
	CalculateDateOfBirthAndSexCode calcolaDataeSesso = new CalculateDateOfBirthAndSexCode();

	public void leggiInputPersoneXML(ArrayList<FiscalCode> persona) throws XMLStreamException {
		
		FiscalCode codiceFiscale = null;
		
		int find = 0;
		int j = 0;
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		
		try {
			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader("inputPersone.xml", new FileInputStream("data/inputPersone.xml"));
		} catch (Exception e) {
			System.out.println("Errore nell'inizializzazione del reader:");
			System.out.println(e.getMessage());
		}

		while (xmlr.hasNext()) {
			switch (xmlr.getEventType()) {
			case XMLStreamConstants.START_DOCUMENT:
				System.out.println("Start Read Doc " + "inputPersone.xml");
				break;
			case XMLStreamConstants.START_ELEMENT:
				System.out.println(xmlr.getLocalName());

				// Metodo che "Trova" il nome, cognome , comune ,data
				find = trovato(find, xmlr);
				if (find == 1) {
					 codiceFiscale = new FiscalCode(0, null, null, null, null);
					 persona.add(codiceFiscale);
					 
				}
				
				for (int i = 0; i < xmlr.getAttributeCount(); i++)
					System.out.printf(" =>%s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
				break;
			case XMLStreamConstants.END_ELEMENT:
				// System.out.println("END-Tag " + xmlr.getLocalName());
				break;
			case XMLStreamConstants.COMMENT:
				// System.out.println("// commento " + xmlr.getText());
				break;
			case XMLStreamConstants.CHARACTERS:
				if (xmlr.getText().trim().length() > 0)
					System.out.println("-> " + xmlr.getText());

				// Metodo Che inizia a creare il to String
				startCreateCf(find, xmlr,codiceFiscale);
				find = 0;

				break;
			}

			xmlr.next();
		}
	}


	private void startCreateCf(int find, XMLStreamReader xmlr ,FiscalCode codiceFiscale) {

		
		
		String nome;
		String cognome;
		String comune;
		String data;

		switch (find) {

		case 1:
			nome = calcolaNome.calculateNameCode(xmlr.getText());// xmlr.getText()
			codiceFiscale.setName(nome);
			break;

		case 2:
			cognome = calcolaCognome.calculateSurenameCode(xmlr.getText());
			codiceFiscale.setSurename(cognome);
			break;
		case 3:
			comune = calcolaComune.calcoloCommuneCode(xmlr.getText()); // "ABANO TERME" // prova primo comune nella //
																		// lista xml
			codiceFiscale.setCommune(comune);
			break;
		case 4:
			calcolaDataeSesso.storageSex(xmlr.getText());
			break;
		case 5:
			data = calcolaDataeSesso.splitDate(xmlr.getText());
			codiceFiscale.setData(data);
			
			addArray(codiceFiscale);

			break;

		}

	}

//	private void newFiscalCode(String nome, String cognome, String comune, String data) {
//
//		FiscalCode codiceFiscale = new FiscalCode(0, nome, cognome, comune, data);
//
//		codiceFiscale.setName(nome);
//
//		codiceFiscale.setSurename(cognome);
//
//		codiceFiscale.setCommune(comune);
//
//		codiceFiscale.setData(data);
//
//		addArray();
//
//	}

	static int count = 0;

	ArrayList<FiscalCode> ArrayCodiciFiscali = new ArrayList<FiscalCode>();

	public void stampaArray() {

		System.out.println(ArrayCodiciFiscali.toString());

	}

	private void addArray(FiscalCode codiceFiscale) {
		ArrayCodiciFiscali.add(count, codiceFiscale);
		count++;
	}

	private int trovato(int find, XMLStreamReader xmlr) {
		if (xmlr.getLocalName() == TROVATO_NOME)
			find = 1;

		if (xmlr.getLocalName() == TROVATO_COGNOME)
			find = 2;
		if (xmlr.getLocalName() == TROVATO_COMUNE)
			find = 3;
		if (xmlr.getLocalName() == TROVATO_SEX)
			find = 4;
		if (xmlr.getLocalName() == TROVATO_DATA)
			find = 5;
		return find;
	}

}
