package zoo;

public class Lion extends Mammal {
	/*
	 * Parameterized constructor to initialize Lion attribute
	 */
	Lion(String animalName, int ageOfAnimal, double weightOfAnimal) {
		this.name = animalName;
		this.age = ageOfAnimal;
		this.weight = weightOfAnimal;
		getSound = "Roars";
	}
/**
 * return animal type lion
 */
	public String getAnimalType() {
		return "Lion";
	}
}
