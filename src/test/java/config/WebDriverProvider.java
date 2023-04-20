package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {

    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static AuthConfig authconfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    public static void config() {
        Configuration.baseUrl = WebDriverProvider.config.getBaseUrl();
        Configuration.browserSize = WebDriverProvider.config.getBrowserSize();
        String[] browserWithVersion = WebDriverProvider.config.getBrowserAndVersion();
        Configuration.browser = browserWithVersion[0];
        Configuration.browserVersion = browserWithVersion[1];
        String remoteUrl = WebDriverProvider.config.getRemoteUrl();
        if (remoteUrl != null) {
            Configuration.remote = "https://" + WebDriverProvider.authconfig.remote_username() + ":" + WebDriverProvider.authconfig.remote_password() + "@" + remoteUrl  + "/wd/hub";
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}
