package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C1_Get_ApiSorgulama {

        /*
tests.C1_Get_ApiSorgulama
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
gonderdigimizde donen Response'un,
status code'unun 200,
ve content type'inin application/json; charset=utf-8, ve
Server isimli Header'in degerinin Cowboy,
ve status Line'in HTTP/1.1 200 OK
ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
 */

    /*
    //API Testlerinde genelde işlemler 4 aşamada gerçekleşir
    //    1-Endpoint belirlenerek hazırlanır
    //    2-Gerekli ise Expected Data hazırlanır
    //    3-Actual Data kaydedilir
    //    4-Assertion İşlemi Yapılır
     */

    @Test
    public void get01(){
      //  1-Endpoint belirlenerek hazırlanır
        String url="https://restful-booker.herokuapp.com/booking/10";
     //2-Gerekli ise Expected Data hazırlanır
     //3-Actual Data kaydedilir
        Response response=given().when().get(url)   ;

        //response.prettyPrint();
        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Content Type: "+response.getContentType());
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Header/Server:"+response.getHeader("Server"));
        System.out.println("Test Time: "+response.getTime()+"ms");



    }



}
