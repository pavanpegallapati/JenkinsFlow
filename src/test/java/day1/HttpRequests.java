package day1;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HttpRequests {
	
	int id;
	
	@Test(priority=3)
	void getUsers()
	{
		
		Response res=given()
		.when()
			.get("https://reqres.in/api/users?page=2");
//		String nam=res.jsonPath().get("page").toString();
//		System.out.println("nam print: "+nam);
		System.out.println(res.asString());
		System.out.println(res.asPrettyString());
		JSONObject jo=new JSONObject(res.asPrettyString());
		int k=0;
		for( int i=0;i<jo.getJSONArray("data").length();i++)
		{
			
			System.out.println(jo.getJSONArray("data").getJSONObject(i).toString());
			System.out.println(jo.getJSONArray("data").getJSONObject(i).get("id"));
			k=Integer.parseInt(jo.getJSONArray("data").getJSONObject(i).get("id").toString());
			System.out.println("k "+k);
			//System.out.println(jo.getJSONArray("data").getJSONObject(i).getString("id"));
			//jo.getJSONArray("data").getJSONObject(0).getString("id");
		}
		Assert.assertEquals(12, k,"Matched");
		
		
			
		/*.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();*/
			
	}
	
//	@Test(priority=1)
//	void createUser() throws FileNotFoundException
//	{
//		//HashMap
//		
////		HashMap data =new HashMap();
////		data.put("name", "Pavan1");
////		data.put("job", "trainer1");
//		
//		
//		//Pojo
//		POJO_PostRequest o=new POJO_PostRequest();
//		o.setName("Pavan1");
//		o.setJob("TestJob");
//		
//		//External Json file
//		System.getProperty("user.dir");
//		File f=new File(".\\data.json");
//		FileReader fr=new FileReader(f);
//		JSONTokener jt=new JSONTokener(fr);
//		JSONObject data1=new JSONObject(jt);
//		
//		
//		id=given()
//			.contentType("application/json")
//			.body(data1.toString())
//			
//			.when()
//			.post("https://reqres.in/api/users").jsonPath().getInt("id");
//			
//				//.then()	
//				//.statusCode(201)
//				//	.log().all();		
//	}
//	
//	@Test(priority=2, dependsOnMethods= {"createUser"})
//	void updateUser()
//	{
//		
//		HashMap data =new HashMap();
//		data.put("name", "Kumar");
//		data.put("job", "train");
//		
//		given()
//			.contentType("application/json")
//			.body(data)
//			
//			.when()
//			.put("https://reqres.in/api/users/"+id)
//			
//			.then()	
//			.statusCode(200)
//			.log().all();
//	}
//	
//	@Test(priority=4)
//	void deleteUser()
//	{
//		
//		
//		given()
//			
//			
//			.when()
//			.delete("https://reqres.in/api/users/"+id)
//			
//			.then()	
//			.statusCode(204);
//			
//	}

}
