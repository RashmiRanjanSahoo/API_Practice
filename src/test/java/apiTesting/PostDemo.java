package apiTesting;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import org.testng.annotations.Test;

public class PostDemo {

	@Test
	void createUser() {
		HashMap hm=new HashMap();
		hm.put("name", "Rashmi");
		hm.put("job", "Engineer");
		
		given()
			.contentType("application/json")
			.body(hm)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
		
		
	}
}
