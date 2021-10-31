package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

public class AuthorizationPage extends BasePage{

    public AuthorizationPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
        this.driver = driver;
    }

    private String searchButtonSelector = "button[class^='button m']";

    @FindBy(id = "passp-field-login")
    private WebElement usernameInput;
    @FindBy(id = "passp-field-passwd")
    private WebElement passwordInput;

    public YandexPage authorization(String login,String password, String startLink) throws InterruptedException {
        usernameInput.click();
        usernameInput.sendKeys(login, Keys.ENTER);

        passwordInput.click();
        passwordInput.sendKeys(password, Keys.ENTER);

        return new YandexPage(driver);
    }

}
