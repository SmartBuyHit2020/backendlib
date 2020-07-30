
package com.hit.sb.cart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.sb.cart.model.CartModel;
import com.hit.sb.cart.service.ICartService;
import com.hit.sb.controller.BaseController;
import com.hit.sb.goods.model.GoodsModel;
import com.hit.sb.restresult.Result;
import com.hit.sb.vo.CartVo;
import java.util.List;


@RestController
@RequestMapping(value="/carts")
@CrossOrigin(origins = {"*", "null"})
public class CartController extends BaseController{
	@Autowired
	  private ICartService cartService;
	@GetMapping("/add")
	  public Result<String> add(Integer pid, Integer amount, HttpSession session) throws Exception {
		Result<String> result=new Result<String>();
	    // 从Session中获取uid
	    //int uid = getUidFromSession(session);
	    // 调用业务方法执行功能
	    cartService.addToCart(0, pid, amount);
	    
	    result.setStatus("OK");
        result.setMessage("加入购物车成功!");
	    // 响应成功
	    return result;
	  }
	
	@GetMapping("/list")
	public Result<CartVo> getByUid(int uid) throws Exception {
	  // 从Session中获取uid
	  // 执行查询，获取数据
	  // 返回成功与数据
		Result<CartVo> result= new Result<>();
		//int uid = getUidFromSession(session);
		// uid =0;//测试用，后面能获取httpsession后换成uid
		result.setList(cartService.getByUid(uid));
		result.setStatus("OK");
        result.setMessage("获取购物车列表成功!");
		return result;
	}
	@GetMapping(value="/delete")
    public Result<String> delete( int uid,int pid) throws Exception{
        cartService.delete(uid,pid);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("删除条目成功!");
        return result;
    }
	@GetMapping(value="/clean")
    public Result<String> clean(int uid) throws Exception{
        cartService.clean(uid);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("清空用户购物车成功!");
        return result;
    }
	  
}

