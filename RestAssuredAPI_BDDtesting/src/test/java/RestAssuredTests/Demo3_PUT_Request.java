package RestAssuredTests;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class Demo3_PUT_Request {
	
	public static HashMap map= new HashMap();
	int emp_id=11254;//update for particular person
	@BeforeClass
	public void putData()
	{
		map.put("EMP_NAME",RestUtils.empName());
		map.put("EMP_SALARY",RestUtils.empSal());
		map.put("EMP_AGE",RestUtils.empAge());
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;//along with emp id
		
	}
	
	@Test
	public void testPUT() {
		given()
		    .body(map)
		    .contentType("application/json")
		 .when()
		      .put()
		 .then()
		       .statusCode(200)
		       .and()
		       .statusLine("HTTP/1.1 200 OK")
		      .log().all();
		
		
	}
	

	
	
	
	
	
	
}
