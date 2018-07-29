package pojo;


public class Merchant {

	private String shopId;				//Ã¥â€¢â€ Ã¥Â®Â¶ID
	private String creditCode;		//Ã¨ï¿½Â¥Ã¤Â¸Å¡Ã¦â€°Â§Ã§â€¦Â§Ã¥ï¿½Â·
	private String idCard;			//Ã¦Â³â€¢Ã¤ÂºÂºÃ¨ÂºÂ«Ã¤Â»Â½Ã¨Â¯ï¿½
	private String corporateName;	//Ã¦Â³â€¢Ã¤ÂºÂºÃ¥Â§â€œÃ¥ï¿½ï¿½
	private String picture;			//Ã¦Â³â€¢Ã¤ÂºÂºÃ§â€¦Â§Ã§â€°â€¡
	private String phone;			//Ã¦Â³â€¢Ã¤ÂºÂºÃ¨ï¿½â€�Ã§Â³Â»Ã¦â€“Â¹Ã¥Â¼ï¿½
	private String shopName;		//Ã¥â€¢â€ Ã¥Â®Â¶Ã¥ï¿½ï¿½Ã§Â§Â°
	private String address;			//Ã¥â€¢â€ Ã¥Â®Â¶Ã¥Å“Â°Ã¥ï¿½â‚¬
	private Integer status; 		//Ã¥Â®Â¡Ã¦Â Â¸Ã§Å Â¶Ã¦â‚¬ï¿½
	private Integer version;
	private String comments;
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCorporateName() {
		return corporateName;
	}
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Merchant(String shopId, String creditCode, String idCard, String corporateName, String picture, String phone,
			String shopName, String address, Integer status, Integer version, String comments) {
		super();
		this.shopId = shopId;
		this.creditCode = creditCode;
		this.idCard = idCard;
		this.corporateName = corporateName;
		this.picture = picture;
		this.phone = phone;
		this.shopName = shopName;
		this.address = address;
		this.status = status;
		this.version = version;
		this.comments = comments;
	}
	
	
	public Merchant(String shopId, String creditCode, String idCard, String corporateName, String picture, String phone,
			String shopName, String address, Integer status, String comments) {
		super();
		this.shopId = shopId;
		this.creditCode = creditCode;
		this.idCard = idCard;
		this.corporateName = corporateName;
		this.picture = picture;
		this.phone = phone;
		this.shopName = shopName;
		this.address = address;
		this.status = status;
		this.comments = comments;
	}
	public Merchant() {
		super();
	}
	@Override
	public String toString() {
		return "Merchant [shopId=" + shopId + ", creditCode=" + creditCode + ", idCard=" + idCard + ", corporateName="
				+ corporateName + ", picture=" + picture + ", phone=" + phone + ", shopName=" + shopName + ", address="
				+ address + ", status=" + status + ", version=" + version + ", comments=" + comments + "]";
	}			
	

	
}