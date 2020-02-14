package SerializationandDeserialization;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import java.util.ArrayList;
import java.util.HashMap;


public class POSTandGETwithout_serializationanddeserialization {
//storing the data to be posted in hashmap
	public HashMap map=new HashMap();
	
// 1)post requests creates a new student record	
    @Test(priority=1)
	public void CreateNewStudent() {
		
		map.put("id",150);
		map.put("firstName","mounika");
		map.put("lastName", "kumari");
		map.put("email","mounikadongari@gmail.com");
		map.put("programme","manage");
		
		//storing the courses list in the hashmap
		ArrayList<String> courseList =new ArrayList<String>();
		courseList.add("Java");
		courseList.add("Selenium");
		
		map.put("courses",courseList);
		
		given()
		     .contentType(ContentType.JSON)
		     .body(map)
         .when()
             .post("http://localhost:8085/student")
         .then()
             .statusCode(201) 
             .assertThat()
             .body("msg",equalTo("Student added"));
		  }
    
    //2)Get Request to retrieve student details 
    @Test(priority=2)
    void getStudentRecord() {
    	given()
    	
    	.when()
    	    .get("http://localhost:8085/student/101")
    	.then()
    	     .statusCode(200)
    	     .and()
    	     .assertThat()
    	     .body("id",equalTo(101))
    	     .log();
    	

    	
    }
    
    
	
	
	
	
	
	
}
