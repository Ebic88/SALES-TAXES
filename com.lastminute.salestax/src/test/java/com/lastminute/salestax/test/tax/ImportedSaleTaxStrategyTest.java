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
import com.lastminute.salestax.tax.ISaleTaxStrategy;
import com.lastminute.salestax.tax.ImportedSaleTaxStrategy;
import com.lastminute.salestax.tax.SaleTaxFactory;
import com.lastminute.salestax.test.object.mother.ObjectMotherItem;

public class ImportedSaleTaxStrategyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemImportedTax() ) );
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemImportedTax() ), instanceOf( ISaleTaxStrategy.class ) );
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemImportedTax() ), instanceOf( ImportedSaleTaxStrategy.class ) );
		SalesLineItem salesLineItem = new SalesLineItemBuilder().withItem( ObjectMotherItem.itemImportedTax() ).withQuantity( 1 ).build();
		assertTrue( new Money( 0.5 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemImportedTax() ).calculateTax( salesLineItem ) ) );

		Item item1 = ObjectMotherItem.itemImportedTax();
		item1.setUnitPrice( new Money( new BigDecimal( 10.00 ) ) );
		salesLineItem = new SalesLineItemBuilder().withItem( item1 ).withQuantity( 1 ).build();
		assertTrue( new Money( 0.5 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( item1 ).calculateTax( salesLineItem ) ) );

		item1.setUnitPrice( new Money( new BigDecimal( 11.25 ) ) );
		assertTrue( new Money( 0.6 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( item1 ).calculateTax( salesLineItem ) ) );
	}

}
