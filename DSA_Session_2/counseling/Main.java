package counseling;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try{
		CounselingProcess process = new CounselingProcess();
		String path = "C:/manoj/GETSample/PF/Allocation list.xls";
		String studentDetails = "C:/manoj/GETSample/PF/Students list.xls";
		String programDetails = "C:/manoj/GETSample/PF/Program list.xls";
			process.allocation(path, studentDetails, programDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}    
	}
}
