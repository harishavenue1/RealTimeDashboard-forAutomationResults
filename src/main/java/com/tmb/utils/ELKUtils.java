package com.tmb.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ELKUtils {

    private ELKUtils() {}

    public static void sendDetailsToElk(String testName, String status) {

        String url = "http://15.206.70.38:9200/suite/result";
        HashMap<String, String> map = new HashMap<>();
        map.put("module", "login");
        map.put("author", "harish");
        map.put("testName", testName);
        map.put("status", status);
        map.put("executionTime", LocalDateTime.now().toString());
        Response res = RestAssured.given().header("Content-Type", "application/json")
                        .body(map).when().post(url);
        Assert.assertEquals(res.statusCode(), 201);
    }
}
