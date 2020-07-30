package com.hit.sb.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.sb.hr.mapper.IAddressMapper;
import com.hit.sb.hr.model.AddressModel;
import com.hit.sb.hr.service.IAddressService;

@Service
@Transactional  //环绕事务Advice的切入点
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressMapper addressMapper=null;
	
	@Override
	public void add(AddressModel am) throws Exception {
		
		addressMapper.insert(am);

	}

	@Override
	public void modify(AddressModel am) throws Exception {
		addressMapper.update(am);

	}

	@Override
	public void delete(AddressModel am) throws Exception {
		addressMapper.delete(am);

	}

	@Override
	public AddressModel getById(String id) throws Exception {
		
		return addressMapper.selectById(id);
	}

	@Override
	public AddressModel getByIdWithUser(String id) throws Exception {
		return addressMapper.selectByIdWithUser(id);
	}

	@Override
	public List<AddressModel> selectListByAllWithPageWithUser(int start, int rows) throws Exception {
		
		return addressMapper.selectListByAllWithPageWithUser(start, rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return addressMapper.selectCountByAll();
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

}
