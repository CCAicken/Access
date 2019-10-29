package model;

/**
 * TClass entity. @author MyEclipse Persistence Tools
 */

public class TClass implements java.io.Serializable {

	// Fields

	private Integer classid;
	private String classname;
	private Integer majorid;

	// Constructors

	/** default constructor */
	public TClass() {
	}

	/** full constructor */
	public TClass(String classname, Integer majorid) {
		this.classname = classname;
		this.majorid = majorid;
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

}