package GetEarthQuake;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

import JsonToJavaObjects.Features;
import JsonToJavaObjects.MainObject;

public class GetEarthquakeData{
	public static void main(String[] args) {
		USGSapi api = new USGSapi();
		String json = api.response.asPrettyString();
		Pattern pattern = Pattern.compile("(pune|Pune|Narasannapeta)");
		MainObject jsonToJavaObject = new Gson().fromJson(json, MainObject.class);
		List<Features> places = jsonToJavaObject.features;
		for(Features feature: places) {
			Matcher matcher = pattern.matcher(feature.properties.place);
			if(matcher.find() == true) {
				System.out.println("Earthquake in "+ feature.properties.place);
			}
//			System.out.println(feature.properties.place);
		}
	}

}
