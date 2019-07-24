package zoo;

import java.util.*;

public class Zone {
	final int MAXIMUM_CAGES = 5;
	boolean hasCanteen;
	boolean hasPark;
	String categoryOfAnimal;
	int presentCages = 0;
	public List<Cage> cageList;
	Zone(String categoryOfAnimal, boolean hasCanteen, boolean hasPark) {
		this.categoryOfAnimal = categoryOfAnimal;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
		cageList = new ArrayList<Cage>();
	}

	public String getZoneType() {
		return categoryOfAnimal;
	}
	/**
	 * @param cage type of Cage
	 * @return true and false according to add cages
	 */
	public boolean addCage(Cage cage) {
		if (presentCages <= MAXIMUM_CAGES) {
			cageList.add(cage);
			presentCages += 1;
			return true;
		} else
			return false;
	}

	/**
	 * getter method
	 * @return List of Cages
	 */
	public List<Cage> getListOfCages() {
		return cageList;
	}
	/**
	 * getter method
	 * @return present number of cages 
	 */
	public int noOfCages() {
		return presentCages;
	}
}
