package zoo;

import java.util.*;

public class Main {
	/**
	 * display animals with their parameters
	 * @param zones list of zone
	 */
	public static void display(List<Zone> zones) {
		for (Zone zone : zones) { //to iterate zone list
			if (zone.getListOfCages().size() > 0) { //checking cages quantity
				for (Cage cage : zone.getListOfCages()) { //iterating cage list
					if (cage.getListOfAnimals().size() > 0) { //checking animals quantity
						int i = 1;
						for (Animal current : cage.getListOfAnimals()) {
							System.out.println(i + ". Name: "
									+ current.getAnimalName() + ", Age:"
									+ current.getAnimalAge());
							System.out.println(" Weight: "
									+ current.getAnimalWeight() + ", Sound:"
									+ current.getAnimalSound());
							i++;
						}
					}
				}
			}
		}
	}
/**
 * delete animal from list
 * @param name which animal to be remove
 * @param z zoo object
 * @param zones list of zones
 * @throws Exception
 */
	public static void delete(String name, Zoo z, List<Zone> zones)
			throws Exception {
	
		for (Zone zone : zones) {
			if (zone.getListOfCages().size() > 0) {
				for (Cage cage : zone.getListOfCages()) {
					if (cage.getListOfAnimals().size() > 0) {
						int i = 1;
						for (Animal current : cage.getListOfAnimals()) {
							
							if (current.getAnimalName().equals(name)) { //checking animal for present list
								z.deathOfAnimal(current); //remove dead animal from zoo
								System.out.println("delete animal");
								break;
							}
						}
					}
				}
			}
		}}
	

	public static void main(String[] args) {
		try {
			Zoo z = new Zoo();
			List<Zone> zones = z.getZones();
			if (z.addZone("Mammal", true, true)) {
				System.out.println("added zone");
			}
			if (z.addZone("Reptile", true, false)) {
				System.out.println("added zone");
			}
			if (z.addZone("Bird", false, true)) {
				System.out.println("added zone");
			}
			if (z.addCage("Lion", "Mammal")) {
				System.out.println("added mammal cage");
			}
			if (z.addCage("Crocodile", "Reptile")) {
				System.out.println("added reptile cage");
			}
			if (z.addCage("Peacock", "Bird")) {
				System.out.println("added bird cage");
			}
			if (z.addAnimal(new Lion("lion-1", 12, 45))) {
				System.out.println("added animal lion 1");
			}
			if (z.addAnimal(new Lion("lion-2", 89, 45))) {
				System.out.println("added animal lion 2");
			}
			if (z.addAnimal(new Lion("lion-3", 12, 45))) {
				System.out.println("added animal lion 3");
			}
			if (z.addAnimal(new Lion("lion-4", 89, 45))) {
				System.out.println("added animal lion 4");
			}
			if (z.addAnimal(new Lion("lion-5", 12, 45))) {
				System.out.println("added animal lion 5");
			}
			if (z.addAnimal(new Lion("lion-6", 89, 45))) {
				System.out.println("added animal lion 6");
			}
			if (z.addAnimal(new Peacock("peacock-1", 89, 45))) {
				System.out.println("added animal peacock 1");
			}
			if (z.addAnimal(new Crocodile("crocodile", 89, 45))) {
				System.out.println("added animal crocodile");
			}
			display(zones);
			delete("crocodile", z, zones);
			display(zones);
			z.showAnimalNo();
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
}