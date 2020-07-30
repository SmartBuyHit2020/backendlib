package com.hit.sb.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;


public class CartVo implements Serializable {


		  
		  private int cid;
		  private int uid;
		  private int pid;
		  private int num;
		  private float price;
		  private String name;
		  private String image;
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
		public void setPrice(float price) {
			this.price = price;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
	
		  
}