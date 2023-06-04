package APIChaining;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class getUser {

	
	@Test
	public void test_getuser(ITestContext context)
	{
		int id=(Integer) context.getAttribute("user_id");
		//int id=(Integer) context.getSuite().getAttribute("user_id");
		//String bearerToken="558f7b522fbb204e22fe444bb6e0a9771d481d1a0b85bacc83fbc077206bfc24";
		String bearerToken=(String) context.getAttribute("token");
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.pathParam("id",id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().body();
		
	}
}
