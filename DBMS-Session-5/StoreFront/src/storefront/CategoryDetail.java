package storefront;

public class CategoryDetail {

	private String categoryName;
	private int noOfChilds;

	/**
	 * Constructor to initialize the data members of the class
	 * @param categoryName is the name of the category
	 * @param noOfChilds is the number of child of that category
	 */
	public CategoryDetail(String categoryName, int noOfChilds) {
		this.categoryName = categoryName;
		this.noOfChilds = noOfChilds;
	}

	//Getter methods
	public String getCategoryName() {
		return categoryName;
	}

	public int getNoOfChilds() {
		return noOfChilds;
	}
}