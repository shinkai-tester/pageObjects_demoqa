package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {
    @Key("username.selenide")
    String remote_username();

    @Key("password.selenide")
    String remote_password();
}
