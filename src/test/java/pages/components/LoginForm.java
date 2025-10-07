package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginForm {
    private SelenideElement loginForm = $("mvid-login-form-phone"),
                            phoneInput = $("#mvideo-form-field-input-1");


    @Step("Проверяем, что отображается форма авторизации")
    public LoginForm checkLoginFormIsDisplayed() {
        loginForm.should(Condition.appear);
        return this;
    }


}
