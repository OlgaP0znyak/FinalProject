package com.it_academy.rest_api;

import com.it_academy.rest_api.service.SushiveslaService;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Name_prefixOfSushiveslaProductsIsContainSelectedFilterTest {
    @Test
    public void testName_prefixOfSushiveslaProductsIsContainSelectedFilter() {
        List<String> sushiveslaProductsName_prefixes =
                new SushiveslaService().getListSushiveslaProductsName_prefix();

        assertThat(sushiveslaProductsName_prefixes).
                as("Не все продукты сушивесла содержат фильтр роллы")
                .allMatch(sushiveslaProductsName_prefixe -> sushiveslaProductsName_prefixe.equals("Роллы"));
    }
}
