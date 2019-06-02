package datadrivenframework;

import static org.testng.Assert.assertThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcel 
{
	 
	 public static void getDataFromExcel(String fielPath,String fileName,String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException
	 {
	 	File file=new File(fielPath+"\\"+fileName);
		FileInputStream fis=new FileInputStream(file);
	
		Workbook workbook=null;
		String fileExtensionName=fileName.substring(fileName.indexOf("."));
		DataFormatter formatter=new DataFormatter();
		if(fileExtensionName.equals(".xlsx"))
		{
			workbook=new XSSFWorkbook(fis);
		}
		else 
			if(fileExtensionName.equals(".xls"))
		{
			workbook=new HSSFWorkbook(fis);
		}
	
		Sheet sheet=workbook.getSheet(sheetName);
		
		int totalRows=sheet.getLastRowNum();
		
		for (int i=1;i<=totalRows;i++)
		{	
			Row r=sheet.getRow(i);
			 
				String userName=formatter.formatCellValue(sheet.getRow(i).getCell(0));
				String passWord=formatter.formatCellValue(sheet.getRow(i).getCell(1));
				System.out.println("Username is  : "+userName);
				System.out.println("Password is  : "+passWord);
				System.out.println();
 		
		}
	
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	 	String filePath="D:\\PracticingSelenium\\InterviewQuestionSelenium\\excel";
		String fileName="testdata.xlsx";
		String sheetName="Sheet1";
		getDataFromExcel(filePath,fileName,sheetName);
	}
}
