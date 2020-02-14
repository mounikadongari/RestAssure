package SerializationandDeserialization;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class VideoGameSerializationandDeserializationUsingXML {

	
	@Test
	public void testVideoGameSerializationXML{
		
		VideoGames myVideoGame= new VideoGames();
		myVideoGame.setId(21);
		myVideoGame.setName("sfdhfjfk");
		myVideoGame.setReleaseDate("2091-45-36");
		myVideoGame.setRating("five");
		myVideoGame.setCategory("Diriving");
		
		given()
		.contentType("application/xml")
		.body(myVideoGame)
		.when()
		.post("http://localhost:8080/app/videogames")
		.then()
		.log().all()
		.body(equalTo("{\"satus\":\"Record Added Successfully\"}"));
	}
	
	@Test(priority=2)
	public void testVideoGameDeSerializationXML() {
		VideoGames myVideoGame=get("http://localhost:8080/app/videogame").as(VideoGames.class);
	System.out.println(myVideoGame.toString());
	}
	
	
}
