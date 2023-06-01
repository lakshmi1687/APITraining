package api.constants;

import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


//created to perform create,retrieve,update and delete operations

public class PetEndPoints {
	
	public static Response addPet() {
    	
         String path=System.getProperty("user.dir")+"//testData//petdata.json";
    	
    	try {
        File f = new File(path);
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject jo = new JSONObject(jt);
	
				
		Response response = given()
		                     .contentType("application/json")
		                     .accept("application/json")
		                     .body(jo.toString())
		
		                   .when()
		                       .post(Routes.updatePet);
		return response;
		
    	} 
    	catch (FileNotFoundException e) {
    		System.out.println("Given file location is wrong");

    	}
		return null;	
	
		                       
	}
    public static void addPetByImage()  {
    	
    	String apiUrl = Routes.postPetImage;  
        String imagePath = "C:\\Users\\Lakshmi.Pathi\\Documents\\dog3.jpg";  

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(apiUrl);

        File imageFile = new File(imagePath);
        FileBody fileBody = new FileBody(imageFile, ContentType.IMAGE_JPEG);

        HttpEntity entity = MultipartEntityBuilder.create()
                .addPart("image", fileBody)  
                .build();

        httpPost.setEntity(entity);

        try {
            HttpResponse response1 = httpClient.execute(httpPost);
            HttpEntity responseEntity = response1.getEntity();

            
            if (responseEntity != null) {
                String responseString = EntityUtils.toString(responseEntity);
                System.out.println(responseString);
            }

            EntityUtils.consume(responseEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
		                       
	}
	
	public static Response getPetById(int petId) {
		
		Response response = given()
		                      .pathParam("petId", petId)
		                    .when()
		                      .get(Routes.getPetById);
		
		        return response;
		  
	}
	
    public static Response getPetByStatus() {
		
		Response response = given()
		                 
		                    .when()
		                      .get(Routes.getPetByStatus);
		
		        return response;
		  
	}
    
    public static Response updatePet() {
    	
    	String path=System.getProperty("user.dir")+"//testData//UpdatedPetData.json";
    	
    	try {
        File f = new File(path);
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject jo = new JSONObject(jt);
	
				
		Response response = given()
		                     .contentType("application/json")
		                     .accept("application/json")
		                     .body(jo.toString())
		
		                   .when()
		                       .post(Routes.updatePet);
		return response;
		
    	} 
    	catch (FileNotFoundException e) {
    		System.out.println("Given file location is wrong");

    	}
		return null;	
		                       
	}
	
	public static Response deletePet(int petId) {
		
		Response response = given()
		                      .pathParam("petId", petId)
		                    .when()
		                       .delete(Routes.delPetById);
		
		        return response;
	}
		
	    public static RequestSpecification postPetByImage() {
	    	RequestSpecification response = given();
	        String apiUrl = Routes.postPetImage;  // Replace with the actual API endpoint URL
	        String imagePath = "C:\\Users\\Lakshmi.Pathi\\Documents\\dog3.jpg";  // Replace with the actual path of your image file

	        HttpClient httpClient = HttpClients.createDefault();
	        HttpPost httpPost = new HttpPost(apiUrl);

	        File imageFile = new File(imagePath);
	        FileBody fileBody = new FileBody(imageFile, ContentType.IMAGE_JPEG);

	        HttpEntity entity = MultipartEntityBuilder.create()
	                .addPart("image", fileBody)  // "image" is the form field name for the image file
	                .build();

	        httpPost.setEntity(entity);

	        try {
	            HttpResponse response1 = httpClient.execute(httpPost);
	            HttpEntity responseEntity = response1.getEntity();

	            // Handle the response as needed
	            if (responseEntity != null) {
	                String responseString = EntityUtils.toString(responseEntity);
	                System.out.println(responseString);
	            }

	            // Close resources
	            EntityUtils.consume(responseEntity);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return response;
	    }



}
