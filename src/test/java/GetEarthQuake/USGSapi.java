package GetEarthQuake;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class USGSapi {
	public Response response;
	public USGSapi() {
		String uri = "/fdsnws/event/1/query?"
				+ "format=geojson"
				+ "&starttime=2014-01-01"
				+ "&minlatitude=10"
				+ "&maxlatitude=25"
				+ "&minlongitude=70"
				+ "&maxlongitude=85";
		RestAssured.baseURI = "https://earthquake.usgs.gov";
		response= RestAssured.given().contentType(ContentType.JSON).when().get(uri).then().extract().response();
	}
}