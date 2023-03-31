package com.Actitime.GenericLibrary;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is generic class which is having non static method to perform data driven testing
 * @author User
 *
 */

public class FileLibrary {
	/**
	 * This method is a non static method which is used to read the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readDataFromProperty( String key) throws IOException 
{
	FileInputStream fis=new FileInputStream("./TestData/commondata.property.txt");
Properties p=new Properties();
p.load(fis);
String value = p.getProperty(key);
return value;
	}
/**
 * This method is non static method which is used to read the data from excel sheet
 * @param Sheet1
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public String readDataFromExcelFile(String Sheet1,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis1=new FileInputStream("./TestData/Textdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	String value = wb.getSheet(Sheet1).getRow(row).getCell(cell).getStringCellValue();
	return value;
}
}

