package APIChaining;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class updateUser {

	@Test
	void test_updateUser(ITestContext context)
	{
		Faker fake=new Faker();
		JSONObject jo=new JSONObject();
		jo.put("name",fake.name().fullName());
		jo.put("gender","Female");
		jo.put("email",fake.internet().emailAddress());
		jo.put("status","active");
		
		String bearerToken="558f7b522fbb204e22fe444bb6e0a9771d481d1a0b85bacc83fbc077206bfc24";
		int id=(Integer) context.getAttribute("user_id");
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.pathParam("id",id)
		.body(jo.toString())
		
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.log().body();
	}
	
}
