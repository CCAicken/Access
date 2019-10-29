package model;

/**
 * VRoleButton entity. @author MyEclipse Persistence Tools
 */

public class VRoleButton implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleId;
	private Integer cluId;
	private Integer btnId;
	private String domId;
	private String btnname;
	private String script;
	private String icon;
	private String btnclass;
	private String btnremark;
	private Integer btnsort;
	private Integer sysModelId;
	private String rolename;
	private String description;
	private String name;
	private String chinesename;
	private String navurl;
	private Integer accesslevel;
	private Integer deepth;
	private Integer parentid;
	private Integer displayorder;
	private String imageurl;
	private String value;
	private String systemname;
	private Boolean isdelete;
	private Boolean isedit;

	// Constructors

	/** default constructor */
	public VRoleButton() {
	}

	/** minimal constructor */
	public VRoleButton(Integer id, Integer roleId, Integer cluId,
			Integer btnId, String domId, String btnname, String script,
			String btnclass, Integer btnsort, Integer sysModelId,
			String rolename, Boolean isedit) {
		this.id = id;
		this.roleId = roleId;
		this.cluId = cluId;
		this.btnId = btnId;
		this.domId = domId;
		this.btnname = btnname;
		this.script = script;
		this.btnclass = btnclass;
		this.btnsort = btnsort;
		this.sysModelId = sysModelId;
		this.rolename = rolename;
		this.isedit = isedit;
	}

	/** full constructor */
	public VRoleButton(Integer id, Integer roleId, Integer cluId,
			Integer btnId, String domId, String btnname, String script,
			String icon, String btnclass, String btnremark, Integer btnsort,
			Integer sysModelId, String rolename, String description,
			String name, String chinesename, String navurl,
			Integer accesslevel, Integer deepth, Integer parentid,
			Integer displayorder, String imageurl, String value,
			String systemname, Boolean isdelete, Boolean isedit) {
		this.id = id;
		this.roleId = roleId;
		this.cluId = cluId;
		this.btnId = btnId;
		this.domId = domId;
		this.btnname = btnname;
		this.script = script;
		this.icon = icon;
		this.btnclass = btnclass;
		this.btnremark = btnremark;
		this.btnsort = btnsort;
		this.sysModelId = sysModelId;
		this.rolename = rolename;
		this.description = description;
		this.name = name;
		this.chinesename = chinesename;
		this.navurl = navurl;
		this.accesslevel = accesslevel;
		this.deepth = deepth;
		this.parentid = parentid;
		this.displayorder = displayorder;
		this.imageurl = imageurl;
		this.value = value;
		this.systemname = systemname;
		this.isdelete = isdelete;
		this.isedit = isedit;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getCluId() {
		return this.cluId;
	}

	public void setCluId(Integer cluId) {
		this.cluId = cluId;
	}

	public Integer getBtnId() {
		return this.btnId;
	}

	public void setBtnId(Integer btnId) {
		this.btnId = btnId;
	}

	public String getDomId() {
		return this.domId;
	}

	public void setDomId(String domId) {
		this.domId = domId;
	}

	public String getBtnname() {
		return this.btnname;
	}

	public void setBtnname(String btnname) {
		this.btnname = btnname;
	}

	public String getScript() {
		return this.script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getBtnclass() {
		return this.btnclass;
	}

	public void setBtnclass(String btnclass) {
		this.btnclass = btnclass;
	}

	public String getBtnremark() {
		return this.btnremark;
	}

	public void setBtnremark(String btnremark) {
		this.btnremark = btnremark;
	}

	public Integer getBtnsort() {
		return this.btnsort;
	}

	public void setBtnsort(Integer btnsort) {
		this.btnsort = btnsort;
	}

	public Integer getSysModelId() {
		return this.sysModelId;
	}

	public void setSysModelId(Integer sysModelId) {
		this.sysModelId = sysModelId;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChinesename() {
		return this.chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public String getNavurl() {
		return this.navurl;
	}

	public void setNavurl(String navurl) {
		this.navurl = navurl;
	}

	public Integer getAccesslevel() {
		return this.accesslevel;
	}

	public void setAccesslevel(Integer accesslevel) {
		this.accesslevel = accesslevel;
	}

	public Integer getDeepth() {
		return this.deepth;
	}

	public void setDeepth(Integer deepth) {
		this.deepth = deepth;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSystemname() {
		return this.systemname;
	}

	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}

	public Boolean getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public Boolean getIsedit() {
		return this.isedit;
	}

	public void setIsedit(Boolean isedit) {
		this.isedit = isedit;
	}
}