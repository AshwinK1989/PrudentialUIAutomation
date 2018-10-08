Feature: To Test the Login Functionality
  Background: For Navigation to Dashboard
   Given You Navigate to Dashboard Page

  Scenario: To test for invalid city
    And You enter the city "Xyz"
    And Click on Search Button
    Then Check whether validation message "Not found" is displayed

  Scenario: To test for valid city
      And You enter the city "Mumbai"
      And Click on Search Button
      Then Verify weather details are displayed


  Scenario: To Test important scenarios-test1
  Then Verify whether all links are working
  Then Verify whether following Options are displayed on Navigation Bar
    |Weather |
    |Maps    |
    |API     |
    |Price   |
    |Partners|
    |Stations|
    |Widgets |
    |Blog    |
  Then Verify whether the chart is present
  Then Verify temperature is displayed in Faraheneit
  Then Verify values in widget items are not null

  Scenario: Verify the Login Functionality ( Additional Test )
  And Click on Sign In button
  And Enter username and password
  And Click on Submit button
  Then Verify Login is Successful

