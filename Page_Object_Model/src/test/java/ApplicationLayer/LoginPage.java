package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//define repository
      @FindBy(name="username")
      WebElement objuser;
      @FindBy(id="password")
      WebElement objpass;
      @FindBy(xpath="//button[@id='btnsubmit']")
      WebElement objlogin;
      @FindBy(name="btnreset")
      WebElement objreset;
      
      //define method for login
      public void adminLogin(String username,String password) 
      {
    	  objreset.click();
    	  objuser.sendKeys(username);
    	  objpass.sendKeys(password);
    	  objlogin.click();
      }
      
}
