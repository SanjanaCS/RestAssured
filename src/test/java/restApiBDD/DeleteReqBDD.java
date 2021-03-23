package restApiBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteReqBDD {
	@Test
	public void test1() {
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.delete("/delete/7")
		.then()
		.statusCode(200)
		.log().all();
		
	}
}
