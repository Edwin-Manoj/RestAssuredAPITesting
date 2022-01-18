package resources;
// enum is spl class in java which has collection of constants or methods
public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;

	APIResources(String resource)  // You have defeined that in enum the ,ethod accepts an argument in similar way u need to declare the constructr such that it accepts the argument
	{
		this.resource=resource;
	}

	public String getresource() {
		return resource;
	}
	
}
