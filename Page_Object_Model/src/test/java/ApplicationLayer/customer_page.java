package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class customer_page {
WebDriver driver;
public customer_page(WebDriver driver) {
	this.driver=driver;
}
//defining repositories
@FindBy(xpath="//li[@id='mi_a_customers']//a[@href='a_customerslist.php'][normalize-space()='Customers']")
WebElement objcustomerlink;
@FindBy(xpath="//div[@class='panel-heading ewGridUpperPanel']//a[@class='btn btn-default ewAddEdit ewAdd btn-sm']")
WebElement pluseicon;
@FindBy(xpath="//input[@id='x_Customer_Number']")
WebElement objcustomernumber;
@FindBy(xpath="//input[@id='x_Customer_Name']")
WebElement objcustomername;
@FindBy(xpath="//textarea[@id='x_Address']")
WebElement objadderss;
@FindBy(xpath="//input[@id='x_City']")
WebElement objcity;
@FindBy(xpath="//input[@id='x_Country']")
WebElement objcountry;
@FindBy(xpath="//input[@id='x_Contact_Person']")
WebElement objcontactperson;
@FindBy(xpath="//input[@id='x_Phone_Number']")
WebElement objphonenumber;
@FindBy(xpath="//input[@id='x__Email']")
WebElement objemail;
@FindBy(xpath="//input[@id='x_Mobile_Number']")
WebElement objmobilenumber;
@FindBy(xpath="//input[@id='x_Notes']")
WebElement objnotes;
@FindBy(xpath="//button[@id='btnAction']")
WebElement objadd_btn;
@FindBy(xpath="//button[normalize-space()='OK!']")
WebElement objconfirmok;
@FindBy(xpath="//button[@class='ajs-button btn btn-primary']")
WebElement objalertok;
@FindBy(xpath="//span[@class='glyphicon glyphicon-search ewIcon']")
WebElement objsearchpannel;
@FindBy(xpath="//input[@id='psearch']")
WebElement objsearchtxt;
@FindBy(xpath="//button[@id='btnsubmit']")
WebElement objsearchbtn;
@FindBy(xpath="//tr[@id='r1_a_customers']//td[@data-name='Customer_Number']//div")
WebElement webtable;

//define method
public boolean add_customer(String customername,String address, String city,
		String country,String contactperson,
		String phonenumber,String email,String mobilenumber,String notes) throws Throwable 
{
	this.objcustomerlink.click();
	this.pluseicon.click();
	String exp_num=this.objcustomernumber.getAttribute("value");
	this.objcustomername.sendKeys(customername);
	this.objadderss.sendKeys(address);
	this.objcity.sendKeys(city);
	this.objcountry.sendKeys(country);
	this.objcontactperson.sendKeys(contactperson);
	this.objphonenumber.sendKeys(phonenumber);
	this.objemail.sendKeys(email);
	this.objmobilenumber.sendKeys(mobilenumber);
	this.objnotes.sendKeys(notes);
	this.objadd_btn.click();
	Thread.sleep(2000);
	this.objconfirmok.click();
	Thread.sleep(2000);
	this.objalertok.click();
	if(!this.objsearchtxt.isDisplayed())
		this.objsearchpannel.click();
	this.objsearchtxt.clear();
	Thread.sleep(3000);
	this.objsearchtxt.sendKeys(exp_num);
	Thread .sleep(2000);
	this.objsearchbtn.click();
	Thread .sleep(2000);
    String act_num=this.webtable.getText();
    if(act_num.equals(exp_num))
    {
    	Reporter.log("customer added success",true);
    	return true;
    }
    else 
    {
    	Reporter.log("customer not added",true);
    	return false;
    }
	
}

}
