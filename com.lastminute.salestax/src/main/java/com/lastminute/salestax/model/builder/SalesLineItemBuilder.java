package com.lastminute.salestax.model.builder;

import com.lastminute.salestax.model.Item;
import com.lastminute.salestax.model.SalesLineItem;

public class SalesLineItemBuilder {
	
	private SalesLineItem sli = new SalesLineItem();
	
	public SalesLineItemBuilder withItem(Item item){
		sli.setItem( item );
		return this;
	}
	
	public SalesLineItemBuilder withQuantity(int quantity){
		sli.setQuantity( quantity );
		return this;
	}
	
	public SalesLineItem build(){
		return sli;
	}

}
