package com.cicada.common;
//菜单树dto用于向页面传输数据
public class MenuTreeDto {
	private int id;
	private int pId;
	private String name;
	Boolean open=true;
	Boolean checked=false;
	public MenuTreeDto() {
		
	}
	public MenuTreeDto(int id, int pId, String name, Boolean open, Boolean checked) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.checked = checked;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPId() {
		return pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
}
