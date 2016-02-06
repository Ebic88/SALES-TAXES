package com.lastminute.salestax.test.model;

import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import org.junit.Test;
import com.lastminute.salestax.model.Money;

public class MoneyTest {

	@Test
	public void testAdd() {
		Money money = new Money();
		Money money2 = new Money( 1.0 );
		money = money.add( money2 );
		assertTrue( money.equals( new Money( 1.0 ) ) );
		money = money.add( money2 );
		assertTrue( money.equals( new Money( 2 ) ) );
		money = money.add( new Money( 0.1 ) );
		assertTrue( money.equals( new Money( 2.1 ) ) );
		money = money.add( new Money( 0.01 ) );
		assertTrue( money.equals( new Money( 2.11 ) ) );

		money = new Money( new BigDecimal( 0 ) );
		money = money.add( new Money( 32.19 ) );
		money = money.add( new Money( 20.89 ) );
		money = money.add( new Money( 9.75 ) );
		money = money.add( new Money( 11.85 ) );
		assertTrue( money.equals( new Money( 74.68 ) ) );
	}

	@Test
	public void testMultiply() {
		Money money = new Money( 1.0 );
		money = money.multiply( 2 );
		assertTrue( money.equals( new Money( 2 ) ) );
		money = money.multiply( 3 );
		assertTrue( money.equals( new Money( 6 ) ) );
		money = new Money( 0.0003 );
		money = money.multiply( 2 );
		assertTrue( money.equals( new Money( 0.0006 ) ) );
	}

}
