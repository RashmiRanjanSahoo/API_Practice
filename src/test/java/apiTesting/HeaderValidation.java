package apiTesting;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class HeaderValidation {
	
	@Test
	void validateHeader() {
		given()
		.when()
		  .get("https://www.google.com/")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Server", "gws");
		
	}
	
	@Test
	void getSingleHeader() {
		Response res = given()
		.when()
			.get("https://www.google.com/");
		
		System.out.println(res.getHeader("Content-Type"));
		System.out.println(res.getHeader("Server"));
	}
	
	@Test
	void getAllHeader() {
		Response res = given()
				.when()
					.get("https://www.google.com/");
		
		Headers hdr = res.getHeaders();
		for(Header hr:hdr) {
			System.out.println(hr.getName()+"      "+hr.getValue());
		}
	}

}
