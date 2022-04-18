package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginObjects {
    private WebDriver driver;
    @FindBy(id = "login-email")
    public WebElement txtemail;
    @FindBy(id = "login-password")
    public WebElement txtpassword;
    @FindBy(css = "button[type='submit']")
    public WebElement btnSubmit;
    //@FindBy(css = "span[class='text-primary']")6
    @FindBy(css = "div[style='color: red; margin-bottom: 15px;']")
    public WebElement WrongTitle;

    @FindBy(css = "")
    public WebElement ExspectTitle;

    public loginObjects(WebDriver driver){
        PageFactory.initElements(driver,this );
    }
    public  void ContactUsForm(String email, String password){
        txtemail.sendKeys(email);
        txtpassword.sendKeys(password);
    }
}
