package ru.Yandex;
import Page.AuthorizationPage;
import Page.MailPage;
import Page.YandexPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class FirstTest {
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Test start");
    }

    @Test
    public void firstTest() throws InterruptedException {

        YandexPage yandexPage = new YandexPage(driver)
                .clickEnter();

        AuthorizationPage authorizationPage = new AuthorizationPage(driver)
                .usernameEnter()
                .passwordEnter();

        yandexPage.clickMail();

        MailPage mailPage = new MailPage(driver)
                .lettersSeach();
    }

    @After
    public void closeTest() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
        System.out.println("Test finish");
    }
}
