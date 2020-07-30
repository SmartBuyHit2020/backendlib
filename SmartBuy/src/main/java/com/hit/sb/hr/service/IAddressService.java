package com.hit.sb.hr.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hit.sb.hr.model.AddressModel;



public interface IAddressService {
	
	//增加地址
		public void add(AddressModel am) throws Exception;
		//修改地址
		public void modify(AddressModel am) throws Exception;
		//删除地址
		public void delete(AddressModel am) throws Exception;
		//取得指定的地址对象,不取关联的用户
		public AddressModel getById(String id) throws Exception;
		//取得指定的地址对象,取关联的用户
		public AddressModel getByIdWithUser(String id) throws Exception;
		
		//取得收货地址的个数
		public int getCountByAll() throws Exception;
		//取得收货地址的显示页数
		public int getPageCountByAll(int rows) throws Exception;
		
		public List<AddressModel> selectListByAllWithPageWithUser(@Param("start") int start,@Param("rows") int rows) throws Exception;


}
