package com.hit.sb.cart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hit.sb.cart.service.ICartService;
import com.hit.sb.controller.BaseController;
import com.hit.sb.restresult.Result;

@RestController
@RequestMapping(value="/carts")
@CrossOrigin(origins = {"*", "null"})
public class CartController extends BaseController{
	@Autowired
	  private ICartService cartService;
	@PostMapping("/add")
	  public Result<String> add(Integer pid, Integer amount, HttpSession session) throws Exception {
		Result<String> result=new Result<String>();
	    // 从Session中获取uid
	    //int uid = getUidFromSession(session);
	    // 调用业务方法执行功能
	    cartService.addToCart(0, pid, amount);
	    // 响应成功
	    return result;
	  }
	  
}

