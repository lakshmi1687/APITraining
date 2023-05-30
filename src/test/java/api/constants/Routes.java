package api.constants;

public class Routes {
	
	public static String petUrl = "https://petstore.swagger.io/v2";
	public static String postPetById = petUrl + "/pet";
	public static String postPetImage = petUrl + "/3222/uploadImage";
	public static String getPetById = petUrl + "/pet/{petId}";
	public static String getPetByStatus = petUrl + "/pet/findByStatus?status=pending";
	public static String updatePet = petUrl + "/pet";
	public static String delPetById = petUrl + "/pet/{petId}";
	 

}
