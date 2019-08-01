package counseling;

import static org.junit.Assert.*;
import jxl.write.WriteException;

import org.junit.Test;

public class CounselingProcessTest {


	@Test
	public void test() throws Exception
	{
		CounselingProcess process = new CounselingProcess();
		String path = "C:/manoj/GETSample/PF/Allocation list.xls";
		String studentDetails = "C:/manoj/GETSample/PF/Students list.xls";
		String programDetails = "C:/manoj/GETSample/PF/Program list.xls";
		process.allocation(path, studentDetails, programDetails);
		
	}
	// check exception which is file not found
	@Test(expected = Exception.class)
	public void test1() throws Exception
	{
		CounselingProcess process = new CounselingProcess();
		String path = "output.xls";
		String studentDetails = "studentDetails.xls";
		String programDetails = "programDetails.xls";
		process.allocation(path, studentDetails, programDetails);
		
	}
}
