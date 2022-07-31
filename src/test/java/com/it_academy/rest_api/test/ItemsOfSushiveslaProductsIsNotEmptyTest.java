package com.it_academy.rest_api.test;

import com.it_academy.rest_api.model.SushiveslaProduct;
import com.it_academy.rest_api.service.SushiveslaService;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemsOfSushiveslaProductsIsNotEmptyTest {
    @Test
    public void testItemsOfSushiveslaProductsIsNotEmpty() {
        List<SushiveslaProduct> sushiveslaProducts = new SushiveslaService().getListSushiveslaProducts();

        assertThat(sushiveslaProducts).
                as("Присутствует пустое поле в продукте сушивесла")
                .isNotEmpty();
    }
}
