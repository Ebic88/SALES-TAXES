package com.lastminute.salestax.test.tax;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import com.lastminute.salestax.model.Item;
import com.lastminute.salestax.model.Money;
import com.lastminute.salestax.model.SalesLineItem;
import com.lastminute.salestax.model.builder.SalesLineItemBuilder;
import com.lastminute.salestax.tax.BaseImportedSaleTaxStrategy;
import com.lastminute.salestax.tax.ISaleTaxStrategy;
import com.lastminute.salestax.tax.SaleTaxFactory;
import com.lastminute.salestax.test.object.mother.ObjectMotherItem;

public class BaseImportedSaleTaxStrategyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseAndImportedTax() ) );
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseAndImportedTax() ), instanceOf( ISaleTaxStrategy.class ) );
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseAndImportedTax() ), instanceOf( BaseImportedSaleTaxStrategy.class ) );
		SalesLineItem salesLineItem = new SalesLineItemBuilder().withItem( ObjectMotherItem.itemBaseAndImportedTax() ).withQuantity( 1 ).build();
		assertTrue( new Money( 1.50 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseAndImportedTax() ).calculateTax( salesLineItem ) ) );

		Item item1 = ObjectMotherItem.itemBaseAndImportedTax();
		item1.setUnitPrice( new Money( new BigDecimal( 47.50 ) ) );
		salesLineItem = new SalesLineItemBuilder().withItem( item1 ).withQuantity( 1 ).build();
		assertTrue( new Money( 7.15 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseAndImportedTax() ).calculateTax( salesLineItem ) ) );

		item1.setUnitPrice( new Money( new BigDecimal( 27.99 ) ) );
		salesLineItem = new SalesLineItemBuilder().withItem( item1 ).withQuantity( 1 ).build();
		assertTrue( new Money( 4.20 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseAndImportedTax() ).calculateTax( salesLineItem ) ) );
	}

}
