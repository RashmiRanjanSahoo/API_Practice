package apiTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class AuthenticationDemo {
	
	@Test(priority=1)
void baiscAuthTest() {
		given()
			.auth().basic("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
			

	}
	@Test(priority=2)
	void preemptiveAuthTest() {
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
			

	}
	@Test(priority=3)
	void digestAuthTest() {
		given()
			.auth().digest("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	
	
	@Test (priority=4)
	void bererTokenAuthTest() {
		String bearerToken="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";
		given()
		.headers("Authorization","Bearer "+bearerToken)
	.when()
	  .get("https://github.com/RashmiRanjanSahoo")
	.then()
		.statusCode(200)
		.log().all();
	}
	
	
	
}
