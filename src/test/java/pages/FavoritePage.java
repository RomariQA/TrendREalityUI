package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FavoritePage {

    private SelenideElement deleteAllButton = $(byText("Очистить")),
            confirmDeleteFavoriteButton = $(".btn.btn_main.px-4", 1),
            cancelDeleteFavoriteButton = $(".btn.btn_secondary.px-4"),
            headerEmptyFavorite = $(".h4.text-black-90"),
            favoriteObjectHeader = $(".obj-card-body__title"),
            favoriteObjectCard = $(".favorite-item"),
            moreButtonHoverOnObjectCard = $(".btn-wrapper.shell-element_brand"),
            moreButtonHover = $(".obj-card-footer__button"),
            favoriteButton = $(".trend-ui-icon-root__LikeFilled-20.text-black-30"),
            searchButton = $(".btn.btn_secondary.px-4");

    @Step("Открываем страницу избраного")
    public FavoritePage openFavoritePage(){
        open("/favorites");

        return this;
    }

    @Step("Клик на кнопку очистки избранного")
    public FavoritePage clickOnDeleteAllButton(){
        deleteAllButton.click();

        return this;
    }

    @Step("Подтверждение очистки избранного")
    public FavoritePage clickConfirmDeleteFavoriteButton(){
        confirmDeleteFavoriteButton.click();

        return this;
    }

    @Step("Отображается заголовок пустой страницы избранного")
    public FavoritePage checkEmptyFavoritePage(){
        headerEmptyFavorite.shouldHave(text("Вы пока ничего не добавили"));

        return this;
    }

    @Step("Отмена очистки избранного")
    public FavoritePage clickOnCancellDelateAllButton(){
        cancelDeleteFavoriteButton.click();

        return this;
    }

    @Step("Отображается ранее добавленный обьект в избранном")
    public FavoritePage checkFavoriteObject(){
        favoriteObjectHeader.shouldHave(text("ЖК «Кинопарк»"));

        return this;
    }

    @Step("Ховер на карточку избранного")
    public FavoritePage hoverOnFavoriteObject(){
        favoriteObjectCard.hover();

        return this;
    }

    @Step("Ховер на кнопку Узнать подробнее на карточке избранного")
    public FavoritePage hoverOnMoreButtonOnObjectCard(){
        moreButtonHover.hover();

        return this;
    }

    @Step("Цвет кнопки соответствует дизайну")
    public FavoritePage checkMoreButtonHoverColor(){
        moreButtonHoverOnObjectCard.shouldBe(cssValue("background-color", "rgba(22, 163, 74, 1)"));

        return this;
    }

    @Step("Цвет кнопки соответствует дизайну")
    public FavoritePage checkMoreButtonHoverOnCardColor(){
        moreButtonHoverOnObjectCard.shouldBe(cssValue("background-color", "rgba(34, 197, 94, 1)"));

        return this;
    }

    @Step("Цвет иконки избранного сооответствует дизайну")
    public FavoritePage checkFavoriteButtonColor(){
        favoriteButton.shouldBe(cssValue("color", "rgba(252, 48, 75, 1)"));

        return this;
    }

    @Step("Клик на кнопку Искать квратиру на пустой странице избранного")
    public FavoritePage clickOnSearchButton(){
        searchButton.click();

        return this;
    }

    @Step("Клик на кнопку удаления избранного обьекта")
    public FavoritePage clickOnDeleteObjectButton(){
        favoriteButton.click();

        return this;
    }
}
