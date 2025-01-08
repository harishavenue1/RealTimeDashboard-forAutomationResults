package com.tmb.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ElasticTesting {

    public static void main(String[] args) {

        String url = "http://15.206.70.38:9200/suite/result";
        HashMap<String, String> map = new HashMap<>();
        map.put("module", "login");
        map.put("author", "harish");

        for (int i=1; i<101; i++) {
            map.put("testName", "TC-"+i);
            if (i % 5 == 0)
                map.put("status", "Fail");
            else if (i % 9 == 0)
                map.put("status", "Skip");
            else
                map.put("status", "Pass");
            map.put("executionTime", LocalDateTime.now().toString());
            Response res = RestAssured.given().header("Content-Type", "application/json")
                    .body(map).when().post(url);
            Assert.assertEquals(res.statusCode(), 201);
            System.out.println("Completed "+ i);
        }
    }
}
