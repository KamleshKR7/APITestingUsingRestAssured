package APIChaining;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteUser {
	@Test
	public void test_deleteuser(ITestContext context)
	{
		int id=(Integer) context.getAttribute("user_id");
		String bearerToken="558f7b522fbb204e22fe444bb6e0a9771d481d1a0b85bacc83fbc077206bfc24";
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.pathParam("id",id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.log().body();
		
	}
}
