package model;


/**
 * TMajor entity. @author MyEclipse Persistence Tools
 */

public class TMajor implements java.io.Serializable {

	// Fields

	private Integer majorid;
	private String majorname;
	private Integer collegeid;

	// Constructors

	/** default constructor */
	public TMajor() {
	}

	/** full constructor */
	public TMajor(String majorname, Integer collegeid) {
		this.majorname = majorname;
		this.collegeid = collegeid;
	}

	// Property accessors

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

}