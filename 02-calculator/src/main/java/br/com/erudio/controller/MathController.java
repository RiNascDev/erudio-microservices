package br.com.erudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.ConvertNumber;
import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.validations.ValidationNumber;

@RestController
public class MathController {
	
	@Autowired
	ConvertNumber convert;
	
	@Autowired
	SimpleMath math;
	
	//soma
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) {
		
		if (!ValidationNumber.isNumeric(numberOne) || !ValidationNumber.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
			
		}
		return math.sum(convert.convertToDouble(numberOne), convert.convertToDouble(numberTwo));
		
	}
	
	//subtração
	@RequestMapping(value = "/minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double minus (
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) {
		
		if (!ValidationNumber.isNumeric(numberOne) || !ValidationNumber.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");	
		}
		
		return math.minus(convert.convertToDouble(numberOne), convert.convertToDouble(numberTwo));
		
	}
	
	
	//Multiplicação
	@RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) {
		
		if (!ValidationNumber.isNumeric(numberOne) || !ValidationNumber.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");	
		}
		
		return math.multi(convert.convertToDouble(numberOne), convert.convertToDouble(numberTwo));
		
	}
	
	//Divisão
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) {
		
		if (!ValidationNumber.isNumeric(numberOne) || !ValidationNumber.isNumeric(numberTwo) || convert.convertToDouble(numberTwo)<=0) {
			throw new UnsuportedMathOperationException("Please set a numeric value and numberTwo greater than zero!");	
		}
		
		return math.div(convert.convertToDouble(numberOne), convert.convertToDouble(numberTwo));
		
	}
	
	//Média
	@RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) {
		
		if (!ValidationNumber.isNumeric(numberOne) || !ValidationNumber.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");	
		}
		
		return math.avg(convert.convertToDouble(numberOne), convert.convertToDouble(numberTwo));
		
	}
	
	//Raiz quadrada
	@RequestMapping(value = "sqr/{numberOne}", method = RequestMethod.GET)
	public Double square(
			@PathVariable("numberOne") String numberOne) {
		
		if (!ValidationNumber.isNumeric(numberOne) || convert.convertToDouble(numberOne) <0) {
			throw new UnsuportedMathOperationException("Please set a numeric value and number greater than or equal to zero");	
		}
		return math.sqr(convert.convertToDouble(numberOne));
		
	}

//	private Double convertToDouble(String strNumber) {
//		if(strNumber == null) return 0D;
//		String number = strNumber.replaceAll(",", ".");
//		if (isNumeric(number)) return Double.parseDouble(number);
//		return 0D;
//	}
//
//	private boolean isNumeric(String strNumber) {
//		if(strNumber == null) return false;
//		String number = strNumber.replaceAll(",", ".");
//		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
//	}
	
	

}
