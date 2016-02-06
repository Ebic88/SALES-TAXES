package com.lastminute.salestax.test.tax;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.lastminute.salestax.model.Money;
import com.lastminute.salestax.model.SalesLineItem;
import com.lastminute.salestax.model.builder.SalesLineItemBuilder;
import com.lastminute.salestax.tax.ISaleTaxStrategy;
import com.lastminute.salestax.tax.NoSaleTaxStrategy;
import com.lastminute.salestax.tax.SaleTaxFactory;
import com.lastminute.salestax.test.object.mother.ObjectMotherItem;

public class NoSaleTaxStrategyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemNoTaxable() ) );
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemNoTaxable() ), instanceOf( ISaleTaxStrategy.class ) );
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemNoTaxable() ), instanceOf( NoSaleTaxStrategy.class ) );
		SalesLineItem salesLineItem = new SalesLineItemBuilder().withItem( ObjectMotherItem.itemNoTaxable() ).withQuantity( 1 ).build();
		assertTrue( new Money( 0 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemNoTaxable() ).calculateTax( salesLineItem ) ) );
		salesLineItem = new SalesLineItemBuilder().withItem( ObjectMotherItem.itemNoTaxable() ).withQuantity( 4 ).build();
		assertTrue( new Money( 0 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemNoTaxable() ).calculateTax( salesLineItem ) ) );
	}

}
