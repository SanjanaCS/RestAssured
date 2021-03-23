package restApiRealTime;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostReqHashmap {
	
	Map<String, Object> map = new HashMap<>();


	@Test
	public void test1() {
		
		map.put("firstName", "Venky");
		map.put("lastName", "123");
		map.put("salary", 1000);
		map.put("email", "Venky@gmail.com");
		
		
		
		
		RestAssured.given()
					.baseUri("http://localhost:8088/")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(map)
					.when()
					.post("employees")
					.then()
					.statusCode(201)
					.log()
					.body();    
	}
		@Test
		public void test2() throws IOException {
		
			
			String jsonfile = new String(Files.readAllBytes(Paths.get("fileInput.json")));
		
		
			RestAssured.given()
					.baseUri("http://localhost:8088/employees")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(jsonfile)
					.when()
					.post()
					.then()
					.statusCode(201)
					.log()
					.body();    
	}
	
}
