package codicifiscali;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.stream.*;

public class WriteXml {

	public static void printXml() {

		XMLOutputFactory xmlof = null;
		XMLStreamWriter xmlw = null;
		ArrayList<FiscalCode> fiscalCode = new ArrayList<>();

		try {
			xmlof = XMLOutputFactory.newInstance();
			xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("codiciPersone.xml"), "utf-8");
			xmlw.writeStartDocument("utf-8", "1.0");
			xmlw.writeComment("PROGRAMMA ARNALDO");
			xmlw.writeComment("PERSONA");
			xmlw.writeComment("0");

		} catch (Exception e) {
			System.out.println("Errore nell'inizializzazione del writer:");
		}

		try {
			xmlw.writeStartElement("programmaArnaldo"); // scrittura del tag radice <programmaArnaldo>
			xmlw.writeComment("INIZIO LISTA"); // scrittura di un commento

			for (int i = 0; i < fiscalCode.length(); i++) {
				xmlw.writeStartElement("autore"); // scrittura del tag autore...
				xmlw.writeAttribute("id", Integer.toString(i)); // ...con attributo id...
//				xmlw.writeCharacters(fiscalCode); // ...e content dato
				xmlw.writeEndElement(); // chiusura di </autore>
			}

			xmlw.writeEndElement(); // chiusura di </programmaArnaldo>
			xmlw.writeEndDocument(); // scrittura della fine del documento
			xmlw.flush(); // svuota il buffer e procede alla scrittura
			xmlw.close(); // chiusura del documento e delle risorse impiegate
		} catch (Exception e) { // se c’è un errore viene eseguita questa parte
			System.out.println("Errore nella scrittura");
		}
	}
}
