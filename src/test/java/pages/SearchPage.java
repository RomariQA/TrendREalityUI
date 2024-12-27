package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class SearchPage {

    private SelenideElement searchHeader = $(".compilation-info__content");

    @Step("Страница поиска открыта")
    public SearchPage checkHeaderOfSearchPage(){
        searchHeader.shouldBe(visible);

        return this;
    }

}
