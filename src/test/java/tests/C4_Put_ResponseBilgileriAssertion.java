package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C4_Put_ResponseBilgileriAssertion {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile
        bir PUT request gonderdigimizde
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }
        donen Response’un,
        status code’unun 200,
        content type’inin application/json; charset=utf-8
        Server isimli Header’in degerinin cloudflare,
        status Line’in HTTP/1.1 200 OK olduğunu assert ediniz.
     */


    @Test
    public void put01(){

        //    1-Endpoint belirlenerek hazırlanır
        String url="https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody=new JSONObject();
        reqBody.put("title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 10);
        reqBody.put("id", 70);

        //    2-Gerekli ise Expected Data hazırlanır

        //    3-Actual Data kaydedilir
        Response response=given().contentType(ContentType.JSON).when()
                                                                      .body(reqBody.toString()).put(url);

        //    4-Assertion İşlemi Yapılır

        response.then().assertThat()
                                    .statusCode(200)
                                    .header("Server", "cloudflare")
                                    .contentType("application/json; charset=utf-8")
                                    .statusLine("HTTP/1.1 200 OK");

        response.prettyPrint();
        System.out.println(response.getHeaders());


    }





}
