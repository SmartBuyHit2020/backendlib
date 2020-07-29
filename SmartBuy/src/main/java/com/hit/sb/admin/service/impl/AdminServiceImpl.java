package com.hit.sb.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.sb.admin.mapper.IAdminMapper;
import com.hit.sb.admin.model.AdminModel;
import com.hit.sb.admin.service.IAdminService;
//管理员业务实现类，使用Spring集成MyBatis方式实现
@Service
@Transactional  //环绕事务Advice的切入点
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminMapper userMapper=null;
	@Override
	public AdminModel getById(String id) throws Exception {
		return userMapper.getById(id);
	}

	@Override
	public boolean validate(String id, String password) throws Exception {
		AdminModel um=userMapper.getById(id);
		if(um!=null&&um.getPassword()!=null&&um.getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void changePassword(String id, String password) throws Exception {
		AdminModel um=userMapper.getById(id);
		um.setPassword(password);
		userMapper.update(um);
	}

}
