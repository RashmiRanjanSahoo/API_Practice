package apiTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostUsingPOJO {

	@Test
void postdemo() {
	
	POJODemo pobj=new POJODemo();
	pobj.setName("Rashmi");
	pobj.setJob("Engineer");
	String [] courseArr= {"Java","Selenium","Postman","Git"};
	pobj.setCourses(courseArr);
	
		
		given()
			.contentType("application/json")
			.body(pobj)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.body("name",equalTo("Rashmi"))
			.body("job",equalTo("Engineer"))
			.body("courses[0]",equalTo ("Java"))
			.body("courses[1]",equalTo ("Selenium"))
			.header("content-type", "application/json; charset=utf-8")
			.log().all();
	}
}
