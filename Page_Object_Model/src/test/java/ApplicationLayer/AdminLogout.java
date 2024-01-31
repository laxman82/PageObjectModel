package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {
@FindBy(xpath="//li[@id='mi_logout']//a[@href='logout.php'][normalize-space()='Logout']")
WebElement objlogout;


	public void adminlogout() {
		objlogout.click();
	}
}
