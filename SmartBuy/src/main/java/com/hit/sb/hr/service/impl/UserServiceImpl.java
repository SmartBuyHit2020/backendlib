package com.hit.sb.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.sb.hr.mapper.IUserMapper;
import com.hit.sb.hr.model.UserModel;
import com.hit.sb.hr.service.IUserService;

@Service
@Transactional  //环绕事务Advice的切入点
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserMapper userMapper=null;
	@Override
	public int add(UserModel dm) throws Exception {
		userMapper.insert(dm);
		return dm.getNo();
	}

	@Override
	public void modify(UserModel dm) throws Exception {
		userMapper.update(dm);
	}

	@Override
	public void delete(UserModel dm) throws Exception {
		userMapper.delete(dm);
	}

	@Override
	public List<UserModel> getListByAll() throws Exception {
		
		return userMapper.selectByAll();
	}

	@Override
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return userMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return userMapper.selectCountByAll();
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

	@Override
	public UserModel getByNo(int no) throws Exception {
		
		return userMapper.selectByNo(no);
	}

}
