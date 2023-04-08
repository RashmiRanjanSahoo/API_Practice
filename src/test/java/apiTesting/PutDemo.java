package apiTesting;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class PutDemo {
	int id;
	@Test(priority=1)
	void getId() {
		HashMap hm=new HashMap();
		hm.put("name", "Rashmi");
		hm.put("job", "Engineer");
		
		
		id = given()
			.contentType("application/json")
			.body(hm)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");	
	}
	@Test(priority=2, dependsOnMethods = "getId")
	void UpdateUser() {
		HashMap hm=new HashMap();
		hm.put("name", "Rashmi");
		hm.put("job", "Senior Test Engineer");
		
		given()
			.contentType("application/json")
			.body(hm)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
		
	}
}
