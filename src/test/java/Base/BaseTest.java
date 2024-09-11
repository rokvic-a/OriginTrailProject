package Base;

import Pages.RegistrationPage;
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


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        registrationPage = new RegistrationPage();
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
    }

    //----------------------------------------------------------------

    public String url = "https://etherscan.io/register";
}
