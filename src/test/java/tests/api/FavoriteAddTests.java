package tests.api;

import api.FavoriteApi;
import data.TestData;
import models.FavoriteAddApartment.FavoriteAddApartmentRequestModel;
import models.FavoriteAddApartment.FavoriteAddApartmentResponseModel;
import models.FavoriteAddBlock.FavoriteAddBlockRequestModel;
import models.FavoriteAddBlock.FavoriteAddBlockResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.LogSpec.*;

@DisplayName("Добавление в избранное")
@Tag("allTests")
public class FavoriteAddTests extends ApiTestBase {

    @DisplayName("Успешное добавление ЖК в избранное")
    @Test
    void successfulAddBlockToFavorite(){

        TestData testData = new TestData();
        FavoriteAddBlockRequestModel request = new FavoriteAddBlockRequestModel(testData.getBlock_id(), testData.getCity());

        FavoriteAddBlockResponseModel response = step("Добавляем обьект в избранное", () ->
                given(RequestSpec)
                        .body(request)
                        .queryParam("city",testData.getCity())
                        .queryParam("session", session)
                        .when()
                        .post("/favorites/blocks")
                        .then()
                        .spec(ResponseSpec201)
                        .extract().as(FavoriteAddBlockResponseModel.class));

        step("Пользоваетль успешно добавил обьект в избранное", () -> {
            assertEquals(testData.getBlock_id(), response.getData().getResult().getBlockId());
            assertEquals(true, response.getData().getResult().getSelf());
            assertEquals(false, response.getData().getResult().getDeleted());
            assertEquals(testData.getCity(), response.getData().getResult().getCity());
            assertEquals(1, response.getData().getResult().getView());
        });
    }

    @DisplayName("Добавление несуществующего ЖК в избранное")
    @Test
    void unsuccessfulAddBlockToFavorite(){

        TestData testData = new TestData();
        FavoriteAddBlockRequestModel request = new FavoriteAddBlockRequestModel("123", testData.getCity());

        FavoriteAddBlockResponseModel response = step("Добавляем несуществующий ЖК в избранное", () ->
                given(RequestSpec)
                        .body(request)
                        .queryParam("city",testData.getCity())
                        .queryParam("session", session)
                        .when()
                        .post("/favorites/blocks")
                        .then()
                        .spec(ResponseSpec400)
                        .extract().as(FavoriteAddBlockResponseModel.class));

        step("Отображается код ошибки и ошибка, а так же обьект ошибки", () -> {
            assertEquals(1, response.getError().getCode());
            assertEquals("Один или несколько параметров не указаны или заполнены неверно.", response.getError().getDescription());
            assertEquals("Invalid ObjectId: 123", response.getError().getParams().getBlockId());
        });
    }

    @DisplayName("Додавление уже находящегося в избранном ЖК повторно в избранное")
    @Test
    void addingAnExistingBlockToFavorites(){
        FavoriteApi.addFavoriteBlock(session);

        TestData testData = new TestData();
        FavoriteAddBlockRequestModel request = new FavoriteAddBlockRequestModel(testData.getBlock_id(), testData.getCity());

        FavoriteAddBlockResponseModel response = step("Добавляем существующий в избранном повторно обьект в избранное", () ->
                given(RequestSpec)
                        .body(request)
                        .queryParam("city",testData.getCity())
                        .queryParam("session", session)
                        .when()
                        .post("/favorites/blocks")
                        .then()
                        .spec(ResponseSpec400)
                        .extract().as(FavoriteAddBlockResponseModel.class));

        step("Отображается код ошибки и ошибка, а так же обьект ошибки", () -> {
            assertEquals(6, response.getError().getCode());
            assertEquals("Объект с заданным свойством в параметрах запроса уже существует.", response.getError().getDescription());
            assertEquals(testData.getBlock_id(), response.getError().getParams().getBlockId());
        });
    }

    @DisplayName("Успешное добавление квартиры в избранное")
    @Test
    void successfulAddApartmentToFavorite(){

        TestData testData = new TestData();
        FavoriteAddApartmentRequestModel request = new FavoriteAddApartmentRequestModel(testData.getApartment_id(), testData.getCity());

        FavoriteAddApartmentResponseModel response = step("Добавляем обьект в избранное", () ->
                given(RequestSpec)
                        .body(request)
                        .queryParam("city",testData.getCity())
                        .queryParam("session", session)
                        .when()
                        .post("/favorites/apartments")
                        .then()
                        .spec(ResponseSpec201)
                        .extract().as(FavoriteAddApartmentResponseModel.class));

        step("Пользоваетль успешно добавил обьект в избранное", () -> {
            assertEquals(testData.getApartment_id(), response.getData().getResult().getApartmentId());
            assertEquals(true, response.getData().getResult().getSelf());
            assertEquals(false, response.getData().getResult().getDeleted());
            assertEquals(testData.getCity(), response.getData().getResult().getCity());
            assertEquals(1, response.getData().getResult().getView());
        });
    }

    @DisplayName("Добавление несуществующей квартиры в избранное")
    @Test
    void unsuccessfulAddApartmentToFavorite(){

        TestData testData = new TestData();
        FavoriteAddApartmentRequestModel request = new FavoriteAddApartmentRequestModel("123", testData.getCity());

        FavoriteAddApartmentResponseModel response = step("Добавляем обьект в избранное", () ->
                given(RequestSpec)
                        .body(request)
                        .queryParam("city",testData.getCity())
                        .queryParam("session", session)
                        .when()
                        .post("/favorites/apartments")
                        .then()
                        .spec(ResponseSpec400)
                        .extract().as(FavoriteAddApartmentResponseModel.class));

        step("Отображается код ошибки и ошибка, а так же обьект ошибки", () -> {
            assertEquals(1, response.getError().getCode());
            assertEquals("Один или несколько параметров не указаны или заполнены неверно.", response.getError().getDescription());
            assertEquals("Invalid ObjectId: 123", response.getError().getParams().getApartmentId());
        });
    }

    @DisplayName("Добавление уже находящейся в избранном квартиры повторно в избранное")
    @Test
    void addingAnExistingApartmentToFavorites(){
        FavoriteApi.addFavoriteApartment(session);

        TestData testData = new TestData();
        FavoriteAddApartmentRequestModel request = new FavoriteAddApartmentRequestModel(testData.getApartment_id(), testData.getCity());

        FavoriteAddApartmentResponseModel response = step("Добавляем обьект в избранное", () ->
                given(RequestSpec)
                        .body(request)
                        .queryParam("city",testData.getCity())
                        .queryParam("session", session)
                        .when()
                        .post("/favorites/apartments")
                        .then()
                        .spec(ResponseSpec400)
                        .extract().as(FavoriteAddApartmentResponseModel.class));

        step("Отображается код ошибки и ошибка, а так же обьект ошибки", () -> {
            assertEquals(6, response.getError().getCode());
            assertEquals("Объект с заданным свойством в параметрах запроса уже существует.", response.getError().getDescription());
            assertEquals(testData.getApartment_id(), response.getError().getParams().getApartmentId());
        });
    }
}
