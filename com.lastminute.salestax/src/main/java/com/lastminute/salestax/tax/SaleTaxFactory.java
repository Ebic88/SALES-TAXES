package com.lastminute.salestax.tax;

import com.lastminute.salestax.model.Item;

public class SaleTaxFactory  {

	private static SaleTaxFactory istance = new SaleTaxFactory();

	private SaleTaxFactory() {
	};

	public static synchronized SaleTaxFactory getIstance() {
		if ( istance == null ) {
			istance = new SaleTaxFactory();
		}
		return istance;
	}

	public ISaleTaxStrategy getSaleTaxStrategy( Item item ) {
		return getSaleTaxStrategy( item.isTaxable(), item.isImported() );
	}

	private ISaleTaxStrategy getSaleTaxStrategy( boolean taxable, boolean imported ) {
		if ( taxable && imported ) {
			return new BaseImportedSaleTaxStrategy();
		} else {
			if ( taxable ) {
				return new BaseSaleTaxStrategy();
			} else {
				if ( imported ) {
					return new ImportedSaleTaxStrategy();
				}
			}
		}
		return new NoSaleTaxStrategy();
	}
}
