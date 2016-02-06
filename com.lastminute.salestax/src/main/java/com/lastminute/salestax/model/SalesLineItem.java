package com.lastminute.salestax.model;

import java.io.Serializable;
import com.lastminute.salestax.tax.ISaleTaxStrategy;
import com.lastminute.salestax.tax.SaleTaxFactory;

public class SalesLineItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7792976766472698026L;
	
	private Item item;
	private int quantity;

	public Item getItem() {
		return item;
	}

	public void setItem( Item item ) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity( int quantity ) {
		this.quantity = quantity;
	}

	public Money getTax() {
		SaleTaxFactory sf = SaleTaxFactory.getIstance();
		ISaleTaxStrategy saleTaxStrategy = sf.getSaleTaxStrategy( this.getItem() );
		return saleTaxStrategy.calculateTax( this );
	}

	public Money getPrice() {
		Money tax = this.getTax();
		Money priceWithTax = tax.add( this.getItem().getUnitPrice() );
		return priceWithTax.multiply( this.quantity );
	}

	@Override
	public String toString() {
		return "SalesLineItem [item=" + item + ", quantity=" + quantity + "]";
	}

}
