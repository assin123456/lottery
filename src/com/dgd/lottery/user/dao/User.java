package com.dgd.lottery.user.dao;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * 
 * @author Administrator
 * 
 * @version
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 6307583128420681723L;
	// 用户id
	private Long userid;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 用户真实姓名
	private String fullname;
	// 用户手机号
	private String mobile;
	
	private User user;
	
	private Date time;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", mobile=" + mobile + "]";
	}
}
