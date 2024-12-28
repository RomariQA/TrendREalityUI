package tests.api;

import data.TestData;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;


public class ApiTestBase {

    public static TestData testData;
    public static String session;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.trendrealty.ru";
    }

    @BeforeEach
    void beforeEach(){
        testData = new TestData();
        session = testData.getSession();

        Cookie sessionCookie = new Cookie.Builder("session", testData.getSession())
                .path("/")
                .build();

        RestAssured.given().cookies("session", testData.getSession());
    }

}
