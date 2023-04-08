package apiTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostUsingJsonData {
	@Test
	void postdemo() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Rashmi");
		jobj.put("job", "Engineer");
		String [] courseArr= {"Java","Selenium","Postman","Git"};
		jobj.put("course", courseArr);
		
		given()
			.contentType("application/json")
			.body(jobj.toString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.body("name",equalTo("Rashmi"))
			.body("job",equalTo("Engineer"))
			.body("course[0]",equalTo ("Java"))
			.body("course[1]",equalTo ("Selenium"))
			.header("content-type", "application/json; charset=utf-8")
			.log().all();
	}

}
