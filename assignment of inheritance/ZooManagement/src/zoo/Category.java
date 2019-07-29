package zoo;

public class Category {
	/**
	 * @param name is name of animal
	 * @return category of animal
	 */
	static String getCategory(String name) {
		if ("Lion".equalsIgnoreCase(name))
			return "Mammal";

		else if ("Crocodile".equalsIgnoreCase(name))
			return "Reptile";

		else if ("Peacock".equalsIgnoreCase(name))
			return "Bird";

		else
			return "category not found";
	}
}
