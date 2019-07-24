package zoo;

import java.util.*;
/**
 * zoo management system which have various operation
 * @author Manoj
 * Dated 22 july 2019
 */
public class Zoo {
	final int MAXIMUM_ZONE = 5;
	int presentZone = 0;
	List<Zone> zoneList = new ArrayList<Zone>();
	public boolean addZone(String categoryOfAnimal, boolean hasPark,
			boolean hasCanteen) {
		if (categoryOfAnimal == null) {
			throw new AssertionError();
		}
		if (presentZone < MAXIMUM_ZONE) {// checking maximum capacity of zones
			Zone newZone = new Zone(categoryOfAnimal, hasPark, hasCanteen);
			zoneList.add(newZone);
			presentZone++;
			return true;
		}
		return false;
	}

	/*
	 * addCage method to add a new Cage in a zone return true if added
	 * successfully
	 */
	boolean addCage(String typeOfAnimal, String categoryOfAnimal)
			throws Exception {
		if (typeOfAnimal == null) {
			throw new AssertionError(" null ");
		}
		if (categoryOfAnimal == null) {
			throw new AssertionError("null");
		}
		for (int index = 0; index < zoneList.size(); index++) { //accessing zone
			if (zoneList.get(index).getZoneType().equals(categoryOfAnimal) //comparing zone category with entered animal
					&& zoneList.get(index).MAXIMUM_CAGES > zoneList.get(index).presentCages) {
				return zoneList.get(index).addCage(
						new Cage(typeOfAnimal, categoryOfAnimal)); //adding zone
			}
		}
		throw new Exception("Please add zone first");
	}

	// addAnimal method add a new animal to zoo with its specified cage and zone

	boolean addAnimal(Animal animal) throws Exception {
		// if name or type of animal found null throw assertion error
		if (animal.getAnimalName() == null
				|| animal.getAnimalName().length() == 0) {
			throw new AssertionError();
		}
		// check for duplicate name if found throw exception of same name
		for (int i = 0; i < zoneList.size(); i++) {
			Zone zone = zoneList.get(i);
			if (zone.categoryOfAnimal.equals(animal.getAnimalCategory())) {
				for (int j = 0; j < zone.cageList.size(); j++) {
					Cage cage = zone.cageList.get(j);
					if (cage.typeOfAnimal.equals(animal.getAnimalType()) //comparing animal type with entered animal and checking maximum value
							&& cage.MAXIMUM_ANIMAL > cage.getNoOfAnimals()) {
						return zone.cageList.get(j).addAnimal(animal);  //adding animal into animal list
					}
				}
			}
		}

		if (this.addCage(animal.getAnimalType(), animal.getAnimalCategory())) {
			return addAnimal(animal);
		}

		return false;
	}

	// deathOfAnimal method to delete a animal from zoo

	boolean deathOfAnimal(Animal animal) throws Exception {
		if (animal.getAnimalName() == null
				|| animal.getAnimalName().length() == 0) {
			throw new AssertionError();
		}
		// check for duplicate name if found then delete name
		for (int i = 0; i < zoneList.size(); i++) {
			Zone zone = zoneList.get(i);
			if (zone.categoryOfAnimal.equals(animal.getAnimalCategory())) {//checking for animal category
				for (int j = 0; j < zone.cageList.size(); j++) {
					Cage cage = zone.cageList.get(j);
					if (cage.typeOfAnimal.equals(animal.getAnimalType())) {//checking animal type which has to b remove
						return zone.cageList.get(j).deathAnimal(animal);
					}
				}
			}
		}
		return false;
	}

	/**
	 * getter method
	 * @return list of zone
	 */
	public List<Zone> getZones() {
		return zoneList;
	}
}
