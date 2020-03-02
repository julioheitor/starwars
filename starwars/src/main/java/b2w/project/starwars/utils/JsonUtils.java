package b2w.project.starwars.utils;

import java.util.concurrent.ExecutionException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonUtils {
	
	public static JsonArray getFieldValueFromJsonString(String field, String json) throws InterruptedException, ExecutionException {
		return convertToJsonObject(json).get(field).getAsJsonArray();
	}
	
	private static JsonObject convertToJsonObject(String json) throws InterruptedException, ExecutionException {
		Gson g = new Gson(); 
		return g.fromJson(json, JsonObject.class);
	}
}
