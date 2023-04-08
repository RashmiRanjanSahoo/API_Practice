package apiTesting;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;
public class CookieDemo {
	
	@Test
	void testcookes() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.cookie("AEC","ARSKqsJSyn8U_VmPR09OLbZwUGb2uH4pjBRJfiz_UgFGrBX2JN5JjJfFpA")
			.log().all();
	}
	
	//get single cookie value
	@Test
	void testSingleCookies() {
		Response res = given()
		.when()
			.get("https://www.google.com/");
		
		System.out.println(res.getCookie("AEC"));
		
	}
	
	@Test
	void testAllCookies() {
		Response res = given()
		.when()
			.get("https://www.google.com/");
		
		Map<String, String> co_val = res.getCookies();
		for(String k:co_val.keySet()) {
			System.out.println(k);
			String val = res.getCookie(k);
			System.out.println(val);
		}
		
	}

}
