package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:app.properties"})
public interface AppConfig extends Config {

    @Key("base.url")
    String baseUrl();

    @Key("headless.mode")
    boolean headless();

    @Key("bearer.token")
    String bearer_token();
}