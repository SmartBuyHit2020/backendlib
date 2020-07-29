package com.hit.sb.goods.controller;

import com.hit.sb.goods.model.GoodsModel;
import com.hit.sb.goods.service.IGoodsService;
import com.hit.sb.restresult.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/goods")
@CrossOrigin(origins = {"*", "null"})
public class GoodsController {
    @Autowired
    private IGoodsService ds=null;

    @PostMapping(value="/add")
    public Result<String> add(@RequestBody GoodsModel dm) throws Exception{
        ds.add(dm);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("增加商品成功!");
        return result;
    }
    @PostMapping(value="/modify")
    public Result<String> modify(@RequestBody GoodsModel dm) throws Exception{
        ds.modify(dm);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("修改商品成功!");
        return result;
    }
    @GetMapping(value="/delete")
    public Result<String> delete(@RequestParam(required=true) int id) throws Exception{
        ds.delete(id);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("删除商品成功!");
        return result;
    }
    //取得部门列表，
    @GetMapping(value="/list/all")
    public Result<GoodsModel> getListByAll() throws Exception{
        Result<GoodsModel> result= new Result<>();

        result.setList(ds.getListByAll());
        result.setStatus("OK");
        result.setMessage("取得商品列表分页方式成功!");
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
        result.setMessage("取得商品列表分页方式成功!");
        return result;
    }
    @GetMapping(value="/get")
    public Result<GoodsModel> getById(@RequestParam(required=true) int id) throws Exception{
        Result<GoodsModel> result=new Result<GoodsModel>();
        result.setResult(ds.getById(id));

        result.setStatus("OK");
        result.setMessage("取得指定商品成功!");
        return result;
    }
    @GetMapping(value="/list/all/itemid")
    public Result<GoodsModel> getListByItemid(@RequestParam(required=true) int itemid) throws Exception{
        Result<GoodsModel> result=new Result<GoodsModel>();
        result.setList(ds.getListByItemid(itemid));

        result.setStatus("OK");
        result.setMessage("取得指定分类商品成功!");
        return result;
    }

}
