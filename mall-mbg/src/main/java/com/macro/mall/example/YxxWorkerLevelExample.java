package com.macro.mall.example;

import com.macro.mall.model.YxxWorkerLevel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YxxWorkerLevelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YxxWorkerLevelExample() {
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

    public YxxWorkerLevelExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public YxxWorkerLevelExample orderBy(String ... orderByClauses) {
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
        YxxWorkerLevelExample example = new YxxWorkerLevelExample();
        return example.createCriteria();
    }

    public YxxWorkerLevelExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public YxxWorkerLevelExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andNameEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`name` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`name` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`name` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`name` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`name` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
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

        public Criteria andEnableIsNull() {
            addCriterion("`enable` is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("`enable` is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("`enable` =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`enable` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("`enable` <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`enable` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("`enable` >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`enable` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("`enable` >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`enable` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("`enable` <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`enable` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("`enable` <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("`enable` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("`enable` in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("`enable` not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("`enable` between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("`enable` not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andPriceMonthIsNull() {
            addCriterion("price_month is null");
            return (Criteria) this;
        }

        public Criteria andPriceMonthIsNotNull() {
            addCriterion("price_month is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMonthEqualTo(BigDecimal value) {
            addCriterion("price_month =", value, "priceMonth");
            return (Criteria) this;
        }

        public Criteria andPriceMonthEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_month = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthNotEqualTo(BigDecimal value) {
            addCriterion("price_month <>", value, "priceMonth");
            return (Criteria) this;
        }

        public Criteria andPriceMonthNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_month <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthGreaterThan(BigDecimal value) {
            addCriterion("price_month >", value, "priceMonth");
            return (Criteria) this;
        }

        public Criteria andPriceMonthGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_month > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_month >=", value, "priceMonth");
            return (Criteria) this;
        }

        public Criteria andPriceMonthGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_month >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthLessThan(BigDecimal value) {
            addCriterion("price_month <", value, "priceMonth");
            return (Criteria) this;
        }

        public Criteria andPriceMonthLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_month < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_month <=", value, "priceMonth");
            return (Criteria) this;
        }

        public Criteria andPriceMonthLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_month <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthIn(List<BigDecimal> values) {
            addCriterion("price_month in", values, "priceMonth");
            return (Criteria) this;
        }

        public Criteria andPriceMonthNotIn(List<BigDecimal> values) {
            addCriterion("price_month not in", values, "priceMonth");
            return (Criteria) this;
        }

        public Criteria andPriceMonthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_month between", value1, value2, "priceMonth");
            return (Criteria) this;
        }

        public Criteria andPriceMonthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_month not between", value1, value2, "priceMonth");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyIsNull() {
            addCriterion("price_monthly is null");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyIsNotNull() {
            addCriterion("price_monthly is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyEqualTo(BigDecimal value) {
            addCriterion("price_monthly =", value, "priceMonthly");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_monthly = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyNotEqualTo(BigDecimal value) {
            addCriterion("price_monthly <>", value, "priceMonthly");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_monthly <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyGreaterThan(BigDecimal value) {
            addCriterion("price_monthly >", value, "priceMonthly");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_monthly > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_monthly >=", value, "priceMonthly");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_monthly >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyLessThan(BigDecimal value) {
            addCriterion("price_monthly <", value, "priceMonthly");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_monthly < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_monthly <=", value, "priceMonthly");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_monthly <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyIn(List<BigDecimal> values) {
            addCriterion("price_monthly in", values, "priceMonthly");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyNotIn(List<BigDecimal> values) {
            addCriterion("price_monthly not in", values, "priceMonthly");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_monthly between", value1, value2, "priceMonthly");
            return (Criteria) this;
        }

        public Criteria andPriceMonthlyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_monthly not between", value1, value2, "priceMonthly");
            return (Criteria) this;
        }

        public Criteria andPriceYearIsNull() {
            addCriterion("price_year is null");
            return (Criteria) this;
        }

        public Criteria andPriceYearIsNotNull() {
            addCriterion("price_year is not null");
            return (Criteria) this;
        }

        public Criteria andPriceYearEqualTo(BigDecimal value) {
            addCriterion("price_year =", value, "priceYear");
            return (Criteria) this;
        }

        public Criteria andPriceYearEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_year = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceYearNotEqualTo(BigDecimal value) {
            addCriterion("price_year <>", value, "priceYear");
            return (Criteria) this;
        }

        public Criteria andPriceYearNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_year <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceYearGreaterThan(BigDecimal value) {
            addCriterion("price_year >", value, "priceYear");
            return (Criteria) this;
        }

        public Criteria andPriceYearGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_year > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceYearGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_year >=", value, "priceYear");
            return (Criteria) this;
        }

        public Criteria andPriceYearGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_year >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceYearLessThan(BigDecimal value) {
            addCriterion("price_year <", value, "priceYear");
            return (Criteria) this;
        }

        public Criteria andPriceYearLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_year < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceYearLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_year <=", value, "priceYear");
            return (Criteria) this;
        }

        public Criteria andPriceYearLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("price_year <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceYearIn(List<BigDecimal> values) {
            addCriterion("price_year in", values, "priceYear");
            return (Criteria) this;
        }

        public Criteria andPriceYearNotIn(List<BigDecimal> values) {
            addCriterion("price_year not in", values, "priceYear");
            return (Criteria) this;
        }

        public Criteria andPriceYearBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_year between", value1, value2, "priceYear");
            return (Criteria) this;
        }

        public Criteria andPriceYearNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_year not between", value1, value2, "priceYear");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("deleted = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("deleted <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("deleted > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("deleted >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("deleted < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("deleted <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountIsNull() {
            addCriterion("order_assign_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountIsNotNull() {
            addCriterion("order_assign_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountEqualTo(Integer value) {
            addCriterion("order_assign_amount =", value, "orderAssignAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_assign_amount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountNotEqualTo(Integer value) {
            addCriterion("order_assign_amount <>", value, "orderAssignAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_assign_amount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountGreaterThan(Integer value) {
            addCriterion("order_assign_amount >", value, "orderAssignAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_assign_amount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_assign_amount >=", value, "orderAssignAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_assign_amount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountLessThan(Integer value) {
            addCriterion("order_assign_amount <", value, "orderAssignAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_assign_amount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_assign_amount <=", value, "orderAssignAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_assign_amount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountIn(List<Integer> values) {
            addCriterion("order_assign_amount in", values, "orderAssignAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountNotIn(List<Integer> values) {
            addCriterion("order_assign_amount not in", values, "orderAssignAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_assign_amount between", value1, value2, "orderAssignAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAssignAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_assign_amount not between", value1, value2, "orderAssignAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountIsNull() {
            addCriterion("order_distribute_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountIsNotNull() {
            addCriterion("order_distribute_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountEqualTo(Integer value) {
            addCriterion("order_distribute_amount =", value, "orderDistributeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_distribute_amount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountNotEqualTo(Integer value) {
            addCriterion("order_distribute_amount <>", value, "orderDistributeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_distribute_amount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountGreaterThan(Integer value) {
            addCriterion("order_distribute_amount >", value, "orderDistributeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_distribute_amount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_distribute_amount >=", value, "orderDistributeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_distribute_amount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountLessThan(Integer value) {
            addCriterion("order_distribute_amount <", value, "orderDistributeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_distribute_amount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_distribute_amount <=", value, "orderDistributeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_distribute_amount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountIn(List<Integer> values) {
            addCriterion("order_distribute_amount in", values, "orderDistributeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountNotIn(List<Integer> values) {
            addCriterion("order_distribute_amount not in", values, "orderDistributeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_distribute_amount between", value1, value2, "orderDistributeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDistributeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_distribute_amount not between", value1, value2, "orderDistributeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountIsNull() {
            addCriterion("order_rush_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountIsNotNull() {
            addCriterion("order_rush_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountEqualTo(Integer value) {
            addCriterion("order_rush_amount =", value, "orderRushAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountNotEqualTo(Integer value) {
            addCriterion("order_rush_amount <>", value, "orderRushAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountGreaterThan(Integer value) {
            addCriterion("order_rush_amount >", value, "orderRushAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_rush_amount >=", value, "orderRushAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountLessThan(Integer value) {
            addCriterion("order_rush_amount <", value, "orderRushAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_rush_amount <=", value, "orderRushAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountIn(List<Integer> values) {
            addCriterion("order_rush_amount in", values, "orderRushAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountNotIn(List<Integer> values) {
            addCriterion("order_rush_amount not in", values, "orderRushAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_rush_amount between", value1, value2, "orderRushAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_rush_amount not between", value1, value2, "orderRushAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainIsNull() {
            addCriterion("order_rush_amount_bargain is null");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainIsNotNull() {
            addCriterion("order_rush_amount_bargain is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainEqualTo(Integer value) {
            addCriterion("order_rush_amount_bargain =", value, "orderRushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount_bargain = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainNotEqualTo(Integer value) {
            addCriterion("order_rush_amount_bargain <>", value, "orderRushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount_bargain <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainGreaterThan(Integer value) {
            addCriterion("order_rush_amount_bargain >", value, "orderRushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount_bargain > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_rush_amount_bargain >=", value, "orderRushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount_bargain >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainLessThan(Integer value) {
            addCriterion("order_rush_amount_bargain <", value, "orderRushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount_bargain < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainLessThanOrEqualTo(Integer value) {
            addCriterion("order_rush_amount_bargain <=", value, "orderRushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("order_rush_amount_bargain <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainIn(List<Integer> values) {
            addCriterion("order_rush_amount_bargain in", values, "orderRushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainNotIn(List<Integer> values) {
            addCriterion("order_rush_amount_bargain not in", values, "orderRushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainBetween(Integer value1, Integer value2) {
            addCriterion("order_rush_amount_bargain between", value1, value2, "orderRushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andOrderRushAmountBargainNotBetween(Integer value1, Integer value2) {
            addCriterion("order_rush_amount_bargain not between", value1, value2, "orderRushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andCutDiscountIsNull() {
            addCriterion("cut_discount is null");
            return (Criteria) this;
        }

        public Criteria andCutDiscountIsNotNull() {
            addCriterion("cut_discount is not null");
            return (Criteria) this;
        }

        public Criteria andCutDiscountEqualTo(BigDecimal value) {
            addCriterion("cut_discount =", value, "cutDiscount");
            return (Criteria) this;
        }

        public Criteria andCutDiscountEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("cut_discount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCutDiscountNotEqualTo(BigDecimal value) {
            addCriterion("cut_discount <>", value, "cutDiscount");
            return (Criteria) this;
        }

        public Criteria andCutDiscountNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("cut_discount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCutDiscountGreaterThan(BigDecimal value) {
            addCriterion("cut_discount >", value, "cutDiscount");
            return (Criteria) this;
        }

        public Criteria andCutDiscountGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("cut_discount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCutDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cut_discount >=", value, "cutDiscount");
            return (Criteria) this;
        }

        public Criteria andCutDiscountGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("cut_discount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCutDiscountLessThan(BigDecimal value) {
            addCriterion("cut_discount <", value, "cutDiscount");
            return (Criteria) this;
        }

        public Criteria andCutDiscountLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("cut_discount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCutDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cut_discount <=", value, "cutDiscount");
            return (Criteria) this;
        }

        public Criteria andCutDiscountLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("cut_discount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCutDiscountIn(List<BigDecimal> values) {
            addCriterion("cut_discount in", values, "cutDiscount");
            return (Criteria) this;
        }

        public Criteria andCutDiscountNotIn(List<BigDecimal> values) {
            addCriterion("cut_discount not in", values, "cutDiscount");
            return (Criteria) this;
        }

        public Criteria andCutDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cut_discount between", value1, value2, "cutDiscount");
            return (Criteria) this;
        }

        public Criteria andCutDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cut_discount not between", value1, value2, "cutDiscount");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("remark = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("remark <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("remark > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("remark >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("remark < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("remark <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andCreateTimeEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
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

        public Criteria andUpdateTimeEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_by = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_by <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_by > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_by >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_by < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("create_by <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_by = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_by <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_by > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_by >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_by < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualToColumn(YxxWorkerLevel.Column column) {
            addCriterion(new StringBuilder("update_by <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private YxxWorkerLevelExample example;

        protected Criteria(YxxWorkerLevelExample example) {
            super();
            this.example = example;
        }

        public YxxWorkerLevelExample example() {
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
        void example(com.macro.mall.example.YxxWorkerLevelExample example);
    }
}