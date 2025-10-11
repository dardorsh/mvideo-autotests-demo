# Демо-проект по автоматизации тестирования для сайта М.Видео
«М.Видео» — это российская торговая сеть по продаже бытовой техники и электроники, одна из крупнейших в России.

<a href="https://mvideo.ru"><img width="70%" title="MVideo logo" src="files/images/Mvideo-Logo.jpg"></a>

## Используемый стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="files/images/Intelij_IDEA.svg">
<img width="6%" title="Java" src="files/images/Java.svg">
<img width="6%" title="Selenide" src="files/images/Selenide.svg">
<img width="6%" title="JUnit5" src="files/images/JUnit5.svg">
<img width="6%" title="Gradle" src="files/images/Gradle.svg">
<img width="6%" title="Selenoid" src="files/images/Selenoid.svg">
<img width="6%" title="Jenkins" src="files/images/Jenkins.svg">
<img width="6%" title="Allure Report" src="files/images/Allure.svg">
<img width="6%" title="Telegram" src="files/images/Telegram.svg">
</p>


## Примеры тестовых сценариев

* Проверка, что на главной странице отображается кнопка для перехода на страницу подписки
* Проверка, что на главной странице кнопка входа в аккаунт ведет на форму авторизации
* Проверка, что кнопка 'Подключить М.Комбо' ведет на форму авторизации, если пользователь не авторизован

## Запуск автотестов

### Локальный запуск
```
gradle clean mvideoTests
``````
### Удаленный запуск через Jenkins

```bash  
clean mvideoTests 
-Dselenoid_url="https://user1:1234@selenoid.autotests.cloud/wd/hub" 
-Dbrowser=${BROWSER} 
-Dbrowser_version=${BROWSER_VERSION} 
-Dresolution=${RESOLUTION}
```

## Сборка в Jenkins

Сборка доступна по адресу: https://jenkins.autotests.cloud/job/C37-daryadorsh-demo-mvideo/build

Для запуска сборки необходимо перейти в раздел <code>Build with parameters</code>
<p align="center">
<img title="Jenkins Build" src="files/images/jenkins_job.png">
</p>

и указать следующие параметры:

<p align="center">
<img title="Jenkins Job Parameters" src="files/images/job_params.png">
</p>


- <code>BROWSER</code> - тип браузера (доступны Сhrome и Firefox)
- <code>BROWSER_VERSION</code> - версия браузера (для Chrome доступны версии: 127.0, 128.0; для Firefox - 124.0, 125.0)
- <code>RESOLUTION</code> - разрешение окна браузера

## Пример Allure-отчета

<p align="center">
<img title="Allure Overview" src="files/images/allure_report_example.png">
</p>

Allure-отчет содержит:

1. Пошаговое описание выполнения теста, оформленное с помощью аннотации @Step в коде проекта
2. Скриншот страницы
3. HTML-код страницы
4. Логи браузерной консоли;
5. Видео выполнения автотеста.


### Уведомления в Telegram 

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="files/images/Telegram_notif.png">
</p>

### Видео примера запуска тестов в Selenoid

<p align="center">
  <img title="Selenoid Video" src="files/images/video.gif">
</p>