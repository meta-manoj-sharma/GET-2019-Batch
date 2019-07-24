package zoo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZoneTest {

	Zoo z = new Zoo();

	// Adding a new Zone for Mammals which has Canteen and Park both
	@Test
	public void addZoneTest() {
		assertTrue(z.addZone("Mammal", true, true));
	}

	// Adding a new Cage for Lion in Zone1 which has a Capacity of 5 Lion
	@Test
	public void addCageTest() {
		try {
			assertTrue(z.addCage("Lion", "Mammal"));
		} catch (Exception e) {
			System.out.println((e.getMessage()));
		}

	}

	// Adding peacock-4 in Cage3 whose age is 2years and weight is 8kgs
	@Test
	public void addAnimalTest() {
		try {
			assertTrue(z.addAnimal(new Lion("lion-1", 12, 45)));
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Providing CategoryOfAnimal as Null
	@Test(expected = AssertionError.class)
	public void addZoneWithNullCategory() {

		z.addZone(null, true, true);
	}

	// Providing CategoryOfAnimal as Null
	@Test(expected = AssertionError.class)
	public void addCageWithNullCategory() throws Exception {

		z.addCage(null, "Mammal");

	}

	// Providing CategoryOfAnimal as Null and Name of Animal as Zero length
	@Test(expected = AssertionError.class)
	public void addAnimalWithNullCategoryORName() throws Exception {

		z.addAnimal(new Peacock(null, 5, 5));

	}

	// Adding Cage in a Full Zone i.e., No cage could be Added in this Zone
	@Test
	public void addCageInFullZone() {
		try {
			z.addCage("Lion", "Mammal");
		} catch (Exception ex) {
			assertEquals("Please add zone first", ex.getMessage());
		}
	}

	// Adding Animal of Different Type to another Type of Cage i.e., Parrot
	@Test
	public void addAnimalWithDifferentTypeOfAnimal() {
		try {
			z.addAnimal(new Peacock("peacock-1", 4, 12));
		} catch (Exception e) {
			assertEquals("Please add zone first", e.getMessage());
		}

	}

	// Adding a new Animal whose Name is already in the System
	@Test
	public void addAnimalWithSameName() {
		try {
			boolean result = z.addAnimal(new Lion("Lion-1", 4, 20));
			assertEquals(false, result);
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
