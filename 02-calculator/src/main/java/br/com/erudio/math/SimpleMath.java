package br.com.erudio.math;

import org.springframework.stereotype.Service;

@Service
public class SimpleMath {
	
	public SimpleMath() {
		
	}
	
	public Double sum (Double n1, Double n2) {
		return n1+n2;
	}
	
	public Double minus (Double n1, Double n2) {
		return n1-n2;
	}
	
	public Double multi (Double n1, Double n2) {
		return n1*n2;
	}
	
	public Double div (Double n1, Double n2) {
		return n1/n2;
	}
	
	public Double avg (Double n1, Double n2) {
		return (n1+n2)/2;
	}
	
	public Double sqr (Double n) {
		return Math.sqrt(n);
	}

	

}
