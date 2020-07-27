package com.hit.sb.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.sb.hr.model.UserModel;
import com.hit.sb.hr.service.IUserService;
import com.hit.sb.restresult.Result;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private IUserService ds=null;
		
	@PostMapping(value="/add")
	public Result<String> add(UserModel dm) throws Exception{
		ds.add(dm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加用户成功!");
		return result;
	}
	@PostMapping(value="/modify")
	public Result<String> modify(UserModel dm) throws Exception{
		ds.modify(dm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改用户成功!");
		return result;
	}
	@PostMapping(value="/delete")
	public Result<String> delete(UserModel dm) throws Exception{
		ds.delete(dm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除用户成功!");
		return result;
	}
	//取得部门列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<UserModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<UserModel> result=new Result<UserModel>();
		result.setCount(ds.getCountByAll());
		result.setPageCount(ds.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(ds.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得用户列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<UserModel> getByNo(@RequestParam(required=true) int no) throws Exception{
		Result<UserModel> result=new Result<UserModel>();
		result.setResult(ds.getByNo(no));
		
		result.setStatus("OK");
		result.setMessage("取得指定用户对象成功!");
		return result;
	}
	

}
