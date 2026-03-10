package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	public static Object[][] getTestData(String file, String sheetName) throws FileNotFoundException, IOException{
		
		Object[][] data = null;
		
		try (FileInputStream fis = new FileInputStream(file);
			Workbook wb =  WorkbookFactory.create(fis);)
		{
			Sheet sheet = wb.getSheet(sheetName);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			data = new Object[rowCount-1][colCount];
			DataFormatter formatter = new DataFormatter();
			for (int i=1 ; i<rowCount; i++) {
				Row row = sheet.getRow(i);
				
				for(int j =0; j<colCount; j++) {
						Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						data[i-1][j]=formatter.formatCellValue(cell);
				}
			}
		}
		catch(IOException e) {
			throw new RuntimeException("Failed to read file: "+file);
		}
		return data;
	}

}
