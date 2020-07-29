package com.hit.sb.goods.mapper;


import com.hit.sb.goods.model.ItemModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IItemMapper {
    //增加新商品
    public void insert(ItemModel gm) throws Exception;
    //修改商品内容
    public void update(ItemModel gm)throws Exception;
    //删除商品
    public  void delete(int id)throws Exception;
    //删除商品
    public  void deleteGoods(int id)throws Exception;
    //根据商品id查询该商品信息
    public ItemModel selectById(int id)throws Exception;
    //查询所有商品
    public List<ItemModel> selectByAll() throws Exception;
}
