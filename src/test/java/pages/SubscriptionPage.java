package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SubscriptionPage {
    private SelenideElement connectSubscriptionButton = $$("div.mcombo-landing__subscribe-btn-with-price").get(0),
                            fullTermsLink = $("a[mvid-link-button]"),
                            fullTermsPageTitle = $(".mcombo-info__title"),
                            subscriptionPageTitle = $(".mcombo-landing__block-title");


    @Step
    public SubscriptionPage openPage() {
        open("/mcombo");
        return this;
    }


    @Step("Нажимаем на кнопку 'Подключить МКомбо'")
    public SubscriptionPage clickConnectSubscriptionButton() {
        connectSubscriptionButton.click();
        return this;
    }

    @Step("Проверяем, что блок {title} содержит текст {text}")
    public SubscriptionPage checkFAQBlockContainsDescription(String title, String text) {
        $(byText(title)).click();
        $(byText(text)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Нажимаем на кнопку 'Полные правила и условия Подписки М.Комбо'")
    public SubscriptionPage clickFullTermsLink() {
        fullTermsLink.click();
        return this;
    }

    @Step("Переключаемся на другую вкладку")
    public SubscriptionPage changeActiveTab(int tab) {
        switchTo().window(tab);
        return this;
    }

    @Step("Проверяем, что отобразилась страница с полными условиями подписки")
    public SubscriptionPage checkFullTermsPageIsDisplayed() {
        fullTermsPageTitle.shouldHave(Condition.text("Условия использования Сервиса «Подписка М.Комбо"));
        return this;
    }

    @Step("Проверяем, что отображается страница MCombo")
    public SubscriptionPage checkPageIsDisplayed() {
        subscriptionPageTitle.shouldHave(Condition.text("С М.Комбо тебе доступны"));
        return this;
    }
}
