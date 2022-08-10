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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListItemsOfComputersAndNetsExistingTest {
    private final HomePage homePage = new HomePage();
    private final CatalogPage catalogPage = new CatalogPage();
    List<String> actualNamesOfListItemsOfComputersAndNets = new ArrayList<>();
    private final List<String> expectedNamesOfListItemsOfComputersAndNets = Arrays.asList(
            "Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование");

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

    @Description("Проверить, что в разделе \"Каталог, Компьютеры и сети\" пункты подменю содержат" +
            "разделы \"Ноутбуки, компьютеры, мониторы\", \"Комплектующие\", \"Хранение данных\", \"Сетевое оборудование\"")
    @Test
    public void testIsExistNamesOfLinkItemOnCatalogPage() {
        homePage.clickOnHomePageLink("Каталог");
        catalogPage.clickOnCatalogPageLink("Компьютеры");
        actualNamesOfListItemsOfComputersAndNets = catalogPage.getNamesOfSubmenuItemsOfComputersAndNets();

        assertThat(actualNamesOfListItemsOfComputersAndNets)
                .as("Пункты подменю \"Компьютеры и сети\" не содержат ожидаемые названия пунктов меню")
                .containsAll(expectedNamesOfListItemsOfComputersAndNets);

    }

    @Step("Закрыть драйвер")
    @AfterClass
    public void tearDown() {
        WebDriverFactoryStaticThreadRemote.closeDriver();
    }
}
