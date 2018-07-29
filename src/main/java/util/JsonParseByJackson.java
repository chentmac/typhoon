package util;


import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class  JsonParseByJackson<T> implements JsonParse<T>{

	@Override
	public String parseObjectToJson(Object object) {
		String result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			result= mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String parseListToJson(List<T> list) {
		String result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			result= mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public T parseJsonToObject(Class<T> clazz, String json) {
		T result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			result=mapper.readValue(json,clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public List<T> parseJsonToList(Class<T> clazz, String json) {
		List<T> result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class,clazz);
			result=mapper.readValue(json,javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Map<String, T> parseJsonToMap(Class<T> clazz, String json) {
		Map<String,T> result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType javaType = mapper.getTypeFactory().constructParametricType(Map.class,String.class,clazz);
			result=mapper.readValue(json,javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String parseMapToJson(Map<String, T> map) {
		String result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			result= mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

}
