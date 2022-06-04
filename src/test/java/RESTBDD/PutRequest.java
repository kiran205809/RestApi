package RESTBDD;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {

	
		
		
	@Test	
	public void test1() {
		 Map<String,Object> mjobj = new HashMap<String, Object>();
			mjobj.put("name", "yash");
			mjobj.put("salary", "9999");
			
			RestAssured.given()
	        .baseUri("http://localhost:3000/employees")
	        .contentType(ContentType.JSON).accept(ContentType.JSON).body(mjobj)
	         .when()
	         //.get()
	         
	         //to retrieve specific employee data
	         .put("/23")
	         .then()
	         .log()
	         .body()
	         //.status()
	         .statusCode(200)
	        . body("name", Matchers.equalTo("yash"));
		
	}

	}



