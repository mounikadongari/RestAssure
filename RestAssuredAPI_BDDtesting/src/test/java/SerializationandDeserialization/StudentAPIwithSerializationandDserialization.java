package SerializationandDeserialization;
import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import junit.framework.Assert;
public class StudentAPIwithSerializationandDserialization {

	//serialization
	@Test(priority=1)
	public void CreateNewStudentSerialization() {
		
		ArrayList<String> coursesList=new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		Student stu = new Student();//Create object for student.java
	    stu.setSID(102);
	    stu.setlastName("mounika");
	    stu.setFirstName("kumari");
	    stu.setEmail("mouni@gmail.com");
	    stu.setprogramme("Computer science");
	    stu.setCourses(coursesList);
	    
	    
	    
	    given()
	      .contentType(ContentType.JSON)
	      .body(stu)
	   .when()
	      .post("http://localhost:8085/student") 
	   .then()
	      .statusCode(201)
	      .assertThat()
	      .body("msg",equalTo("student added"));//IF post succesfull msg
	    
	}
	
	
	//Deserialization
	
	@Test
	void getStudentRecordDeserialization() {
		
		Student stu=get("http://localhost:8085/student/102").as(Student.class);//converting file into object
		System.out.println(stu.getStudentRecord());
		Assert.assertEquals(stu.getSID(),102);
	    	
	
	}
	
	
	
}
