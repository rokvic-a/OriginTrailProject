package Base;

import Pages.RegistrationPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public RegistrationPage registrationPage;
    public Resources resources;
    protected String username;
    protected String password;
    protected String email;


    @BeforeClass
    public void setUp() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        registrationPage = new RegistrationPage();
        resources = new Resources("C:\\Users\\rokvaa\\Desktop\\credentials.txt");
        username = resources.getUsername();
        password = resources.getPassword();
        email = resources.getEmail();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    //------------------------HELPERS--------------------------------

    public String usernameError = "Please enter Username.";
    public String alphanumericalUsernameError = "Only alphanumeric characters allowed.";
    public String shortUsernameError = "Please enter at least 5 characters.";
    public String emailError = "Please enter a valid email address.";
    public String confirmEmailError = "Please re-enter your email address.";
    public String mismatchedEmailError = "Email address does not match.";
    public String emptyPasswordError = "Please enter Password.";
    public String shortPasswordError = "Your password must be at least 8 characters long.";
    public String confirmPasswordError = "Password does not match, please check again.";
    public String termsCheckBoxError = "Please accept our Terms and Conditions.";
}
