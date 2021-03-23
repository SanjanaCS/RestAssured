package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetRequestwithParams {
	 @Test
	    public void test1() {
	        RestAssured.baseURI = "http://localhost:3000/employees";
	        RequestSpecification request = RestAssured.given();
	        Response response = request.param("id", "3").get();
	        String responsebody = response.getBody().asString();
	        System.out.println("Response body :" +responsebody);
	        
	        //Checking the Response Code
	        int responsecode = response.getStatusCode();
	        Assert.assertEquals(200, responsecode);
	        
	        //Checking the Response Headers
	        String contentType = response.header("Content-Type");
	        Assert.assertEquals("application/json; charset=utf-8", contentType);
	        
	        //Checking the name in Response
	        Assert.assertTrue(responsebody.contains("Poonam"));
	        
	        //Checking the exact node
	        
	        JsonPath jpath = response.jsonPath();
//	        String name = jpath.getString("name");
//	        System.out.println(name);
	        
	        List <String> name = jpath.get("name");
	        Assert.assertTrue(name.get(0).contains("Poonam"));
	        System.out.println(name);
	        
	        
	        
	    }
	    
}
