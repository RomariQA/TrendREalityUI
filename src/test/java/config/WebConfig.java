package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envWeb}.properties",
})

public interface WebConfig extends Config{

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remoteVideo")
    String getRemoteVideo();

    @Key("remoteUrl")
    String getRemoteUrl();
}