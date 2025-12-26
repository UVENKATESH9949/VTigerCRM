package com.vtiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.baseclass.BaseClass;

public class NewOrganizationCreationPage extends BaseClass{

	WebDriver driver;
	public NewOrganizationCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgnameedit;
	
	@FindBy(name = "ship_street")
	private WebElement shippingAddress;

	@FindBy(name = "button")
	private WebElement savebtn;
	
	@FindBy(name = "industry")
	private WebElement industryselect;
	
	@FindBy(id = "phone")
	private WebElement phoneedit;
	
	public WebElement getOrgname() {
		return orgnameedit;
	}

	public WebElement getShippingAddress() {
		return shippingAddress;
	}
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	
	public WebElement getIndustryselect() {
		return industryselect;
	}

	
	public WebElement getPhoneedit() {
		return phoneedit;
	}

	public void createOrg(String orgname, String shippingAdd) {
		orgnameedit.sendKeys(orgname);
		shippingAddress.sendKeys(shippingAdd);
		savebtn.click();
	}
}
