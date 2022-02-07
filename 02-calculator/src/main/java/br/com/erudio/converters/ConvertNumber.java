package br.com.erudio.converters;

import org.springframework.stereotype.Component;

import br.com.erudio.validations.ValidationNumber;

@Component
public class ConvertNumber {
	
	private String strNumber;
	
	public ConvertNumber() {
		
	}
	
	public ConvertNumber(String strNumber) {
		this.strNumber = strNumber;
	}

	public String getStrNumber() {
		return strNumber;
	}
	
	public void setStrNumber(String strNumber) {
		this.strNumber = strNumber;
	}


	public Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (ValidationNumber.isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

}
