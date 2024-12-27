package tests.api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ApiTestBase {

    public static TestData testData;
    public static String session;
    public static String city_id;
    public static boolean isUITest;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.trendrealty.ru";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        testData = new TestData();
        session = testData.getSession();
    }

    @BeforeEach
    void beforeEach(){
        Cookie sessionCookie = new Cookie.Builder("session", testData.getSession())
                .path("/")
                .build();

        RestAssured.given().cookies("session", testData.getSession());
    }

}
