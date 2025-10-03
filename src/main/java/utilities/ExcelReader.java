package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
public static Map<String, String> readData(String filePath, String sheetName) {
		Map<String, String> rowData = new HashMap<>();
		List<Map<String, String>> data = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = WorkbookFactory.create(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in file: " + filePath);
			}

			// Assuming first row is header
			Row headerRow = sheet.getRow(0);
			int colCount = headerRow.getLastCellNum();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
			    if (row == null || isRowEmpty(row)) continue;
				if (row == null)
					continue;

				for (int j = 0; j < colCount; j++) {
					Cell headerCell = headerRow.getCell(j);
					Cell cell = row.getCell(j);

					String key = headerCell.getStringCellValue();
					String value = (cell == null) ? "" : cell.toString();
					rowData.put(key, value);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowData;
	}

public static List<Map<String, String>> readMultiRowData(String filePath, String sheetName) {
	//Map<String, String> rowData = new HashMap<>();
	List<Map<String, String>> data = new ArrayList<>();
	try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = WorkbookFactory.create(fis)) {

		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in file: " + filePath);
		}

		// Assuming first row is header
		Row headerRow = sheet.getRow(0);
		int colCount = headerRow.getLastCellNum();
		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
		    if (row == null || isRowEmpty(row)) continue;
			if (row == null)
				continue;
			Map<String, String> rowData = new LinkedHashMap<>();
			for (int j = 0; j < colCount; j++) {
				Cell headerCell = headerRow.getCell(j);
				Cell cell = row.getCell(j);

				String key = headerCell.getStringCellValue();
				String value = (cell == null) ? "" : cell.toString();
				System.out.println("ExcelReader.readMultiRowData::key: "+ key + " , value: " + value );
				//System.out.println("value" + value);
				rowData.put(key, value);
			}
			data.add(rowData);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	return data; //rowData;
}
		
	private static boolean isRowEmpty(Row row) {
	    if (row == null) return true;

	    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != CellType.BLANK) {
	            if (cell.getCellType() == CellType.STRING && !cell.getStringCellValue().trim().isEmpty()) {
	                return false;
	            } else if (cell.getCellType() != CellType.STRING) {
	                return false;
	            }
	        }
	    }
		return false;

	}
}
