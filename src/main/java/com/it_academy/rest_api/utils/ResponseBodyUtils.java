package com.it_academy.rest_api.utils;

import io.restassured.response.ResponseBody;

import java.util.List;

public final class ResponseBodyUtils {

    public static <T> List<T> getObjectsByJsonPath(
            ResponseBody responseBody, String jsonPath, Class<T> type) {
        return responseBody
                .jsonPath()
                .getList(jsonPath, type);
    }

    public static List<String> getListStringByJsonPath(
            ResponseBody responseBody, String jsonPath) {
        return responseBody
                .jsonPath()
                .getList(jsonPath);
    }
}
