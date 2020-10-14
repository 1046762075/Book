package com.th.entity;

import java.util.List;

public class Tree {
	
	private Integer id ; 
	private String text ;
	private Integer father;
	private List<Tree> children;
	private Tree attributes;
	private boolean checked ;
	private String state ;
	private String url;
	private String iconCls;
	private String permissions;

	private String dd_id;
	public String getDd_id() {
		return dd_id;
	}
	public void setDd_id(String dd_id) {
		this.dd_id = dd_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getFather() {
		return father;
	}
	public void setFather(Integer father) {
		this.father = father;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	public Tree getAttributes() {
		return attributes;
	}
	public void setAttributes(Tree attributes) {
		this.attributes = attributes;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
}
