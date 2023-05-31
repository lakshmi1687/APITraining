package api.tests;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import api.constants.PetEndPoints;
import io.restassured.response.Response;

public class Scenario1 {
	
	@Test(priority=1)
  public void postPet() throws FileNotFoundException {
		
		Response response = PetEndPoints.addPet();
		
		response.then().assertThat().statusCode(200)
		               .log().all();
	}
  @Test(priority=2)
  public void postByImage() {
		PetEndPoints.addPetByImage();
	}
  @Test(priority=3)
  public void getPetById() {
		Response response = PetEndPoints.getPetById(3222);
		      response.then().assertThat().statusCode(200);
		      int id = response.jsonPath().get("category.id");
		      if(id == 3101) {
		    	  System.out.println("pet data is updated");
		      } else {
		    	  System.out.println("pet data is original");
		      }

}
  @Test(priority=4)
  public void getPetByStatus() {
		Response response = PetEndPoints.getPetByStatus();
		      response.then().assertThat().statusCode(200)
		     .log().all();
		               	
	}
}
