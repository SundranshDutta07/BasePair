# BasePair Sample Upload - E2E Test Automation
This repository contains an end-to-end automation test suite for the **Sample Upload** feature of the BasePair application, built using **Katalon Studio**.

## Project Structure

E2E_BasePair_SampleUpload/
│
├── Test Cases/                      # E2E test cases
│
├── Object Repository/              # Page objects for UI elements
│   ├── Dashboard Page/
│   ├── Login Page/
│   ├── New Sample/
│   └── Samples Page/
│
├── Keywords/
│   ├── com.pages/                  # Custom keywords for page-level actions
│   │   ├── Dashboard.groovy
│   │   ├── Login.groovy
│   │   └── Sample.groovy
│   └── com.utils/                  # Utilities like screenshot and exception handling
│       ├── ExceptionHandling.groovy
│       └── Screenshot.groovy
│
├── Test Listeners/                 # Test listeners (optional)
├── Reports/                        # Test execution reports
├── Include/
├── Plugins/
├── .gitignore
├── build.gradle
└── console.properties
```

## Key Features
- **Login Automation** with UI verification
- **New Sample Upload** via file browser and drag & drop
- **Dashboard Validation** post-login
- **Custom Keywords** for reusability and clean code
- **Screenshot Capture** for all critical steps
- **Exception Handling** using custom utility

## Prerequisites
- Katalon Studio (v10.1.0 or compatible)
- Java JDK 8+
- Git

## Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/SundranshDutta07/BasePair.git
2. Open the project in **Katalon Studio**
3. Run test cases from the **Test Cases** folder manually or through a test suite

## Scripts Snapshot

Example from `Login.groovy`:
groovy
WebUI.comment('Navigating to the webpage')
assert WebUI.verifyMatch(LoginTitle, expectedTitle, false)
CustomKeywords.'com.pages.Login.input_Login'(...)
```

## Author
- **Sundransh Dutta** - [https://github.com/SundranshDutta07]

## License
This project is for demonstration and interview assignment purposes only.