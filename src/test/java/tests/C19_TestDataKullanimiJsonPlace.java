package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19_TestDataKullanimiJsonPlace  extends BaseUrlJsonPlaceUrl {

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
     */




            //3-Request gönder / Response Kaydet
            //4-Assertion İşlemi yap

    @Test
    public void test01(){
        //1-Endpoint ve RequestBody varsa hazırlamak
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","22");

        //2-ExpectedBody Hazırlama
        JSONObject expBody= JsonPlaceData.expectedDataOlustur22();


        Response response=given().when().spec(specJsonPlaceHolder).get("{pp1}/{pp2}");

        JsonPath resJP=response.jsonPath();
        assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
        assertEquals(expBody.getInt("userId"),resJP.getInt("userId"));
        assertEquals(expBody.getInt("id"),resJP.getInt("id"));
        assertEquals(expBody.getString("title"),resJP.getString("title"));
        assertEquals(expBody.getString("body"),resJP.getString("body"));



    }
}
