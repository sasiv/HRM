package generics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class HRMLoginData {
	
	public static int getRow(String path,String sheet)
	{
		int rc=0;
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			rc = wb.getSheet(sheet).getLastRowNum();
			
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			 
			e.printStackTrace();
		}
		return rc;
	}
	
	public static String getCellValue(String path,String sheet,int row,int col)
	{
		String v="";
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			v = wb.getSheet(sheet).getRow(row).getCell(col).toString();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			
			e.printStackTrace();
		}
		
		return v;
	}

}
