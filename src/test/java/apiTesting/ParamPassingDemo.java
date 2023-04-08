package apiTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class ParamPassingDemo {
	//https://reqres.in/api/users?page=2
@Test
void pathAndQueryParam() {
	given()
		.pathParam("mypath", "users")
		.queryParam("page", 2)
		//.queryParam("id", 125)
	.when()
	 .get("https://reqres.in/api/{mypath}")
	.then()
		.statusCode(200)
		.log().all();
}
}
