package process;

import java.util.*;

public class ProcessInput {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			Scanner choice = new Scanner(System.in);
			System.out.println("Enter number of process to be processed");
			final int UserInput = choice.nextInt();
			int inputArray[][] = new int[UserInput][2];
			int CompilationTime[] = new int[UserInput];
			int waitingTime[] = new int[UserInput];
			int turnAroundTime[] = new int[UserInput];
			int maximumwaitingTimePeriod;
			double averagewaitingTime;
			for (int i = 0; i < UserInput; i++) {
				for (int j = 0; j < 2; j++) {
					if (j == 0) {
						System.out.print("Enter arrival time for process" + " "
								+ (i + 1));
					} else
						System.out.print("Enter burst time for process" + " "
								+ (i + 1));
					int UserTime;
					UserTime = choice.nextInt();
					if (UserTime >= 0) {
						inputArray[i][j] = UserTime;
					} else {
						System.out.println("Enter again time is not valid ...");
						j = j - 1; // to return column in its initial positin
					}
				}
			}
			inputArray = Functionality.sortProcess(inputArray, UserInput); // to get sort array
			if (UserInput > 0) {
				System.out.println("ArrivalTime \t" + "BurstTime\t"
						+ "ComplitionTime\t" + "turnAroundTime\t "
						+ "waitingTime\t");
			}
			CompilationTime = Functionality.completionTime(inputArray,UserInput); // to get completion time array
			turnAroundTime = Functionality.turnAroundTime(inputArray,CompilationTime, UserInput); // to get turn around time array
			waitingTime = Functionality.waitingTime(inputArray, turnAroundTime,UserInput); // to get waiting time array
			for (int i = 0; i < UserInput; i++) {
				System.out.println("");
				for (int j = 0; j < 2; j++) {
					System.out.print(inputArray[i][j] + "\t\t");
				}
				System.out.print(" " + CompilationTime[i] + "\t\t\t"
						+ turnAroundTime[i] + "\t\t" + waitingTime[i]);
			}
			maximumwaitingTimePeriod = Functionality.maximumWaitingTimePeriod(waitingTime, UserInput); // to get maximum waiting time
			averagewaitingTime = Functionality.averageWaitingTime(waitingTime,UserInput); // to get average waiting time
			System.out.println("");
			System.out.println(" Maximum Waiting Time Period ="+ maximumwaitingTimePeriod);
			System.out.println(" Average Waiting Time =" + averagewaitingTime);
		} catch (Exception e) {
			System.out.println("Invalid entry...enter again..");
			main(args);
		}
	}

}