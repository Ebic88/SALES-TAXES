package com.lastminute.salestax.register;

import java.util.LinkedList;
import java.util.List;
import com.lastminute.salestax.model.Item;
import com.lastminute.salestax.model.Money;
import com.lastminute.salestax.model.Receipt;
import com.lastminute.salestax.model.SalesLineItem;
import com.lastminute.salestax.model.builder.ItemBuilder;
import com.lastminute.salestax.model.builder.ReceiptBuilder;
import com.lastminute.salestax.model.builder.SalesLineItemBuilder;

public class Register {

	private static Register instance = null;

	private List<SalesLineItem> salesLineItems = null;

	protected Register() {
		this.salesLineItems = new LinkedList<SalesLineItem>();
	}

	public static Register getInstance() {
		if ( instance == null ) {
			instance = new Register();
		}
		return instance;
	}

	public void addSalesLineItem( SalesLineItem salesLineItem ) {
		this.salesLineItems.add( salesLineItem );
	}

	public void addSalesLineItem( Item item, int quantity ) {
		SalesLineItemBuilder salesBuilder = new SalesLineItemBuilder();
		salesBuilder.withItem( item ).withQuantity( quantity );
		salesLineItems.add( salesBuilder.build() );
	}

	public void addSalesLineItem( String description, boolean taxable, boolean imported, Money unitPrice, int quantity ) {
		ItemBuilder itemBuilder = new ItemBuilder();
		itemBuilder.withDescription( description ).withImported( imported ).withTaxable( taxable ).withUnitPrice( unitPrice );
		this.addSalesLineItem( itemBuilder.build(), quantity );
	}

	public Receipt total() {
		Money total = new Money();
		Money tax = new Money();

		for ( SalesLineItem salesLineItem : salesLineItems ) {
			total = total.add( salesLineItem.getPrice() );
			tax = tax.add( salesLineItem.getTax() );
		}
		ReceiptBuilder receiptBuilder = new ReceiptBuilder();
		Receipt receipt = receiptBuilder.withTotal( total ).withTax( tax ).withSalesLineItems( salesLineItems ).build();
		this.salesLineItems = new LinkedList<SalesLineItem>();
		return receipt;
	}

}
