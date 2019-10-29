package model;

/**
 * TTableClumn entity. @author MyEclipse Persistence Tools
 */

public class TTableClumn implements java.io.Serializable {

	// Fields

	private Integer id;
	private String clumnKey;
	private String clumnName;
	private Integer sort;
	private Integer sysModleId;
	private String remark;

	// Constructors

	/** default constructor */
	public TTableClumn() {
	}

	/** minimal constructor */
	public TTableClumn(String clumnKey, String clumnName, Integer sort,
			Integer sysModleId) {
		this.clumnKey = clumnKey;
		this.clumnName = clumnName;
		this.sort = sort;
		this.sysModleId = sysModleId;
	}

	/** full constructor */
	public TTableClumn(String clumnKey, String clumnName, Integer sort,
			Integer sysModleId, String remark) {
		this.clumnKey = clumnKey;
		this.clumnName = clumnName;
		this.sort = sort;
		this.sysModleId = sysModleId;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}