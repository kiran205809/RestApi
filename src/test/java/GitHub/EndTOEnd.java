package GitHub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndTOEnd {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "https://api.github.com/users/kiran205809/repos";
		
		RequestSpecification request = RestAssured.given();
				
				Response response = request.get();
				
				String ResponseBody = response.getBody().asString();
				
				System.out.println(ResponseBody);
				
				int ResponseCode = response.getStatusCode();
				
				AssertJUnit.assertEquals(ResponseCode, 200);
	}

	
	 public void test2() throws IOException {
		 
		 byte[] dataBytes = Files.readAllBytes(Paths.get("data.json"));
		 
		 RequestSpecification request = RestAssured.given();
			
	        Response response=request.auth().oauth2("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").contentType(ContentType.JSON).accept(ContentType.JSON).body(dataBytes).post();
	        
	    String  body = response.getBody().asString();
	    
	    System.out.println(body);
	        
	      int code = response.getStatusCode();
	    		  
	    		  AssertJUnit.assertEquals(code,201);   
	 }
}
