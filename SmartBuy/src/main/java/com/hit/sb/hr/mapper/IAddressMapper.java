package com.hit.sb.hr.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.sb.hr.model.AddressModel;





@Mapper
public interface IAddressMapper {

	    //增加收货地址
		public void insert(AddressModel am) throws Exception;
		//修改收货地址
		public void update(AddressModel am) throws Exception;
		//删除收货地址
		public void delete(AddressModel am) throws Exception;
		//取得指定的地址对象,不取关联的用户
		public AddressModel selectById(String id) throws Exception;
		//取得指定的地址对象,取关联的用户
		public AddressModel selectByIdWithUser(String id) throws Exception;
		
		public int selectCountByAll() throws Exception;
		
		//取得所有地址列表，取关联的用户, 分页模式
		public List<AddressModel> selectListByAllWithPageWithUser(@Param("start") int start,@Param("rows") int rows) throws Exception;
	
	
		

		
}
