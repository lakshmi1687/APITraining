package api.tests;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.testng.annotations.Test;
import api.constants.Params;
import api.constants.PetEndPoints;
import io.restassured.response.Response;

public class Scenario2 {
	@Test(priority=1)
public void postPet() {
		
		Response response = PetEndPoints.addPet();
		
		response.then().assertThat().statusCode(is(equalTo(200)))
		               .log().all();
	}
@Test(priority=2)
public void getPetById() {
	Params idValue = Params.ID;
	  Params updatedIdValue = Params.ID1;
	  
		Response response = PetEndPoints.getPetById(idValue.getValue());
		      response.then().assertThat().statusCode(is(equalTo(200)));
		      int id = response.jsonPath().get("category.id");
		      if(id == updatedIdValue.getValue()) {
		    	  System.out.println("pet data is updated");
		      } else {
		    	  System.out.println("pet data is original");
		      }

}
@Test(priority=3)
public void getPetByStatus() {
	Response response = PetEndPoints.getPetByStatus();
	      response.then().assertThat().statusCode(is(equalTo(200)))
	     .log().all();
	               	
}
@Test(priority=4)
public void delPet() {
	Params idValue = Params.ID;
	Response response = PetEndPoints.deletePet(idValue.getValue());
	
	response.then().assertThat().statusCode(is(equalTo(200)));
}

}
