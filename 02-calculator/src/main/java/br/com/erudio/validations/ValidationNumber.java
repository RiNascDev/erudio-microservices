package br.com.erudio.validations;

public class ValidationNumber {
	
	private String strNumber;
	
	public ValidationNumber(String strNumber) {
		this.strNumber = strNumber;
	}


	public String getStrNumber() {
		return strNumber;
	}


	public void setStrNumber(String strNumber) {
		this.strNumber = strNumber;
	}



	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
