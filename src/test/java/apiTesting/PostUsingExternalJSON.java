package apiTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class PostUsingExternalJSON {
	@Test
	void postdemo() throws FileNotFoundException {
		
		File f=new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject jobj = new JSONObject(jt);
		
			
			given()
				.contentType("application/json")
				.body(jobj.toString())
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
