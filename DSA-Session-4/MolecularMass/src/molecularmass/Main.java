package molecularmass;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		MolecularMass molecularMass = new MolecularMass();
		String choice;
		int flag;
		try {
			while (true) {
				System.out.println("Enter compound formula contains only C, H and O molecule");
				choice = input.nextLine();
				System.out.println("molecuar mass is  "+ molecularMass.calculateMass(choice));
				System.out.println("Press 0 to exit or any number to continue");
				flag = input.nextInt();
				input.nextLine();
					if (flag == 0) {
						System.out.println("Program exit....");
						System.exit(0);
					}
			}
		} catch (Exception e) {
			System.out.println("Invalid data ");
			main(args);
		}
	}
}
