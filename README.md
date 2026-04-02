# 🧪 Automation Framework – Selenium + JUnit + GitHub Actions

This repository contains a simple and scalable **UI automation framework** built using:

* ✅ Java
* ✅ Selenium WebDriver
* ✅ JUnit
* ✅ Page Object Model (POM)
* ✅ GitHub Actions (CI/CD)

---

# 🚀 Features

* 🔹 Clean Page Object Model design
* 🔹 Reusable BaseTest and BasePage
* 🔹 Headless execution (CI ready)
* 🔹 Screenshot capture after test execution
* 🔹 GitHub Actions integration
* 🔹 Automatic artifact upload (screenshots)

---

# 📁 Project Structure

```
src
 ├── main
 │   └── java
 │       └── pages
 │           ├── BasePage.java
 │           ├── LoginPage.java
 │           └── SecurePage.java
 │
 └── test
     └── java
         └── tests
             ├── BaseTest.java
             └── LoginTest.java
```

---

# ⚙️ Setup Instructions

## 1. Clone Repository

```
git clone <your-repo-url>
cd <repo-name>
```

---

## 2. Install Dependencies

Make sure you have:

* Java 11+
* Gradle

Run:

```
./gradlew build
```

---

## ▶️ Run Tests Locally

```
./gradlew test
```

---

# 🔐 Test Scenario

**Form Authentication Test**

* Navigate to login page
* Enter valid credentials
* Verify successful login message

---

# 📸 Screenshots

* Screenshots are captured after test execution
* Stored in:

```
/screenshots/
```

---

# 🤖 GitHub Actions (CI/CD)

Pipeline runs automatically on:

* ✅ Push to `main`
* ✅ Pull Request to `main`

---

## 📄 Workflow File

Location:

```
.github/workflows/automation.yml
```

---

## ⚙️ What Pipeline Does

* Checkout code
* Setup Java
* Run tests using Gradle
* Capture screenshots
* Upload screenshots as artifacts

---

## 📥 How to Download Screenshots

1. Go to **GitHub → Actions**
2. Open workflow run
3. Scroll to **Artifacts**
4. Download `Screenshots.zip`

---

# ⚠️ Important Notes

* Tests run in **headless mode** (required for CI)
* ChromeDriver is managed automatically using WebDriverManager
* Screenshots use timestamp to avoid overwrite

---

# 🔥 Future Enhancements

* ✅ Screenshot only on failure
* ✅ Allure reporting integration
* ✅ Parallel execution
* ✅ TestNG + DataProvider
* ✅ Cucumber BDD support

---

# 👨‍💻 Author

Automation framework designed for learning and scalable test implementation.

---
