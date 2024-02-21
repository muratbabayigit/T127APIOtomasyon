package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonPlaceData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_DeSerializationPUT extends BaseUrlJsonPlaceUrl {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }

        Expected Response Body:

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
     */

    @Test
    public void test01(){
        //1-endpoint hazırlama ve varsa reqBody hazırlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");

        Map<String,Object> reqBodyMAP= JsonPlaceData.bodyOlustur();

        //2-Expected Data oluşturma

        Map<String,Object> expBodyMAP=JsonPlaceData.bodyOlustur();
        System.out.println("expBodyMAP = " + expBodyMAP);

        //3-Response Kaydet

        Response response=given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                                                            .when().body(reqBodyMAP)
                                                            .put("{pp1}/{pp2}");

        //4-Assertion İşlemi

        // expected body <--------> response
        //       Map     <-------->   response

        //Assertion işlemi yapabilmek için dönen response MAP'e çevrilmelidir.
        // İşte bu olaya De-Serialization denir

        Map<String,Object> resMap=response.as(HashMap.class);

        assertEquals(expBodyMAP.get("title"),resMap.get("title"));
        assertEquals(expBodyMAP.get("body"),resMap.get("body"));
        assertEquals(expBodyMAP.get("userId"),resMap.get("userId"));
        assertEquals(expBodyMAP.get("id"),resMap.get("id"));

    }
}
