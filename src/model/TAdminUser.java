package model;


/**
 * TAdminUser entity. @author MyEclipse Persistence Tools
 */

public class TAdminUser implements java.io.Serializable {

	// Fields

	private String userid;
	private String mobile;
	private String pwd;
	private Integer roleId;
	private Integer userstatus;
	private String realname;
	private String createtime;
	private Integer loginstatus;
	private String lastlogindate;

	// Constructors

	/** default constructor */
	public TAdminUser() {
	}

	/** minimal constructor */
	public TAdminUser(String userid, String pwd, Integer roleId,
			Integer userstatus, String realname, String createtime) {
		this.userid = userid;
		this.pwd = pwd;
		this.roleId = roleId;
		this.userstatus = userstatus;
		this.realname = realname;
		this.createtime = createtime;
	}

	/** full constructor */
	public TAdminUser(String userid, String mobile, String pwd, Integer roleId,
			Integer userstatus, String realname, String createtime,
			Integer loginstatus, String lastlogindate) {
		this.userid = userid;
		this.mobile = mobile;
		this.pwd = pwd;
		this.roleId = roleId;
		this.userstatus = userstatus;
		this.realname = realname;
		this.createtime = createtime;
		this.loginstatus = loginstatus;
		this.lastlogindate = lastlogindate;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserstatus() {
		return this.userstatus;
	}

	public void setUserstatus(Integer userstatus) {
		this.userstatus = userstatus;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getLoginstatus() {
		return this.loginstatus;
	}

	public void setLoginstatus(Integer loginstatus) {
		this.loginstatus = loginstatus;
	}

	public String getLastlogindate() {
		return this.lastlogindate;
	}

	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

}