package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJsonPlaceHolder;
import testData.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_PojoClassPUT extends BaseUrlJsonPlaceUrl {
/*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body'e sahip bir PUT request yolladigimizda
    donen response'in
    status kodunun 200,
    content type'inin "application/json; charset=utf-8",
    Connection header degerinin "keep-alive"
    ve response body'sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Response body : // expected data
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
 */

    @Test
    public void test01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        PojoJsonPlaceHolder reqBodyPojo=new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        PojoJsonPlaceHolder expBodyPojo=new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        Response response=given().spec(specJsonPlaceHolder).contentType(ContentType.JSON).when().body(reqBodyPojo).put("{pp1}/{pp2}");

        PojoJsonPlaceHolder resPojo=response.as(PojoJsonPlaceHolder.class);




        assertEquals(expBodyPojo.getTitle(),resPojo.getTitle());
        assertEquals(expBodyPojo.getBody(),resPojo.getBody());
        assertEquals(expBodyPojo.getId(),resPojo.getId());
        assertEquals(expBodyPojo.getUserId(),resPojo.getUserId());
        assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
        assertEquals(JsonPlaceData.contentType,response.getContentType());
        assertEquals(JsonPlaceData.header,response.header("Connection"));




    }


}
