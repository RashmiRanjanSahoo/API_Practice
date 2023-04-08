package apiTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class LogDemo {
	@Test
	void logtest() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.log().headers()
		.log().cookies()
		.log().body()
		.log().all();
		
	}

}
