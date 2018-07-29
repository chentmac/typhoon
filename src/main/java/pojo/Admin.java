package pojo;


public class Admin {

	private Integer id;			//ç®¡ç�†å‘˜ID
	private String userName;	//è´¦å�·
	private String password;	//å¯†ç �
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	public Admin(Integer id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public Admin() {
		super();
	}
	
}
