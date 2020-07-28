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
    public void delete(GoodsModel gm) throws Exception {
        goodsMappeer.delete(gm);
    }

    @Override
    public GoodsModel getById(int id) {
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




}
