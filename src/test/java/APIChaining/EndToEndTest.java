package APIChaining;

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




public class EndToEndTest {
	Response response;
    
	@Test
	public void test1() {
		response = GetMethodAll();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		response = PostMethod("sunny", "3000");
		
		AssertJUnit.assertEquals(response.getStatusCode(), 201);
		JsonPath Jpath = response.jsonPath();
        int EmpID= Jpath.get("id");
        System.out.println(EmpID);
        
        
        response = Putmethod(EmpID,"Raju","44");
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
	
        response = Deletemethod(EmpID);
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        AssertJUnit.assertEquals(response.getBody().asString(), "{}");
        
        response = Getmethod(EmpID);
        AssertJUnit.assertEquals(response.getStatusCode(), 404);
        AssertJUnit.assertEquals(response.getBody().asString(), "{}");
	}
	
	
	public Response GetMethodAll() {
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
	Response response=	request.get();
	return response;
	
	
	
	}
	
	public Response PostMethod(String Name, String Salary) {
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", Name);
		jobj.put("salary", Salary);

		RequestSpecification request = RestAssured.given();
		
		        Response response=request.contentType(ContentType.JSON).accept(ContentType.JSON).body(jobj.toString()).post("/create");
		return response;
	}
	public Response Putmethod(int EmpID, String Name, String Salary) {
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", Name);
		jobj.put("salary", Salary);

		RequestSpecification request = RestAssured.given();
		
		        Response response=request.contentType(ContentType.JSON).accept(ContentType.JSON).body(jobj.toString()).put("/"+EmpID);
		return response;
	}
	public Response Deletemethod(int EmpID) {
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
				
				Response response = request.delete("/" + EmpID);
				
				return response;
				
				
	}
	public Response Getmethod(int EmpID) {
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
				
				Response response = request.get("/" + EmpID);
				
				return response;
	}
	
}
