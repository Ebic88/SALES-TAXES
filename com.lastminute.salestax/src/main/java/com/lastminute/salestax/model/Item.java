package com.lastminute.salestax.model;

import java.io.Serializable;

public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String description;

	private boolean taxable;

	private boolean imported;

	private Money unitPrice;

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	public boolean isTaxable() {
		return taxable;
	}

	public void setTaxable( boolean taxable ) {
		this.taxable = taxable;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported( boolean imported ) {
		this.imported = imported;
	}

	public Money getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice( Money unitPrice ) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Item [description=" + description + ", taxable=" + taxable + ", imported=" + imported + ", unitPrice=" + unitPrice + "]";
	}
}
