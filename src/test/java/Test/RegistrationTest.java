package Test;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        String url = resources.getUrl();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
