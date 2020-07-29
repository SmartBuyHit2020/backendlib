package com.hit.sb.hr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
//送货地址的Model类
@Alias("Address")
public class AddressModel implements Serializable{
	
	private String id=null;
	private String province=null;
	private String city=null;
	private String detail=null;
	//关联的用户对象
	private UserModel user=null;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	

}
