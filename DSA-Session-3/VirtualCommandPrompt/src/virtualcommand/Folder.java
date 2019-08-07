package virtualcommand;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Folder {
	String folderName;
	List<Folder> subFoldersList;
	Folder parentFolder;
	Date dateAndTime;

	public Folder(String name) {
		this.folderName = name;
		this.subFoldersList = new LinkedList<Folder>();
		this.parentFolder = null;
		this.dateAndTime = Calendar.getInstance().getTime();
	}

	/**
	 * This method is used for Converting date and time into String
	 * @return dateAndTime in String form
	 */
	public String getDateAndTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String dateAndTime = dateFormat.format(this.dateAndTime);
		return dateAndTime;
	}

	/**
	 * This method is used for sub-folders
	 * @return subFolders in this directory
	 */
	public List<Folder> getSubFoldersList() {
		return subFoldersList;
	}

	/**
	 * This method is used to get the name of directory
	 * @return name of the directory
	 */
	public String getFolderName() {
		return folderName;
	}

	/**
	 * This method is used to set name
	 * @param name of the directory
	 */
	public void setFolderName(String name) {
		this.folderName = name;
	}

	/**
	 * @return parent of the directory
	 */
	public Folder getParentFolder() {
		return parentFolder;
	}

	/**
	 * @param parent of the directory
	 */
	public void setParentFolder(Folder parent) {
		this.parentFolder = parent;
	}

	/**
	 * This method creates a sub-folder
	 * @param name, name of the subFolder which is going to be create
	 * @return "true" if folder has created successfully else "false" if same name
	 * folder exist from earlier then new folder with same name will not create
	 */
	public boolean mkdir(String folderName) {

		Folder subFolder = findSubfolder(folderName);
		if (subFolder != null) {
			return false;
		}
		subFolder = new Folder(folderName);
		subFolder.setParentFolder(this);
		this.subFoldersList.add(subFolder);
		return true;
	}

	/**
	 * This method helps in finding subfolder
	 * @param subFolderName, name of the subFolder in which controller going to enter
	 * @return subFolder if exist else return "null"
	 */
	public Folder cd(String subFolderName) {

		return findSubfolder(subFolderName);
	}

	/**
	 * This method moves back to parent directory
	 * @param currentFolder as this
	 * @return parent folder of this folder
	 */
	public Folder bk() {

		return this.getParentFolder();
	}

	/**
	 * This method list all the directories
	 * @param currentFolder as this
	 * @return subFolders of this folder
	 */
	public List<Folder> ls() {
		
		return this.getSubFoldersList();
	}

	/**
	 * This method is used to find any folder in given directory
	 * @param subFolderName which we need to find recursively in subFolders
	 * @return foundSubFolder if folder exist else
	 */
	public Folder find(String subFolderName) {

		List<Folder> subFoldersList = this.getSubFoldersList();
		Folder foundFolder;
		for (Folder subFolder : subFoldersList) {
			// if this subFolder name is equal then return true
			if (subFolderName.equals(subFolder.getFolderName())) {
				return subFolder;
			}
		}

		for (Folder subFolder : subFoldersList) {
			foundFolder = subFolder.find(subFolderName);
			if (foundFolder != null) {
				return foundFolder;
			}
		}
		return null;
	}

	/**
	 * This method is used to find any folder in given directory
	 * @param name, name of the subFolder which is going to be find
	 * @return subFolder if exist else null if doesn't exist
	 */
	private Folder findSubfolder(String folderName) {

		for (Folder subFolder : this.getSubFoldersList()) {
			if (folderName.equals(subFolder.getFolderName())) {
				return subFolder;
			}
		}
		return null;
	}
}
