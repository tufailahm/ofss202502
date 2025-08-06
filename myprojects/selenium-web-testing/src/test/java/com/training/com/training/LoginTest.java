package com.training.com.training;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    String browserName="chrome";
    public LoginTest() {
        System.out.println("1. Driver loaded ");
     //   driver = new ChromeDriver();
    }

    @Before
    public void before() {
        System.out.println("Before cucumber test");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void after() {
        System.out.println("After cucumber test");
    }
    @BeforeEach()
    public void beforeEach() {
        System.out.println("2. ###Before each called");
        driver = new ChromeDriver();

    }

    @AfterEach()
    public void afterEach() {
        System.out.println("LAST. Driver removed ");
        driver = null;
    }
    @Given("Customer is on the login page")
    @Test
    @Order(1)
    @DisplayName(("1. open sauce demo"))
    public void customer_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
        System.out.println("3. Customer is on the login page");
    }

  //  @When("User enters valid username and password")
  //  @Test
    @Order(2)
    @DisplayName(("2. enter valid username and password"))
    @When("^User enters valid (.*) and (.*)$")
    public void user_enters_valid_username_and_password(String username, String password) {
        System.out.println("4. User enters valid credentials");
     //   driver.findElement(By.id("user-name")).sendKeys(username);
    //    driver.findElement(By.id("password")).sendKeys(password);
     //   driver.findElement(By.id("login-button")).click();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }


    @Test
    @Order(3)
    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        System.out.println("User should be redirected to the dashboard");
        String actual = driver.getCurrentUrl();
        String expected = "https://www.saucedemo.com/inventory.html";
        assertEquals(expected, actual);
        driver.quit();
    }
}
