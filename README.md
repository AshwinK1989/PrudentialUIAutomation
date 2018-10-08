# PrudentialUIAutomation Assignment

I have developed a Behaviour Driven Framework using :
* Cucumber
* Selenium Webdriver
* TestNG

## List of softwares required to run:

* Java

* Maven


## Path Settings

Set Java Path in environment variable,

## Test Flow

```gherkin
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

```

## Steps to run the test

* Clone the project on your machine using command: **git clone https://github.com/AshwinK1989/PrudentialUIAutomation.git**

* Traverse to root level of the project and run the command: **mvn clean compile verify  -Dcucumber.options="/Users/ashwin/Documents/work/learning/PrudentialUIAutomation/Features/Prudential_Scenarios.feature"**

The report will be present in file: **/PrudentialUIAutomation/target/cucumber-report-html/cucumber-html-reports/overview-features.html**

## Jenkins Setup Recording
* I have configured Jenkins on my local machine and recorded the test. 
* The link is as follows: [Recording Url](https://drive.google.com/drive/folders/1SKqHXiW5vQ8eL3nESD0GRso6qeCGqMXA?usp=sharing)