package com.lastminute.salestax.round;

import com.lastminute.salestax.model.Money;

public final class Rounding {

	private static final String ROUND_FACTOR = "0.05";

	private Rounding() {
	};

	public static Money round2Near005( Money v ) {
		Money v1 = v.divide( ROUND_FACTOR );
		double ceil = Math.ceil( v1.getAmount().doubleValue() );
		Money intMoney = new Money( ceil );
		return intMoney.multiply( ROUND_FACTOR );
	}

}
