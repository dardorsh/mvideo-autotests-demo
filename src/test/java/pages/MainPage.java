package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.sun.tools.javac.Main;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement loginButton = $("a[href='https://www.mvideo.ru/login?from=widget']"),
            todayProductsBlock = $("mvid-day-products-block"),
            addToCartButton = $$("mvid-day-products-block span").findBy(Condition.text("В корзину")),
            goToCartButton = $$("button[title = 'Перейти в корзину']").get(0),
            openMcomboPageButton = $("a[href='/mcombo?from=persblok']");


    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open(baseUrl);
        return this;
    }

    @Step("Нажимаем на кнопку 'Авторизуйся, чтобы применить бонусы'")
    public MainPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Проверяем, что отображается блок 'Товары дня'")
    public MainPage checkTodayProductsBlockIsDisplayed() {
        todayProductsBlock.should(Condition.appear);
        return this;
    }

    @Step("Нажимаем на кнопку 'Максимум выгоды в подписке М.Комбо'")
    public MainPage clickMcomboButton() {
        openMcomboPageButton.click();
        return this;
    }



}
