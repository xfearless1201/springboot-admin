package com.cn.tianxia.admin.base.shiro;

import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName ShiroUser
 * @Description 认真用户信息
 * @author Hardy
 * @Date 2019年4月24日 下午2:31:06
 * @version 1.0.0
 */
public class ShiroUser implements Serializable {

	private static final long serialVersionUID = -8401918752041209440L;

	private Long id;

	private Integer cid;

	private Integer type;

	private final String loginName;

	private String name;

	private String roleName;

	private Set<String> urls;

	private Set<String> roles;
	
	private Byte userType;

	public ShiroUser(String loginName) {
		super();
		this.loginName = loginName;
	}

	public ShiroUser(Long id, Integer cid, Integer type, String loginName, String name, String roleName,
			Set<String> urls, Set<String> roles,Byte userType) {
		super();
		this.id = id;
		this.cid = cid;
		this.type = type;
		this.loginName = loginName;
		this.name = name;
		this.roleName = roleName;
		this.urls = urls;
		this.roles = roles;
		this.userType = userType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getUrls() {
		return urls;
	}

	public void setUrls(Set<String> urls) {
		this.urls = urls;
	}

	public String getLoginName() {
		return loginName;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Byte getUserType() {
		return userType;
	}

	public void setUserType(Byte userType) {
		this.userType = userType;
	}


}
