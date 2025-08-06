package com.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SauceDemoTest {

    WebDriver driver;
    String browserName = "chrome";

    @BeforeEach
    public void setUp(){
        if(browserName.equals("edge")){
            driver = new EdgeDriver();
        }
        else if (browserName.equals("chrome"))
        {
            driver = new ChromeDriver();
        }
        else
        {
            driver = new FirefoxDriver();
        }
    }

    @Test
    @DisplayName(("To test with valid credentials"))
    public void sauceDemoTest(){
        System.out.println("Driver loaded");
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actual = driver.getCurrentUrl();
        String expected = "https://www.saucedemo.com/inventory.html";
        Assertions.assertEquals(expected, actual);

        driver.quit();
    }
    @Test
    @DisplayName(("To test with invalid credentials"))
    public void sauceDemoTest2(){
        System.out.println("Driver loaded");
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce1");
        driver.findElement(By.id("login-button")).click();
        String actual = driver.getCurrentUrl();
        String expected = "https://www.saucedemo.com/";
        Assertions.assertEquals(expected, actual);

        driver.quit();
    }

    @DisplayName(("To test with invalid credentials  - part 2"))
    @Test
    public void testSauceDemo1(){
        driver.get("https://www.saucedemo.com/");

        System.out.println("Driver loaded!");
        WebElement element = driver.findElement(By.id("user-name"));
        element.sendKeys("standard_user");
        System.out.println("Username typed");

        driver.findElement(By.id("password")).sendKeys("secret_sauce1");
        System.out.println("Password typed");

        driver.findElement(By.id("login-button")).click();
        System.out.println("Login Button clicked");

        assertTrue(element.isDisplayed());
        driver.quit();

    }

    @DisplayName(("To test with valid credentials  - part 2"))
    @Test
    public void testSauceDemo4(){
        driver.get("https://www.saucedemo.com/");

        System.out.println("Driver loaded!");
        WebElement element = driver.findElement(By.id("user-name"));
        element.sendKeys("standard_user");
        System.out.println("Username typed");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        System.out.println("Password typed");

        driver.findElement(By.id("login-button")).click();
        System.out.println("Login Button clicked");

        WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));

        assertTrue(cart.isDisplayed());
        driver.quit();

    }
}
