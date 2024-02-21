package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DummyData {
    /*
         {
                "status":"success",
                "data":{
                        "id":3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":""
                        },
                "message":"Successfully! Record has been fetched."
            }
     */
    public static int basariliSC=200;
    public static String contentType="application/json";

    public static JSONObject expDataOlustur(int id,String employee_name, int employee_salary,int employee_age, String profile_image) {

        JSONObject expData=new JSONObject();
        JSONObject data=new JSONObject();

        data.put("id",id);
        data.put("employee_name",employee_name);
        data.put("employee_salary",employee_salary);
        data.put("employee_age",employee_age);
        data.put("profile_image",profile_image);

        expData.put("status","success");
        expData.put("data",data);
        expData.put("message","Successfully! Record has been fetched.");

        return expData;
    }


    public static Map<String,Object> mapBodyOlustur(){
        Map<String,Object> mapBody=new HashMap<>();
        Map<String,Object> dataBody=new HashMap<>();

        dataBody.put("id",3.0);
        dataBody.put("employee_name","Ashton Cox");
        dataBody.put("employee_salary",86000.0);
        dataBody.put("employee_age",66.0);
        dataBody.put( "profile_image","");

        mapBody.put("status","success");
        mapBody.put("data",dataBody);
        mapBody.put("message","Successfully! Record has been fetched.");
        return mapBody;
    }

}
