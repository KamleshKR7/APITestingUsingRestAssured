import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
public class JsonSchemaValidator {

	//@Test
	public void jsonschemavalidator()
	{
		given()
		.when()
		.get("http://localhost:3000/students")
		.then()
		.assertThat().body(io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath("json-schema.json"));
	}
	
	@Test
	public void xmlschemavalidator()
	{
		given()
		.when()
		.get("http://localhost:3000/students")
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("studentsschema.xsd"));
	}
}
