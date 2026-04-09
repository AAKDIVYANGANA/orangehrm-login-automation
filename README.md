# OrangeHRM Login Automation

## Overview
Automated login functionality of OrangeHRM web application
using Selenium WebDriver and TestNG with Page Object Model (POM).

## Test Scenarios
| TC | Scenario | Expected Result | Status |
|---|---|---|---|
| TC01 | Valid Login | Dashboard visible | ✅ Pass |
| TC02 | Invalid Password | Error message shown | ✅ Pass |
| TC03 | Invalid Username | Error message shown | ✅ Pass |
| TC04 | Empty Fields | Required error shown | ✅ Pass |

## Technologies
- Java 25
- Selenium WebDriver 4.18.1
- TestNG 7.9.0
- Maven

## Design Pattern
Page Object Model (POM)

## How to Run
1. Clone the repo
2. Open in IntelliJ IDEA
3. Run `LoginTest.java`
