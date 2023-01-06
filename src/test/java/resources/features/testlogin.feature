Feature: Login Customer

  # Login
  Scenario: Check login successfully with select correct username
    Given user is on login page
    When click customer login button
    When select correct username
    And click on login button
    Then user is navigated to the home page

  # Deposit

  #Valid data
  Scenario Outline: Check user Deposit
    Given user login successfully
    When click on Deposit
    And enter <amount> to be deposit
    And click on deposit button
    Then the <message> is displayed
    Examples:
      | amount | message              |
      | 20000  | Withdrawl Successful |

  #Invalid data
  Scenario Outline: Check user Deposit
    Given user login successfully
    When click on Deposit
    And enter <amount> to be deposit
    And click on deposit button
    Then the <message> is displayed
    Examples:
      | amount | message                                                  |
      | -1000  | Failed [-1000] is a negative bumber. Please enter again! |
      | 0      | Failed [0] is a number 0. Please enter again!            |
      | e      | Failed [e] is a character. Please enter again!           |
      |        | Please fill out this field

  # Withdrawl

  #Valid data
  Scenario Outline: Check user Withdrawl
    Given user login successfully
    And click on withdrawl
    And enter <amount> to be withdrawl
    And click on withdrawl button
    Then the <message> is displayed
    Examples:
      | amount | message              |
      | 20000  | Withdrawl Successful |

 #Invalid data
  Scenario Outline: Check user Withdrawl
    Given user login successfully
    And click on withdrawl
    And enter <amount> to be withdrawl
    And click on withdrawl button
    Then the <message> is displayed
    Examples:
      | amount | message                                                  |
      | -1000  | Failed [-1000] is a negative bumber. Please enter again! |
      | 0      | Failed [0] is a number 0. Please enter again!            |
      | e      | Failed [e] is a character. Please enter again!           |
      |        | Please fill out this field                               |
      | 999999 | You can not withdraw amount more than the balance. Please enter again! |



  Scenario Outline: Verify that user Withdrawl failed if input amount to be withdrawn is more than the balance
  Given user login successfully
    And click on withdrawl
    And enter <amount> to be withdrawl
    And click on withdrawl button
    Then the <message> is displayed
    Examples:
      | amount | message                                                                |
      | 999999 | You can not withdraw amount more than the balance. Please enter again! |

  #Transaction
  Scenario: Verify that user can see transaction successfully
    Given user login successfully
    And click on transaction button
    Then message is displayed

  Scenario: Verify that user can back homepage when click on "Back" button
    Given user login successfully
    And click on transaction button
    And click on back button
    And user is navigated to the home page
    Then message is displayed

  Scenario: Verify that user can reset transation page when click on "Reset" button
    Given user login successfully
    And click on transaction button
    And click on reset button
    Then message is displayed