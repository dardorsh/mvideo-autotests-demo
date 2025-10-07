package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SubscriptionPage;
import pages.components.LoginForm;


public class SubscriptionTests extends TestBase {

    SubscriptionPage subscriptionPage = new SubscriptionPage();
    LoginForm loginForm = new LoginForm();


    @Test
    @DisplayName("Проверка, что на странице /mcombo есть описание условий подписки")
    void mcomboSubscriptionIsDescribedTest() {
        subscriptionPage.openPage();
        subscriptionPage.checkFAQBlockContainsDescription("Что такое персональные предложения по подписке?",
                "Подписчикам М.Комбо доступны лучшие цены на выделенный ассортимент товаров. " +
                        "Ознакомиться с предложениями можно на странице подписки на сайте");
        subscriptionPage.checkFAQBlockContainsDescription("Какой срок действия подписки?",
                "М.Комбо действует 12 месяцев с момента покупки. 1 месяц равен периоду в 30 дней");
        subscriptionPage.checkFAQBlockContainsDescription("Нужно ли привязывать банковскую карту для оплаты подписки?",
                "Нет, можно оплатить подписку без привязки банковской карты");
    }

    @Test
    @DisplayName("Проверка, что по кнопке 'Полные правила и условия Подписки М.Комбо' открывается страница с документом")
    void mcomboFullTermsPageIsOpenedTest() {
        subscriptionPage.openPage();
        subscriptionPage.clickFullTermsLink();
        subscriptionPage.changeActiveTab(1);
        subscriptionPage.checkFullTermsPageIsDisplayed();
    }

    @Test
    @DisplayName("Проверка, что кнопка 'Подключить М.Комбо' ведет на форму авторизации, если пользователь не авторизован")
    void mcomboSubscribeButtonOpensLoginFormTest() {
        subscriptionPage.openPage();
        subscriptionPage.clickConnectSubscriptionButton();
        loginForm.checkLoginFormIsDisplayed();
    }
}
