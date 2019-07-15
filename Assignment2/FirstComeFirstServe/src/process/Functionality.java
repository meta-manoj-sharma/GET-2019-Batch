package process;

public class Functionality {
/**
 * 
 * @param InputArray integer array which is gethering processes
 * @param UserInput number of process
 * @return sorted array
 */
	public static int[][] SortProcess(int InputArray[][], int UserInput) {
		for(int k=0;k<UserInput;k++){
		for (int i = 1; i < UserInput; i++) {
			if (InputArray[i][0] < InputArray[i - 1][0]) {
				int temp = 0;
				temp = InputArray[i][0];
				InputArray[i][0] = InputArray[i - 1][0];
				InputArray[i - 1][0] = temp;
				temp = 0;
				temp = InputArray[i][1];
				InputArray[i][1] = InputArray[i - 1][1];
				InputArray[i - 1][1] = temp;
			}
		}
		}
		return InputArray;
	}
/**
 * 
 * @param InputArray integer array which is gathering processes
 * @param UserInput number of process
 * @return return completion time of each process in array form
 */
	public static int[] CompletionTime(int InputArray[][], int UserInput) {
		int CompilationTimeArray[] = new int[UserInput];
		CompilationTimeArray[0] = InputArray[0][0] + InputArray[0][1];
		for (int i = 1; i < UserInput; i++) {
			if (InputArray[i][0] < CompilationTimeArray[i - 1]) {
				CompilationTimeArray[i] = InputArray[i][1] + CompilationTimeArray[i - 1];
			} else {
				CompilationTimeArray[i] = InputArray[i][0] + InputArray[i][1];
			}
		}
		return CompilationTimeArray;
	}
	/**
	 * 
	 * @param InputArray integer array which is gathering processes
	 * @param UserInput number of process
	 *  @param  TurnAroundTime array of process
	 * @return return waiting time of each process in array form
	 */

	public static int[] WaitingTime(int InputArray[][], int TurnAroundTime[], int UserInput) {
		int WaitingTimeArray[] = new int[UserInput];
		for (int i = 0; i < UserInput; i++) {
			WaitingTimeArray[i] = TurnAroundTime[i] - InputArray[i][1];
		}

		return WaitingTimeArray;
	}
	/**
	 * 
	 * @param InputArray integer array which is gethering processes
     * @param CompilationTime array of processes
	 * @param UserInput number of process
	 * @return return TurnAroundTime  of each process in array form
	 */


	public static int[] TurnAroundTime(int InputArray[][], int CompilationTime[], int UserInput) {
		int TurnAroundTimeArray[] = new int[UserInput];
		for (int i = 0; i < UserInput; i++) {
			TurnAroundTimeArray[i] = CompilationTime[i] - InputArray[i][0];
		}
		return TurnAroundTimeArray;

	}
	/**
	 * 
	 * @param WaitingTime array of waiting time of all processes
	 * @param UserInput no of process
	 * @return average waiting time
	 */

	public static double AverageWaitingTime(int WaitingTime[], double UserInput) {
		double sum = 0;
		for (int i = 0; i < UserInput; i++) {
			sum += WaitingTime[i];
		}

		return sum / UserInput;

	}
	/**
	 * 
	 * @param WaitingTime array of waiting time of all processes
	 * @param UserInput no of process
	 * @return maximum waiting time
	 */

	public static int MaximumWaitingTimePeriod(int WaitingTime[], int UserInput) {
		int max = 0;
		for (int i = 0; i < UserInput; i++) {
			if (max < WaitingTime[i]) {
				max = WaitingTime[i];
			}
		}
		return max;
	}
}