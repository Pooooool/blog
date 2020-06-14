package mapper;

import java.util.List;
import pojo.ArticleView;
import pojo.ArticleViewExample;

public interface ArticleViewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleView record);

    int insertSelective(ArticleView record);

    List<ArticleView> selectByExample(ArticleViewExample example);

    ArticleView selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleView record);

    int updateByPrimaryKey(ArticleView record);
}