package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApi {
	
	@Test
	public void test1() {
		
RestAssured.baseURI = "http://localhost:3000/employees";
		
RestAssured.baseURI = "http://localhost:3000/employees";

RequestSpecification request = RestAssured.given();

Response response = request.get();

String ResponseBody = response.getBody().asString();

System.out.println(ResponseBody);

int ResponseCode = response.getStatusCode();

AssertJUnit.assertEquals(ResponseCode, 200);

AssertJUnit.assertTrue(ResponseBody.contains("Davi"));




//To retrive all name 
JsonPath jpath = response.jsonPath();
List<String> names = jpath.get("name");

for(String s:names) {
	
	System.out.println(s);
}


	}

}
