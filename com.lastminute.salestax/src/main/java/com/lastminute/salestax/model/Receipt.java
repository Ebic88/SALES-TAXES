package com.lastminute.salestax.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class Receipt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6869087804522668918L;

	private List<SalesLineItem> salesLineItems;

	private Money total;

	private Money tax;

	public Receipt() {
		this.salesLineItems = new LinkedList<SalesLineItem>();
		total = new Money();
		tax = new Money();
	}

	public List<SalesLineItem> getSalesLineItems() {
		return salesLineItems;
	}

	public Money getTotal() {
		return total;
	}

	public void setTotal( Money total ) {
		this.total = total;
	}

	public Money getTax() {
		return tax;
	}

	public void setTax( Money tax ) {
		this.tax = tax;
	}

	public String print() {
		StringBuilder sbInput = new StringBuilder();
		StringBuilder sbOutput = new StringBuilder();
		String pattern = "#0.##";
		DecimalFormat formatter = new DecimalFormat( pattern );
		for ( SalesLineItem s : salesLineItems ) {
			sbInput.append( s.getQuantity() );
			sbInput.append( " " );
			sbInput.append( s.getItem().getDescription() );
			sbInput.append( " " );
			String uniPrice = formatter.format( s.getItem().getUnitPrice().getAmount().doubleValue() );
			sbInput.append( uniPrice );
			sbInput.append( "\n" );

			sbOutput.append( s.getQuantity() );
			sbOutput.append( " " );
			sbOutput.append( s.getItem().getDescription() );
			sbOutput.append( " " );
			String price = formatter.format( s.getPrice().getAmount().doubleValue() );
			sbOutput.append( price );
			sbOutput.append( "\n" );

		}
		sbOutput.append( "\n" );
		sbOutput.append( "Sales Taxes: " );
		String taxFormat = formatter.format( this.tax.getAmount().doubleValue() );
		sbOutput.append( taxFormat );
		sbOutput.append( "\n" );
		String totalFormat = formatter.format( this.total.getAmount().doubleValue() );
		sbOutput.append( "Total: " );
		sbOutput.append( totalFormat );
		sbInput.append( "-------------" );
		sbInput.append( "\n" );
		sbInput.append( sbOutput.toString() );
		return sbInput.toString();
	}

	@Override
	public String toString() {
		return "Receipt [salesLineItems=" + salesLineItems + ", total=" + total + ", tax=" + tax + "]";
	}

}
