package RESTBDD;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest {
	
	
	
	@Test
	public void test1() {
		
		
		RestAssured.given()
		            .baseUri("http://localhost:3000/employees")
		             .when()
		             //.get()
		             
		             //to retrieve specific employee data
		             .get("/1")
		             .then()
		             .log()
		             .body()
		             //.status()
		             .statusCode(200);
		
		
	}
	
	@Test
	public void test2() {
		RestAssured.given()
        .baseUri("http://localhost:3000/employees")
        //.queryParam("id", "1")
        .queryParam("name", "Davi")
         .when()
         //.get()
         
         //to retrieve specific employee data
         .get()
         .then()
         .log()
         .body()
         //.status()
         .statusCode(200)
		 .body("[0].name", Matchers.equalTo("Davi"));
		
		
		
		
		
	}
	
	public void test3() {
		
		Response response=RestAssured.given()
        .baseUri("http://localhost:3000/employees")
        //.queryParam("id", "1")
        .queryParam("name", "Davi")
         .when()
         .get();
		JsonPath jpath = response.jsonPath();
		List<String> names = jpath.get("name");

		System.out.println(names.get(0));
		AssertJUnit.assertEquals(names.get(0), "Davi");

		String Header = response.getHeader("Content-Type");
		System.out.println(Header);
		
		
		
	}
	
}