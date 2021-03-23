package restApiBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class GetReqBDD {
	
	@Test
	public void test1() {
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.queryParam("id","1")   //retrives the specific parameter
					.when()
					.get()
					.then()
					.statusCode(200)
					.body("[0].name", Matchers.equalTo("Harish"))
					.body("[0].salary", Matchers.equalTo("8000"))
					.body("id", Matchers.equalTo(1))
					.log()
					.all();     //.all() can also be used
	}
}