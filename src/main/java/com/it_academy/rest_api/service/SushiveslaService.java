package com.it_academy.rest_api.service;

import com.it_academy.rest_api.endpoints.OnlinerEndpoints;
import com.it_academy.rest_api.model.SushiveslaProduct;
import com.it_academy.rest_api.util.GetRequestUtil;
import com.it_academy.rest_api.util.ResponseBodyUtil;
import io.restassured.response.ResponseBody;

import java.util.List;

public class SushiveslaService {
    private static final String SUSHIVESLA_PRODUCTS_JSON_PATH = "products";
    private static final String SUSHIVESLA_PRODUCTS_NAME_PREFIX_JSON_PATH = "products.name_prefix";

    public List<SushiveslaProduct> getListSushiveslaProducts() {
        ResponseBody responseBody;
        responseBody = GetRequestUtil.makeRequestAndGetResponseBody(
                OnlinerEndpoints.getCatalogSushiveslaEndPoint(),
                null, null);
        return ResponseBodyUtil.getObjectsByJsonPath(
                responseBody, SUSHIVESLA_PRODUCTS_JSON_PATH, SushiveslaProduct.class);
    }

    public List<String> getListSushiveslaProductsName_prefix() {
        ResponseBody responseBody = GetRequestUtil.makeRequestAndGetResponseBody(
                OnlinerEndpoints.getCatalogSushiveslaRollsEndPoint(),
                null, null);
        return ResponseBodyUtil.getListStringByJsonPath(
                responseBody, SUSHIVESLA_PRODUCTS_NAME_PREFIX_JSON_PATH);
    }
}
