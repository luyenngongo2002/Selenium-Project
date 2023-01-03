Feature: Login Customer

  # Login
  Scenario: Check login successfully with select correct username
    Given user is on login page
    And verify login page
    When click customer login button
    When select correct username
    And click on login button
    Then user is navigated to the home page
  # Deposit
  Scenario Outline: Verify that user Deposit successfully with input valid amount
    Given user is on login page
    And verify login page
    When click customer login button
    When select correct username
    And click on login button
    When click on Deposit
    And enter valid <amount> to be deposit
    And click on deposit button
    Then message is displayed
    Examples:
      | amount |
      | 20000 |

 #Negative Deposit
  Scenario: Verify that user Deposit failed with input invalid amount (character, Number 0, Negative number)
    Given user is on login page
    And verify login page
    When click customer login button
    When select correct username
    And click on login button
    When click on Deposit
    And enter invalid mount to be deposit
    And click on deposit button
    Then message is displayed

  # Withdrawl
  Scenario Outline: Verify that user Withdrawl successfully with input valid amount
    Given user is on login page
    And verify login page
    When click customer login button
    When select correct username
    And click on login button
    And click on withdrawl
    And enter valid <amount> to be withdrawl
    And click on withdrawl button
    Then message is displayed
    Examples:
      | amount |
      | 10000 |


    #Negative Withdrawl
  Scenario: Verify that user Withdrawl failed with input invalid amount (character, Number 0, Negative number)
    Given user is on login page
    And verify login page
    When click customer login button
    When select correct username
    And click on login button
    And click on withdrawl
    And enter invalid mount to be withdrawl
    And click on withdrawl button
    Then message is displayed

  #Transaction
  Scenario: Verify that user can see transaction successfully
    Given user is on login page
    And verify login page
    When click customer login button
    When select correct username
    And click on login button
    And click on transaction button
    Then message is displayed

  Scenario: Verify that user can back homepage when click on "Back" button
    Given user is on login page
    And verify login page
    When click customer login button
    When select correct username
    And click on login button
    And click on transaction button
    And click on back button
    And user is navigated to the home page
    Then message is displayed

  Scenario: Verify that user can reset transation page when click on "Reset" button
    Given user is on login page
    And verify login page
    When click customer login button
    When select correct username
    And click on login button
    And click on transaction button
    And click on reset button
    Then message is displayed