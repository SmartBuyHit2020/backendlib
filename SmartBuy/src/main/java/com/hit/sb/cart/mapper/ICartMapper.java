package com.hit.sb.cart.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.sb.cart.model.CartModel;

@Mapper
public interface ICartMapper {
	
		//增加购物车中的商品
		public int insert(CartModel cm) throws Exception;
		//修改购物车中商品的数量
		public int update(	@Param("cid") int cid, 
							@Param("num") int num,
							@Param("modifiedtime") Date modifiedtime
							) throws Exception;
		//删除购物车中的物品
		public void delete(CartModel cm) throws Exception;
		//取得购物车中所有的商品列表
		public List<CartModel> selectByAll() throws Exception;
		//根据用户的id和商品的id查询购物车条目
		public CartModel selectById(@Param("uid") int uid,@Param("pid") int pid) throws Exception;
		
	
}
