package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_baseUrlJsonPlaceHolder extends BaseUrlJsonPlaceUrl {

    // https://jsonplaceholder.typicode.com/posts/44 endpointine
    //   bir GET request gonderdigimizde donen response’un
    //   status code’unun 200 oldugunu
    //   ve “title” degerinin “optio dolor molestias sit” oldugunu test edin

    @Test
    public void test01(){

        specJsonPlaceHolder.pathParams("pp1","posts","pp2","44");

        Response response=given().when().spec(specJsonPlaceHolder).get("{pp1}/{pp2}");

        response.then().assertThat()
                                    .statusCode(200)
                                    .body("title", Matchers.equalTo("optio dolor molestias sit"));
    }

            /*
         // https://jsonplaceholder.typicode.com/posts endpointine
        //    bir GET request gonderdigimizde donen response’un
        //    status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test edin

             */
    @Test
    public void test02(){

        specJsonPlaceHolder.pathParam("pp1","posts");

        Response response=given().when().spec(specJsonPlaceHolder).get("{pp1}");

        //response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .body("title",Matchers.hasSize(100));

    }




}
