package blog.service;

import java.util.List;

import blog.pojo.SysView;
import blog.pojo.SysViewExample;

public interface SysViewService {
	 	void deleteByPrimaryKey(Long id);

	    void insertSelective(SysView record);

	    List<SysView> selectByExample(SysViewExample example);

	    SysView selectByPrimaryKey(Long id);

}
