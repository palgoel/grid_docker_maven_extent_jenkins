package utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataProvider {
	
	XSSFWorkbook wb;
	public excelDataProvider() {
		File src = new File("./testData/data.xlsx");
		try {
			FileInputStream file = new FileInputStream(src);
			wb = new XSSFWorkbook(file);
			
		} catch (Exception e) {
			System.out.println("Unable to dat excel file"+e.getMessage());
		}
				
	}
	public String getStringData(int sheetindex, int row,int num) {
		return wb.getSheetAt(sheetindex).getRow(row).getCell(num).getStringCellValue();
	}
	public String getStringData(String sheetname, int row,int num) {
		return wb.getSheet(sheetname).getRow(row).getCell(num).getStringCellValue();
	}
	public double geNumData(String sheetname, int row,int num) {
		return wb.getSheet(sheetname).getRow(row).getCell(num).getNumericCellValue();
	}

}
