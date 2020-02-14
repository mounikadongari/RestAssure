package RestAssuredTests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Demo6_BasicValidations_XML {

//	1)Verifying Singlr content in XML Response

	@Test
	void testSingleContent()
	{
		given()
		
		.when()
		   .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		 .then()
		       .body("CUSTOMER.ID",equalTo("15"))
		       .log().all();
	
		
	}

	// 2)Verifying Multiple content in XML Response
	@Test
	void testMultipleContent()
	{
		given()
		
		.when()
		   .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		 .then()
		       .body("CUSTOMER.ID",equalTo("15"))
		       .body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
		       .body("CUSTOMER.LASTNAME",equalTo( "Clancy"))
		       .body("CUSTOMER.STREET",equalTo("319 Upload p1."))
		       .body("CUSTOMER.CITY", equalTo("Seattle"))
		       .log().all();
	
		
	}	
	
	//3) Verifying ALL the content in one go
	
	
	@Test
	void testMultipleContentInOneGo()
	{
		given()
		
		.when()
		   .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		 .then() // we can give all content in one line also using TEXT()
		       .body("CUSTOMER.text()",equalTo("15BillClancy319 Upload p1.Seattle"))
		       .log().all();
	
		
	}	
	
	
	//5) How to find values using XML path in XML response
	
	@Test
	void testUsingXpath1()
	{
		given()
        
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
	
}

	@Test(priority=5)
	void testUsingXPath()
	{
		given()
		.when()
		.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then() // somewhere 30 num is there or not
		.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
		.log().all();
	}


}
