package model;

/**
 * TButton entity. @author MyEclipse Persistence Tools
 */

public class TButton implements java.io.Serializable {

	// Fields

	private Integer id;
	private String domId;
	private String name;
	private String script;
	private String icon;
	private String btnclass;
	private String remark;
	private Integer sort;
	private Integer sysModelId;

	// Constructors

	/** default constructor */
	public TButton() {
	}

	/** minimal constructor */
	public TButton(String domId, String name, String script, String btnclass,
			Integer sort, Integer sysModelId) {
		this.domId = domId;
		this.name = name;
		this.script = script;
		this.btnclass = btnclass;
		this.sort = sort;
		this.sysModelId = sysModelId;
	}

	/** full constructor */
	public TButton(String domId, String name, String script, String icon,
			String btnclass, String remark, Integer sort, Integer sysModelId) {
		this.domId = domId;
		this.name = name;
		this.script = script;
		this.icon = icon;
		this.btnclass = btnclass;
		this.remark = remark;
		this.sort = sort;
		this.sysModelId = sysModelId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDomId() {
		return this.domId;
	}

	public void setDomId(String domId) {
		this.domId = domId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSysModelId() {
		return this.sysModelId;
	}

	public void setSysModelId(Integer sysModelId) {
		this.sysModelId = sysModelId;
	}

}