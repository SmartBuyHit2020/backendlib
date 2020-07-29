package com.hit.sb.cart.service.impl;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.sb.cart.mapper.ICartMapper;
import com.hit.sb.cart.model.CartModel;
import com.hit.sb.cart.service.ICartService;
import com.hit.sb.goods.service.impl.GoodsServiceImpl;
import com.hit.sb.vo.CartVo;

@Service
@Transactional  //环绕事务Advice的切入点
public class CartServiceImpl implements ICartService {

	@Autowired 
	  private ICartMapper cartMapper=null;
	@Override
	public void addToCart(int uid, int pid, int amount) throws Exception {
		Date now = new Date();
	    // 调用findByUidAndPid()查询购物车详情
	    CartModel result = findByUidAndPid(uid, pid);
	    // 判断查询结果是否为null
	    if (result == null) {
	      // 是：表示该用户的购物车没有该商品，则需要执行insert操作
	      // -- 调用productService.getById()得到商品详情，该数据中包含商品价格
	    	GoodsServiceImpl product = new GoodsServiceImpl();
	      // -- 创建新的Cart对象
	      CartModel cart = new CartModel();
	      // -- 补全Cart对象的属性：uid > 参数uid
	      cart.setUid(uid);
	      // -- 补全Cart对象的属性：pid > 参数pid
	      cart.setPid(pid);
	      // -- 补全Cart对象的属性：num > 参数amount
	      cart.setNum(amount);
	      // -- 补全Cart对象的属性：price > 以上查询到的商品详情中包含价格
	      cart.setPrice(product.getById(pid).getPrice());
	      //cart.setPrice(9.9);//测试用，实际要取商品表价格
	      cart.setCreatedtime(now);
	      cart.setModifiedtime(now);

	      // -- 调用insert()插入数据
	      add(cart);
	    } else {
	      // 否：表示该用户的购物车已有该商品，则需要执行update操作增加数量
	      // -- 从查询结果中获取cid
	      Integer cid = result.getCid();
	      // -- 从查询结果中取出原有数量，与参数amount相加，得到新的数量
	      Integer num =  amount;
	      // -- 调用updateNumByCid()执行修改数量
	      modifyNumByCid(cid, num, now);
	    }
	

	}
	/**
	   * 查询购物车中的商品列表
	   * @param uid 用户的id
	 * @throws Exception 
	   */
	@Override
	public List<CartVo> getByUid(int uid) throws Exception {
		
		return findByUid(uid);
	}
	  /**
	   * 插入购物车数据
	   * 
	   * @param cart 购物车数据
	 * @throws Exception 
	   */
	  private void add(CartModel cart) throws Exception {
	    int rows = cartMapper.insert(cart);
	    if (rows != 1) {
	      throw new Exception("创建购物车数据失败！插入购物车数据时出现未知错误，请联系系统管理员！");
	    }
	  }
	  private void modifyNumByCid(int cid, int num, Date modifiedTime) throws Exception {
		    int rows = cartMapper.update(cid, num,  modifiedTime);
		    if (rows != 1) {
		      throw new Exception("修改商品数量失败！更新购物车数据时出现未知错误，请联系系统管理员！");
		    }
		  }
	  
	  private CartModel findByUidAndPid(Integer uid, Integer pid) throws Exception {
		    return cartMapper.selectById(uid, pid);
		  }
	  private List<CartVo> findByUid(Integer uid) {
		    return cartMapper.findByUid(uid);
		  }
	@Override
	public void delete(CartModel cm) throws Exception {
		cartMapper.delete(cm);
		
	}
	@Override
	public void clean(CartModel cm) throws Exception {
		cartMapper.clean(cm);
		
	}
	
		
	
}
