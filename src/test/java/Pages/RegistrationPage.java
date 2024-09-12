package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BaseTest {

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    @FindBy(id = "ContentPlaceHolder1_txtUserName")
    public WebElement usernameField;

    @FindBy(id = "ContentPlaceHolder1_txtEmail")
    public WebElement emailAddressField;

    @FindBy(id = "ContentPlaceHolder1_txtConfirmEmail")
    public WebElement confirmEmailAddressField;

    @FindBy(id = "ContentPlaceHolder1_txtPassword")
    public WebElement passwordField;

    @FindBy(id = "ContentPlaceHolder1_txtPassword2")
    public WebElement confirmPasswordField;

    @FindBy(id = "ContentPlaceHolder1_MyCheckBox")
    public WebElement termsAndConditionsCheckBox;

    @FindBy(id = "ContentPlaceHolder1_SubscribeNewsletter")
    public WebElement newsletterCheckBox;

    @FindBy(id = "ContentPlaceHolder1_btnRegister")
    public WebElement registerButton;

    @FindBy(id = "btnCookie")
    public WebElement cookieButton;

    @FindBy(id = "ContentPlaceHolder1_txtUserName-error")
    private WebElement usernameError;

    @FindBy(id = "ContentPlaceHolder1_txtEmail-error")
    private WebElement emailError;

    @FindBy(id = "ContentPlaceHolder1_txtConfirmEmail-error")
    private WebElement confirmEmailError;

    @FindBy(id = "ContentPlaceHolder1_txtPassword-error")
    private WebElement passwordError;

    @FindBy(id = "ContentPlaceHolder1_txtPassword2-error")
    private WebElement confirmPasswordError;

    @FindBy(id = "ctl00$ContentPlaceHolder1$MyCheckBox-error")
    private WebElement termsCheckBoxError;

    //-------------------------------------------------------


    public String getUsernameError() {
        return usernameError.getText();
    }

    public String getEmailError() {
        return emailError.getText();
    }

    public String getConfirmEmailError() {
        return confirmEmailError.getText();
    }

    public String getPasswordError() {
        return passwordError.getText();
    }

    public String getConfirmPasswordError() {
        return confirmPasswordError.getText();
    }

    public String getTermsCheckBoxError() {
        return termsCheckBoxError.getText();
    }


    public void signUp(String username, String email, String confirmEmail, String password, String confirmPassword, boolean shouldClickTerms, boolean shouldClickNewsletter) {
        usernameField.clear();
        usernameField.sendKeys(username);
        emailAddressField.clear();
        emailAddressField.sendKeys(email);
        confirmEmailAddressField.clear();
        confirmEmailAddressField.sendKeys(confirmEmail);
        passwordField.clear();
        passwordField.sendKeys(password);
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword);
        if (shouldClickTerms) {
            termsAndConditionsCheckBox.click();
        }
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", registerButton);
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        jsExecutor.executeScript("arguments[0].click();", registerButton);
        if(shouldClickNewsletter) {
            newsletterCheckBox.click();
        }
    }





}
