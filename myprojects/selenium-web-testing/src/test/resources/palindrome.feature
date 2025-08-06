Feature: Palindrome check

  Scenario Outline: Valid Palindrome
    Given I entered <word>
    When I test it for Palindrome
    Then the result should be <result>
    Examples:
      | word      | result        |
      | malayalam | palindrome    |
      | mom       | palindrome    |
      | find      | notpalindrome |
      | dad       | palindrome    |