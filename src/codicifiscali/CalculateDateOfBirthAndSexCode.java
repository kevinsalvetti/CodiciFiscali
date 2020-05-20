package codicifiscali;



public class CalculateDateOfBirthAndSexCode {

	public String calcuDateOfBirthAndSexCode(String year, String month, String day) {

		String dateOfBirthAndSexCode;
		String yearCode;
		String monthCode;
		String dayAndSexCode;

		yearCode = calculateYearCode(year);
		monthCode = calculateMonthCode(month);
		dayAndSexCode = dateOfBirthAndSexCode(day);
		dateOfBirthAndSexCode = yearCode + monthCode + dayAndSexCode;

		return dateOfBirthAndSexCode;

	}

	/**
	 * metodo per calcolare il codice dell'anno
	 * 
	 * @param year
	 * @return
	 */
	public String calculateYearCode(String year) {
		String part1 = year;
		return part1.substring(2);
	}

	/**
	 * metodo per calcolare il codice del mese
	 * 
	 * @param month
	 * @return
	 */
	public String calculateMonthCode(String month) {
		String result;

		switch (month) {

		case "01":
			result = "A";
			break;

		case "02":
			result = "B";
			break;

		case "03":
			result = "C";
			break;

		case "04":
			result = "D";
			break;

		case "05":
			result = "E";
			break;

		case "06":
			result = "H";
			break;

		case "07":
			result = "L";
			break;

		case "08":
			result = "M";
			break;

		case "09":
			result = "P";
			break;

		case "10":
			result = "R";
			break;

		case "11":
			result = "S";
			break;

		case "12":
			result = "T";
			break;

		default:
			result = "";
			break;
		}
		return result;

	}

	String sex = null;

	public boolean storageSex(String sex) {

		if (sex == "F") {
			return true;
		} else
			return false;
	}

	/**
	 * metodo per calcolare il codice del giorno di nascita e il sesso
	 * 
	 * @param part3
	 * @param sex
	 * @return
	 */

	public String dateOfBirthAndSexCode(String day) {

		String part3 = day;
//		String part3 = String.format("%02s", day);

		if (storageSex(sex) == true) {

			int integerDayCode;
			integerDayCode = Integer.parseInt(part3);
			integerDayCode += 40;
			part3 = Integer.toString(integerDayCode);
		}
		return part3;
	}

	public String splitDate(String data) {
		String anno = null;
		String mese = null;
		String giorno = null;

		String string = data;
		String[] parts = string.split("-", 3);
		String part1 = parts[0];
		String part2 = parts[1];
		String part3 = parts[2];

		anno = calculateYearCode(part1);
		mese = calculateMonthCode(part2);
		giorno = dateOfBirthAndSexCode(part3);
		
		return anno + mese + giorno;
		

	
	}

}
