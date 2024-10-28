# OrangeHRM Automation Selenium TestNG Project

## Scenario
- Login as a admin to https://opensource-demo.orangehrmlive.com/
- Go to PIM menu and create a new employee. Save the employee firstname, lastname, employeeid, username and password into JSONArray file. Generate random password which meets following criteria:
For a strong password, please use a hard to guess combination of text with upper- and lower-case characters, symbols and numbers. Assert if employee is created successfully.
- Now go to the dashboard again and search by the employee id to check if the employee is found
- Now go to the Directory menu and search by employee name and check if the employee is found
- Logout the session.
- Now login with the newly created employee creds
- Assert your full name is showing besides the profile icon.
- Go to my info
- Scroll down and select Gender and Blood Type as O+ and save it. Then logout the user.
- Create a smoke suite configuration which will run only following features (positive cases only):
  -	Login to admin
  - search by the employee id if found
  - logout admin and login to the employee id you created last
  -	Update the blood Group as AB-
  -	Logout the user

## Technology and Tool Used
- Selenium Webdriver
- TestNG
- Gradle
- Java
- JavaFaker
- Simple JSON
- Allure Report
- Intellij idea

## Prerequisite
- JDK 11 or higher
- java IDE
- Configure environment variable for Java, Gradle and Allure Report

## Website
- `https://opensource-demo.orangehrmlive.com/`

## How to run this project
- Clone the project
- Execute the following command on the project directory  
`gradle clean test -Pusername="Admin" -Ppassword="admin123" -PsuiteName="masterRegressionSuite"`  
`gradle clean test -Pusername="Admin" -Ppassword="admin123" -PsuiteName="masterSmokeSuite"`  
or  
`gradle clean test -PsuiteName="masterRegressionSuite"`  
`gradle clean test -PsuiteName="masterSmokeSuite"`

## Generate Allure Report
- Execute the following commands (after finishing the project run)  
`allure generate allure-results --clean`  
`allure serve allure-results --clean`

## Test Case
https://docs.google.com/spreadsheets/d/1hYoGyGd56HxPzVGG1XJR0346oaRm-l_-PwLAFRE4GxI/edit?usp=drive_link

## Video of Automation Output
### Regression Test
https://github.com/touhid-96/OrangeHRM-Automation-Selenium-TestNG-Project/assets/29010371/b3c5f2c8-d9b2-4f38-9cce-461941f559a0

### Smoke Test
https://github.com/touhid-96/OrangeHRM-Automation-Selenium-TestNG-Project/assets/29010371/696fd01a-baa6-4263-9b30-6265d22b4e6f

## Allure Reports
![1 overview](https://github.com/touhid-96/OrangeHRM-Automation-Selenium-TestNG-Project/assets/29010371/0a501781-a0f5-486d-ac8a-56d9b374ec22)

![2 suites](https://github.com/touhid-96/OrangeHRM-Automation-Selenium-TestNG-Project/assets/29010371/66d69fe9-7748-4f7d-b98c-b4c317304c7a)

![3 graph](https://github.com/touhid-96/OrangeHRM-Automation-Selenium-TestNG-Project/assets/29010371/7dd2cb5d-2329-4ef9-a7e6-1f655684708f)

![4 behaviors](https://github.com/touhid-96/OrangeHRM-Automation-Selenium-TestNG-Project/assets/29010371/97b9bd60-48f9-4e1a-bb1a-7c7ded552b1e)

![5 packages](https://github.com/touhid-96/OrangeHRM-Automation-Selenium-TestNG-Project/assets/29010371/ed51faee-139a-476a-b22a-3c4e62a17307)


## Gradle Report
![6 gradle report](https://github.com/touhid-96/OrangeHRM-Automation-Selenium-TestNG-Project/assets/29010371/48d61c6e-b7fa-4176-83cd-a54ee706bced)
