package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexPage extends BasePage{

    public YandexPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("https://yandex.ru/");
    }

    @FindBy(xpath = "//div[@class='desk-notif-card__login-new-item-title']")
    private WebElement enterButton;
    @FindBy(xpath = "//div[@class='desk-notif-card__mail-title']")
    private WebElement mailText;

    public YandexPage clickEnter() throws InterruptedException {
        Thread.sleep(1000);
        enterButton.click();
        return this;
    }
}
