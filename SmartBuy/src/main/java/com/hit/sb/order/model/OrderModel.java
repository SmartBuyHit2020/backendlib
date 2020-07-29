package com.hit.sb.order.model;

import org.apache.ibatis.type.Alias;
import java.io.Serializable;

@Alias("Order")
@SuppressWarnings("serial")
public class OrderModel implements Serializable{
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getTimeOfOccur() {
		return timeOfOccur;
	}
	public void setTimeOfOccur(String timeOfOccur) {
		this.timeOfOccur = timeOfOccur;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	private int id;
	private int goodsNumber;
	private int totalMoney;
	private String timeOfOccur;
	private int UserID;
	
	
	
	
}
