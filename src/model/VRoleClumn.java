package model;

/**
 * VRoleClumn entity. @author MyEclipse Persistence Tools
 */

public class VRoleClumn implements java.io.Serializable {

	private Integer id;
	private Integer roleId;
	private Integer clumnId;
	private Boolean isedit;
	private String rolename;
	private String description;
	private String clumnKey;
	private String clumnName;
	private Integer sort;
	private Integer sysModleId;
	private String modelname;
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

	// Constructors

	/** default constructor */
	public VRoleClumn() {
	}

	/** minimal constructor */
	public VRoleClumn(Integer id, Integer roleId, Integer clumnId,
			Boolean isedit, String rolename, String clumnKey, String clumnName,
			Integer sort, Integer sysModleId) {
		this.id = id;
		this.roleId = roleId;
		this.clumnId = clumnId;
		this.isedit = isedit;
		this.rolename = rolename;
		this.clumnKey = clumnKey;
		this.clumnName = clumnName;
		this.sort = sort;
		this.sysModleId = sysModleId;
	}

	/** full constructor */
	public VRoleClumn(Integer id, Integer roleId, Integer clumnId,
			Boolean isedit, String rolename, String description,
			String clumnKey, String clumnName, Integer sort,
			Integer sysModleId, String modelname, String chinesename,
			String navurl, Integer accesslevel, Integer deepth,
			Integer parentid, Integer displayorder, String imageurl,
			String value, String systemname, Boolean isdelete) {
		this.id = id;
		this.roleId = roleId;
		this.clumnId = clumnId;
		this.isedit = isedit;
		this.rolename = rolename;
		this.description = description;
		this.clumnKey = clumnKey;
		this.clumnName = clumnName;
		this.sort = sort;
		this.sysModleId = sysModleId;
		this.modelname = modelname;
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

	public Integer getClumnId() {
		return this.clumnId;
	}

	public void setClumnId(Integer clumnId) {
		this.clumnId = clumnId;
	}

	public Boolean getIsedit() {
		return this.isedit;
	}

	public void setIsedit(Boolean isedit) {
		this.isedit = isedit;
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

	public String getClumnKey() {
		return this.clumnKey;
	}

	public void setClumnKey(String clumnKey) {
		this.clumnKey = clumnKey;
	}

	public String getClumnName() {
		return this.clumnName;
	}

	public void setClumnName(String clumnName) {
		this.clumnName = clumnName;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSysModleId() {
		return this.sysModleId;
	}

	public void setSysModleId(Integer sysModleId) {
		this.sysModleId = sysModleId;
	}

	public String getModelname() {
		return this.modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
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

}