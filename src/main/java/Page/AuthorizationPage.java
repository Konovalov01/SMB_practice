package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage extends BasePage{

    public AuthorizationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private String login = "k4r4bast";
    private String password = "karabast123";

    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement passwordInput;

    public AuthorizationPage usernameEnter() throws InterruptedException {
        Thread.sleep(700);
        usernameInput.click();
        usernameInput.sendKeys(login, Keys.ENTER);
        return this;
    }
    public AuthorizationPage passwordEnter() throws InterruptedException {
        Thread.sleep(700);
        passwordInput.click();
        passwordInput.sendKeys(password, Keys.ENTER);
        return this;
    }

}
