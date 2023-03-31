package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	//declaration
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement addnewbtn;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement newcust;
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name')[2]]")
	private WebElement custname;
	
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdest;
	
	@FindBy(xpath="(//div[.='Create Customer]")
	private WebElement creatcust;
	
	//initialization
	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
//utilization

	public WebElement getAddnewbtn() {
		return addnewbtn;
	}


	public WebElement getNewcust() {
		return newcust;
	}


	public WebElement getCustname() {
		return custname;
	}


	public WebElement getCustdest() {
		return custdest;
	}


	public WebElement getCreatcust() {
		return creatcust;
	}
  
}
