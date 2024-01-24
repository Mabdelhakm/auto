package utils;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	File f;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	public Object[][] read_excel() {
		f = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "file.xlsx");
		try {
			wb = new XSSFWorkbook(f);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet("sheet1");
		int num_of_rows = sheet.getPhysicalNumberOfRows();
		int num_of_cols = sheet.getRow(0).getLastCellNum();
		String[][] obj = new String[num_of_rows - 1][num_of_cols];
		for (int i = 1; i < num_of_rows; i++) {
			for (int k = 0; k < num_of_cols; k++) {
				row = sheet.getRow(i);
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
