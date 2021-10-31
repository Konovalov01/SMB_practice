package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage{

    public MailPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
        this.driver = driver;
    }

    @FindBy(css = "a[title^='Написать']")
    private WebElement newLetterButton;
    @FindBy(css = "div[class = 'composeYabbles']")
    private WebElement mailAdressInput;
    @FindBy(css = "input[name='subject']")
    private WebElement topicInput;
    @FindBy(css = "div[class^='cke_wysiwyg']")
    private WebElement mailTextInput;
    @FindBy(css = "button[class^='Button2 Button2_pin_circle-circle Button2_view_d']")
    private WebElement sendButton;

    private int mailCount = 0;
    private int previousValue = 0;


    private final String
            topicMailSelector = "span[title='Simbirsoft theme.']",
            sendConfimSelector ="div[class = 'ComposeDoneScreen-Title']";

    public MailPage lettersSeach() throws InterruptedException {
        this.waitForElementByCss(topicMailSelector);
        mailCount = driver.findElements(By.cssSelector(topicMailSelector)).size();
        return this;
    }

    public MailPage writeLetter(String mailLink,String mailAdress, String topic) throws InterruptedException {

        newLetterButton.click();

        mailAdressInput.click();
        mailAdressInput.sendKeys(mailAdress);

        topicInput.click();
        topicInput.sendKeys(topic);

        String mailText = "Найдено " + mailCount + " писем/ьма .";

        mailTextInput.click();
        mailTextInput.sendKeys(mailText);
        sendButton.click();

        this.waitForElementByCss(sendConfimSelector);

        driver.get(mailLink);
        return this;
    }

    public boolean testCheck() throws InterruptedException {
        previousValue = mailCount;

        this.waitForElementByCss(topicMailSelector);
        mailCount = driver.findElements(By.cssSelector(topicMailSelector)).size();

        return previousValue < mailCount;
    }

}
