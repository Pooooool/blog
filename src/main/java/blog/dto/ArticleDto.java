package blog.dto;

import java.util.Date;

public class ArticleDto {
	/**
	 * ArticleInfo
	 */
	 private Long id;

	    private String category;

	    private String title;

	    private String image_path;
	    
	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getImage_path() {
			return image_path;
		}

		public void setImage_path(String image_path) {
			this.image_path = image_path;
		}

		public Boolean getIs_top() {
			return is_top;
		}

		public void setIs_top(Boolean is_top) {
			this.is_top = is_top;
		}

		public Long getArticle_id() {
			return article_id;
		}

		public void setArticle_id(Long article_id) {
			this.article_id = article_id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		private Boolean is_top;
	    /**
	     * ArticleContent
	     */
	    private Long article_id;

		private String content;
	    
	    @Override
	    public String toString() {
	    	
	    	return this.getCategory()+this.getContent()+this.getImage_path()+this.getTitle()+this.getArticle_id()+this.getId()+this.getIs_top();
	    }
}
