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

    @BeforeClass
    public void setUp() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        registrationPage = new RegistrationPage();
        resources = new Resources("C:\\Users\\rokvaa\\Desktop\\credentials.txt");
    }

    @AfterClass
    public void tearDown() {
        // driver.quit();
    }

    //----------------------------------------------------------------

}
