package apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import static io.restassured.RestAssured.*;
public class BodyValidation {

	@Test
	void validateResonseBody() {
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.body("data.last_name", equalTo("Weaver"));
	}
	
	@Test
	void validateBody1() {
		Response res = given()
		.when()
			.get("https://reqres.in/api/users/2");
		
	Assert.assertEquals(res.getStatusCode(), 200);
	String email = res.jsonPath().get("data.email").toString();
	Assert.assertEquals(email, "janet.weaver@reqres.in");
	}
	
	@Test
	void validateBody2() {
		Response res = given()
				.when()
					.get("https://reqres.in/api/users?page=2");
		
		JSONObject jo = new JSONObject(res.asString());
		
		boolean status=false;
		for(int i=0;i<jo.getJSONArray("data").length();i++) {
			String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(email);
			
			if(email.equals("tobias.funke@reqres.in")) {
				status=true;
				break;
			}
			
		}
		Assert.assertEquals(status, true);
	}
}
