package api.tests;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import api.constants.PetEndPoints;
import io.restassured.response.Response;


public class Tests {
	
	@Test(priority=1,groups = {"scenario1","scenario2","scenario3"})
	public void postPet() throws FileNotFoundException {
		
		Response response = PetEndPoints.addPet();
		
		response.then().assertThat().statusCode(200)
		               .log().all();
	}
	
	@Test(priority =2,groups = {"scenario1","scenario3"})
	public void postByImage() {
		PetEndPoints.addPetByImage();
	}
	
	@Test(priority=3,groups = {"scenario1","scenario2"})
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
	@Test(priority=4,groups = {"scenario1","scenario2"})
	public void getPetByStatus() {
		Response response = PetEndPoints.getPetByStatus();
		      response.then().assertThat().statusCode(200)
		     .log().all();
		               	
	}
	
	@Test(priority=5 , groups = "scenario3")
	public void putUser() throws FileNotFoundException {
		
		Response response = PetEndPoints.updatePet();
		
		response.then().statusCode(200)
		.log().all();
//		int id = response.jsonPath().get("category.id");
//		Assert.assertEquals(id, 3101);
	}
	
	@Test(priority=6, groups = {"scenario2","scenario3"})
	public void delPet() {
		Response response = PetEndPoints.deletePet(3222);
		
		response.then().assertThat().statusCode(200);
	}

	
}
