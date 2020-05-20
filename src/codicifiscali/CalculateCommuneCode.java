package codicifiscali;

import java.io.FileInputStream;

import javax.xml.stream.*;

public class CalculateCommuneCode {

	private static String CODICE = "codice";

	public String calcoloCommuneCode(String comune) {

		int find = 0;
		int end = 1;
		String codiceTrovato = null;
		int trovato = 0;

		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		try {
			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader("comuni.xml", new FileInputStream("data/comuni.xml"));
		} catch (Exception e) {
			System.out.println("Errore nell'inizializzazione del reader:");
			System.out.println(e.getMessage());
		}

		do {
			try {
				xmlr.hasNext();
				{
					switch (xmlr.getEventType()) {
					case XMLStreamConstants.START_DOCUMENT:

						break;
					case XMLStreamConstants.START_ELEMENT:

						if (find == 1 && xmlr.getLocalName().equals(CODICE)) {
							trovato = 1;
						}

						break;
					case XMLStreamConstants.END_ELEMENT:

						break;
					case XMLStreamConstants.COMMENT:

						break;
					case XMLStreamConstants.CHARACTERS:
						if (xmlr.getText().trim().length() > 0) {

							if (xmlr.getText().equals(comune)) {
								find = 1;
							}

							if (trovato == 1) {
								codiceTrovato = codiceComune(xmlr);
								// System.out.println(codiceTrovato); test per vedere se stampa il codice del
								// comune
								end = 0;
							}

						}

						break;
					}
					try {
						xmlr.next();
					} catch (XMLStreamException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			} catch (XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (end != 0);
		return codiceTrovato;

	}

	private String codiceComune(XMLStreamReader xmlr) {
		// TODO Auto-generated method stub
		String codiceTrovato;
		codiceTrovato = xmlr.getText();
		return codiceTrovato;
	}

}
