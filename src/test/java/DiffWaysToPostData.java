import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class DiffWaysToPostData {
	
	// Post data using HashMap

	//@Test(priority=1)
	void getdata()
	{
		HashMap map=new HashMap();
		
		given()
		.when()
			.get("http://localhost:3000/students/1")
		.then()
		.statusCode(200)
		.body("name", equalTo("arun"))
		.log().all();
		

	}
//@Test(priority=1)
	
	void postdata()
	{
		HashMap map=new HashMap();
		map.put("name", "Kamlesh");
		map.put("gender", "Male");
		ArrayList list=new ArrayList();
		list.add("Data Structure");
		list.add("Java");
		map.put("Courses",list);
		
		given()
		.contentType("application/json")
		.body(map)
		.when()
			.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.log().all();
		

	}

//@Test(priority=1)

void updatedata()
{
	HashMap map=new HashMap();
	map.put("name", "Mohit");
	map.put("gender", "Male");
	ArrayList list=new ArrayList();
	list.add("Science");
	list.add("SST");
	map.put("Courses",list);
	
	given()
	.contentType("application/json")
	.body(map)
	.when()
		.put("http://localhost:3000/students/4")
	.then()
	.log().all();
}

//@Test(priority=1)

void deletedata()
{
	given()
	.when()
		.delete("http://localhost:3000/students/6")
	.then()
	.log().all();
}

// Post data using org.json library

//@Test(priority=1)

	void postdatausningorgjson()
	{
		JSONObject data=new JSONObject();
		data.put("name", "Saket");
		data.put("gender", "Male");
		ArrayList list2=new ArrayList();
		list2.add("AI");
		list2.add("ML");
		data.put("Courses",list2);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.log().all();
		

	}

//@Test(priority=1)

void postdatauPOJO()
{
	PojoClass data=new PojoClass();
	data.setName("Kiran");
	data.setGender("Female");
	String[] courses= {"Finance","Marketing"};
	data.setCourses(courses);
	
	given()
	.contentType("application/json")
	.body(data)
	.when()
		.post("http://localhost:3000/students")
	.then()
	.statusCode(201)
	.log().all();
	

}

@Test(priority=1)

void postdataexternalfile() throws FileNotFoundException
{
	File f=new File("F:\\FakeApi\\data.json");
	FileReader fr=new FileReader(f);
	JSONTokener jt=new JSONTokener(fr);
	JSONObject data=new JSONObject(jt);
	
	given()
	.contentType("application/json")
	.body(data.toString())
	.when()
		.post("http://localhost:3000/students")
	.then()
	.statusCode(201)
	.log().all();
	

}

}
