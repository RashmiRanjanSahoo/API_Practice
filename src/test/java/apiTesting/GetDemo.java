package apiTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetDemo {

	@Test
	void getUsers() {
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200);
	}
}
