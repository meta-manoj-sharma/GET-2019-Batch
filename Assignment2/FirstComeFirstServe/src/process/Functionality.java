package process;
public class Functionality {
	/**
	 * 
	 * @param inputArray integer array which is gethering processes
	 * @param UserInput number of process
	 * @return sorted array
	 */
	public static int[][] sortProcess(int inputArray[][], int UserInput) {
		for (int k = 0; k < UserInput; k++) { // bubble sorting method to sort input processes
			for (int i = 1; i < UserInput; i++) {
				if (inputArray[i][0] < inputArray[i - 1][0]) {
					int temp = 0;
					temp = inputArray[i][0];
					inputArray[i][0] = inputArray[i - 1][0]; //Swapping of arrival time
					inputArray[i - 1][0] = temp;
					temp = 0;
					temp = inputArray[i][1];
					inputArray[i][1] = inputArray[i - 1][1]; //swapping of burst time
					inputArray[i - 1][1] = temp;
				}
			}
		}
		return inputArray;
	}
    /**
	 * 
	 * @param inputArray integer array which is gathering processes
	 * @param UserInput number of process
	 * @return return completion time of each process in array form
	 */
	public static int[] completionTime(int inputArray[][], int UserInput) {
		int compilationTimeArray[] = new int[UserInput];
		compilationTimeArray[0] = inputArray[0][0] + inputArray[0][1];
		for (int i = 1; i < UserInput; i++) {
			if (inputArray[i][0] < compilationTimeArray[i - 1]) {
				compilationTimeArray[i] = inputArray[i][1]
						+ compilationTimeArray[i - 1];
			} else {
				compilationTimeArray[i] = inputArray[i][0] + inputArray[i][1];
			}
		}
		return compilationTimeArray;
	}
	/**
	 * 
	 * @param inputArray integer array which is gathering processes
	 * @param UserInput number of process
	 * @param turnAroundTime array of process
	 * @return return waiting time of each process in array form
	 */
	public static int[] waitingTime(int inputArray[][], int turnAroundTime[],
			int UserInput) {
		int waitingTimeArray[] = new int[UserInput];
		for (int i = 0; i < UserInput; i++) {
			waitingTimeArray[i] = turnAroundTime[i] - inputArray[i][1];
		}
		return waitingTimeArray;
	}
	/**
	 * 
	 * @param inputArray integer array which is gethering processes
	 * @param compilationTime array of processes
	 * @param UserInput number of process
	 * @return return turnAroundTime of each process in array form
	 */
	public static int[] turnAroundTime(int inputArray[][],
			int compilationTime[], int UserInput) {
		int turnAroundTimeArray[] = new int[UserInput];
		for (int i = 0; i < UserInput; i++) {
			turnAroundTimeArray[i] = compilationTime[i] - inputArray[i][0];
		}
		return turnAroundTimeArray;
	}
	/**
	 * 
	 * @param waitingTime array of waiting time of all processes
	 * @param UserInput no of process
	 * @return average waiting time
	 */
	public static double averageWaitingTime(int waitingTime[], double UserInput) {
		double sum = 0;
		for (int i = 0; i < UserInput; i++) {
			sum += waitingTime[i];
		}
		return sum / UserInput;
    }
	/**
	 * 
	 * @param waitingTime array of waiting time of all processes
	 * @param UserInput no of process
	 * @return maximum waiting time
	 */
      public static int maximumWaitingTimePeriod(int waitingTime[], int UserInput) {
		int max = 0;
		for (int i = 0; i < UserInput; i++) {
			if (max < waitingTime[i]) {
				max = waitingTime[i];
			}
		}
		return max;
	}
}