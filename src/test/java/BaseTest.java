//import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
public class BaseTest {
    WebDriver driver;
   // Faker faker = new Faker();
    @BeforeEach
    void setup()
    {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qavalidation.com/demo-form");
    }
    @AfterEach
    void close()
    {
        //  driver.quit();
    }
}
