package pojo;


import java.util.Date;


public class Ad {

	private Integer id;			
	private String shopId;
	private String shopName;
	private String picture;
	private String slogan;
	private Double price;
	private Integer state;
	private Date time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Ad [id=" + id + ", shopId=" + shopId + ", shopName=" + shopName + ", picture=" + picture + ", slogan="
				+ slogan + ", price=" + price + ", state=" + state + ", time=" + time + "]";
	}
	public Ad(Integer id, String shopId, String shopName,String picture, String slogan, Double price, Integer state, Date time) {
		super();
		this.id = id;
		this.shopId = shopId;
		this.shopName=shopName;
		this.picture = picture;
		this.slogan = slogan;
		this.price = price;
		this.state = state;
		this.time = time;
	}
	public Ad(Integer id, String shopId, String shopName,String picture, String slogan, Double price, Integer state) {
		super();
		this.id = id;
		this.shopId = shopId;
		this.shopName=shopName;
		this.picture = picture;
		this.slogan = slogan;
		this.price = price;
		this.state = state;
	}
	public Ad() {
		super();
	}
	
	
	
}
