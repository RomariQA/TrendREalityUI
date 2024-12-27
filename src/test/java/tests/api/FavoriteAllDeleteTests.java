package tests.api;

import api.FavoriteApi;
import data.TestData;
import models.FavoriteAllDelete.FavoriteAllDeleteResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.LogSpec.*;

@DisplayName("Полная очистка избранного")
@Tag("allTests")
public class FavoriteAllDeleteTests extends ApiTestBase {

    @DisplayName("Успешная очистка избранного (в избранном 1 Жк и 1 квартира)")
    @Test
    void successfulAllDeleteFromFavorite(){
        FavoriteApi.addFavoriteApartment(session);
        FavoriteApi.addFavoriteBlock(session);

        TestData testData = new TestData();

        FavoriteAllDeleteResponseModel response = step("Очищаем избранное", () ->
                given(RequestSpec)
                        .queryParam("city",testData.getCity())
                        .queryParam("session", session)
                        .when()
                        .delete("/favorites/all")
                        .then()
                        .spec(ResponseSpec200)
                        .extract().as(FavoriteAllDeleteResponseModel.class));

        step("Обьекты очищены из избранного", () -> {
            assertEquals(true, response.getData().getResult().getBlocks().getAcknowledged());
            assertEquals(1, response.getData().getResult().getBlocks().getMatchedCount());
            assertEquals(1, response.getData().getResult().getBlocks().getModifiedCount());
            assertEquals(0, response.getData().getResult().getBlocks().getUpsertedCount());
            assertEquals(true, response.getData().getResult().getApartments().getAcknowledged());
            assertEquals(1, response.getData().getResult().getApartments().getMatchedCount());
            assertEquals(1, response.getData().getResult().getApartments().getModifiedCount());
            assertEquals(0, response.getData().getResult().getApartments().getUpsertedCount());
        });
    }

    @DisplayName("Успешная очистка пустого избранного")
    @Test
    void successfulAllDeleteFromEmptyFavorite(){

        TestData testData = new TestData();

        FavoriteAllDeleteResponseModel response = step("Очищаем избранное", () ->
                given(RequestSpec)
                        .queryParam("city",testData.getCity())
                        .queryParam("session", session)
                        .when()
                        .delete("/favorites/all")
                        .then()
                        .spec(ResponseSpec200)
                        .extract().as(FavoriteAllDeleteResponseModel.class));

        step("В ответе нет измененных обьектов", () -> {
            assertEquals(true, response.getData().getResult().getBlocks().getAcknowledged());
            assertEquals(0, response.getData().getResult().getBlocks().getMatchedCount());
            assertEquals(0, response.getData().getResult().getBlocks().getModifiedCount());
            assertEquals(0, response.getData().getResult().getBlocks().getUpsertedCount());
            assertEquals(true, response.getData().getResult().getApartments().getAcknowledged());
            assertEquals(0, response.getData().getResult().getApartments().getMatchedCount());
            assertEquals(0, response.getData().getResult().getApartments().getModifiedCount());
            assertEquals(0, response.getData().getResult().getApartments().getUpsertedCount());
        });
    }
}
