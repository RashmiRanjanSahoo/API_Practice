package apiTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class DeleteDemo {

	@Test
	void deleteUser() {
		given()
		. when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204)
			.log().all();
		
	}
}
