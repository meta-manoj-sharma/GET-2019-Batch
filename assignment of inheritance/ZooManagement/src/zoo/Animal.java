package zoo;

public class Animal {
	protected String name;
	protected double weight;
	protected int age;
	protected String getSound;
	protected String animalCategory;
	protected String animalType;
/**
 * @return name of animal
 */
	public String getAnimalName() {
		return name;
	}
/**
 * @return weight of animal
 */
	public double getAnimalWeight() {
		return weight;
	}
/**
 * @return age of animal
 */
	public int getAnimalAge() {
		return age;
	}
/**
 * @return sound of animal
 */
	public String getAnimalSound() {
		return getSound;
	}
/**
 * @return category of animal
 */
	public String getAnimalCategory() {
		return animalCategory;
	}
/**
 * @return type of animal
 */
	public String getAnimalType() {
		return animalType;
	}
}
