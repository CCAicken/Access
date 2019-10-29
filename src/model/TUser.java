package model;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private String userid;
	private String username;
	private String pwd;
	private Integer userregion;
	private Integer usertype;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(String userid, String username, String pwd,
			Integer userregion, Integer usertype) {
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.userregion = userregion;
		this.usertype = usertype;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getUserregion() {
		return this.userregion;
	}

	public void setUserregion(Integer userregion) {
		this.userregion = userregion;
	}

	public Integer getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

}