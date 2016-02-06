package com.lastminute.salestax.main;

import com.lastminute.salestax.model.Item;
import com.lastminute.salestax.model.Money;
import com.lastminute.salestax.model.builder.ItemBuilder;

public final class ObjectMotherItem {

	private static final String ITEM_DESCRIPTION = "item";

	private static final String ITEM_BOTTLE = "Bottle of Perfume";

	private ObjectMotherItem() {
	};

	public static Item itemNoTaxable() {
		return new ItemBuilder().withDescription( ITEM_DESCRIPTION ).withImported( false ).withTaxable( false ).withUnitPrice( new Money( 10 ) ).build();
	}

	public static Item itemBaseTax() {
		return new ItemBuilder().withDescription( ITEM_DESCRIPTION ).withImported( false ).withTaxable( true ).withUnitPrice( new Money( 10 ) ).build();
	}

	public static Item itemImportedTax() {
		return new ItemBuilder().withDescription( ITEM_DESCRIPTION ).withImported( true ).withTaxable( false ).withUnitPrice( new Money( 10 ) ).build();
	}

	public static Item itemBaseAndImportedTax() {
		return new ItemBuilder().withDescription( ITEM_DESCRIPTION ).withImported( true ).withTaxable( true ).withUnitPrice( new Money( 10 ) ).build();
	}

	public static Item item11() {
		return new ItemBuilder().withDescription( "Book" ).withImported( false ).withTaxable( false ).withUnitPrice( new Money( 12.49 ) ).build();
	}

	public static Item item12() {
		return new ItemBuilder().withDescription( "Music CD" ).withImported( false ).withTaxable( true ).withUnitPrice( new Money( 14.99 ) ).build();
	}

	public static Item item13() {
		return new ItemBuilder().withDescription( "Chocolate Bar" ).withImported( false ).withTaxable( false ).withUnitPrice( new Money( 0.85 ) ).build();
	}

	public static Item item21() {
		return new ItemBuilder().withDescription( "Box of chocolates" ).withImported( true ).withTaxable( false ).withUnitPrice( new Money( 10.00 ) ).build();
	}

	public static Item item22() {
		return new ItemBuilder().withDescription( ITEM_BOTTLE ).withImported( true ).withTaxable( true ).withUnitPrice( new Money( 47.50 ) ).build();
	}

	public static Item item31() {
		return new ItemBuilder().withDescription( ITEM_BOTTLE ).withImported( true ).withTaxable( true ).withUnitPrice( new Money( 27.99 ) ).build();
	}

	public static Item item32() {
		return new ItemBuilder().withDescription( ITEM_BOTTLE ).withImported( false ).withTaxable( true ).withUnitPrice( new Money( 18.99 ) ).build();
	}

	public static Item item33() {
		return new ItemBuilder().withDescription( "packet of headache pills" ).withImported( false ).withTaxable( false ).withUnitPrice( new Money( 9.75 ) ).build();
	}

	public static Item item34() {
		return new ItemBuilder().withDescription( "chocolates" ).withImported( true ).withTaxable( false ).withUnitPrice( new Money( 11.25 ) ).build();
	}
}
