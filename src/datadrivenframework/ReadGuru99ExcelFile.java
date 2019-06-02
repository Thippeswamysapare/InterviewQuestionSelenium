package datadrivenframework;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadGuru99ExcelFile {

    public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

    //Create an object of File class to open xlsx file

    File file =    new File(filePath+"\\"+fileName);

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);

    Workbook guru99Workbook = null;

    //Find the file extension by splitting file name in substring  and getting only extension name

    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){

    //If it is xlsx file then create object of XSSFWorkbook class

    guru99Workbook = new XSSFWorkbook(inputStream);

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of XSSFWorkbook class

        guru99Workbook = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
    DataFormatter formatter = new DataFormatter();
    //Find number of rows in excel file

    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

    //Create a loop over all the rows of excel file to read it

    for (int i = 1; i <=rowCount; i++) {

        Row row = guru99Sheet.getRow(i);

        //Create a loop to print cell values in a row
              
        
            //Print Excel data in console
        	//String celldata=cell.getStringCellValue();
         
        		String username=formatter.formatCellValue(guru99Sheet.getRow(i).getCell(0));
        		String password=formatter.formatCellValue(guru99Sheet.getRow(i).getCell(1));
                System.out.print("usernname :"+username+"||"+"and password is :"+password);
                System.out.println();
        	 
        

        System.out.println();
    } 

    }  

    //Main function is calling readExcel function to read data from excel file

    public static void main(String...strings) throws IOException{

    //Create an object of ReadGuru99ExcelFile class

    ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();

    //Prepare the path of excel file

    String filePath = "D:\\PracticingSelenium\\InterviewQuestionSelenium\\excel";

    //Call read file method of the class to read data

    objExcelFile.readExcel(filePath,"testdata.xlsx","Sheet1");

    }

}