package apiTesting;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class SearilizationDemo {

	@Test(priority=1)
	void Searilize() throws JsonProcessingException {
	POJODemo2 obj1 = new POJODemo2();
	obj1.setName("Rashmi");
	obj1.setJob("Engineer");
	
	ObjectMapper objMapper = new ObjectMapper();
	 String str1 = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);
	 System.out.println(str1);
	}


@Test(priority=2)
void Deserelize() throws JsonMappingException, JsonProcessingException {
	
	String jsondata = "{\r\n"
			+ "  \"name\" : \"Rashmi\",\r\n"
			+ "  \"job\" : \"Engineer\"\r\n"
			+ "}";
	
	ObjectMapper objMapper = new ObjectMapper();
	POJODemo2 obj1 = objMapper.readValue(jsondata, POJODemo2.class);
	
	System.out.println(obj1.getName());
	System.out.println(obj1.getJob());
	
			
}

}