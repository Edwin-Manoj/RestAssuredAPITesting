Feature: Validating place API's'

@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlace API
Given Add place payload with "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" place API with "Post" http request
Then API call is successful with a status code 200 response
And The "status" is response body is "OK"
And The "scope" is response body is "APP"
And Verify if "place_id" created maps to the "<name>" using "GetPlaceAPI"

Examples: 
|name	  |language|address	   |
|RubyElite|English |30,Mudichur|
#|CasaGrand|French|Aadhanur|

@DeletePlace
Scenario: Verify if place is being successfully deleted using DeletePlaceAPI
Given Delete place payload
When User calls "DeletePlaceAPI" place API with "Post" http request
Then API call is successful with a status code 200 response
And The "status" is response body is "OK"



