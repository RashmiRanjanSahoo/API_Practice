package apiChainingTesting;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PostDemo1 {

	@Test
	void post1(ITestContext context) {
		String name1 = (String)context.getAttribute("user_name");
		
		JSONObject jo=new JSONObject();
		jo.put("name", name1);
		jo.put("job", "zion resident");
		
		given()
		.body(jo.toString())
		.when()
		 .post("https://reqres.in/api/users")
		.then()
		.log().all();
	}
}
