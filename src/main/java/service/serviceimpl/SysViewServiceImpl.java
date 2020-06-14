package service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.SysViewMapper;
import pojo.SysView;
import pojo.SysViewExample;
import service.SysViewService;
@Service
public class SysViewServiceImpl implements SysViewService{
	@Autowired
	SysViewMapper sysviewmapper;
	
	@Override
	public void deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		sysviewmapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void insertSelective(SysView record) {
		// TODO Auto-generated method stub
		sysviewmapper.insertSelective(record);
	}
	
	@Override
	public List<SysView> selectByExample(SysViewExample example) {
		List<SysView> sysViews = sysviewmapper.selectByExample(example);
		return sysViews;
	}
	
	@Override
	public SysView selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		SysView sysView = sysviewmapper.selectByPrimaryKey(id);
		return sysView;
	}
	
}
