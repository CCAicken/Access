package model;


/**
 * VAdminUser entity. @author MyEclipse Persistence Tools
 */

public class VAdminUser implements java.io.Serializable {

	private String userid;
	private String mobile;
	private String pwd;
	private Integer userstatus;
	private String realname;
	private String createtime;
	private Integer loginstatus;
	private String lastlogindate;
	private Integer roleId;
	private String name;
	private String description;

	// Constructors

	/** default constructor */
	public VAdminUser() {
	}

	/** minimal constructor */
	public VAdminUser(String userid, String pwd, Integer userstatus,
			String realname, String createtime, Integer roleId, String name) {
		this.userid = userid;
		this.pwd = pwd;
		this.userstatus = userstatus;
		this.realname = realname;
		this.createtime = createtime;
		this.roleId = roleId;
		this.name = name;
	}

	/** full constructor */
	public VAdminUser(String userid, String mobile, String pwd,
			Integer userstatus, String realname, String createtime,
			Integer loginstatus, String lastlogindate, Integer roleId,
			String name, String description) {
		this.userid = userid;
		this.mobile = mobile;
		this.pwd = pwd;
		this.userstatus = userstatus;
		this.realname = realname;
		this.createtime = createtime;
		this.loginstatus = loginstatus;
		this.lastlogindate = lastlogindate;
		this.roleId = roleId;
		this.name = name;
		this.description = description;
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

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}