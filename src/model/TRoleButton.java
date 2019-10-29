package model;

/**
 * TRoleButton entity. @author MyEclipse Persistence Tools
 */

public class TRoleButton implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleId;
	private Integer btnId;
	private Boolean isedit;

	// Constructors

	/** default constructor */
	public TRoleButton() {
	}

	/** full constructor */
	public TRoleButton(Integer roleId, Integer btnId, Boolean isedit) {
		this.roleId = roleId;
		this.btnId = btnId;
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

	public Integer getBtnId() {
		return this.btnId;
	}

	public void setBtnId(Integer btnId) {
		this.btnId = btnId;
	}

	public Boolean getIsedit() {
		return this.isedit;
	}

	public void setIsedit(Boolean isedit) {
		this.isedit = isedit;
	}

}