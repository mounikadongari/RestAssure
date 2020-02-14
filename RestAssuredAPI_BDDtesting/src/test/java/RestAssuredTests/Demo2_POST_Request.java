package RestAssuredTests;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo2_POST_Request {
	
public static HashMap map=new HashMap();// to store all values in it
	@BeforeClass//create restutils.java to generate everytime random values
	public void postdata()
	{
		map.put("FirstName",RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("UserName",RestUtils.getUserName());
		map.put("Password",RestUtils.getPassword());
		map.put("Email",RestUtils.getEmail());
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
	}
	
	@Test
	public void testPost()
	{
		given()
		   .contentType("application/json")
		   .body(map)
		
		.when()
		    .post()
		    
		.then()
		    .statusCode(201)
		    .and()
		    .body("SuccessCode",equalTo("OPERATION_SUCCESS"))
            .and()
            .body("Message",equalTo("Operation completed successfully"));
		
		
	}
	
	
	
	
}
