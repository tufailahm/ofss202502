package  com.example;

import org.example.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    int expected;
    Calculator calculator ;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All - OFSS Test started");
    }

    @AfterAll
    public static void AfterAll() {
        System.out.println("After All - OFSS Test Completed");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before Each - OFSS Test started");
        calculator = new Calculator();
        expected = 20;
    }

    @AfterEach
    public void afterEach() {
        System.out.println("AfterEach - OFSS Test started");
        calculator = null  ;        // eligible for GC
        expected = 0;

    }
    @Test
    @DisplayName("3. Testing two same number - 10 and 10")
    @Order(3)
    public void testSum3(){
        int actual = calculator.sum(10, 10);
       assertEquals(expected,actual);
    }
    @Test
    @DisplayName("1. Testing two different number - 5 and 15")
    @Order(1)
    public void testSum2(){
        int actual = calculator.sum(5, 15);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("1. Testing two div number - 5 and 15")
    @Order(6)
    public void testDiv1(){
        expected = 5;
        int actual = calculator.divide(10,2);
        assertEquals(expected,actual);
    }

    @Test
    @Order(2)
    @DisplayName("2. Sum of one positive and one negative no.")
    public void testZApple(){
        int actual = calculator.sum(40, -20);
        int expected = 20;
        assertEquals(expected,actual);
    }


    @ParameterizedTest(name = "{index} - {0} and {1} should be {2}")
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    public void testSum(int num1,int num2,int expected){
        int actual = calculator.sum(num1,num2);
        assertEquals(expected,actual);
    }

    @Test
    public void testConvertStringToNumber1(){
        expected = 90;
        String marks ="90";
        int actual = calculator.convertStringToNumber(marks);
        assertEquals(expected,actual);
    }

    @Test
    public void testConvertStringToNumber2(){
        expected = 90;
        String marks ="Ninety";
        assertThrows(NumberFormatException.class, () -> {
            int actual = calculator.convertStringToNumber(marks);
            assertEquals(expected, actual);
        });
    }

}
