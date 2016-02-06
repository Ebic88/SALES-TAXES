package com.lastminute.salestax.test.register;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.lastminute.salestax.model.Money;
import com.lastminute.salestax.model.Receipt;
import com.lastminute.salestax.model.SalesLineItem;
import com.lastminute.salestax.model.builder.ItemBuilder;
import com.lastminute.salestax.model.builder.SalesLineItemBuilder;
import com.lastminute.salestax.register.Register;
import com.lastminute.salestax.test.object.mother.ObjectMotherItem;

public class RegisterTest {

	@Test
	public void testTotal() {
		Register register = Register.getInstance();
		SalesLineItemBuilder salesbuilder = new SalesLineItemBuilder();
		ItemBuilder itemBuilder = new ItemBuilder();
		itemBuilder.withDescription( "Item 1" ).withImported( false ).withTaxable( false ).withUnitPrice( new Money() );
		SalesLineItem s1 = salesbuilder.withItem( itemBuilder.build() ).withQuantity( 1 ).build();
		register.addSalesLineItem( s1 );
		Receipt receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money() ) );
		assertTrue( receipt.getTax().equals( new Money() ) );

		itemBuilder = new ItemBuilder();
		itemBuilder.withDescription( "Item 2" ).withImported( false ).withTaxable( false ).withUnitPrice( new Money( 1.0 ) );
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s2 = salesbuilder.withItem( itemBuilder.build() ).withQuantity( 1 ).build();
		register.addSalesLineItem( s2 );
		receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 1.0 ) ) );
		assertTrue( receipt.getTax().equals( new Money() ) );

		itemBuilder = new ItemBuilder();
		itemBuilder.withDescription( "Item 3" ).withImported( false ).withTaxable( true ).withUnitPrice( new Money( 1.0 ) );
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s3 = salesbuilder.withItem( itemBuilder.build() ).withQuantity( 1 ).build();
		register.addSalesLineItem( s3 );
		receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 1.1 ) ) );
		assertTrue( receipt.getTax().equals( new Money( 0.1 ) ) );

		itemBuilder = new ItemBuilder();
		itemBuilder.withDescription( "Item 4" ).withImported( true ).withTaxable( false ).withUnitPrice( new Money( 1.0 ) );
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s4 = salesbuilder.withItem( itemBuilder.build() ).withQuantity( 1 ).build();
		register.addSalesLineItem( s4 );
		receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 1.05 ) ) );
		assertTrue( receipt.getTax().equals( new Money( 0.05 ) ) );

		itemBuilder = new ItemBuilder();
		itemBuilder.withDescription( "Item 5" ).withImported( true ).withTaxable( true ).withUnitPrice( new Money( 1.0 ) );
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s5 = salesbuilder.withItem( itemBuilder.build() ).withQuantity( 1 ).build();
		register.addSalesLineItem( s5 );
		receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 1.15 ) ) );
		assertTrue( receipt.getTax().equals( new Money( 0.15 ) ) );

		register.addSalesLineItem( s1 );
		register.addSalesLineItem( s2 );
		receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 1.0 ) ) );
		assertTrue( receipt.getTax().equals( new Money() ) );

		register.addSalesLineItem( s1 );
		register.addSalesLineItem( s2 );
		register.addSalesLineItem( s3 );
		receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 2.1 ) ) );
		assertTrue( receipt.getTax().equals( new Money( 0.1 ) ) );

		register.addSalesLineItem( s1 );
		register.addSalesLineItem( s2 );
		register.addSalesLineItem( s3 );
		register.addSalesLineItem( s4 );
		receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 3.15 ) ) );
		assertTrue( receipt.getTax().equals( new Money( 0.15 ) ) );

		register.addSalesLineItem( s1 );
		register.addSalesLineItem( s2 );
		register.addSalesLineItem( s3 );
		register.addSalesLineItem( s4 );
		register.addSalesLineItem( s5 );
		receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 4.30 ) ) );
		assertTrue( receipt.getTax().equals( new Money( 0.3 ) ) );
	}
	
	/*
	 * 	Input 1:
	 *		1 book at 12.49
	 *		1 music CD at 14.99
	 *		1 chocolate bar at 0.85
	 * 
	 *	Output 1: 
	 *		1 book : 12.49
	 *		1 music CD: 16.49
	 *		1 chocolate bar: 0.85
	 *	
	 *	Sales Taxes: 1.50
	 *	Total: 29.83
	 * 
	 */
	public void testInput1(){
		SalesLineItemBuilder salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s1 = salesbuilder.withItem( ObjectMotherItem.item11() ).withQuantity( 1 ).build();
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s2 = salesbuilder.withItem( ObjectMotherItem.item12() ).withQuantity( 1 ).build();
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s3 = salesbuilder.withItem( ObjectMotherItem.item13() ).withQuantity( 1 ).build();
		Register register = Register.getInstance();
		register.addSalesLineItem( s1 );
		register.addSalesLineItem( s2 );
		register.addSalesLineItem( s3 );
		Receipt receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 29.83 ) ) );
		assertTrue( receipt.getTax().equals( new Money( 1.50 ) ) );
	}
	
	/*
	 *	Input 2:
	 *		1 imported box of chocolates at 10.00
	 *		1 imported bottle of perfume at 47.50
	 * 
	 *	Output 2:
	 *		1 imported box of chocolates: 10.50
	 *		1 imported bottle of perfume: 54.65
	 *
	 *	Sales Taxes: 7.65
	 *	Total: 65.15
	 * 
	 */
	public void testInput2(){
		SalesLineItemBuilder salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s1 = salesbuilder.withItem( ObjectMotherItem.item21() ).withQuantity( 1 ).build();
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s2 = salesbuilder.withItem( ObjectMotherItem.item22() ).withQuantity( 1 ).build();
		Register register = Register.getInstance();
		register.addSalesLineItem( s1 );
		register.addSalesLineItem( s2 );
		Receipt receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 65.15 ) ) );
		assertTrue( receipt.getTax().equals( new Money( 7.65 ) ) );
	}
	
	
	/*
	 *	Input 3:
	 *		1 imported bottle of perfume at 27.99
	 *		1 bottle of perfume at 18.99
	 *		1 packet of headache pills at 9.75
	 *		1 box of imported chocolates at 11.25
	 *
	 *	Output 3:
	 *		1 imported bottle of perfume: 32.19
	 *		1 bottle of perfume: 20.89
	 *		1 packet of headache pills: 9.75
	 *		1 imported box of chocolates: 11.85
	 *
	 *	Sales Taxes: 6.70
	 *	Total: 74.68
	 * 
	 */
	public void testInput3(){
		SalesLineItemBuilder salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s1 = salesbuilder.withItem( ObjectMotherItem.item31() ).withQuantity( 1 ).build();
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s2 = salesbuilder.withItem( ObjectMotherItem.item32() ).withQuantity( 1 ).build();
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s3 = salesbuilder.withItem( ObjectMotherItem.item33() ).withQuantity( 1 ).build();
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s4 = salesbuilder.withItem( ObjectMotherItem.item34() ).withQuantity( 1 ).build();
		Register register = Register.getInstance();
		register.addSalesLineItem( s1 );
		register.addSalesLineItem( s2 );
		register.addSalesLineItem( s3 );
		register.addSalesLineItem( s4 );
		Receipt receipt = register.total();
		assertTrue( receipt.getTotal().equals( new Money( 74.68 ) ) );
		assertTrue( receipt.getTax().equals( new Money( 6.70 ) ) );
		
	}
	
}
