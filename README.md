# OrangeHRM Login Automation Project

## 📌 Overview
This project automates the login functionality of the **OrangeHRM** web application. It is built using **Selenium WebDriver** and **TestNG**, following the **Page Object Model (POM)** design pattern to ensure maintainability and reusability of the code.

## 🧪 Test Scenarios
| TC ID | Test Scenario | Expected Result | Status |
|:---:|---|---|:---:|
| TC01 | Valid Login | Should redirect to Dashboard | ✅ Pass |
| TC02 | Invalid Password | Should display "Invalid credentials" | ✅ Pass |
| TC03 | Invalid Username | Should display "Invalid credentials" | ✅ Pass |
| TC04 | Empty Fields | Should display "Required" validation error | ✅ Pass |

## 🛠️ Technologies & Tools
* **Language:** Java 25
* **Automation Tool:** Selenium WebDriver (v4.18.1)
* **Testing Framework:** TestNG (v7.9.0)
* **Build Tool:** Maven

## Design Pattern:
Page Object Model (POM)

## 🏗️ Project Structure
- `src/test/java/pages`: Contains Page Object classes (Locators and Methods).
- `src/test/java/tests`: Contains TestNG test scripts.

## 🚀 How to Run
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/AAKDIVYANGANA/orangehrm-login-automation.git](https://github.com/AAKDIVYANGANA/orangehrm-login-automation.git)
2. Open in IntelliJ IDEA
3. Run `LoginTest.java`
