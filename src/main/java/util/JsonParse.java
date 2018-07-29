package util;


import java.util.List;
import java.util.Map;

public interface JsonParse<T> {
	//object to json
	public String parseObjectToJson(Object object);
	
	//list to json
	public String parseListToJson(List<T> list);
	
	//map to json
	public String parseMapToJson(Map<String,T> map);
	
	//json to object
	public T parseJsonToObject(Class<T> clazz,String json);
	
	//json to list
	public List<T> parseJsonToList(Class<T> clazz,String json);
	
	//json to map
	public Map<String,T> parseJsonToMap(Class<T> clazz,String json);

}
