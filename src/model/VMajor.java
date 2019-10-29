package model;

/**
 * VMajor entity. @author MyEclipse Persistence Tools
 */

public class VMajor implements java.io.Serializable {

	// Fields

	private Integer majorid;
	private String majorname;
	private Integer collegeid;
	private String collegename;

	// Constructors

	/** default constructor */
	public VMajor() {
	}

	/** full constructor */
	public VMajor(Integer majorid, String majorname, Integer collegeid,
			String collegename) {
		this.majorid = majorid;
		this.majorname = majorname;
		this.collegeid = collegeid;
		this.collegename = collegename;
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

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

}