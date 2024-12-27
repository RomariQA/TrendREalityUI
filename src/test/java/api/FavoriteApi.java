package api;

import data.TestData;
import io.qameta.allure.Step;
import models.FavoriteAddApartment.FavoriteAddApartmentRequestModel;
import models.FavoriteAddBlock.FavoriteAddBlockRequestModel;

import static io.restassured.RestAssured.given;
import static specs.LogSpec.*;

public class FavoriteApi {

    @Step("Подготовка. Добавление ЖК в избранное")
    public static String addFavoriteBlock(String session){

        TestData testData = new TestData();
        FavoriteAddBlockRequestModel request = new FavoriteAddBlockRequestModel(testData.getBlock_id(), testData.getCity());

        return given(RequestSpec)
                .body(request)
                .queryParam("city",testData.getCity())
                .queryParam("session", session)
                .when()
                .post("/favorites/blocks")
                .then()
                .spec(ResponseSpec201).toString();
    }

    @Step("Подготовка. Добавление квартиры в избранное")
    public static String addFavoriteApartment(String session){

        TestData testData = new TestData();
        FavoriteAddApartmentRequestModel request = new FavoriteAddApartmentRequestModel(testData.getApartment_id(), testData.getCity());

        return given(RequestSpec)
                .body(request)
                .queryParam("city",testData.getCity())
                .queryParam("session", session)
                .when()
                .post("/favorites/apartments")
                .then()
                .spec(ResponseSpec201).toString();
    }

    @Step("Подготовка. Очистка избранного")
    public static String deleteAllFavorites(String session){

        TestData testData = new TestData();

        return given(RequestSpec)
                .queryParam("city", testData.getCity())
                .queryParam("session", session)
                .when()
                .delete("/favorites/all")
                .then()
                .spec(ResponseSpec200).toString();
    }

}
