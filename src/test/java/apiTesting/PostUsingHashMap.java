package apiTesting;


import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class PostUsingHashMap {
	
	@Test
	void postdemo() {
		HashMap hm=new HashMap();
		hm.put("name", "Rashmi");
		hm.put("job", "Engineer");
		String [] courseArr= {"Java","Selenium","Postman","Git"};
		hm.put("course", courseArr);
		
		
		given()
			.contentType("application/json")
			.body(hm)
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
