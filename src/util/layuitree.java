package util;

import java.util.List;

public class layuitree {
	private Integer id;
	private Integer relationshipid;
	private String name;

	private Boolean spread = false;
	private String type;

	// private Boolean checked = false;
	private List<layuitree> children;

	public layuitree(Integer id, Integer relationshipid, String name,
			Boolean spread, String type, List<layuitree> children) {
		super();
		this.id = id;
		this.relationshipid = relationshipid;
		this.name = name;
		this.spread = spread;
		this.type = type;
		this.children = children;
	}

	public layuitree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRelationshipid() {
		return relationshipid;
	}

	public void setRelationshipid(Integer relationshipid) {
		this.relationshipid = relationshipid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public List<layuitree> getChildren() {
		return children;
	}

	public void setChildren(List<layuitree> children) {
		this.children = children;
	}

}
