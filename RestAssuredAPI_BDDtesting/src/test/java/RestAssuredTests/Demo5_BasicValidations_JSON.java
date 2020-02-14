package RestAssuredTests;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
/*
1)Test Status Code
2)Log Response
3)Verifying Single content in response body
4)Verifying Multiple contents in response body
4)Setting parameters & headers
 */
public class Demo5_BasicValidations_JSON {

	//1) Test Status Code
	
	@Test(priority=1)
	public void testStatusCode() {
		
		
		
		given()
		
		
		.when()
		     .get("http://jsonplaceholder.typicode.com/posts/5")
		    
		.then()
		   .statusCode(200);
		  // .log().all() ;
		   
		     
	}
	
	//2) Log Response
	
	@Test(priority=3)
	public void testLogging()
	{
		given()
		
		.when()
		    .get("http://services.groupkt.com/country/get/iso2code/IN")  
		.then()
		     .statusCode(200)
		      .log().all();
				}
	
	//3) Verifying Single content in response body
	@Test(priority=4)
	public void testSingleContent()
	{
		given()
		
		.when()
		    .get("http://services.groupkt.com/country/get/iso2code/IN")  
		.then()
		     .statusCode(200)
		     .body("RestResponse.result.name",equalTo("India"));

	}
	
	//4) Verifying Multiple content in response body
		@Test(priority=2)
		public void testMultipleContent()
		{
			given()
			
			.when()
			    .get("http://services.groupkt.com/country/get/all")  
			.then()
			     .statusCode(200)
			     .body("RestResponse.result.name",hasItems("India","Australia","United States of America"));

		}
    //5) Setting parameters&headers
		
		@Test
		public void testParamersAndHeaders()
		{
			given()
			.param("MyName", "pavan")
			.header("MyHeader","India")
			.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
			.statusCode(200)
			.log().all();
		
		
		}



}
