import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class dummyDataGenerator {

	
	@Test
	
	public void datagenerator()
	{
		Faker fake=new Faker();
		String fullName=fake.name().firstName();
		String lastName=fake.name().lastName();
		String phonenumber=fake.phoneNumber().phoneNumber();
		String email=fake.internet().emailAddress();
		
		System.out.println(fullName);
		System.out.println(lastName);
		System.out.println(phonenumber);
		System.out.println(email);
	}
}
