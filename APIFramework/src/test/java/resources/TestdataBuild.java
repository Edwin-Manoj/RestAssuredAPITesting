package resources;

import java.util.ArrayList;
import java.util.List;
import POJOClass.POJOClasses_GoogleAPI;
import POJOClass.POJOClasses_GoogleAPI_location;

public class TestdataBuild {

	public POJOClasses_GoogleAPI addPlacePayload(String name, String language, String place)
	{
		POJOClasses_GoogleAPI p = new POJOClasses_GoogleAPI();
		p.setAccuracy("100");
		p.setName(name);
		p.setPhone_number("123456789");
		p.setAddress(place);
		p.setWebsite("http://google.com");
		p.setLanguage(language);
		
		//Setting location latitude and longitude
		POJOClasses_GoogleAPI_location location = new POJOClasses_GoogleAPI_location();
		location.setLat(-40.383494);
		location.setLng(40.427362);
		p.setLocation(location);
		
		//Setting Types
		List<String> types = new ArrayList<String>();
		types.add("Ruby");
		types.add("Residency");
		p.setTypes(types);
		
		return p;
	}
	
	public String Deletepayload(String placeId)
	{
		if(placeId==null)
		{
			
		}
		return "{\r\n"
				+ "    \"place_id\": \""+placeId+"\"\r\n"
				+ "}";
	}
}
