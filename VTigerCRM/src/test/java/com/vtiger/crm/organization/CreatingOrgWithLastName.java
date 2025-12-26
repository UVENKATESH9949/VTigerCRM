package com.vtiger.crm.organization;

import org.testng.annotations.Test;

import com.vtiger.crm.baseclass.BaseClass;
import com.vtiger.crm.generic.fileUtility.XL_Utility;
import com.vtiger.crm.generic.webDriverUtility.JavaUtility;
import com.vtiger.generic.ObjectRepository.HomePage;
import com.vtiger.generic.ObjectRepository.NewOrganizationCreationPage;
import com.vtiger.generic.ObjectRepository.OrganizationCreatingConformationPage;
import com.vtiger.generic.ObjectRepository.OrganizationPage;

public class CreatingOrgWithLastName extends BaseClass{

	@Test
	public void CreateOrganizationTest() throws Exception {
		
		XL_Utility xu = new XL_Utility();
		JavaUtility ju = new JavaUtility();
		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		NewOrganizationCreationPage n = new NewOrganizationCreationPage(driver);
		
		hp.getOrganizationLink().click();
		
		op.getNewOrgLink().click();
		
		String orgname =xu.getDataFromExcel("data", 1, 0).toString()+ju.getRandomNumber();
		String shippingAddress = xu.getDataFromExcel("data", 1, 0).toString();

		n.createOrg(orgname,shippingAddress);
		
		Thread.sleep(2000);
		String header =new OrganizationCreatingConformationPage(driver).getHeader().getText();
		if(header.contains(orgname)) {
			System.out.println(orgname +" is created == pass");
		}else {
			System.out.println(orgname+" is not created == Fail");
		}
	}
}
