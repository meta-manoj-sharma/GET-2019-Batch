package molecularmass;

import static org.junit.Assert.*;

import org.junit.Test;

public class MolecularMassTest {

	/**
	 * Success test case for different chemical compound
	 * @throws Exception
	 */
	@Test
	public void calculateMassSuccess1() throws Exception {
		MolecularMass molecularMass = new MolecularMass();
		assertEquals(86, molecularMass.calculateMass("CHOC(CH3)3"));
	}

	@Test
	public void calculateMassSuccess2() throws Exception {
		MolecularMass molecularMass = new MolecularMass();
		assertEquals(45, molecularMass.calculateMass("CHO2"));
	}

	@Test
	public void calculateMassSuccess3() throws Exception {
		MolecularMass molecularMass = new MolecularMass();
		assertEquals(29, molecularMass.calculateMass("CHO"));
	}

	/**
	 * Fail test case for chemical compound
	 */
	@Test
	public void calculateMassFail() {
		MolecularMass molecularMass = new MolecularMass();
		try {
			assertEquals(29, molecularMass.calculateMass("CHA"));
		} catch (Exception e) {
			assertEquals("Element not exists", e.getMessage());
		}
	}
}
