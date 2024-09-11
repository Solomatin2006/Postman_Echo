package ru.netology;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanEchoTest {


    @Test
    void shouldReturnSendData() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Hello") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when().log().all()
                .post("/post")
// Проверки
                .then().log().all()
                .statusCode(200)
                .body("data", org.hamcrest.Matchers.equalTo("Hello2"));

    }
}
