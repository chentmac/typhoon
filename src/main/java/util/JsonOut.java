package util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonOut {
    private static JsonParse json = new JsonParseByJackson();
    public static void outJson(HttpServletRequest request, HttpServletResponse response, Object object){
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", -10);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String jsonStr=json.parseObjectToJson(object);
            out.print(jsonStr);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            out.close();
        }
    }
}
