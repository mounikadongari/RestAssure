package RestAssuredTests;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Demo4_DELETE_Request {
//int emp_id=3;
	
	@BeforeClass
	public void DeleteData(){
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/11514";
	}
	@Test
	public void deleteEmployeeRecord() {
	 Response response=	
		given()
		
		.when()
		    .delete()
		 .then()
		     .statusCode(200)
		     .and()
		     .statusLine("HTTP/1.1 200 OK")
		     .log().all()
		     .extract().response();
          String jsonASString= response.asString();
	    Assert.assertEquals(jsonASString.contains("successfully! delete Records"),true);
	}
	
}
