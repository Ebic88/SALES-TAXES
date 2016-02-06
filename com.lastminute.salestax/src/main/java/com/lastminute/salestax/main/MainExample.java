package com.lastminute.salestax.main;

import org.apache.log4j.Logger;
import com.lastminute.salestax.model.Receipt;
import com.lastminute.salestax.model.SalesLineItem;
import com.lastminute.salestax.model.builder.SalesLineItemBuilder;
import com.lastminute.salestax.register.Register;

public class MainExample {

	private MainExample() {
	};

	private static final Logger LOGGER = Logger.getLogger( MainExample.class ); 

	public static void main( String[] args ) {
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
		LOGGER.info( receipt.print() );

		LOGGER.info( "" );
		LOGGER.info( "" );

		salesbuilder = new SalesLineItemBuilder();
		s1 = salesbuilder.withItem( ObjectMotherItem.item21() ).withQuantity( 1 ).build();
		salesbuilder = new SalesLineItemBuilder();
		s2 = salesbuilder.withItem( ObjectMotherItem.item22() ).withQuantity( 1 ).build();
		register.addSalesLineItem( s1 );
		register.addSalesLineItem( s2 );
		receipt = register.total();
		LOGGER.info( receipt.print() );

		LOGGER.info( "" );
		LOGGER.info( "" );

		salesbuilder = new SalesLineItemBuilder();
		s1 = salesbuilder.withItem( ObjectMotherItem.item31() ).withQuantity( 1 ).build();
		salesbuilder = new SalesLineItemBuilder();
		s2 = salesbuilder.withItem( ObjectMotherItem.item32() ).withQuantity( 1 ).build();
		salesbuilder = new SalesLineItemBuilder();
		s3 = salesbuilder.withItem( ObjectMotherItem.item33() ).withQuantity( 1 ).build();
		salesbuilder = new SalesLineItemBuilder();
		SalesLineItem s4 = salesbuilder.withItem( ObjectMotherItem.item34() ).withQuantity( 1 ).build();
		register = Register.getInstance();
		register.addSalesLineItem( s1 );
		register.addSalesLineItem( s2 );
		register.addSalesLineItem( s3 );
		register.addSalesLineItem( s4 );
		receipt = register.total();
		LOGGER.info( receipt.print() );

	}

}
