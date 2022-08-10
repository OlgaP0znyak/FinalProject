package com.it_academy.ui;

import com.it_academy.driver.WebDriverFactoryStaticThreadRemote;
import com.it_academy.page_object.CatalogPage;
import com.it_academy.page_object.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class EachElementOfAccessoriesContainingTest {
    private final HomePage homePage = new HomePage();
    private final CatalogPage catalogPage = new CatalogPage();
    List<String> titlesOfElementsOfAccessories = new ArrayList<>();

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

    @Description("Проверить, что в разделе \"Каталог, Компьютеры и сети, Комплектующие\" " +
            "все элементы содержат название, количество и цену")
    @Test
    public void testAccessoriesContainElements() {
        homePage.clickOnHomePageLink("Каталог");
        catalogPage.clickOnCatalogPageLink("Компьютеры");
        catalogPage.clickOnItemOfComputersAndNets("Комплектующие");
        titlesOfElementsOfAccessories = catalogPage.getTitlesOfElementsOfAccessories();
        List<String> quantities = catalogPage.getQuantityOfElementsOfAccessories();
        List<String> prices = catalogPage.getPricesOfElementsOfAccessories();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(titlesOfElementsOfAccessories)
                .as("В списке комплектующих не все элементы содержат название")
                .isNotEmpty()
                .doesNotContain("")
                .doesNotContainNull();
        softly.assertThat(quantities)
                .as("В списке комплектующих не все элементы содержат количество")
                .isNotEmpty()
                .doesNotContain("")
                .doesNotContainNull();
        softly.assertThat(prices)
                .as("В списке комплектующих не все элементы содержат цену")
                .isNotEmpty()
                .doesNotContain("")
                .doesNotContainNull();
        softly.assertAll();
    }

    @Step("Закрыть драйвер")
    @AfterClass
    public void tearDown() {
        WebDriverFactoryStaticThreadRemote.closeDriver();
    }
}

