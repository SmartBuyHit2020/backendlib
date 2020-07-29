package com.hit.sb.order.service;

import com.hit.sb.order.model.OrderModel;

public interface IOrderService {
	//增加新订单
    public int add(OrderModel om) throws Exception;
    //修改订单内容
    public void modify(OrderModel om)throws Exception;
    //删除订单
    public  void delete(OrderModel om)throws Exception;
    //根据订单id查询订单信息
    public  OrderModel getByID(int id);
   
}
