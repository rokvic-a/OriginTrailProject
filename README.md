# OriginTrail Project

This project automates the registration form on the [Etherscan Registration Page](https://etherscan.io/register). The tests are written in Java using Selenium WebDriver and TestNG.

## Project Overview
The goal is to automate the registration form with both positive and negative test scenarios. This project ensures the form behaves as expected, including validating field input, error messages, and successful form submissions.

## Tools and Versions
- **IntelliJ IDEA**: 2024.1 Community Edition
- **Selenium WebDriver**: 4.24.0
- **Google Chrome**: 128.0.6613.120
- **Java**: 21
- **Maven**: For dependency management
- **TestNG**: For test framework and reporting version 7.10.2

## How to Run the Tests
1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Ensure all dependencies are installed with Maven (`mvn install`).
4. Run the tests directly from individual classes in IntelliJ.

### Captcha Handling Limitation

In the **positive test scenario**, the registration form on [Etherscan](https://etherscan.io/register) includes a captcha, which cannot be bypassed or handled programmatically during automated testing. The captcha is designed to prevent automated submissions and does not allow for manual handling during the execution of the test. As a result, while the test successfully fills out all the required fields, it cannot proceed beyond the captcha step.

This limitation affects the completion of the registration test, but it demonstrates the form-filling process up until captcha verification.


## Test Scenarios
- **Positive Tests**: 
   - Valid registration using all correct details.
- **Negative Tests**:
  - Empty form submission.
  - Empty username field.
  - Short username.
  - Empty email field.
  - Empty confirm email field.
  - Special characters username.
  - Mismatched email addresses.
  - Mismatched passwords.
  - Invalid email format.
  - Empty password field.
  - Short password.
  - Terms and conditions not accepted.

  
## Automated Testing Tools and Setup

### Tools
- **Selenium WebDriver**: Automates browser interactions for form input, validation, and submission.
- **TestNG**: Manages the structure and execution of test cases and generates test reports.
- **Jenkins**: Continuous integration tool that runs the tests automatically after code commits.
- **Allure Reports**: Provides detailed test reports for analyzing failures and successes.

### Usage
1. **Selenium** automates browser actions like filling out forms and clicking buttons.
2. **TestNG** organizes and runs tests, allowing for parallel execution and reporting.
3. **Jenkins** runs the tests automatically after each code change.
4. **Allure** generates detailed reports after test execution.



