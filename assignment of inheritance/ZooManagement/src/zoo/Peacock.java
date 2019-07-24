package zoo;

public class Peacock extends Bird {
	/*
	 * Parameterized constructor to initialize peacock attribute
	 */
	Peacock(String animalName, int ageOfAnimal, double weightOfAnimal) {
		this.name = animalName;
		this.age = ageOfAnimal;
		this.weight = weightOfAnimal;
		getSound = "Scream";
	}
/**
 * return animal type peacock
 */
	public String getAnimalType() {
		return "Peacock";
	}
}
