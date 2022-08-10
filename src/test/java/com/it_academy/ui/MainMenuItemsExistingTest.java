package com.it_academy.ui;

import com.it_academy.driver.WebDriverFactoryStaticThreadRemote;
import com.it_academy.page_object.CatalogPage;
import com.it_academy.page_object.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainMenuItemsExistingTest {
    private final HomePage homePage = new HomePage();
    private final CatalogPage catalogPage = new CatalogPage();
    private final List<String> expectedNamesOfLinkItem = Arrays.asList(
            "Электроника", "Компьютеры и сети", "Бытовая техника", "Стройка и ремонт", "Дом и сад",
            "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис");

    @Step("Засетать драйвер и перейти на сайт onliner.by")
    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUp(String browser) {
        WebDriverFactoryStaticThreadRemote.setDriver(browser);
        System.out.println("set Up: " + Thread.currentThread().getId());
        WebDriverFactoryStaticThreadRemote
                .getDriver()
                .get("https://www.onliner.by/");
    }

    @Description("Проверить, что названия пункты меню имеют названия " +
            "\"Электроника\", \"Компьютеры и сети\", \"Бытовая техника\", \"Стройка и ремонт\", " +
            "\"Дом и сад\", \"Авто и мото\", \"Красота и спорт\", \"Детям и мамам\", \"Работа и офис\"")
    @Test
    public void testIsExistNamesOfLinkItemOnCatalogPage() {
        homePage.clickOnHomePageLink("Каталог");
        List<String> actualNamesOfLinkItem = catalogPage.getNamesOfLinkItem();

        assertThat(actualNamesOfLinkItem)
                .as("Названия пунктов меню на странице каталога не соответствуют ожидаемым")
                .containsAll(expectedNamesOfLinkItem);
    }

    @Step("Закрыть драйвер")
    @AfterClass
    public void tearDown() {
        WebDriverFactoryStaticThreadRemote.closeDriver();
    }
}
