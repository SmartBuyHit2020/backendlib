package com.hit.sb.order.controller;

import com.hit.sb.order.model.OrderModel;
import com.hit.sb.order.service.IOrderService;
import com.hit.sb.restresult.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/order")
@CrossOrigin(origins = {"*", "null"})
public class Ordercontroller {
	 @Autowired
	    private IOrderService ds=null;

	    @PostMapping(value="/add")
	    public Result<String> add(OrderModel om) throws Exception{
	        ds.add(om);
	        Result<String> result=new Result<String>();
	        result.setStatus("OK");
	        result.setMessage("增加订单成功!");
	        return result;
	    }
	    @PostMapping(value="/modify")
	    public Result<String> modify(OrderModel om) throws Exception{
	        ds.modify(om);
	        Result<String> result=new Result<String>();
	        result.setStatus("OK");
	        result.setMessage("修改订单成功!");
	        return result;
	    }
	    @PostMapping(value="/delete")
	    public Result<String> delete(OrderModel om) throws Exception{
	        ds.delete(om);
	        Result<String> result=new Result<String>();
	        result.setStatus("OK");
	        result.setMessage("删除订单成功!");
	        return result;
	    }
	    @GetMapping(value="/get")
	    public Result<OrderModel> getByID(@RequestParam(required=true) int id) throws Exception{
	        Result<OrderModel> result=new Result<OrderModel>();
	        result.setResult(ds.getByID(id));
	        result.setStatus("OK");
	        result.setMessage("老子取得指定订单！!");
	        return result;
	    }
	
}
