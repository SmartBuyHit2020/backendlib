package com.hit.sb.goods.controller;

import com.hit.sb.goods.model.GoodsModel;
import com.hit.sb.goods.model.ItemModel;
import com.hit.sb.goods.service.IGoodsService;
import com.hit.sb.goods.service.IItemService;
import com.hit.sb.restresult.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/item")
@CrossOrigin(origins = {"*", "null"})
public class ItemController {
    @Autowired
    private IItemService ds=null;
    @PostMapping(value="/add")
    public Result<String> add(@RequestBody ItemModel dm) throws Exception{
        ds.add(dm);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("增加商品类型成功!");
        return result;
    }
    @PostMapping(value="/modify")
    public Result<String> modify(@RequestBody ItemModel dm) throws Exception{
        ds.modify(dm);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("修改商品类型成功!");
        return result;
    }
    @GetMapping(value="/delete")
    public Result<String> delete(@RequestParam(required=true) int id) throws Exception{
        ds.delete(id);
        ds.deleteGoods(id);
        Result<String> result=new Result<String>();
        result.setStatus("OK");
        result.setMessage("删除商品类型成功!");
        return result;
    }
    //取得商品类型列表，
    @GetMapping(value="/list/all")
    public Result<ItemModel> getListByAll() throws Exception{
        Result<ItemModel> result= new Result<>();

        result.setList(ds.getListByAll());
        result.setStatus("OK");
        result.setMessage("取得商品列表分页方式成功!");
        return result;
    }
    @GetMapping(value="/get")
    public Result<ItemModel> getById(@RequestParam(required=true) int id) throws Exception{
        Result<ItemModel> result=new Result<ItemModel>();
        result.setResult(ds.getById(id));

        result.setStatus("OK");
        result.setMessage("取得指定商品类型成功!");
        return result;
    }

}
