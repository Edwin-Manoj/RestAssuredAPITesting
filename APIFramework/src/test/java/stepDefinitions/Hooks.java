package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void PlaceId() throws IOException
	{
		StepDefinition SD = new StepDefinition();
		if (StepDefinition.place_id_value == null) {
		SD.place_payload_with("Casagrand MIRO", "Spanish", "AddhanurRoad");
		SD.user_calls_place_api_with_http_request("AddPlaceAPI", "POST");
		SD.verify_if_place_id_created_maps_to_the_using("place_id", "Casagrand MIRO", "GetPlaceAPI");

		}
	}
	
}
