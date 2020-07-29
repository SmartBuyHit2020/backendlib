package com.hit.sb.order.service.impl;

import com.hit.sb.order.mapper.IOrderMapper;
import com.hit.sb.order.model.OrderModel;
import com.hit.sb.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional  //环绕事务Advice的切入点
public class OrderServiceImpl implements IOrderService{
	@Autowired
    private IOrderMapper orderMappeer = null;
    @Override
    public int add(OrderModel om) throws Exception {
        orderMappeer.insert(om);
        return om.getId();
    }
    @Override
    public void modify(OrderModel om) throws Exception {
       orderMappeer.update(om);
    }
    @Override
    public void delete(OrderModel om) throws Exception {
        orderMappeer.delete(om);
    }
    @Override
    public OrderModel getByID(int id) {
        return  orderMappeer.selectByID(id);
    }
    
}
