package com.hit.sb.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hit.sb.admin.model.AdminModel;
//管理员DAO层Mapper接口
@Mapper
public interface IAdminMapper {
	public void update(AdminModel um) throws Exception;
	//通过ID取得管理员对象
	public AdminModel getById(String id) throws Exception;
}
