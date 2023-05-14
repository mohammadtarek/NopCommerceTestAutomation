package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelReader {

	 FileInputStream fis ;

	public FileInputStream getFileInput() {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\exeldata.xlsx";
				
				File srcFile = new File(filePath);
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {

			System.out.println("Error Exel test data file not found " + e.getMessage());
			System.exit(0);// to exit and not to continue

		}
		return fis;
	}

	

	public Object[][] getExelData() throws IOException {
		fis = getFileInput();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int totalNumberOfRows = sheet.getLastRowNum() +1;
		int totalNumberOfCols = 4;
		
		
		
		 String[][] arrayOfExelData = new String[totalNumberOfRows][totalNumberOfCols];
		for (int i = 0; i < totalNumberOfRows; i++) {
			for (int j = 0; j < totalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayOfExelData[i][j] = row.getCell(j).toString();
			}

		}

		wb.close();
		return arrayOfExelData;
	}

}
