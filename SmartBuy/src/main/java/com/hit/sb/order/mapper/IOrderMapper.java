package com.hit.sb.order.mapper;

import com.hit.sb.order.model.OrderModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOrderMapper {
	//增加新订单
	public void insert(OrderModel om) throws Exception;
	//修改订单内容
	public void update(OrderModel om)throws Exception;
	//删除订单
	public  void delete(OrderModel om)throws Exception;
	//根据订单号查询订单信息
	public OrderModel selectByID(int id);
	
}
