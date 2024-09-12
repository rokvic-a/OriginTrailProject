package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        String url = resources.getUrl();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Verify that user can successfully register with valid data.
    // Can't assert successful registration because of captcha.
    @Test(priority = 1)
    public void validUserRegistration() {
        registrationPage.cookieButton.click();
        registrationPage.signUp(username, email, email, password, password, true, true);
    }

    //Verify that the form shows appropriate error messages when all fields are left empty and submitted.
    @Test(priority = 2)
    public void emptyFormRegistration() {
        registrationPage.signUp("", "", "", "", "", false, false);
        Assert.assertEquals(registrationPage.getUsernameError(), usernameError);
        Assert.assertEquals(registrationPage.getEmailError(), emailError);
        Assert.assertEquals(registrationPage.getConfirmEmailError(), confirmEmailError);
        Assert.assertEquals(registrationPage.getPasswordError(), emptyPasswordError);
        Assert.assertEquals(registrationPage.getConfirmPasswordError(), shortPasswordError);
        Assert.assertEquals(registrationPage.getTermsCheckBoxError(), termsCheckBoxError);
    }

    // Verify that the user can't register when only username filed is left empty.
    @Test(priority = 3)
    public void emptyUsernameField() {
        registrationPage.signUp("", email, email, password, password, true, true);
        Assert.assertEquals(registrationPage.getUsernameError(), usernameError);
    }

    // Verify that the system rejects a username that is shorter than the minimum required length (5 characters).
    @Test(priority = 4)
    public void usernameTooShort() {
        registrationPage.signUp("test", email, email, password, password, true, true);
        Assert.assertEquals(registrationPage.getUsernameError(), shortUsernameError);
    }

    // Verify that the system rejects a username that is consisted of special characters.
    @Test(priority = 5)
    public void specialCharactersUsername() {
        registrationPage.signUp(".,!@#$%^&", email, email, password, password, true, true);
        Assert.assertEquals(registrationPage.getUsernameError(), alphanumericalUsernameError);
    }

    // Verify that the user can't register when only email filed is left empty.
    @Test(priority = 6)
    public void emptyEmailField() {
        registrationPage.signUp(username, "", email, password, password, true, true);
        Assert.assertEquals(registrationPage.getEmailError(), emailError);
    }

    // Verify that an error message is shown when the "Email Address" and "Confirm Email Address" fields do not match.
    @Test(priority = 7)
    public void mismatchedEmailAddresses() {
        registrationPage.signUp(username, email, "test123@gmail.com", password, password, true, true);
        Assert.assertEquals(registrationPage.getConfirmEmailError(), mismatchedEmailError);
    }

    //Verify that the registration page correctly identifies and handles email addresses with multiple "@" symbols.
    @Test(priority = 8)
    public void registrationPageHandlesMultipleAtSymbols() {
        registrationPage.signUp(username, "test@gmail@gmail.com", "test@gmail@gmail.com", password, password, true, true);
        Assert.assertEquals(registrationPage.getEmailError(), emailError);
        Assert.assertEquals(registrationPage.getConfirmEmailError(), confirmEmailError);
    }

    // Verify that the form shows an error when the "Email Address" is filled, but the "Confirm Email Address" field is left empty.
    @Test(priority = 9)
    public void missingConfirmEmailField() {
        registrationPage.signUp(username, email, "", password, password, true, true);
        Assert.assertEquals(registrationPage.getConfirmEmailError(), confirmEmailError);
    }

    // Verify that an error message is shown when an invalid email format is entered.
    @Test(priority = 10)
    public void invalidEmailFormat() {
        registrationPage.signUp(username, "testestgmail.com", "testtestgmail.com", password, password, true, true);
        Assert.assertEquals(registrationPage.getEmailError(), emailError);
        Assert.assertEquals(registrationPage.getConfirmEmailError(), confirmEmailError);
    }

    // Verify that the user can't register when only password filed is left empty.
    @Test(priority = 11)
    public void emptyPasswordField() {
        registrationPage.signUp(username, email, email, "", password, true, true);
        Assert.assertEquals(registrationPage.getPasswordError(), emptyPasswordError);
    }

    // Verify that the system rejects a password that is shorter than the minimum required length (8 characters).
    @Test(priority = 12)
    public void passwordTooShort() {
        registrationPage.signUp(username, email, email, "test", "test", true, true);
        Assert.assertEquals(registrationPage.getPasswordError(), shortPasswordError);
    }

    // Verify that an error message is shown when the "Password" and "Confirm Password" fields do not match.
    @Test(priority = 13)
    public void mismatchedPasswords() {
        registrationPage.signUp(username, email, email, password, "testpassword", true, true);
        Assert.assertEquals(registrationPage.getConfirmPasswordError(), confirmPasswordError);
    }

    // Verify that the system shows an error when the "I agree to the Terms and Conditions" checkbox is left unchecked.
    @Test(priority = 14)
    public void uncheckedTermsAndConditions() {
        registrationPage.signUp(username, email, email, password, password, false, true);
        Assert.assertEquals(registrationPage.getTermsCheckBoxError(), termsCheckBoxError);
    }
}
