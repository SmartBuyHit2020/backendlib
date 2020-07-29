package com.hit.sb.goods.service;

import com.hit.sb.goods.model.GoodsModel;
import com.hit.sb.goods.model.ItemModel;

import java.util.List;

public interface IItemService {
    //增加新商品类型
    public void add(ItemModel gm) throws Exception;
    //修改商品类型内容
    public void modify(ItemModel gm)throws Exception;
    //删除商品类型
    public  void delete(int id)throws Exception;
    //删除商品类型
    public  void deleteGoods(int id)throws Exception;
    //根据商品id查询该商品信息
    public  ItemModel getById(int id) throws Exception;


    //查询所有商品类型
    public List<ItemModel> getListByAll() throws Exception;
}
