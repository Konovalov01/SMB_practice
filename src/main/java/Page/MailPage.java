package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage{
    public WebDriver driver;

    public MailPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("https://mail.yandex.ru/");
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

    protected final static String
            mailAdress = "K4r4bast@yandex.ru",
            topic = "Simbirsoft theme.";

    public MailPage lettersSeach() throws InterruptedException {
        Thread.sleep(2000);
        mailCount = driver.findElements(By.cssSelector("span[title='Simbirsoft theme.']")).size();
        return this;
    }

    public MailPage writeLetter() throws InterruptedException {

        newLetterButton.click();

        Thread.sleep(2000);

        mailAdressInput.click();
        mailAdressInput.sendKeys(mailAdress);

        topicInput.click();
        topicInput.sendKeys(topic);

        String mailText = "Найдено " + mailCount + " писем/ьма .";

        mailTextInput.click();
        mailTextInput.sendKeys(mailText);
        Thread.sleep(500);
        sendButton.click();

        Thread.sleep(2000);

        driver.get("https://mail.yandex.ru/");
        Thread.sleep(1000);

        return this;
    }

    public boolean testCheck() throws InterruptedException {

        previousValue = mailCount;
        mailCount = driver.findElements(By.cssSelector("span[title='Simbirsoft theme.']")).size();
        Thread.sleep(1000);
        return previousValue < mailCount;
    }

}
