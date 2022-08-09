package com.it_academy.ui;

import com.it_academy.driver.WebDriverFactoryStaticThreadRemote;
import com.it_academy.page_object.CatalogPage;
import com.it_academy.page_object.HomePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EachElementOfAccessoriesContainingTest {
    private final HomePage homePage = new HomePage();
    private final CatalogPage catalogPage = new CatalogPage();
    List<String> titlesOfElementsOfAccessories = new ArrayList<>();

    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUp(String browser) {
        WebDriverFactoryStaticThreadRemote.setDriver(browser);
        System.out.println("set Up: " + Thread.currentThread().getId());
        WebDriverFactoryStaticThreadRemote
                .getDriver()
                .get("https://www.onliner.by/");
    }

    @Test
    public void testAccessoriesContainElements() {
        homePage.clickOnHomePageLink("�������");
        catalogPage.clickOnCatalogPageLink("����������");
        catalogPage.clickOnItemOfComputersAndNets("�������������");
        titlesOfElementsOfAccessories = catalogPage.getTitlesOfElementsOfAccessories();
        List<String> quantities = catalogPage.getQuantityOfElementsOfAccessories();
        List<String> prices = catalogPage.getPricesOfElementsOfAccessories();

        assertThat(titlesOfElementsOfAccessories)
                .as("� ������ ������������� �� ��� �������� �������� ��������")
                .doesNotContain("")
                .doesNotContainNull();
        assertThat(quantities)
                .as("� ������ ������������� �� ��� �������� �������� ����������")
                .doesNotContain("")
                .doesNotContainNull();
        assertThat(prices)
                .as("� ������ ������������� �� ��� �������� �������� ����")
                .doesNotContain("")
                .doesNotContainNull();
    }


    @AfterClass
    public void tearDown() {
        WebDriverFactoryStaticThreadRemote.closeDriver();
    }
}

