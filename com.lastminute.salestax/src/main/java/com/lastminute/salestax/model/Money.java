package com.lastminute.salestax.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Money implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7888825374586949447L;

	private static final MathContext CONTEXT = new MathContext( 4, RoundingMode.HALF_UP );

	private BigDecimal amount;

	public Money() {
		super();
		this.amount = new BigDecimal( 0, CONTEXT );
	}

	public Money( double amount ) {
		super();
		this.amount = new BigDecimal( amount, CONTEXT );
	}

	public Money( BigDecimal amount ) {
		super();
		this.amount = new BigDecimal( amount.doubleValue(), CONTEXT );
	}

	public Money add( Money money ) {
		BigDecimal totalAmount = this.amount.add( money.getAmount(), CONTEXT );
		return new Money( totalAmount );
	}

	public Money multiply( int factor ) {
		BigDecimal totalAmount = this.amount.multiply( new BigDecimal( factor, CONTEXT ), CONTEXT );
		return new Money( totalAmount );
	}

	public Money multiply( String factor ) {
		BigDecimal totalAmount = this.amount.multiply( new BigDecimal( factor, CONTEXT ), CONTEXT );
		return new Money( totalAmount );
	}

	public Money divide( String factor ) {
		BigDecimal totalAmount = this.amount.divide( new BigDecimal( factor, CONTEXT ), CONTEXT );
		return new Money( totalAmount );
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount( BigDecimal amount ) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( amount == null ) ? 0 : amount.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		Money other = ( Money ) obj;
		if ( amount == null ) {
			if ( other.amount != null )
				return false;
		} else if ( !amount.equals( other.amount ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + "]";
	}

}
