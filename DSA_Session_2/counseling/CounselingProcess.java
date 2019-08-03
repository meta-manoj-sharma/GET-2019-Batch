package counseling;

import java.util.*;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/**
 * program to allocate branch to student according to rank
 * @author Manoj Sharma
 * Dated 1 august 2019
 */
public class CounselingProcess {
private Queue<String> queueOfStudents = new LinkedList<String>();
	private Map<String, Integer> programWithCap = new HashMap<String, Integer>();
	private Map<String, String> studentWithPref = new HashMap<String, String>();
/**
 * method to read files from storage in excel format
 * @param filePath files store in secondary storage
 * @param check check to select program file and student file
 * @throws Exception
 */
	private void readFile(String filePath, int check) throws Exception {
		int capacity;
		int index;
		String prefrence;
		File inputWorkbook = new File(filePath);
		Workbook work;
		work = Workbook.getWorkbook(inputWorkbook);
		// Get the first sheet
		Sheet sheet = work.getSheet(0);

		for (index = 1; index < sheet.getRows(); index++) {
			String name = sheet.getCell(0, index).getContents();
			if (check == 1) {
				capacity = Integer.parseInt(sheet.getCell(1, index).getContents());
				programWithCap.put(name, capacity);
			} else {
				prefrence = sheet.getCell(1, index).getContents();
				studentWithPref.put(name, prefrence);
				queueOfStudents.add(name);
			}
		}
	}
/**
 * method to allocate branch to student according to rank
 * @param path where to store output list 
 * @param studentPrefernce path of student list in form of string
 * @param programCapacity path of program list in form of string
 * @throws Exception
 */
	public void allocation(String path, String studentPrefernce, String programCapacity) throws Exception {
		readFile(programCapacity, 1);
		readFile(studentPrefernce, 2);
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(new File(path));
			WritableSheet sheet = workbook.createSheet("Output", 0);
			int count = 1;
			while (!queueOfStudents.isEmpty()) {
				String student = queueOfStudents.remove(); //get first student from queue
				String pref = studentWithPref.get(student);
				String[] preference = new String[5];

				preference = pref.split(","); // to separate student selected branches
				boolean assign = false;

				for (int index = 0; index < preference.length; index++) {
					if (assign){
						break;
					}
					String subject = preference[index];
					int capacity = programWithCap.get(subject);
					if (capacity > 0) {
						Label label = new Label(0, count, student); // to add in column first of excel sheet
						sheet.addCell(label);
						Label label1 = new Label(1, count, preference[index]); // to add in second column in excel sheet
						sheet.addCell(label1);
						count++;
						assign = true;
						capacity--;
						programWithCap.put(subject, capacity); // update the program sheet
					}
				}
			}
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
