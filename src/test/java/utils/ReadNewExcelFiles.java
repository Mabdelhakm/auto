package utils;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadNewExcelFiles {
	File f;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	String sheetName;
	public ReadNewExcelFiles(String sheetName) {
		this.sheetName=sheetName;
	}
	public Object[][] read_excel() {
		//define xlsx path and read the workbook
		f = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "file.xlsx");
		try {
			wb = new XSSFWorkbook(f);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//define the required sheet
		sheet = wb.getSheet(sheetName);
		//initialize varibles with number of rows -1 [the header] and the number of rows
		int num_of_rows = sheet.getPhysicalNumberOfRows();
		int num_of_cols = sheet.getRow(0).getLastCellNum();
		//declare the object[][]
		String[][] obj = new String[num_of_rows - 1][num_of_cols];
		//loop over all rows next to header
		for (int i = 1; i < num_of_rows; i++) {
			//loop over all columns
			for (int k = 0; k < num_of_cols; k++) {
				//declare current row 
				row = sheet.getRow(i);
				//if the row is null add "" to the object & convert all types into string
				if (row != null && row.getCell(k) != null) {
					if (row.getCell(k).getCellType() == CellType.NUMERIC) {
						obj[i - 1][k] = String.valueOf(row.getCell(k));
					} else if (row.getCell(k).getCellType() == CellType.BLANK) {
						obj[i - 1][k] = String.valueOf(row.getCell(k));
					} else if (row.getCell(k).getCellType() == CellType.BOOLEAN) {
						obj[i - 1][k] = String.valueOf(row.getCell(k));
					} else {
						obj[i - 1][k] = String.valueOf(row.getCell(k));
					}
				} else {
					obj[i - 1][k] = "";
				}
			}
		}
		return obj;
	}
}
