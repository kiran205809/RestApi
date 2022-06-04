package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJsonObject {
	
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "john");
		jobj.put("salary", "10000");

		RequestSpecification request = RestAssured.given();
		
		        Response response=request.contentType(ContentType.JSON).accept(ContentType.JSON).body(jobj.toString()).post("/create");
		        
		    String  body = response.getBody().asString();
		    
		    System.out.println(body);
		        
		      int code = response.getStatusCode();
		    		  
		    		  AssertJUnit.assertEquals(code,201);   
		    		  
		    		  
		    		  JsonPath Jpath = response.jsonPath();
		    	        Jpath.get("id");
		    	        System.out.println("id"+Jpath.get("id"));
		        

	}

}
