package RESTBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRequest {
	
	@Test
	public void test1() {
		
		
		RestAssured.given()
		            .baseUri("http://localhost:3000/employees")
		             .when()
		             //.get()
		             
		             //to retrieve specific employee data
		             .delete("/23")
		             .then()
		             .log()
		             .body()
		             //.status()
		             .statusCode(200);

}
}