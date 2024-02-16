import groovy.json.JsonOutput;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C7_Get_BodyTekrarlardanKurtulma {
     /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
            status code’unun 200,
            ve content type’inin application/json,
            ve response body’sindeki
            “firstname”in, “Eric”,
            ve “lastname”in, “Jackson”,
            ve “totalprice”in, 866,
            ve “depositpaid”in, true,
	        ve “additionalneeds”in, “Breakfast” oldugunu test edin
	        NOT: Veriler değişiyor Postman'de dataları kontrol ediniz
     */

    @Test
    public void bodyTekrarindanKurtulma(){
        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);

        response.then().assertThat().statusCode(200).contentType("application/json")
                                    .body("firstname", equalTo("Eric"),"lastname",equalTo("Wilson"),
                                          "totalprice",equalTo(866),"depositpaid",equalTo(true),
                                          "additionalneeds",equalTo("Breakfast"));
        System.out.println(response.contentType());

    }




}
