package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends BasePage{

    public MailPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//    private String xpath1 = "//span[@title='Simbirsoft theme.']";

    @FindBy(xpath = "//div[@class='mail-ComposeButton-Wrap js-compose-button-container']")
    private WebElement pip;


    public MailPage lettersSeach() throws InterruptedException {

        Thread.sleep(5000);

        pip.click();

//        int puper = driver.findElements(By.xpath("//span[@title='Simbirsoft theme.']")).size();
//        System.out.println(puper);

//        ArrayList<WebElement> list = new ArrayList <WebElement>();
//        list = (ArrayList<WebElement>) driver.findElements(By.xpath("//span[@title='Simbirsoft theme.']"));
//        puper = list.size();
//        System.out.println(puper);

//        System.out.println(driver.findElements(By.xpath("//span[@title='Simbirsoft theme.']")).size());
//        mailText.click();


        return this;
    }

}
