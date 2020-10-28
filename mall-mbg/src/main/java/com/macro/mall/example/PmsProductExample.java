package com.macro.mall.example;

import com.macro.mall.model.PmsProduct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PmsProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsProductExample() {
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

    public PmsProductExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public PmsProductExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static Criteria newAndCreateCriteria() {
        PmsProductExample example = new PmsProductExample();
        return example.createCriteria();
    }

    public PmsProductExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public PmsProductExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
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

        public Criteria andIdEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
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

        public Criteria andProductCategoryIdIsNull() {
            addCriterion("product_category_id is null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdIsNotNull() {
            addCriterion("product_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdEqualTo(Long value) {
            addCriterion("product_category_id =", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdNotEqualTo(Long value) {
            addCriterion("product_category_id <>", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdGreaterThan(Long value) {
            addCriterion("product_category_id >", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_category_id >=", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdLessThan(Long value) {
            addCriterion("product_category_id <", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("product_category_id <=", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdIn(List<Long> values) {
            addCriterion("product_category_id in", values, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdNotIn(List<Long> values) {
            addCriterion("product_category_id not in", values, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdBetween(Long value1, Long value2) {
            addCriterion("product_category_id between", value1, value2, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("product_category_id not between", value1, value2, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("`name` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("`name` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("`name` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("`name` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("`name` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("`name` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("pic = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("pic <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("pic > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("pic >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("pic < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("pic <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andProductSnIsNull() {
            addCriterion("product_sn is null");
            return (Criteria) this;
        }

        public Criteria andProductSnIsNotNull() {
            addCriterion("product_sn is not null");
            return (Criteria) this;
        }

        public Criteria andProductSnEqualTo(String value) {
            addCriterion("product_sn =", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_sn = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductSnNotEqualTo(String value) {
            addCriterion("product_sn <>", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_sn <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductSnGreaterThan(String value) {
            addCriterion("product_sn >", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_sn > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductSnGreaterThanOrEqualTo(String value) {
            addCriterion("product_sn >=", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_sn >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductSnLessThan(String value) {
            addCriterion("product_sn <", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_sn < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductSnLessThanOrEqualTo(String value) {
            addCriterion("product_sn <=", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_sn <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductSnLike(String value) {
            addCriterion("product_sn like", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnNotLike(String value) {
            addCriterion("product_sn not like", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnIn(List<String> values) {
            addCriterion("product_sn in", values, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnNotIn(List<String> values) {
            addCriterion("product_sn not in", values, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnBetween(String value1, String value2) {
            addCriterion("product_sn between", value1, value2, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnNotBetween(String value1, String value2) {
            addCriterion("product_sn not between", value1, value2, "productSn");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNull() {
            addCriterion("delete_status is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(Integer value) {
            addCriterion("delete_status =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("delete_status = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(Integer value) {
            addCriterion("delete_status <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("delete_status <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(Integer value) {
            addCriterion("delete_status >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("delete_status > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_status >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("delete_status >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(Integer value) {
            addCriterion("delete_status <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("delete_status < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("delete_status <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("delete_status <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<Integer> values) {
            addCriterion("delete_status in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<Integer> values) {
            addCriterion("delete_status not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("delete_status between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_status not between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIsNull() {
            addCriterion("publish_status is null");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIsNotNull() {
            addCriterion("publish_status is not null");
            return (Criteria) this;
        }

        public Criteria andPublishStatusEqualTo(Integer value) {
            addCriterion("publish_status =", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("publish_status = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotEqualTo(Integer value) {
            addCriterion("publish_status <>", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("publish_status <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThan(Integer value) {
            addCriterion("publish_status >", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("publish_status > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("publish_status >=", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("publish_status >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThan(Integer value) {
            addCriterion("publish_status <", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("publish_status < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThanOrEqualTo(Integer value) {
            addCriterion("publish_status <=", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("publish_status <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPublishStatusIn(List<Integer> values) {
            addCriterion("publish_status in", values, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotIn(List<Integer> values) {
            addCriterion("publish_status not in", values, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusBetween(Integer value1, Integer value2) {
            addCriterion("publish_status between", value1, value2, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("publish_status not between", value1, value2, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIsNull() {
            addCriterion("recommend_status is null");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIsNotNull() {
            addCriterion("recommend_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusEqualTo(Integer value) {
            addCriterion("recommend_status =", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("recommend_status = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotEqualTo(Integer value) {
            addCriterion("recommend_status <>", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("recommend_status <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecommendStatusGreaterThan(Integer value) {
            addCriterion("recommend_status >", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("recommend_status > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecommendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend_status >=", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("recommend_status >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecommendStatusLessThan(Integer value) {
            addCriterion("recommend_status <", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("recommend_status < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecommendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("recommend_status <=", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("recommend_status <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIn(List<Integer> values) {
            addCriterion("recommend_status in", values, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotIn(List<Integer> values) {
            addCriterion("recommend_status not in", values, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusBetween(Integer value1, Integer value2) {
            addCriterion("recommend_status between", value1, value2, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend_status not between", value1, value2, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sort = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sort <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sort > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sort >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sort < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sort <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSubTitleIsNull() {
            addCriterion("sub_title is null");
            return (Criteria) this;
        }

        public Criteria andSubTitleIsNotNull() {
            addCriterion("sub_title is not null");
            return (Criteria) this;
        }

        public Criteria andSubTitleEqualTo(String value) {
            addCriterion("sub_title =", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sub_title = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSubTitleNotEqualTo(String value) {
            addCriterion("sub_title <>", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sub_title <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThan(String value) {
            addCriterion("sub_title >", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sub_title > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThanOrEqualTo(String value) {
            addCriterion("sub_title >=", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sub_title >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThan(String value) {
            addCriterion("sub_title <", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sub_title < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThanOrEqualTo(String value) {
            addCriterion("sub_title <=", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("sub_title <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSubTitleLike(String value) {
            addCriterion("sub_title like", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotLike(String value) {
            addCriterion("sub_title not like", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleIn(List<String> values) {
            addCriterion("sub_title in", values, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotIn(List<String> values) {
            addCriterion("sub_title not in", values, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleBetween(String value1, String value2) {
            addCriterion("sub_title between", value1, value2, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotBetween(String value1, String value2) {
            addCriterion("sub_title not between", value1, value2, "subTitle");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("keywords = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("keywords <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("keywords > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("keywords >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("keywords < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("keywords <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andDetailTitleIsNull() {
            addCriterion("detail_title is null");
            return (Criteria) this;
        }

        public Criteria andDetailTitleIsNotNull() {
            addCriterion("detail_title is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTitleEqualTo(String value) {
            addCriterion("detail_title =", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("detail_title = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailTitleNotEqualTo(String value) {
            addCriterion("detail_title <>", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("detail_title <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailTitleGreaterThan(String value) {
            addCriterion("detail_title >", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("detail_title > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailTitleGreaterThanOrEqualTo(String value) {
            addCriterion("detail_title >=", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("detail_title >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailTitleLessThan(String value) {
            addCriterion("detail_title <", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("detail_title < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailTitleLessThanOrEqualTo(String value) {
            addCriterion("detail_title <=", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("detail_title <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailTitleLike(String value) {
            addCriterion("detail_title like", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleNotLike(String value) {
            addCriterion("detail_title not like", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleIn(List<String> values) {
            addCriterion("detail_title in", values, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleNotIn(List<String> values) {
            addCriterion("detail_title not in", values, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleBetween(String value1, String value2) {
            addCriterion("detail_title between", value1, value2, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleNotBetween(String value1, String value2) {
            addCriterion("detail_title not between", value1, value2, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameIsNull() {
            addCriterion("product_category_name is null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameIsNotNull() {
            addCriterion("product_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameEqualTo(String value) {
            addCriterion("product_category_name =", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameNotEqualTo(String value) {
            addCriterion("product_category_name <>", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameGreaterThan(String value) {
            addCriterion("product_category_name >", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_category_name >=", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameLessThan(String value) {
            addCriterion("product_category_name <", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("product_category_name <=", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("product_category_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameLike(String value) {
            addCriterion("product_category_name like", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameNotLike(String value) {
            addCriterion("product_category_name not like", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameIn(List<String> values) {
            addCriterion("product_category_name in", values, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameNotIn(List<String> values) {
            addCriterion("product_category_name not in", values, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameBetween(String value1, String value2) {
            addCriterion("product_category_name between", value1, value2, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameNotBetween(String value1, String value2) {
            addCriterion("product_category_name not between", value1, value2, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNull() {
            addCriterion("region_id is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("region_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(Long value) {
            addCriterion("region_id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(Long value) {
            addCriterion("region_id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(Long value) {
            addCriterion("region_id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("region_id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(Long value) {
            addCriterion("region_id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("region_id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<Long> values) {
            addCriterion("region_id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<Long> values) {
            addCriterion("region_id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(Long value1, Long value2) {
            addCriterion("region_id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("region_id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("region <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andIsBargainIsNull() {
            addCriterion("is_bargain is null");
            return (Criteria) this;
        }

        public Criteria andIsBargainIsNotNull() {
            addCriterion("is_bargain is not null");
            return (Criteria) this;
        }

        public Criteria andIsBargainEqualTo(Integer value) {
            addCriterion("is_bargain =", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("is_bargain = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainNotEqualTo(Integer value) {
            addCriterion("is_bargain <>", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("is_bargain <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainGreaterThan(Integer value) {
            addCriterion("is_bargain >", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("is_bargain > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_bargain >=", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("is_bargain >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainLessThan(Integer value) {
            addCriterion("is_bargain <", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("is_bargain < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainLessThanOrEqualTo(Integer value) {
            addCriterion("is_bargain <=", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("is_bargain <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainIn(List<Integer> values) {
            addCriterion("is_bargain in", values, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainNotIn(List<Integer> values) {
            addCriterion("is_bargain not in", values, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainBetween(Integer value1, Integer value2) {
            addCriterion("is_bargain between", value1, value2, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainNotBetween(Integer value1, Integer value2) {
            addCriterion("is_bargain not between", value1, value2, "isBargain");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdIsNull() {
            addCriterion("charge_standard_id is null");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdIsNotNull() {
            addCriterion("charge_standard_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdEqualTo(Long value) {
            addCriterion("charge_standard_id =", value, "chargeStandardId");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("charge_standard_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdNotEqualTo(Long value) {
            addCriterion("charge_standard_id <>", value, "chargeStandardId");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("charge_standard_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdGreaterThan(Long value) {
            addCriterion("charge_standard_id >", value, "chargeStandardId");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("charge_standard_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("charge_standard_id >=", value, "chargeStandardId");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("charge_standard_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdLessThan(Long value) {
            addCriterion("charge_standard_id <", value, "chargeStandardId");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("charge_standard_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdLessThanOrEqualTo(Long value) {
            addCriterion("charge_standard_id <=", value, "chargeStandardId");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("charge_standard_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdIn(List<Long> values) {
            addCriterion("charge_standard_id in", values, "chargeStandardId");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdNotIn(List<Long> values) {
            addCriterion("charge_standard_id not in", values, "chargeStandardId");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdBetween(Long value1, Long value2) {
            addCriterion("charge_standard_id between", value1, value2, "chargeStandardId");
            return (Criteria) this;
        }

        public Criteria andChargeStandardIdNotBetween(Long value1, Long value2) {
            addCriterion("charge_standard_id not between", value1, value2, "chargeStandardId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("create_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("create_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("create_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("create_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("create_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("create_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("update_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("update_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("update_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("update_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("update_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("update_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCommonCostIsNull() {
            addCriterion("common_cost is null");
            return (Criteria) this;
        }

        public Criteria andCommonCostIsNotNull() {
            addCriterion("common_cost is not null");
            return (Criteria) this;
        }

        public Criteria andCommonCostEqualTo(String value) {
            addCriterion("common_cost =", value, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("common_cost = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommonCostNotEqualTo(String value) {
            addCriterion("common_cost <>", value, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostNotEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("common_cost <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommonCostGreaterThan(String value) {
            addCriterion("common_cost >", value, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostGreaterThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("common_cost > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommonCostGreaterThanOrEqualTo(String value) {
            addCriterion("common_cost >=", value, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostGreaterThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("common_cost >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommonCostLessThan(String value) {
            addCriterion("common_cost <", value, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostLessThanColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("common_cost < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommonCostLessThanOrEqualTo(String value) {
            addCriterion("common_cost <=", value, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostLessThanOrEqualToColumn(PmsProduct.Column column) {
            addCriterion(new StringBuilder("common_cost <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommonCostLike(String value) {
            addCriterion("common_cost like", value, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostNotLike(String value) {
            addCriterion("common_cost not like", value, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostIn(List<String> values) {
            addCriterion("common_cost in", values, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostNotIn(List<String> values) {
            addCriterion("common_cost not in", values, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostBetween(String value1, String value2) {
            addCriterion("common_cost between", value1, value2, "commonCost");
            return (Criteria) this;
        }

        public Criteria andCommonCostNotBetween(String value1, String value2) {
            addCriterion("common_cost not between", value1, value2, "commonCost");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private PmsProductExample example;

        protected Criteria(PmsProductExample example) {
            super();
            this.example = example;
        }

        public PmsProductExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
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

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(com.macro.mall.example.PmsProductExample example);
    }
}