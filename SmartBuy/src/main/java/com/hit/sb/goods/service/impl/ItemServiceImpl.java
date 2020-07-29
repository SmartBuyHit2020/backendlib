package com.hit.sb.goods.service.impl;

import com.hit.sb.goods.mapper.IGoodsMapper;
import com.hit.sb.goods.mapper.IItemMapper;
import com.hit.sb.goods.model.ItemModel;
import com.hit.sb.goods.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional  //环绕事务Advice的切入点
public class ItemServiceImpl implements IItemService {
    @Autowired
    private IItemMapper itemMapper =null;

    @Override
    public void add(ItemModel gm) throws Exception {
        itemMapper.insert(gm);
    }

    @Override
    public void modify(ItemModel gm) throws Exception {
        itemMapper.update(gm);
    }

    @Override
    public void delete(int id) throws Exception {
         itemMapper.delete(id);
    }

    @Override
    public void deleteGoods(int id) throws Exception {
        itemMapper.deleteGoods(id);
    }

    @Override
    public ItemModel getById(int id) throws Exception {
        return itemMapper.selectById(id);
    }

    @Override
    public List<ItemModel> getListByAll() throws Exception {
        return itemMapper.selectByAll();
    }
}
