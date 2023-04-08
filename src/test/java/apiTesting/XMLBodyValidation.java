package apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
public class XMLBodyValidation {

	@Test
	void validatexmlBody() {
		given()
		.when()
		  .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.body("TravelerinformationResponse.page", equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
		
	}
	
	@Test
	void validateXmlBody1() {
		Response res = given()
		.when()
		  .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");
		
		String name = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(name, "Developer");
	}
	
	@Test
	void validateXmlBody2() {
		Response res = given()
		.when()
		  .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xp = new XmlPath(res.asString());
		List<String> travellers = xp.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);
		
		List<String> names = xp.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status=false;
		
		for(String name: names) {
			if(name.equals("Developer")) {
				status=true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	}
}
