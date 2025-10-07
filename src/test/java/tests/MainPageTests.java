package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SubscriptionPage;
import pages.components.LoginForm;

public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    LoginForm loginForm = new LoginForm();
    SubscriptionPage subscriptionPage = new SubscriptionPage();


    @Test
    @DisplayName("Проверка, что на главной странице кнопка входа в аккаунт ведет на форму авторизации")
    void loginButtonOpensAuthFormOnMainPageTest() {
        mainPage.openPage();
        mainPage.clickLoginButton();
        loginForm.checkLoginFormIsDisplayed();
    }

    @Test
    @DisplayName("Проверка, что на главной странице отображается блок 'Товары дня'")
    void todayProductsBlockIsDisplayedOnMainPageTest() {
        mainPage.openPage();
        mainPage.checkTodayProductsBlockIsDisplayed();
    }

    @Test
    @DisplayName("Проверка, что на главной странице отображается кнопка для перехода на страницу подписки")
    void mcomboButtonOnMainPageOpensSubscribtionPage() {
        mainPage.openPage();
        mainPage.clickMcomboButton();
        subscriptionPage.checkPageIsDisplayed();
    }
}

