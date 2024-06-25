package selenuim.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelenuimTests {
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://distedu.ukma.edu.ua/login/index.php");
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void verifyElementText() {
        WebElement element = driver.findElement(By.xpath("//p[contains(text(), 'Увійдіть, використовуючи свій обліковий запис на:')]"));
        String expectedText = "Увійдіть, використовуючи свій обліковий запис на:";
        String actualText = element.getText();
        Assertions.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyElementAttribute() {
        WebElement element = driver.findElement(By.className("rui-login-box"));
        WebElement passwordElement = element.findElement(By.id("password"));
        String expectedPlaceHolder = "Пароль";
        String actualAttribute = passwordElement.getAttribute("placeholder");
        Assertions.assertEquals(actualAttribute, expectedPlaceHolder);
    }

    @Test
    public void verifyLoginButtonRedirect() {
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://distedu.ukma.edu.ua/login/index.php";
        Assertions.assertEquals(currentUrl, expectedUrl);
    }
}
