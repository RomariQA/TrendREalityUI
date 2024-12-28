package tests.web;

import api.FavoriteApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FavoritePage;
import pages.SearchPage;

@Tag("web")
@DisplayName("Страница избранного")
public class FavoriteTests extends UiTestBase {

    FavoritePage favoritePage = new FavoritePage();
    SearchPage searchPage = new SearchPage();

    @DisplayName("Полная очистка избранного")
    @Test
    void cleanAllFavoriteTest(){
        FavoriteApi.deleteAllFavorites(session);
        FavoriteApi.addFavoriteBlock(session);

        favoritePage
                .openFavoritePage()
                .clickOnDeleteAllButton()
                .clickConfirmDeleteFavoriteButton()
                .checkEmptyFavoritePage();
    }

    @DisplayName("Отмена очистки избранного в попапе подтверждения")
    @Test
    void cancelConfirmationAllFavoriteTest(){
        FavoriteApi.deleteAllFavorites(session);
        FavoriteApi.addFavoriteBlock(session);

        favoritePage
                .openFavoritePage()
                .clickOnDeleteAllButton()
                .clickOnCancellDelateAllButton()
                .checkFavoriteObject();
    }

    @DisplayName("Смена цвета кнопки Узнать подробнее при ховере на карточке товара")
    @Test
    void changeColorOfButtonByHoverOnCardTest(){
        FavoriteApi.deleteAllFavorites(session);
        FavoriteApi.addFavoriteBlock(session);

        favoritePage
                .openFavoritePage()
                .hoverOnFavoriteObject()
                .checkMoreButtonHoverOnCardColor();
    }

    @DisplayName("Смена цвета кнопки Узнать подробнее при ховере саму кнопку")
    @Test
    void changeColorOfButtonByHoverOnButtonTest(){
        FavoriteApi.deleteAllFavorites(session);
        FavoriteApi.addFavoriteBlock(session);

        favoritePage
                .openFavoritePage()
                .hoverOnMoreButtonOnObjectCard()
                .checkMoreButtonHoverColor();
    }

    @DisplayName("Цвет кнопки избьранного соовтетствует дизайну на карточке обьекта")
    @Test
    void colorOfFavoriteButtonTest(){
        FavoriteApi.deleteAllFavorites(session);
        FavoriteApi.addFavoriteBlock(session);

        favoritePage
                .openFavoritePage()
                .checkFavoriteButtonColor();
    }

    @DisplayName("Переход на страницу поиска по кнопку искать квартиру на пустой странице избранного")
    @Test
    void openSearchPageFromEmptyFavoritePageTest(){
        FavoriteApi.deleteAllFavorites(session);

        favoritePage
                .openFavoritePage()
                .clickOnSearchButton();
        searchPage
                .checkHeaderOfSearchPage();
    }

    @DisplayName("Удаление обьекта из избранного")
    @Test
    void deleteFavoriteObjectTest(){
        FavoriteApi.deleteAllFavorites(session);
        FavoriteApi.addFavoriteBlock(session);

        favoritePage
                .openFavoritePage()
                .clickOnDeleteObjectButton()
                .checkEmptyFavoritePage();
    }
}
