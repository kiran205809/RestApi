package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {
	
	
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		
	    Map<String,Object> mjobj = new HashMap<String, Object>();
		mjobj.put("name", "cena");
		mjobj.put("salary", "700000");

		RequestSpecification request = RestAssured.given();
		
		        Response response=request.contentType(ContentType.JSON).accept(ContentType.JSON).body(mjobj).post("/create");
		        
		    String  body = response.getBody().asString();
		    
		    System.out.println(body);
		        
		      int code = response.getStatusCode();
		    		  
		    		  AssertJUnit.assertEquals(code,201);   
		    		  
		    		  
		    		  JsonPath Jpath = response.jsonPath();
		    	        Jpath.get("id");
		    	        System.out.println("id"+Jpath.get("id"));

}
}