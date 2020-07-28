package com.hit.sb.goods.controller;

import com.hit.sb.goods.model.GoodsModel;
import com.hit.sb.goods.service.IGoodsService;
import com.hit.sb.restresult.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/goods")
public class GoodsController {
    @Autowired
    private IGoodsService ds=null;

    @PostMapping(value="/add")
    public Result<String> add(GoodsModel dm) throws Exception{
        ds.add(dm);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("增加用户成功!");
        return result;
    }
    @PostMapping(value="/modify")
    public Result<String> modify(GoodsModel dm) throws Exception{
        ds.modify(dm);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("修改用户成功!");
        return result;
    }
    @PostMapping(value="/delete")
    public Result<String> delete(GoodsModel dm) throws Exception{
        ds.delete(dm);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("删除用户成功!");
        return result;
    }
    //取得部门列表，分页模式
    @GetMapping(value="/list/all/page")
    public Result<GoodsModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows, @RequestParam(required=false,defaultValue="1") int page) throws Exception{
        Result<GoodsModel> result= new Result<>();
        result.setCount(ds.getCountByAll());
        //System.out.println(ds.getCountByAll());
        result.setPageCount(ds.getPageCountByAll(rows));
        //System.out.println(ds.getPageCountByAll(rows));
        result.setRows(rows);
        result.setPage(page);
        result.setList(ds.getListByAllWithPage(rows, page));
        result.setStatus("OK");
        result.setMessage("取得用户列表分页方式成功!");
        return result;
    }
    @GetMapping(value="/get")
    public Result<GoodsModel> getById(@RequestParam(required=true) int id) throws Exception{
        Result<GoodsModel> result=new Result<GoodsModel>();
        result.setResult(ds.getById(id));

        result.setStatus("OK");
        result.setMessage("取得指定用户对象成功!");
        return result;
    }

}
