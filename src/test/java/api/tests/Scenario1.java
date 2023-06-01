package api.tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import api.constants.Endpoints;
import api.constants.PetEndPoints;
import io.restassured.response.Response;

public class Scenario1 {
	
	@Test(priority=1)
  public void postPet() {
		Response response = PetEndPoints.addPet();
		
		response.then().assertThat()
		.statusCode(is(equalTo(200)))
		
		               .log().all();
	}
  @Test(priority=2)
  public void postByImage() {
		PetEndPoints.addPetByImage();
	}
  @Test(priority=3)
  public void getPetById() {
	  Endpoints idValue = Endpoints.ID;
	  Endpoints updatedIdValue = Endpoints.ID1;
	  
		Response response = PetEndPoints.getPetById(idValue.getValue());
		
		      response.then().assertThat().statusCode(is(equalTo(200)));
		      
		      int id = response.jsonPath().get("category.id");
		      if(id == updatedIdValue.getValue()) {
		    	  System.out.println("pet data is updated");
		      } else {
		    	  System.out.println("pet data is original");
		      }

}
  @Test(priority=4)
  public void getPetByStatus() {
		Response response = PetEndPoints.getPetByStatus();
		      response.then().assertThat().statusCode(is(equalTo(200)))
		     .log().all();
		               	
	}
}
