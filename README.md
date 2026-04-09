# OrangeHRM Login Automation 🚀

A test automation project built with **Selenium WebDriver**, 
**TestNG**, and **Maven** in Java using Page Object Model (POM).

## 📁 Project Structure

SeleniumLearning/
├── src/
│   └── test/
│       └── java/
│           ├── pages/
│           │   └── LoginPage.java
│           └── tests/
│               └── LoginTest.java
├── pom.xml
└── .gitignore

## 🛠️ Technologies Used

- Java 25
- Selenium WebDriver 4.18.1
- TestNG 7.9.0
- Maven
- IntelliJ IDEA

## 🧪 Test Scenarios

| TC | Scenario | Expected Result | Status |
|---|---|---|---|
| TC01 | Valid Login | Dashboard visible | ✅ Pass |
| TC02 | Invalid Password | Error message shown | ✅ Pass |
| TC03 | Invalid Username | Error message shown | ✅ Pass |
| TC04 | Empty Fields | Required error shown | ✅ Pass |

## 🎯 Design Pattern

Page Object Model (POM) — separates page elements 
from test logic for maintainable test structure.

## ▶️ How to Run

1. Clone the repository:
   git clone https://github.com/AAKDIVYANGANA/orangehrm-login-automation.git

2. Open in IntelliJ IDEA

3. Run Maven install:
   mvn clean install -U

4. Run LoginTest.java using TestNG

## 📌 Notes

- Chrome browser is required
- Selenium Manager automatically handles ChromeDriver setup
- Test site used: OrangeHRM Demo (opensource-demo.orangehrmlive.com)

## 👩‍💻 Author

**Ahinsa Divyangana**
