package blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import blog.pojo.ArticleInfo;
import blog.pojo.ArticleInfoExample;
public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    List<ArticleInfo> selectByExample(ArticleInfoExample example);

    ArticleInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);
}