package com.cicada.entity;

import com.cicada.common.BaseEntity;

public class Dictionary extends BaseEntity{
	private String value;
	private String tag;
	private String type;
	private String description;
	private int sort;
	private String deleted;
	
	public Dictionary() {
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Dictionary [value=" + value + ", tag=" + tag + ", type=" + type + ", description=" + description
				+ ", sort=" + sort + ", deleted=" + deleted + "]";
	}
}
