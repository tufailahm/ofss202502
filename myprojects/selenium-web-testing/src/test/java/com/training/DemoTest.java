package com.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoTest {
    WebDriver driver;
    String browserName="chrome";
    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
    }
    @Test
    public void AmazonDemoTest() {
        System.out.println("Amazon Test");
        driver.get("https://www.amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("diamond studded name plate");
        driver.findElement(By.id("nav-search-submit-text")).click();
        String exp="https://www.amazon.in/s?k=diamond+studded+name+plate&ref=nb_sb_noss";
        String act=driver.getCurrentUrl();

        WebElement productImage = driver.findElement(By.xpath("//img[contains(@alt, 'DLCCREATION Name Plate Personalised Stainless Steel')]"));

        assertTrue(productImage.isDisplayed(), "Product image is not displayed!");

        driver.quit();
    }
}