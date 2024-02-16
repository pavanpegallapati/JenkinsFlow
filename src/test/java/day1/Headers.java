package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Headers 
{
	//@Test(priority=1)
	void header()
	{
		given()
		
		.when()
			.get();	
	}
	
	
	

}
