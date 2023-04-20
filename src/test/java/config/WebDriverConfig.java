package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {
    @Key("browserWithVersion")
    @DefaultValue("chrome,111.0")
    String[] getBrowserAndVersion();

    @Key("browser_size")
    @DefaultValue("1680x1050")
    String getBrowserSize();

    @Key("base_url")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("selenoid")
    String getRemoteUrl();
}
