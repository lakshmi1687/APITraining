package api.tests;

import org.testng.annotations.Test;
import api.constants.PetEndPoints;
import io.restassured.response.Response;

public class Scenario3 {
	@Test(priority=1)
	
public void postPet() {
		
		Response response = PetEndPoints.addPet();
		
		response.then().assertThat().statusCode(200)
		               .log().all();
	}
	
	@Test(priority =2)
	public void postByImage() {
		PetEndPoints.addPetByImage();
	}
	@Test(priority=3)
public void putUser() {
		
		Response response = PetEndPoints.updatePet();
		
		response.then().statusCode(200)
		.log().all();
//		int id = response.jsonPath().get("category.id");
//		Assert.assertEquals(id, 3101);
	}
	
@Test(priority=4)
public void delPet() {
	Response response = PetEndPoints.deletePet(3222);
	
	response.then().assertThat().statusCode(200);
}

}
