package com.hit.sb.goods.mapper;

import com.hit.sb.goods.model.GoodsModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IGoodsMapper {
    //增加新商品
    public void insert(GoodsModel gm) throws Exception;
    //修改商品内容
    public void update(GoodsModel gm)throws Exception;
    //删除商品
    public  void delete(GoodsModel gm)throws Exception;
    //根据商品id查询该商品信息
    public GoodsModel selectById(int id);
    //查询所有商品
    public List<GoodsModel> selectByAll() throws Exception;
    //取得商品的个数
    public int selectCountByAll() throws Exception;
    //取得商品的显示页数
    public List<GoodsModel> selectByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;
    //取得分类商品的个数


}
