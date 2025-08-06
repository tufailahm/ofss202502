package com.training.com.training;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {
    String word;
    String actualResult ;
    @Given("^I entered (.*)$")
    public void i_entered_word(String word) {
       this.word = word;
    }
    @When("I test it for Palindrome")
    public void i_test_it_for_palindrome() {
        String reversed = new StringBuilder(word).reverse().toString();
        actualResult = word.equalsIgnoreCase(reversed) ? "palindrome" : "notpalindrome";
    }
    @Then("^the result should be (.*)$")
    public void the_result_should_be_result(String expectedResult) {
        assertEquals(expectedResult, actualResult);
    }
}
