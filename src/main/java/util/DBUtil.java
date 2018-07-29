package util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;



public class DBUtil {

	private static Properties db=new Properties();
	private static BasicDataSource source= new BasicDataSource();
	
	static {
		try {
			db.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			String url=db.getProperty("jdbc.url");
			String username=db.getProperty("jdbc.username");
			String password=db.getProperty("jdbc.password");
			String className=db.getProperty("jdbc.className");
			source.setUrl(url);
			source.setUsername(username);
			source.setPassword(password);
			source.setDriverClassName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnSource()
	{
		Connection connection=null;
		try {
			connection=source.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static Connection getConn() {
		Connection connection=null;
		try {
			String url=db.getProperty("jdbc.url");
			String username=db.getProperty("jdbc.username");
			String password=db.getProperty("jdbc.password");
			String className=db.getProperty("jdbc.className");
			Class.forName(className);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void close(Connection conn,Statement state,ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(state!=null)state.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
