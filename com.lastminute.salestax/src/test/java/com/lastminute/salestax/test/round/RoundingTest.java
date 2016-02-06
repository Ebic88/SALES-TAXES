package com.lastminute.salestax.test.round;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.lastminute.salestax.model.Money;
import com.lastminute.salestax.round.Rounding;

public class RoundingTest {

	@Test
	public void testRound2Near005() {

		Money money = new Money();
		money = Rounding.round2Near005( money );
		assertTrue( money.equals( new Money() ) );

		money = new Money( 0.05 );
		money = Rounding.round2Near005( money );
		assertTrue( money.equals( new Money( 0.05 ) ) );

		money = new Money( 0.08 );
		money = Rounding.round2Near005( money );
		assertTrue( money.equals( new Money( 0.1 ) ) );

		money = new Money( 0.01 );
		money = Rounding.round2Near005( money );
		assertTrue( money.equals( new Money( 0.05 ) ) );

		money = new Money( 0.005 );
		money = Rounding.round2Near005( money );
		assertTrue( money.equals( new Money( 0.05 ) ) );

		money = new Money( 0.008 );
		money = Rounding.round2Near005( money );
		assertTrue( money.equals( new Money( 0.05 ) ) );

		money = new Money( 0.01 );
		money = Rounding.round2Near005( money );
		assertTrue( money.equals( new Money( 0.05 ) ) );

	}

}
