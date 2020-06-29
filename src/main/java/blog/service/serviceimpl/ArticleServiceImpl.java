package blog.service.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.dto.ArticleDto;
import blog.mapper.ArticleContentMapper;
import blog.mapper.ArticleInfoMapper;
import blog.pojo.ArticleContent;
import blog.pojo.ArticleContentExample;
import blog.pojo.ArticleInfo;
import blog.pojo.ArticleInfoExample;
import blog.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	ArticleContentMapper articlecontentmapper;
	@Autowired
	ArticleInfoMapper articleinfomapper;
	
	@Override
	public void addArticle(ArticleDto articleDto) {
		// ArticleInfo
	ArticleInfo articleInfo = new ArticleInfo();
	articleInfo.setCategory(articleDto.getCategory());
	articleInfo.setTitle(articleDto.getTitle());
	articleInfo.setIs_top(articleDto.getIs_top());
	articleInfo.setImage_path(articleDto.getImage_path());
	articleinfomapper.insert(articleInfo);
	//ArticleContent
	ArticleContent articleContent = new ArticleContent();
	articleContent.setContent(articleDto.getContent());
	articleContent.setArticle_id(getLatestArticleId());
	articlecontentmapper.insert(articleContent);
	}
	
	@Override
	public void deleteArticle(Long id) {
		// TODO Auto-generated method stub
		ArticleContent articleContent = articlecontentmapper.selectByPrimaryKey(id);
		Long ArticleInfoId = articleContent.getArticle_id();
		articleinfomapper.deleteByPrimaryKey(ArticleInfoId);
		articlecontentmapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public List<ArticleDto> selectArticle() {
		// TODO Auto-generated method stub
		List<ArticleDto> articleDtos = new ArrayList<ArticleDto>();
		ArticleDto articleDto = new ArticleDto();
		ArticleContentExample articleContentExample = new ArticleContentExample();
		articleContentExample.setOrderByClause("id asc");
		List<ArticleContent> articleContents = articlecontentmapper.selectByExampleWithBLOBs(articleContentExample);
		//检索的字段中包含大字段类型时，必须用selectByExampleWithBLOBs，不检索大字段时，用selectByExample就足够了。update同样如此。
		for (ArticleContent articleContent : articleContents) {
			articleDto.setId(articleContent.getId());
			articleDto.setContent(articleContent.getContent());
			ArticleInfo articleInfo = articleinfomapper.selectByPrimaryKey(articleContent.getArticle_id());
			articleDto.setArticle_id(articleContent.getArticle_id());
			articleDto.setCategory(articleInfo.getCategory());
			articleDto.setImage_path(articleInfo.getImage_path());
			articleDto.setIs_top(articleInfo.getIs_top());
			articleDto.setTitle(articleInfo.getTitle());
			articleDtos.add(articleDto);
		}
		return articleDtos;
	}
	@Override
	public ArticleDto selectOneById(Long id) {
		// TODO Auto-generated method stub
		ArticleDto articleDto = new ArticleDto();
		ArticleContent articleContent = articlecontentmapper.selectByPrimaryKey(id);
		ArticleInfo articleInfo = articleinfomapper.selectByPrimaryKey(articleContent.getArticle_id());
		articleDto.setArticle_id(articleContent.getArticle_id());
		articleDto.setCategory(articleInfo.getCategory());
		articleDto.setContent(articleContent.getContent());
		articleDto.setImage_path(articleInfo.getImage_path());
		articleDto.setIs_top(articleInfo.getIs_top());
		articleDto.setTitle(articleInfo.getTitle());
		
		return articleDto;
	}
	
	@Override
	public void updateArticle(ArticleDto articleDto) {
		//articleInfo
		ArticleInfo articleInfo = new ArticleInfo();
		articleInfo.setId(articleDto.getArticle_id());
		articleInfo.setCategory(articleDto.getCategory());
		articleInfo.setImage_path(articleDto.getImage_path());
		articleInfo.setIs_top(articleDto.getIs_top());
		articleInfo.setTitle(articleDto.getTitle());
		articleinfomapper.updateByPrimaryKeySelective(articleInfo);
		// articleContent
		ArticleContent articleContent = new ArticleContent();
		articleContent.setId(articleDto.getId());
		articleContent.setArticle_id(articleDto.getArticle_id());
		articleContent.setContent(articleDto.getContent());
		articlecontentmapper.updateByPrimaryKeySelective(articleContent);
		
	}
	
	private Long getLatestArticleId() {
		ArticleInfoExample articleInfoExample = new ArticleInfoExample();
		articleInfoExample.setOrderByClause("id desc");
		return articleinfomapper.selectByExample(articleInfoExample).get(0).getId();
		
	} 
	
	@Override
	public List<ArticleInfo> selectArtcileInfoByCategory(String name) {
		// TODO Auto-generated method stub
		List<ArticleInfo> articleInfos = new ArrayList<ArticleInfo>();
		ArticleInfoExample example = new ArticleInfoExample();
		example.createCriteria();
		example.getOredCriteria().get(0).andCategoryEqualTo(name);
		articleInfos = articleinfomapper.selectByExample(example);
		return articleInfos;
	}
	
	@Override
	public List<ArticleInfo> selectArticleInfo() {
		// TODO Auto-generated method stub
		List<ArticleInfo> articleInfos = new ArrayList<ArticleInfo>();
		ArticleInfoExample example = new ArticleInfoExample();
		example.setOrderByClause("id desc");
		articleInfos = articleinfomapper.selectByExample(example);
		return articleInfos;
	}
	
}
