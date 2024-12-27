package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class UiTestBase {

    public static TestData testData;
    public static String session;
    public static String city_id;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://trendrealty.ru";
        RestAssured.baseURI = "https://api.trendrealty.ru";
        Configuration.pageLoadStrategy = "eager";


        Configuration.remote = System.getProperty("remoteURL");
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browserVersion");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        testData = new TestData();
        session = testData.getSession();
        city_id = testData.getCity();

        Cookie sessionCookie = new Cookie.Builder("session", testData.getSession())
                .path("/")
                .build();

        RestAssured.given().cookies("session", testData.getSession());

        open("/");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("selected_city", city_id));
        WebDriverRunner.getWebDriver().manage().addCookie(sessionCookie);
    }

    @AfterEach
    void addAttachments() {

        Attach.screenshotAs("Last screenshot");
        if (!Configuration.browser.equals("firefox")) {
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
        closeWebDriver();
    }
}
