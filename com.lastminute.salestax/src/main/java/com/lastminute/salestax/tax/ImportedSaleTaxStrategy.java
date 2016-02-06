package com.lastminute.salestax.tax;

import com.lastminute.salestax.model.Money;
import com.lastminute.salestax.model.SalesLineItem;
import com.lastminute.salestax.round.Rounding;
import com.lastminute.salestax.tax.rate.TaxRate;

public class ImportedSaleTaxStrategy implements ISaleTaxStrategy {

	public Money calculateTax( SalesLineItem salesLineItem ) {
		Money tax = salesLineItem.getItem().getUnitPrice().multiply( TaxRate.IMPORTED_TAX.getTaxRate()  ).multiply( salesLineItem.getQuantity() );
		tax = Rounding.round2Near005( tax );
		return tax;
	}

}
