package zoo;

import java.util.*;

public class Cage {
	final int MAXIMUM_ANIMAL = 4;
	int presentAnimal = 0;
	String typeOfAnimal;
	int zoneNumber;
	String categoryOfAnimal;
	List<Animal> animalList;  //list of animals

	Cage(String typeOfAnimal, String categoryOfAnimal) {
		this.typeOfAnimal = typeOfAnimal;
		this.categoryOfAnimal = categoryOfAnimal;
	}
	//return number of present animals
	public void setNoOfAnimals(int noOfAnimals) {
		this.presentAnimal = noOfAnimals;
	}
	/**
	 * @param animal which has to be added
	 * @return true or false according add animal or not
	 */
	boolean addAnimal(Animal animal) {
		if (animalList == null) {//checking array list for null
			animalList = new ArrayList<Animal>();

		} else {
			for (int i = 0; i < animalList.size(); i++) {// checking for duplicate animal
				if (animalList.get(i).getAnimalName()
						.equals(animal.getAnimalName())) {
					return false;
				}
			}
		}
		animalList.add(animal);// adding animal
		presentAnimal++;
		return true;
	}
	/**
	 * removing animal after death
	 * @param animal which is dead
	 * @return true and false according to action
	 */
	boolean deathAnimal(Animal animal) {
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i).getAnimalName()
					.equals(animal.getAnimalName())) {
				animalList.remove(animal);
				presentAnimal--;
				return true;
			}
		}
		return false;
	}

	public int getNoOfAnimals() {
		return presentAnimal;
	}

	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}

	/**
	 * getter method of List<Animal>
	 * 
	 * @return A list of animal class
	 */
	public List<Animal> getListOfAnimals() {
		return animalList;
	}
}
