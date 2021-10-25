package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends BasePage{

    public MailPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("https://mail.yandex.ru/");
    }
    @FindBy(xpath = "//div[@class='mail-ComposeButton-Wrap js-compose-button-container']")
    private WebElement newLetterButton;
    @FindBy(xpath = "//div[@class = 'composeYabbles']")
    private WebElement mailAdressInput;
    @FindBy(xpath = "//input[@name='subject']")
    private WebElement topicInput;
    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_htmlplaceholder']")
    private WebElement mailTextInput;
    @FindBy(xpath = "//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']")
    private WebElement sendButton;
    @FindBy(xpath = "//span[@class='mail-ComposeButton-Refresh js-main-action-refresh ns-action']")
    private WebElement updateButton;

    private int mailCount = 0;
    protected final static String
            mailAdress = "K4r4bast@yandex.ru",
            topic = "Simbirsoft theme.";

    public MailPage lettersSeach() throws InterruptedException {
        Thread.sleep(1000);
        mailCount = driver.findElements(By.xpath("//span[@title='Simbirsoft theme.']")).size();
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

        sendButton.click();

        Thread.sleep(1000);

        //driver.navigate().refresh();
        driver.get("https://mail.yandex.ru/");
        Thread.sleep(1000);

        return this;
    }

    public boolean testCheck() throws InterruptedException {

        int previousValue = mailCount;
        mailCount = driver.findElements(By.xpath("//span[@title='Simbirsoft theme.']")).size();
        if(previousValue < mailCount) {
            return true;
        } else {
            return false;
        }
    }

}
