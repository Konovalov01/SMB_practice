package ru.Yandex;
import Page.AuthorizationPage;
import Page.MailPage;
import Page.YandexPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() throws InterruptedException {

//        new YandexPage(driver)
//                .clickEnter();

        MailPage mailPage =new YandexPage(driver)
                .clickEnter()
                .usernameEnter()
                .passwordEnter()
                .lettersSeach()
                .writeLetter();

//        Thread.sleep(1000);

//        MailPage mailPage = new MailPage(driver)
//                .lettersSeach()
//                .writeLetter();

        assertTrue("The number of letters has not increased", mailPage.testCheck());

    }

    @After
    public void closeTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
