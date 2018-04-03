package com.cicada.entity;

import java.util.Date;
import java.util.List;

import com.cicada.common.BaseEntity;

public class Menu extends BaseEntity {
	private String parent_menu;
	private String parent_menu_ids;
	private String name;
	private Double sort;
	private String link_address;
	private String aim_window;
	private String icon;
	private String view;
	private String code;
	private String founder;
	private Date creation_time;
	private String updater;
	private Date update_time;
	private String description;
	private String deleted;
	private List<Menu> menus;
	

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSort() {
		return sort;
	}

	public void setSort(Double sort) {
		this.sort = sort;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getParent_menu() {
		return parent_menu;
	}

	public void setParent_menu(String parent_menu) {
		this.parent_menu = parent_menu;
	}

	public String getParent_menu_ids() {
		return parent_menu_ids;
	}

	public void setParent_menu_ids(String parent_menu_ids) {
		this.parent_menu_ids = parent_menu_ids;
	}

	public String getLink_address() {
		return link_address;
	}

	public void setLink_address(String link_address) {
		this.link_address = link_address;
	}

	public String getAim_window() {
		return aim_window;
	}

	public void setAim_window(String aim_window) {
		this.aim_window = aim_window;
	}

	public Date getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

}
