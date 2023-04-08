package apiTesting;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;

public class JsonSchemaValidation {
	@Test
	void validateSchema() {
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemaDemo.json"));
		
	}

}
