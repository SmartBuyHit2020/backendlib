package com.hit.sb.cart.service;

public interface ICartService {
	 /**
	   * 将商品添加到购物车
	   * @param uid 用户的id
	   * @param pid 商品的id
	   * @param amount 添加的商品数量
	 * @throws Exception 
	   */
	  void addToCart(int uid, int pid, int amount) throws Exception;
	  
}
