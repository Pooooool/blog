package blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCreate_byIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreate_byIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_byEqualTo(Date value) {
            addCriterion("create_by =", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotEqualTo(Date value) {
            addCriterion("create_by <>", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byGreaterThan(Date value) {
            addCriterion("create_by >", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byGreaterThanOrEqualTo(Date value) {
            addCriterion("create_by >=", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLessThan(Date value) {
            addCriterion("create_by <", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLessThanOrEqualTo(Date value) {
            addCriterion("create_by <=", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byIn(List<Date> values) {
            addCriterion("create_by in", values, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotIn(List<Date> values) {
            addCriterion("create_by not in", values, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byBetween(Date value1, Date value2) {
            addCriterion("create_by between", value1, value2, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotBetween(Date value1, Date value2) {
            addCriterion("create_by not between", value1, value2, "create_by");
            return (Criteria) this;
        }

        public Criteria andModify_byIsNull() {
            addCriterion("modify_by is null");
            return (Criteria) this;
        }

        public Criteria andModify_byIsNotNull() {
            addCriterion("modify_by is not null");
            return (Criteria) this;
        }

        public Criteria andModify_byEqualTo(Date value) {
            addCriterion("modify_by =", value, "modify_by");
            return (Criteria) this;
        }

        public Criteria andModify_byNotEqualTo(Date value) {
            addCriterion("modify_by <>", value, "modify_by");
            return (Criteria) this;
        }

        public Criteria andModify_byGreaterThan(Date value) {
            addCriterion("modify_by >", value, "modify_by");
            return (Criteria) this;
        }

        public Criteria andModify_byGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_by >=", value, "modify_by");
            return (Criteria) this;
        }

        public Criteria andModify_byLessThan(Date value) {
            addCriterion("modify_by <", value, "modify_by");
            return (Criteria) this;
        }

        public Criteria andModify_byLessThanOrEqualTo(Date value) {
            addCriterion("modify_by <=", value, "modify_by");
            return (Criteria) this;
        }

        public Criteria andModify_byIn(List<Date> values) {
            addCriterion("modify_by in", values, "modify_by");
            return (Criteria) this;
        }

        public Criteria andModify_byNotIn(List<Date> values) {
            addCriterion("modify_by not in", values, "modify_by");
            return (Criteria) this;
        }

        public Criteria andModify_byBetween(Date value1, Date value2) {
            addCriterion("modify_by between", value1, value2, "modify_by");
            return (Criteria) this;
        }

        public Criteria andModify_byNotBetween(Date value1, Date value2) {
            addCriterion("modify_by not between", value1, value2, "modify_by");
            return (Criteria) this;
        }

        public Criteria andImage_pathIsNull() {
            addCriterion("image_path is null");
            return (Criteria) this;
        }

        public Criteria andImage_pathIsNotNull() {
            addCriterion("image_path is not null");
            return (Criteria) this;
        }

        public Criteria andImage_pathEqualTo(String value) {
            addCriterion("image_path =", value, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathNotEqualTo(String value) {
            addCriterion("image_path <>", value, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathGreaterThan(String value) {
            addCriterion("image_path >", value, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathGreaterThanOrEqualTo(String value) {
            addCriterion("image_path >=", value, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathLessThan(String value) {
            addCriterion("image_path <", value, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathLessThanOrEqualTo(String value) {
            addCriterion("image_path <=", value, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathLike(String value) {
            addCriterion("image_path like", value, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathNotLike(String value) {
            addCriterion("image_path not like", value, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathIn(List<String> values) {
            addCriterion("image_path in", values, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathNotIn(List<String> values) {
            addCriterion("image_path not in", values, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathBetween(String value1, String value2) {
            addCriterion("image_path between", value1, value2, "image_path");
            return (Criteria) this;
        }

        public Criteria andImage_pathNotBetween(String value1, String value2) {
            addCriterion("image_path not between", value1, value2, "image_path");
            return (Criteria) this;
        }

        public Criteria andIs_topIsNull() {
            addCriterion("is_top is null");
            return (Criteria) this;
        }

        public Criteria andIs_topIsNotNull() {
            addCriterion("is_top is not null");
            return (Criteria) this;
        }

        public Criteria andIs_topEqualTo(Boolean value) {
            addCriterion("is_top =", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topNotEqualTo(Boolean value) {
            addCriterion("is_top <>", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topGreaterThan(Boolean value) {
            addCriterion("is_top >", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_top >=", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topLessThan(Boolean value) {
            addCriterion("is_top <", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topLessThanOrEqualTo(Boolean value) {
            addCriterion("is_top <=", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topIn(List<Boolean> values) {
            addCriterion("is_top in", values, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topNotIn(List<Boolean> values) {
            addCriterion("is_top not in", values, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topBetween(Boolean value1, Boolean value2) {
            addCriterion("is_top between", value1, value2, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_top not between", value1, value2, "is_top");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}