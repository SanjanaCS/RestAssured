package restApiBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostReqBDD {

	@Test
	public void test1() {
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body("{\r\n"
				+ "    \"name\": \"Sameer\",\r\n"
				+ "    \"salary\": \"15000\"\r\n"
				+ "}")
		.when()
		.post("/create")
		.then()
		.statusCode(201)
		.body("name",Matchers.equalTo("Sameer"))
		.body("salary",Matchers.equalTo("15000"))
		.log().all();
		
	}
}
