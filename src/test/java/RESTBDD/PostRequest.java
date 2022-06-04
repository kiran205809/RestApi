package RESTBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	
	
@Test	
public void test1() {
	 Map<String,Object> mjobj = new HashMap<String, Object>();
		mjobj.put("name", "Ashish");
		mjobj.put("salary", "9999");
		
		RestAssured.given()
        .baseUri("http://localhost:3000/employees")
        .contentType(ContentType.JSON).accept(ContentType.JSON).body(mjobj)
         .when()
         //.get()
         
         //to retrieve specific employee data
         .post("/create")
         .then()
         .log()
         .body()
         //.status()
         .statusCode(201)
        . body("name", Matchers.equalTo("Ashish"));
	
}

}
