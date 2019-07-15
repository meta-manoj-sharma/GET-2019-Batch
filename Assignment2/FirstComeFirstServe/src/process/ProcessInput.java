package process;

import java.util.*;

public class ProcessInput {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			Scanner choice = new Scanner(System.in);
			System.out.println("Enter number of process to be processed");
			final int UserInput = choice.nextInt();
			int InputArray[][] = new int[UserInput][2];
			for (int i = 0; i < UserInput; i++) {
				for (int j = 0; j < 2; j++) {
					if (j == 0) {
						System.out.print("Enter arrival time for process" + " " + (i + 1));
					} else
						System.out.print("Enter burst time for process" + " " + (i + 1));

					int UserTime;
					UserTime = choice.nextInt();
					if (UserTime >= 0) {
						InputArray[i][j] = UserTime;
					} else {
						System.out.println("Enter again time is not valid ...");
						j = j - 1;                               //to return column in its initial positin
					}

				}
			}
			InputArray = Functionality.SortProcess(InputArray, UserInput);   //to get sort array
			if (UserInput > 0) {
				System.out.println(
						"ArrivalTime \t" + "BurstTime\t" + "ComplitionTime\t" + "TurnAroundTime\t " + "WaitingTime\t");
			}
			int CompilationTime[] = new int[UserInput];
			int WaitingTime[] = new int[UserInput];
			int TurnAroundTime[] = new int[UserInput];
			CompilationTime = Functionality.CompletionTime(InputArray, UserInput);    // to get completion time array
			TurnAroundTime = Functionality.TurnAroundTime(InputArray, CompilationTime, UserInput);  // to get turn around time array
			WaitingTime = Functionality.WaitingTime(InputArray, TurnAroundTime, UserInput);         // to get waiting time array

			for (int i = 0; i < UserInput; i++) {
				System.out.println("");
				for (int j = 0; j < 2; j++) {
					System.out.print(InputArray[i][j] + "\t\t");
				}
				System.out.print(" " + CompilationTime[i] + "\t\t\t" + TurnAroundTime[i] + "\t\t" + WaitingTime[i]);
			}
			int maximumWaitingTimePeriod = Functionality.MaximumWaitingTimePeriod(WaitingTime, UserInput);   //to get maximum waiting time
			double averageWaitingTime = Functionality.AverageWaitingTime(WaitingTime, UserInput);            // to get average waiting time
			System.out.println("");
			System.out.println(" Maximum Waiting Time Period =" + maximumWaitingTimePeriod);
			System.out.println(" Average Waiting Time =" + averageWaitingTime);
		} catch (Exception e) {
			System.out.println("Invalid entry...enter again..");
			main(args);
		}
	}

}