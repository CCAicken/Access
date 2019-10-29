package model;

/**
 * TRoleClumn entity. @author MyEclipse Persistence Tools
 */

public class TRoleClumn implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleId;
	private Integer clumnId;
	private Boolean isedit;
	private String remark;

	// Constructors

	/** default constructor */
	public TRoleClumn() {
	}

	/** minimal constructor */
	public TRoleClumn(Integer roleId, Integer clumnId, Boolean isedit) {
		this.roleId = roleId;
		this.clumnId = clumnId;
		this.isedit = isedit;
	}

	/** full constructor */
	public TRoleClumn(Integer roleId, Integer clumnId, Boolean isedit,
			String remark) {
		this.roleId = roleId;
		this.clumnId = clumnId;
		this.isedit = isedit;
		this.remark = remark;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}