import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJsonResponseBody {

	//@Test
	public void parsingjson()
	{
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store")
		.then()
		.statusCode(200)
		.body("Books[1].title",equalTo("Fairy tales"));
	}
	
	//@Test
	public void parsingjson2()
	{
		Response res=
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.statusCode(), 200);
		String bookname=res.jsonPath().get("Books[3].title").toString();
		Assert.assertEquals(bookname,"The Epic Of Gilgamesh");
	}
	
	//@Test
	public void parsingjsonobjectclass()
	{
		Response res=
		given()
		.contentType("application/json")
		.when()
			.get("http://localhost:3000/store");
		
		JSONObject jo=new JSONObject(res.asString());
		for (int i=0;i<jo.getJSONArray("Books").length();i++)
		{
			String title=jo.getJSONArray("Books").getJSONObject(i).get("title").toString();
			System.out.println(title);
		}
	}
	
	@Test
	public void parsing()
	{
		Response res=
		given()
		.contentType("application/json")
		.when()
			.get("http://localhost:3000/store");
		
		JSONObject jo=new JSONObject(res.asString());
		System.out.println(jo.getJSONArray("Books").getJSONObject(1).get("country"));
	}
}
