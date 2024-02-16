package day1;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.module.jsv.JsonSchemaValidator;
public class JSONSchemaValidation {
	
	String d="";
	POJO_PostRequest p;
	@Test
	void convertJson() throws JsonProcessingException
	{
		p=new POJO_PostRequest();
		p.setJob("Test1");
		p.setName("Test2");
		ObjectMapper obj=new ObjectMapper();
		d=obj.writerWithDefaultPrettyPrinter().writeValueAsString(p);
		System.out.println(d);
		
//		given()
//			.when()
//			.get("https://reqres.in/api/users?page=2")
//				.then()
//				.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
	}

	@Test
	void jsonConvert() throws JsonMappingException, JsonProcessingException
	{
		String jsondata;
		ObjectMapper stuObj=new ObjectMapper();
		p=stuObj.readValue(d, POJO_PostRequest.class);
		System.out.println(p.getName());
		System.out.println(p.getJob());
		
	}
}
