package com.hit.sb.cart.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;


@Alias("cart")
public class CartModel implements Serializable {
		private int cid;
		private int uid;
		private int pid;
		private int num;
		private float price;
		private Date createdtime;
		private Date modifiedtime;
	  
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float d) {
		this.price = d;
	}
	public Date getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	public Date getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	
}
