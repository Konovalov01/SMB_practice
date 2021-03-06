package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class YandexPage extends BasePage{

    public YandexPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
        this.driver = driver;
    }

    public YandexPage goToStartLink(String link) {
        driver.get(link);
        return this;
    }

    private String enterButtonSelector = "a[class^='home-link desk-notif-card__login']";
    @FindBy(css = "a[class^='home-link desk-notif-card__login']")
    private WebElement enterButton;

    private String mailButtonSelector = "a[class^='home-link desk-notif-card__d']";
    @FindBy(css = "a[class^='home-link desk-notif-card__d']")
    private WebElement mailButton;

    public AuthorizationPage clickEnter() throws InterruptedException {
        this.waitForElementByCss(enterButtonSelector);
        enterButton.click();
        return new AuthorizationPage(driver);
    }

    public MailPage clickMailButton(){
        this.waitForElementByCss(mailButtonSelector);
        mailButton.click();
        this.goToLastTab();
        return new MailPage(driver);
    }
}
