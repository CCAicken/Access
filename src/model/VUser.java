package model;

/**
 * VUser entity. @author MyEclipse Persistence Tools
 */

public class VUser implements java.io.Serializable {

	// Fields

	private Integer classid;
	private String classname;
	private Integer majorid;
	private String majorname;
	private Integer collegeid;
	private String collegename;
	private String userid;
	private String pwd;
	private String username;
	private Integer usertype;

	// Constructors

	/** default constructor */
	public VUser() {
	}

	/** minimal constructor */
	public VUser(Integer collegeid, String collegename, String userid,
			String pwd, String username, Integer usertype) {
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.userid = userid;
		this.pwd = pwd;
		this.username = username;
		this.usertype = usertype;
	}

	/** full constructor */
	public VUser(Integer classid, String classname, Integer majorid,
			String majorname, Integer collegeid, String collegename,
			String userid, String pwd, String username, Integer usertype) {
		this.classid = classid;
		this.classname = classname;
		this.majorid = majorid;
		this.majorname = majorname;
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.userid = userid;
		this.pwd = pwd;
		this.username = username;
		this.usertype = usertype;
	}

	// Property accessors

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Integer getMajorid() {
		return this.majorid;
	}

	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
	}

	public String getMajorname() {
		return this.majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

}