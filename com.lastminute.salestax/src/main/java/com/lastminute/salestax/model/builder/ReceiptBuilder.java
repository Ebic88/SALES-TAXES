package com.lastminute.salestax.model.builder;

import java.util.List;
import com.lastminute.salestax.model.Money;
import com.lastminute.salestax.model.Receipt;
import com.lastminute.salestax.model.SalesLineItem;

public class ReceiptBuilder {

	private Receipt receipt = new Receipt();

	public ReceiptBuilder withTotal( Money total ) {
		this.receipt.setTotal( total );
		return this;
	}

	public ReceiptBuilder withTax( Money tax ) {
		this.receipt.setTax( tax );
		return this;
	}

	public ReceiptBuilder withSalesLineItems( List<SalesLineItem> salesLineItems ) {
		this.receipt.getSalesLineItems().addAll( salesLineItems );
		return this;
	}

	public Receipt build() {
		return this.receipt;
	}
}
