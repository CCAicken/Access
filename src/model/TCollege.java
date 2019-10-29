package model;


/**
 * TCollege entity. @author MyEclipse Persistence Tools
 */

public class TCollege implements java.io.Serializable {

	// Fields

	private Integer collegeid;
	private String collegename;

	// Constructors

	/** default constructor */
	public TCollege() {
	}

	/** full constructor */
	public TCollege(String collegename) {
		this.collegename = collegename;
	}

	// Property accessors

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