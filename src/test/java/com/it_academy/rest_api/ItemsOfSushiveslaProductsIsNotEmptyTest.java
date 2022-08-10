package com.it_academy.rest_api;

import com.it_academy.rest_api.model.SushiveslaProduct;
import com.it_academy.rest_api.service.SushiveslaService;
import io.qameta.allure.Description;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;

public class ItemsOfSushiveslaProductsIsNotEmptyTest {
    @Description("Проверить, что каждый продукт сушивесла содержит не пустой id, key, name и full_name")
    @Test
    public void testItemsOfSushiveslaProductsIsNotEmpty() {
        List<SushiveslaProduct> sushiveslaProducts = new SushiveslaService().getListSushiveslaProducts();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(sushiveslaProducts).
                as("Присутствует пустое поле id в продукте сушивесла")
                .allMatch(sushiveslaProduct -> !sushiveslaProduct.getId().isEmpty());
        softly.assertThat(sushiveslaProducts).
                as("Присутствует пустое поле key в продукте сушивесла")
                .allMatch(sushiveslaProduct -> !sushiveslaProduct.getKey().isEmpty());
        softly.assertThat(sushiveslaProducts).
                as("Присутствует пустое поле name в продукте сушивесла")
                .allMatch(sushiveslaProduct -> !sushiveslaProduct.getName().isEmpty());
        softly.assertThat(sushiveslaProducts).
                as("Присутствует пустое поле full_name в продукте сушивесла")
                .allMatch(sushiveslaProduct -> !sushiveslaProduct.getFull_name().isEmpty());
        softly.assertAll();
    }
}
