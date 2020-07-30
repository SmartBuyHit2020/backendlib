package com.hit.sb.goods.service.impl;

import com.hit.sb.goods.mapper.IGoodsMapper;
import com.hit.sb.goods.model.GoodsModel;
import com.hit.sb.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  //环绕事务Advice的切入点
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private IGoodsMapper goodsMappeer =null;


    @Override
    public void add(GoodsModel gm) throws Exception {
        goodsMappeer.insert(gm);
    }

    @Override
    public void modify(GoodsModel gm) throws Exception {
       goodsMappeer.update(gm);
    }

    @Override
    public void delete(int id) throws Exception {
        goodsMappeer.delete(id);
    }

    @Override
    public GoodsModel getById(int id) throws Exception {
        return  goodsMappeer.selectById(id);
    }


    @Override
    public List<GoodsModel> getListByAll() throws Exception {
        return  goodsMappeer.selectByAll();
    }

    @Override
    public List<GoodsModel> getListByAllWithPage(int rows, int page) throws Exception {
        return goodsMappeer.selectByAllWithPage(rows*(page-1), rows);
    }

    @Override
    public List<GoodsModel> getListByItemWithPage(int rows, int page, int itemid) throws Exception {
        return goodsMappeer.selectByItemWithPage(rows*(page-1), rows,itemid);
    }

    @Override
    public int getCountByAll() throws Exception {
        return   goodsMappeer.selectCountByAll();
    }

    @Override
    public int getPageCountByAll(int rows) throws Exception {
        int count=this.getCountByAll();
        int pageCount=0;
        if(count%rows==0) {
            pageCount=count/rows;
        }
        else {
            pageCount=count/rows+1;
        }
        return pageCount;
    }

    @Override
    public int getCountByItem(int itemid) throws Exception {
        return   goodsMappeer.selectCountByItem(itemid);

    }

    @Override
    public int getPageCountByItem(int rows,int itemid) throws Exception {
        int count=this.getCountByItem(itemid);
        int pageCount=0;
        if(count%rows==0) {
            pageCount=count/rows;
        }
        else {
            pageCount=count/rows+1;
        }
        return pageCount;
    }

    @Override
    public List<GoodsModel> getListById() throws Exception {
        return null;
    }


    @Override
    public List<GoodsModel> getListByItemid(int itemid) throws Exception {
        return goodsMappeer.selectByItemid(itemid);
    }


}
