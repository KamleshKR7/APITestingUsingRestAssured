import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class CookiesHeaders {
	
	//@Test
	public void Param()
	{
		given()
		.pathParam("path","users")
		.queryParam("page",2)
		.when()
		.get("https://reqres.in/api/{path}")
		.then()
		.statusCode(200)
		.log().body();
	}
	//@Test
	public void Coookies()
	{
		Response res=
		given()
		.when()
		.get("https://google.com/");
		
		Map<String,String> cookies_value=res.getCookies();
		
		for(String s:cookies_value.keySet())
		{
			System.out.println(s+" : "+res.getCookie(s));
		}
	}
	
	@Test
		public void Headers()
		{
			Response res=
			given()
			.when()
			.get("https://google.com/");
			
			Headers head=res.getHeaders();
			for(Header h:head)
			{
				System.out.println(h.getName()+" : "+h.getValue());
			}
		}
		

}
