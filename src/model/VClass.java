package model;

/**
 * VClass entity. @author MyEclipse Persistence Tools
 */

public class VClass implements java.io.Serializable {

	// Fields

	private Integer classid;
	private String classname;
	private Integer majorid;
	private String majorname;
	private Integer collegeid;
	private String collegename;

	// Constructors

	/** default constructor */
	public VClass() {
	}

	/** full constructor */
	public VClass(Integer classid, String classname, Integer majorid,
			String majorname, Integer collegeid, String collegename) {
		this.classid = classid;
		this.classname = classname;
		this.majorid = majorid;
		this.majorname = majorname;
		this.collegeid = collegeid;
		this.collegename = collegename;
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

}