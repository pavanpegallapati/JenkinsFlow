package day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class cookiesDemo {

	
@Test(priority=2)	
void testCookie()
{
	given()
		.when()	
			.get("https://www.google.com")
			.then()
			//.cookie("AEC","Ae3NU9M6PnppjnKvQCdLSX6XV04njlcgvS5qxWOps6CpACPKecqa0jCS4vQ")
			.log().all();
				
}

@Test(priority=1)
void getCookiesInfo()
{
	Response res=given().when()
			.get("https://www.google.com");
	
	String Cookie_Value=res.getCookie("AEC");
	System.out.println("value of cookie is "+ Cookie_Value);
	Map<String,String>cook= res.getCookies();
//	System.out.println(cook.keySet());
//	System.out.println(cook.values());
	for(String k:cook.keySet())
	{
		String key1=res.getCookie(k);
		System.out.println(k+"   "+key1);
	}
	
}

}
