package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PutRequest {
	
	@Test
	public void test() {
	
	RestAssured.baseURI = "http://localhost:3000/employees";
	
	
    Map<String,Object> mjobj = new HashMap<String, Object>();
	mjobj.put("name", "Khan");
	mjobj.put("salary", "790000");

	RequestSpecification request = RestAssured.given();
	
	        Response response=request.contentType(ContentType.JSON).accept(ContentType.JSON).body(mjobj).put("/16");
	        
	    String  body = response.getBody().asString();
	    
	    System.out.println(body);
	        
	      int code = response.getStatusCode();
	    		  
	    		  AssertJUnit.assertEquals(code,200);   
	    		  
	    		  
	    		  

	

}
}