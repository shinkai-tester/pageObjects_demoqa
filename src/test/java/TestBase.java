import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1680x1050";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
