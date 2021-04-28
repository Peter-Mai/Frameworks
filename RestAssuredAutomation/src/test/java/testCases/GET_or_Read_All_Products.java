package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;

import static io.restassured.RestAssured.io;

import java.util.concurrent.TimeUnit;

public class GET_or_Read_All_Products {

	@Test
	public void read_All_Products() {
		Response response = 
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type", "application/json; charset=UTF-8")
			.queryParams("id", "1474" ).
		when()
			.get("/product/read.php").
		then()
			.extract().response();
		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		if (responseTime <= 2000) {
			System.out.println("Response time is wihtin range!");
		} else {
			System.out.println("Response time is out of range");
		}
		
		System.out.println("Response Body: " + response.getBody().prettyPrint());
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body " + responseBody);
		JsonPath js = new JsonPath(responseBody);
		System.out.println(js);
	
	}
}
