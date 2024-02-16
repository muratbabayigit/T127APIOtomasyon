import org.json.JSONObject;
import org.junit.Test;

public class C3_JsonObjesiOlusturma {
           /*
           Asagidaki JSON Objesini olusturup konsolda yazdirin.
                     {
                     "title":"Ahmet",
                     "body":"Merhaba",
                     "userId":1
                     }
            */
    @Test
    public void jsonData(){

        JSONObject jsonData=new JSONObject();

        jsonData.put("Title","Ahmet");
        jsonData.put("body","Merhaba");
        jsonData.put("userId",1);

        System.out.println("ilk Oluşturulan JSON Data: "+jsonData);

    }

    /*
Asagidaki JSON Objesini olusturup konsolda yazdirin.

{
"firstname":"Jim",
"additionalneeds":"Breakfast",
"bookingdates":{
               "checkin":"2018-01-01",
               "checkout":"2019-01-01"
               },
"totalprice":111,
"depositpaid":true,
"lastname":"Brown"
}
*/

    @Test
    public void innerJsonData(){
        JSONObject innerJson=new JSONObject();
            innerJson.put("checkin","2018-01-01");
            innerJson.put("checkout","2019-01-01");

        JSONObject outerJson=new JSONObject();
            outerJson.put("firstname","Jim");
            outerJson.put("additionalneeds","Breakfast");
            outerJson.put("bookingdates",innerJson);
            outerJson.put("totalprice",111);
            outerJson.put("depositpaid",true);
            outerJson.put("lastname","Brown");


        System.out.println(outerJson);

    }


}
