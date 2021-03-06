package restAPI;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Simulate_Query {
	
	  
	@Test
	public void querySimulator() 
	
	{
	        RequestSpecification request=RestAssured.given();
		
		 //Specify headers
		 
		request.header("Content-Type","application/json");
 
		//Specify body
		
		JSONObject json=new JSONObject();
		json.put("device_id_type","idfa");
		json.put("device_id","BAC9BA51-4C51-45C8-8091-3F6890A21A70");
		json.put("app_version","1.1");
		json.put("country","US");
		json.put("q","hello"); // Actual Query
		request.body(json.toJSONString());
		
 		ResponseBody body = response.getBody();
		String responselog = RestAssured.given()
				.log()
				.all()
 				.asString();
		System.out.println(response);
				
		System.out.println("Response Body is: " + body.asString());
		//prettyPrint());
		
	}
	
	
	private Object log() {
	return null;
	}

	//Adding Validation tests
	@Test
	public void validateFields() 
	{
		
		 RequestSpecification request=RestAssured.given();
		
		 //Specifying headers
		 
		request.header("Content-Type","application/json");
		request.header("Authorization","APIKEY BHEQty70228WUEBYAN50VRYBZRHQKYF9KN");
		request.header("project-id","95T443T");

		//Specifying body
		
		JSONObject json=new JSONObject();

		json.put("q","hello");
		
		request.body(json.toJSONString());
		
 		
		int code=response.getStatusCode();
		
		ResponseBody body = response.getBody();
		System.out.println("Response Body is: " + body.asString());

		
		Assert.assertEquals(code, 400);
					
	}
	
}
