package ru.Yandex;
import page.MailPage;
import page.YandexPage;
import data.UserProperties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {
    public static WebDriver driver;
    public static UserProperties properties;


    @Before
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        properties = new UserProperties();
    }

    @Test
    public void firstTest() throws InterruptedException {
        MailPage mailPage = new YandexPage(driver)
                .goToStartLink(properties.getStartLink())
                .clickEnter()
                .authorization(
                        properties.getLogin(),properties.getPassword())
                .clickMailButton()
                .lettersSeach()
                .writeLetter(properties.getMailLink(),properties.getMailAdress(),properties.getTopic());

        assertTrue("The number of letters has not increased", mailPage.testCheck());

    }

    @After
    public void closeTest(){
        driver.quit();
    }
}
