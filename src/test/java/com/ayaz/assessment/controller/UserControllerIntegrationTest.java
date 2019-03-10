package com.ayaz.assessment.controller;


import com.ayaz.assessment.dto.LoginDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class UserControllerIntegrationTest {

    public UserControllerIntegrationTest() {
    }


    @Test
    public void contextLoads() {
    }

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "api/users";
    }

    @Test
    public void canSuccessfullyLoginWithValidUserCredentials() {
        LoginDto loginDto = new LoginDto("admin","letmein");

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(loginDto)
                .post("/signin")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value());

    }

    @Test
    public void failToLoginWithInValidUserCredentials() {
        LoginDto loginDto = new LoginDto("admin","letmeinerer");

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(loginDto)
                .post("/signin")
                .then()
                .log().all()
                .statusCode(HttpStatus.FORBIDDEN.value())
                .body("error", containsString("Forbidden"));

    }

    @Test
    public void canSuccessfullySignup() {
        LoginDto loginDto = new LoginDto("newadmin","letmeinerer","test","testlastname");

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(loginDto)
                .post("/signup")
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
                .body("username", containsString("newadmin"))
                .body("firstName", containsString("test"))
                .body("lastName", containsString("testlastname"))
                .body("roles[0].roleName", containsString("ROLE_API_ACCESS"));

    }

    @Test
    public void failToSignupIfUsernameAlreadyExists() {
        LoginDto loginDto = new LoginDto("admin","letmeinerer","test","testlastname");

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(loginDto)
                .post("/signup")
                .then()
                .log().all()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("message", containsString("400 User already exists"));

    }
}
