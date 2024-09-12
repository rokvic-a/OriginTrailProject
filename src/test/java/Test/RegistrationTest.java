package Test;

import Base.BaseTest;
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
    @Test
    public void validUserRegistration() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        String email = resources.getEmail();
        registrationPage.signUp(username, email, email, password, password);
    }
}
