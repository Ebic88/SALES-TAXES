package com.lastminute.salestax.test.object.mother;

import java.math.BigDecimal;
import com.lastminute.salestax.model.Item;
import com.lastminute.salestax.model.Money;
import com.lastminute.salestax.model.builder.ItemBuilder;

public final class ObjectMotherItem {

	public static Item itemNoTaxable() {
		return new ItemBuilder().withDescription( "item 1" ).withImported( false ).withTaxable( false ).withUnitPrice( new Money( new BigDecimal( 10 ) ) ).build();
	}

	public static Item itemBaseTax() {
		return new ItemBuilder().withDescription( "item 1" ).withImported( false ).withTaxable( true ).withUnitPrice( new Money( new BigDecimal( 10 ) ) ).build();
	}

	public static Item itemImportedTax() {
		return new ItemBuilder().withDescription( "item 1" ).withImported( true ).withTaxable( false ).withUnitPrice( new Money( new BigDecimal( 10 ) ) ).build();
	}

	public static Item itemBaseAndImportedTax() {
		return new ItemBuilder().withDescription( "item 1" ).withImported( true ).withTaxable( true ).withUnitPrice( new Money( new BigDecimal( 10 ) ) ).build();
	}

	public static Item item11() {
		return new ItemBuilder().withDescription( "Book" ).withImported( false ).withTaxable( false ).withUnitPrice( new Money( new BigDecimal( 12.49 ) ) ).build();
	}

	public static Item item12() {
		return new ItemBuilder().withDescription( "Music CD" ).withImported( false ).withTaxable( true ).withUnitPrice( new Money( new BigDecimal( 14.99 ) ) ).build();
	}

	public static Item item13() {
		return new ItemBuilder().withDescription( "Chocolate Bar" ).withImported( false ).withTaxable( false ).withUnitPrice( new Money( new BigDecimal( 0.85 ) ) ).build();
	}

	public static Item item21() {
		return new ItemBuilder().withDescription( "Box of chocolates" ).withImported( true ).withTaxable( false ).withUnitPrice( new Money( new BigDecimal( 10.00 ) ) ).build();
	}

	public static Item item22() {
		return new ItemBuilder().withDescription( "Bottle of Perfume" ).withImported( true ).withTaxable( true ).withUnitPrice( new Money( new BigDecimal( 47.50 ) ) ).build();
	}
	
	public static Item item31(){
		return new ItemBuilder().withDescription( "Bottle of Perfume" ).withImported( true ).withTaxable( true ).withUnitPrice( new Money( new BigDecimal( 27.99 ) ) ).build();
	}
	
	public static Item item32(){
		return  new ItemBuilder().withDescription( "Bottle of Perfume" ).withImported( false ).withTaxable( true ).withUnitPrice( new Money( new BigDecimal( 18.99 ) ) ).build();
	}
	
	public static Item item33(){
		return new ItemBuilder().withDescription( "packet of headache pills" ).withImported( false ).withTaxable( false ).withUnitPrice( new Money( new BigDecimal( 9.75 ) ) ).build();
	}
	
	public static Item item34(){
		return new ItemBuilder().withDescription( "chocolates" ).withImported( true ).withTaxable( false ).withUnitPrice( new Money( new BigDecimal( 11.25 ) ) ).build();
	}
}
