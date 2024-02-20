package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_TestDataJsonPlaceDinamik extends BaseUrlJsonPlaceUrl {


    /*
        https://jsonplaceholder.typicode.com/posts/40 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":4,
            "id":40,
            "title":"enim quo cumque",
            "body":"ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
        }
     */
    @Test
    public void test01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","40");


        JSONObject expBody= JsonPlaceData.JSonDataOlustur(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");

        Response response=given().when().spec(specJsonPlaceHolder).get("{pp1}/{pp2}");

        JsonPath resJP=response.jsonPath();
        assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
        assertEquals(expBody.getInt("userId"),resJP.getInt("userId"));
        assertEquals(expBody.getInt("id"),resJP.getInt("id"));
        assertEquals(expBody.getString("title"),resJP.getString("title"));
        assertEquals(expBody.getString("body"),resJP.getString("body"));


    }

}
