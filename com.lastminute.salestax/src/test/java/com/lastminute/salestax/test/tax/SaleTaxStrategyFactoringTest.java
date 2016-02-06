package com.lastminute.salestax.test.tax;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import com.lastminute.salestax.tax.BaseImportedSaleTaxStrategy;
import com.lastminute.salestax.tax.BaseSaleTaxStrategy;
import com.lastminute.salestax.tax.ISaleTaxStrategy;
import com.lastminute.salestax.tax.ImportedSaleTaxStrategy;
import com.lastminute.salestax.tax.NoSaleTaxStrategy;
import com.lastminute.salestax.tax.SaleTaxFactory;
import com.lastminute.salestax.test.object.mother.ObjectMotherItem;

public class SaleTaxStrategyFactoringTest {
	
	

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetIstance(){
		assertNotNull(SaleTaxFactory.getIstance());
	}

	@Test
	public void testIstanceNoSaleTax(){
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemNoTaxable() ), instanceOf(ISaleTaxStrategy.class));
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemNoTaxable() ), instanceOf(NoSaleTaxStrategy.class));
	}
	
	@Test
	public void testIstanceBaseSaleTax(){
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseTax() ), instanceOf(ISaleTaxStrategy.class));
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseTax() ), instanceOf(BaseSaleTaxStrategy.class));
	}
	
	@Test
	public void testIstanceImportedSaleTax(){
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemImportedTax() ), instanceOf(ISaleTaxStrategy.class));
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemImportedTax() ), instanceOf(ImportedSaleTaxStrategy.class));
	}
	
	@Test
	public void testIstanceBaseImportedSaleTax(){
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseAndImportedTax() ), instanceOf(ISaleTaxStrategy.class));
		assertThat( SaleTaxFactory.getIstance().getSaleTaxStrategy( ObjectMotherItem.itemBaseAndImportedTax() ), instanceOf(BaseImportedSaleTaxStrategy.class));
	}
	
	
}
