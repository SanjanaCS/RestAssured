package restApiBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Test
public class PutReqBDD {
	public void test1() {
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body("{\r\n"
				+ "    \"name\": \"Sanjana\",\r\n"
				+ "    \"salary\": \"12000\"\r\n"
				+ "}")
		.when()
		.put("/update/5")
		.then()
		.statusCode(200)
		.body("name",Matchers.equalTo("Sanjana"))
		.body("salary",Matchers.equalTo("12000"))
		.log().all();
		
	}
}
