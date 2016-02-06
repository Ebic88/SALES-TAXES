package com.lastminute.salestax.tax.rate;

public enum TaxRate {
	NO_TAX("0"),IMPORTED_TAX("0.05"),BASE_TAX("0.1"),IMPORTED_BASE_TAX("0.15"); 
	
	private String rate;

	private TaxRate( String taxRate ) {
		this.rate = taxRate;
	}

	public String getTaxRate() {
		return rate;
	}
	
}
