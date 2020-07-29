package com.hit.sb.goods.service;

import com.hit.sb.goods.model.GoodsModel;

import java.util.List;

public interface IGoodsService {
    //增加新商品
    public void add(GoodsModel gm) throws Exception;
    //修改商品内容
    public void modify(GoodsModel gm)throws Exception;
    //删除商品
    public  void delete(GoodsModel gm)throws Exception;
    //根据商品id查询该商品信息
    public  GoodsModel getById(int id);
    //根据商品分类查询某类别的全部商品
   // public List<GoodsModel> getByItemide(int itemid)throws Exception;
    //查询所有商品
    public List<GoodsModel> getListByAll() throws Exception;
    //取得所有用户列表,分页模式
    public List<GoodsModel> getListByAllWithPage(int rows, int page) throws Exception;
    public int getCountByAll() throws Exception;
    //取得商品的显示页数
    public int getPageCountByAll(int rows) throws Exception;
    //查询所有商品
    public List<GoodsModel> getListById() throws Exception;
    //查询所有分类商品
    public  List<GoodsModel> getListByItemid(int itemid) throws Exception;
    //取得分类商品的个数
    //public int getItemCountByAll(int rows,int itemid) throws Exception;
    //取得分类商品的显示页数
   // public int getItemPageCountByAll(int rows) throws Exception;
}
