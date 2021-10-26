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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest {
    public static WebDriver driver;
    public static final String PathToProperties = "src/main/resources/Properties/AuthorizationData.properties";
    private String loginToSite;
    private String passwordToSite;
    private FileInputStream fileInputStream;

    @Before
    public void setUp() throws IOException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        Properties authorizationProp = new Properties();
        fileInputStream = new FileInputStream(PathToProperties);
        authorizationProp.load(fileInputStream);

        loginToSite = authorizationProp.getProperty("login");
        passwordToSite = authorizationProp.getProperty("password");
    }

    @Test
    public void firstTest() throws InterruptedException {

        MailPage mailPage =new YandexPage(driver)
                .clickEnter()
                .authorization(loginToSite,passwordToSite)
                .lettersSeach()
                .writeLetter();

        assertTrue("The number of letters has not increased", mailPage.testCheck());

    }

    @After
    public void closeTest(){
        driver.quit();
    }
}
