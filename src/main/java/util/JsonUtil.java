package util;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.Admin;




public class JsonUtil {
	
	private static List<Admin> users=new ArrayList<>();
	
	static {
		for(int i=0;i<100;i++) {
			Admin user=new Admin(i,"user"+i,"psw"+1);
			users.add(user);
		}
	}
	
	public static List<Admin> getAllUser(){
		return users;
	}
	
	public static List<String> parseObjectToJson(List<?> objects){
		List<String> result=new ArrayList<>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			for(Object object:objects) {
				String s = mapper.writeValueAsString(object);
				result.add(s);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void testJacksonRead() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		Admin user=mapper.readValue(new FileInputStream("user.data"), Admin.class);
//		List<User> users=mapper.readValue(new FileInputStream("user.data"),new TypeReference<List<User>>() {});
		System.out.println(user.toString());
	}

}
