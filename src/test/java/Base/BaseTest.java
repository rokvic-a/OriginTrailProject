package Base;

import Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver driver;
    public RegistrationPage registrationPage;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage();
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
    }
}
