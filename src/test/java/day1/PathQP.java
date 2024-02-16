package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathQP {
	
	@Test
	void testQPP()
	{
		
		given()
		.pathParam("mypath", "users")
		.queryParam("page", 2)
		.queryParam("id", 5)
		
			.when()
				.get("https://reqres.in/api/{mypath}")
				.then()
				.statusCode(200)
				.log().all();
	}

}
