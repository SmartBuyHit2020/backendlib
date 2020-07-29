package com.hit.sb.cart.service;

import com.hit.sb.cart.model.CartModel;
import com.hit.sb.hr.model.UserModel;
import com.hit.sb.vo.CartVo;
import java.util.List;

public interface ICartService {
	 /**
	   * 将商品添加到购物车
	   * @param uid 用户的id
	   * @param pid 商品的id
	   * @param amount 添加的商品数量
	 * @throws Exception 
	   */
	  void addToCart(int uid, int pid, int amount) throws Exception;
	  /**
	   * 查询购物车中的商品列表
	   * @param uid 用户的id
	 * @throws Exception 
	   */
	  List<CartVo> getByUid(int uid)throws Exception;
	  public void delete(CartModel cm) throws Exception;
	  public void clean(CartModel cm) throws Exception;
	  
}
