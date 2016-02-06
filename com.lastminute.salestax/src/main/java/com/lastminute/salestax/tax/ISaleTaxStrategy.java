package com.lastminute.salestax.tax;

import com.lastminute.salestax.model.Money;
import com.lastminute.salestax.model.SalesLineItem;

public interface ISaleTaxStrategy {
	
	public Money calculateTax(SalesLineItem salesLineItem);

}
