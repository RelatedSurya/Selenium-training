Feature: To validate the login functionality of facebook application
Scenario: To validate login with valid username and invalid password
Given To launch the chrome browser and maximize window
When To launch the url of the facebook application
And To pass the valid username in email field
And To pass the invalid password in password field
And To click the login button
And To check whether navigate to the home page or not
Then To close the browser
                     (OR)
Feature: To validate the login functionality of facebook application
Scenario Outline: To validate the positive and negative combination of login functionality
Given User has to launch thr browser and maximize the window
When User has to hit the facebook url 
And User has to pass the data "<emaildatas>" in email field
And User has to pass the data "<passworddatas>" in passwoed field
And User has to click the login button
Then User has to close the browser

Examples:

|emaildatas          |passworddatas|
|selenium@gmail.com  |12345        |
|inmakes@gmail.com   |67890        |
|surya2819@gmail.com |2819         |
|nathan2819@gmail.com|nrs2819      |