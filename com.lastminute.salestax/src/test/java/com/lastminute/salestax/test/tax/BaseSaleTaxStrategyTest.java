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
import com.lastminute.salestax.tax.BaseSaleTaxStrategy;
import com.lastminute.salestax.tax.ISaleTaxStrategy;
import com.lastminute.salestax.tax.SaleTaxFactory;
import com.lastminute.salestax.test.object.mother.ObjectMotherItem;

public class BaseSaleTaxStrategyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseTax() ) );
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseTax() ), instanceOf( ISaleTaxStrategy.class ) );
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseTax() ), instanceOf( BaseSaleTaxStrategy.class ) );
		SalesLineItem salesLineItem = new SalesLineItemBuilder().withItem( ObjectMotherItem.itemBaseTax() ).withQuantity( 1 ).build();
		assertTrue( new Money( 1.00 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseTax() ).calculateTax( salesLineItem ) ) );

		Item item1 = ObjectMotherItem.itemBaseTax();
		item1.setUnitPrice( new Money( new BigDecimal( 14.99 ) ) );
		salesLineItem = new SalesLineItemBuilder().withItem( item1 ).withQuantity( 1 ).build();
		assertTrue( new Money( 1.5 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( item1 ).calculateTax( salesLineItem ) ) );

		Item item2 = ObjectMotherItem.itemBaseTax();
		item2.setUnitPrice( new Money( new BigDecimal( 18.99 ) ) );
		salesLineItem = new SalesLineItemBuilder().withItem( item2 ).withQuantity( 1 ).build();
		assertTrue( new Money( 1.9 ).equals( SaleTaxFactory.getIstance().getSaleTaxStrategy( item2 ).calculateTax( salesLineItem ) ) );
	}

}
