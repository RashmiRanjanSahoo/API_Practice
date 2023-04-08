package apiChainingTesting;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Getdemo1 {
	@Test
	void get1(ITestContext context) {
		String name = given()
		.when()
			.get("https://reqres.in/api/users?page=2")
			.jsonPath().getString("data[1].first_name");
		
		System.out.println(name);
		context.setAttribute("user_name", name);
}
}
