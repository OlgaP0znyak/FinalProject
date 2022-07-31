package com.it_academy.rest_api.endpoints;

import com.it_academy.framework.PropertiesReader;

public class OnlinerEndpoints {

    public static String getCatalogSushiveslaEndPoint() {
        return PropertiesReader.getEndpointProperty("catalog.search.sushivesla");
    }

    public static String getCatalogSushiveslaRollsEndPoint() {
        return PropertiesReader.getEndpointProperty("catalog.search.sushivesla.rolls");
    }
}
