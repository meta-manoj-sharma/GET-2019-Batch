package virtualcommand;

import java.util.*;
/**
 * this program is virtual command prompt
 * @author Manoj Sharma
 * Dated 2 august 2019
 */
public class Command {
	Folder currentFolder;
	List<String> foldersList = new ArrayList<String>();

	public void setCurrentFolder(Folder currentFolder) {
		this.currentFolder = currentFolder;
	}

	public Folder getCurrentFolder() {
		return currentFolder;
	}

	public List<String> getFoldersList() {
		return foldersList;
	}

	public Command() {
		currentFolder = new Folder("R");
	}

	/**
	 * This method to start cmd line by selecting user input
	 */
	public void runVcp() {

		String inputCommand;
		Scanner input = new Scanner(System.in);
		while (true) {

			printPath();
			inputCommand = input.nextLine();

			String[] commands = inputCommand.split(" ");
			if (commands.length == 1) {

				switch (commands[0]) {

				case "bk":
					bk();
					break;

				case "ls":
					ls();
					break;

				case "tree":
					tree();
					break;
				case "exit":
					System.exit(0);
					break;

				default:
					System.out.println("Command Not found");
				}
			}

			else if (commands.length == 2) {
				switch (commands[0]) {

				case "mkdir":
					mkdir(commands[1]);
					break;

				case "cd":
					cd(commands[1]);
					break;

				case "find":
					search(commands[1]);
					break;

				default:
					System.out.println("Command Not found");
				}
			}
		}
	}

	/**
	 * This method for mkdir command (make directory)
	 * @param folderName
	 */
	public void mkdir(String folderName) {
		boolean status = getCurrentFolder().mkdir(folderName);
		if (status == false) {
			System.out.println("folder already exist with same name then new folder will not create");
		}
	}

	/**
	 * This method is for cd command (change directory)
	 * @param folderName is name of folder
	 */
	public void cd(String folderName) {
		Folder subFolder = getCurrentFolder().cd(folderName);
		if (subFolder != null) {
			setCurrentFolder(subFolder);
			foldersList.add(subFolder.getFolderName());
		} else {
			System.out.println("folder doesn't exist with this name");
		}
	}

	/**
	 * This method is for search command
	 * @param folderName is name of folder
	 */
	public void search(String folderName) {
		Folder foundFolder = getCurrentFolder().find(folderName);
		if (foundFolder != null) {
			String path = getPathOfFolder(foundFolder);
			System.out.println(path);
		} else {
			System.out.println("Not Found");
		}
	}

	/**
	 * This method is for getting path of the folder
	 * @param folderName is name of folder
	 */
	private String getPathOfFolder(Folder foundFolder) {
		Folder currentFolder = foundFolder;
		Stack<String> folders = new Stack<String>();
		String path = new String(" ");
		while (currentFolder != null) {
			folders.push(currentFolder.getFolderName());
			currentFolder = currentFolder.getParentFolder();
		}
		while (!folders.empty()) {
			path = path + "/" + folders.pop();
		}
		return path;
	}

	/**
	 * This method is for bk command(back to directory)
	 */
	public void bk() {
		if (getCurrentFolder().getParentFolder() != null) {
			setCurrentFolder(getCurrentFolder().getParentFolder());
			foldersList.remove(foldersList.size() - 1);
		}
	}

	/**
	 * This method is for ls command(list command)
	 */
	public void ls() {
		List<Folder> subFolders = getCurrentFolder().ls();

		for (Folder subFolder : subFolders) {
			System.out.println(subFolder.getDateAndTime() + "  " + subFolder.getFolderName());
		}
	}

	public void tree() {
		printTree(getCurrentFolder(), 0);
	}

	/**
	 * This method is for printing tree of the directory
	 * @param currentDirectory is the present directory
	 * @param nesting is sub folders range
	 */
	private void printTree(Folder currentDirectory, int nesting) {
		for (Folder subDirectory : currentDirectory.getSubFoldersList()) {
			for (int i = 0; i < nesting; i++)
				System.out.print(" --> ");
			if (subDirectory.getSubFoldersList().size() != 0) {
				System.out.println("--> " + subDirectory.getFolderName());
				printTree(subDirectory, nesting + 1);
			} else
				System.out.println("-->--> " + subDirectory.getFolderName());
		}
	}

	/**
	 * This method prints path
	 */
	private void printPath() {
		System.out.print("R:");
		for (String folderName : getFoldersList()) {
			System.out.print("\\" + folderName);
		}
		System.out.print(">");
	}
}
