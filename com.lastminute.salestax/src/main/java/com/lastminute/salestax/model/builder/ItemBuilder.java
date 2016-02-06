package com.lastminute.salestax.model.builder;

import com.lastminute.salestax.model.Item;
import com.lastminute.salestax.model.Money;

public class ItemBuilder {

	private Item item = new Item();

	public ItemBuilder withDescription( String description ) {
		item.setDescription( description );
		return this;
	}

	public ItemBuilder withUnitPrice( Money unitPrice ) {
		item.setUnitPrice( unitPrice );
		return this;
	}

	public ItemBuilder withTaxable( boolean taxable ) {
		item.setTaxable( taxable );
		return this;
	}

	public ItemBuilder withImported( boolean imported ) {
		item.setImported( imported );
		return this;
	}

	public Item build() {
		return item;
	}

}
