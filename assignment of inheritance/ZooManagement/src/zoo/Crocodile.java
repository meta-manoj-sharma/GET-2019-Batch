package zoo;

public class Crocodile extends Reptile {
	/*
	 * Parameterized constructor to initialize Crocodile attribute
	 */
	Crocodile(String animalName, int ageOfAnimal, double weightOfAnimal) {
		this.name = animalName;
		this.age = ageOfAnimal;
		this.weight = weightOfAnimal;
		getSound = "hiss";
	}
/**
 * return animal type crocodile
 */
	public String getAnimalType() {
		return "Crocodile";
	}
}
