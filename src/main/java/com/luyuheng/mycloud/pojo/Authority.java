package com.luyuheng.mycloud.pojo;

/**
 * @author xuhu2
 *
 * @version 1.0
 * 
 * @description 权限菜单类
 *
 */

public class Authority{

    //菜单编号
	private String id;
	
	//菜单名称
	private String name;
	
	//菜单类型
	private String type;
	
	//菜单父级菜单编号
	private String parentId;
	
	//菜单级别
	private Integer level;
	
	//菜单序号
	private Integer sort;
	
	//菜单备注信息
	private String remark;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Authority [id=" + id + ", name=" + name + ", parentId=" + parentId + ", level=" + level + ", sort="
				+ sort + ", remark=" + remark + "]";
	}
	
	
}
