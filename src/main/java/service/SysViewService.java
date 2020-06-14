package service;

import java.util.List;

import pojo.SysView;
import pojo.SysViewExample;

public interface SysViewService {
	 	void deleteByPrimaryKey(Long id);

	    void insertSelective(SysView record);

	    List<SysView> selectByExample(SysViewExample example);

	    SysView selectByPrimaryKey(Long id);

}
