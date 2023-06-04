package APIChaining;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class createUser {

	@Test
	void test_createUser(ITestContext context)
	{
		Faker fake=new Faker();
		JSONObject jo=new JSONObject();
		jo.put("name",fake.name().fullName());
		jo.put("gender","Male");
		jo.put("email",fake.internet().emailAddress());
		jo.put("status","inactive");
		
		String bearerToken="558f7b522fbb204e22fe444bb6e0a9771d481d1a0b85bacc83fbc077206bfc24";
		int  id=
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.body(jo.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		System.out.println("Generated id : "+id);
		context.setAttribute("user_id",id);   //just like global variable,so thet we can refer in other test and this is only availabe to test level.
		//context.getSuite().setAttribute("user_id",id); //suite level
		context.setAttribute("token",bearerToken);
	}
}
