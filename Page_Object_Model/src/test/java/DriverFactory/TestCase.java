package DriverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ApplicationLayer.customer_page;
import config.AppUtills;
import utilities.ExcelFileUtils;

public class TestCase extends AppUtills{
	String inputpath="./Fileinput/cdata.xlsx";
	String output="./Fileoutput/addcustomer.xlsx";
	ExtentReports reports;
	ExtentTest logger;
	@Test
	public void starttest() throws Throwable {
		reports=new ExtentReports("./target/reports/creports.html");
		ExcelFileUtils xl=new ExcelFileUtils(inputpath);
		int rc=xl.rowCount("cdata");
		Reporter.log("row count:"+rc,true);
		for(int i=1;i<=rc;i++)
		{   logger=reports.startTest("add_customer validation");
		    logger.assignAuthor("laxman");
		    logger.assignCategory("customer module");
			String customername=xl.getCellData("cdata", i, 0);
			String address=xl.getCellData("cdata", i, 1);
			String city=xl.getCellData("cdata", i, 2);
			String country=xl.getCellData("cdata", i, 3);
			String cperson=xl.getCellData("cdata", i, 4);
			String pnumber=xl.getCellData("cdata", i, 5);
			String email=xl.getCellData("cdata", i, 6);
			String mnumber=xl.getCellData("cdata", i, 7);
			String notes=xl.getCellData("cdata", i, 8);
			customer_page cp=PageFactory.initElements(driver, customer_page.class);
			boolean res=cp.add_customer(customername, address, city, country, cperson, pnumber, email, mnumber, notes);
			if (res) {
				xl.setcelldata("cdata", i, 9, "pass", output);
				logger.log(LogStatus.PASS, "add_customer is success");
			}
			else {
				File sc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(sc, new File("./screenshot/customerscreenshot/"+i+"Login.png"));
				xl.setcelldata("cdata", i, 9, "fail", output);
				logger.log(LogStatus.FAIL, "add_customer is not success");
			}
			reports.endTest(logger);
			reports.flush();
		}
	}

}
