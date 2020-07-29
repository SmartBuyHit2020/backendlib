package com.hit.sb.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.sb.hr.model.AddressModel;
import com.hit.sb.hr.service.IAddressService;
import com.hit.sb.restresult.Result;

@RestController
@RequestMapping(value="/address")
@CrossOrigin(origins = {"*", "null"})
public class AddressController {

	@Autowired
	private IAddressService ds=null;
		
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody AddressModel am) throws Exception{
		ds.add(am);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加收货地址成功!");
		return result;
	}
	@PostMapping(value="/modify")
	public Result<String> modify(@RequestBody AddressModel am) throws Exception{
		ds.modify(am);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改收货地址成功!");
		return result;
	}
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody AddressModel am) throws Exception{
		ds.delete(am);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除收货地址成功!");
		return result;
	}
	//取得部门列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<AddressModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<AddressModel> result=new Result<AddressModel>();
		result.setCount(ds.getCountByAll());
		result.setPageCount(ds.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(ds.selectListByAllWithPageWithUser(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得收货地址列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<AddressModel> getByNo(@RequestParam(required=true) String id) throws Exception{
		Result<AddressModel> result=new Result<AddressModel>();
		result.setResult(ds.getById(id));
		
		result.setStatus("OK");
		result.setMessage("取得指定收货地址对象成功!");
		return result;
	}
	
}
