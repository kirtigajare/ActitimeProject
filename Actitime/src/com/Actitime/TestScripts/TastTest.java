package com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom.TaskPage;
import com.Actitime.pom.homePage;

public class TastTest extends BaseClass {
@Test
public void creatcustomer() throws EncryptedDocumentException, IOException {
homePage h	=new homePage(driver);
h.getTasklnk().click();
TaskPage tp=new TaskPage(driver);
tp.getAddnewbtn().click();
tp.getNewcust().click();
FileLibrary f= new FileLibrary();
String name = f.readDataFromExcelFile("Sheet1", 4, 0);
tp.getCustname().sendKeys(name);
String description = f.readDataFromExcelFile("Sheet1", 4, 2);
tp.getCustdest().sendKeys(description);
tp.getCreatcust().click();

}
}
