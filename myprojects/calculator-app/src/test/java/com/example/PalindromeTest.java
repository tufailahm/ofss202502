package com.example;

import org.example.InvalidWordException;
import org.example.Palindrome;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class PalindromeTest {
    Palindrome palindrome;

    @BeforeEach
    void setUp() {
        palindrome = new Palindrome();
    }

    @AfterEach
    void tearDown() {
        palindrome = null;
    }

    @Test
    @Order(1)
    @DisplayName("Check if 'mom' is palindrome")
    public void testMomPalindrome() {
        boolean result = palindrome.checkPalindrome("mom");
        assertTrue(result);
    }

    @Test
    @Order(2)
    @DisplayName("Check if 'dad' is palindrome")
    public void testDadPalindrome() {
        boolean result = palindrome.checkPalindrome("dad");
        assertTrue(result);
    }

    @Test
    @Order(3)
    @DisplayName("Check if 'bro' is palindrome")
    public void testBroPalindrome() {
        boolean result = palindrome.checkPalindrome("bro");
        assertFalse(result);
    }

    @Test
    @Order(4)
    @DisplayName("Check if 'sis' is palindrome")
    public void testSisPalindrome() {
        boolean result = palindrome.checkPalindrome("sis");
        assertTrue(result);
    }

    @ParameterizedTest(name = "{index} - word={0}, expected={1}")
    @CsvFileSource(resources = "palindromeTest.csv", numLinesToSkip = 1)
    public void testFile(String word, String expected) {
        switch (expected.trim().toLowerCase()) {
            case "yes" -> {
                assertTrue(palindrome.checkPalindrome(word), () -> word + " should be palindrome");
            }
            case "no" -> {
                assertFalse(palindrome.checkPalindrome(word), () -> word + " should not be palindrome");
            }
            case "exception" -> {
                assertThrows(InvalidWordException.class, () -> palindrome.checkPalindrome(word),
                        () -> word + " should cause exception");
            }
            default -> fail("Unrecognized expected value: " + expected);
        }
    }


}