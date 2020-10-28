package com.macro.mall.example;

import com.macro.mall.model.YxxWorkerOrderCount;
import java.util.ArrayList;
import java.util.List;

public class YxxWorkerOrderCountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YxxWorkerOrderCountExample() {
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

    public YxxWorkerOrderCountExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public YxxWorkerOrderCountExample orderBy(String ... orderByClauses) {
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
        YxxWorkerOrderCountExample example = new YxxWorkerOrderCountExample();
        return example.createCriteria();
    }

    public YxxWorkerOrderCountExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public YxxWorkerOrderCountExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andWorkerIdIsNull() {
            addCriterion("worker_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdIsNotNull() {
            addCriterion("worker_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdEqualTo(Long value) {
            addCriterion("worker_id =", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("worker_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotEqualTo(Long value) {
            addCriterion("worker_id <>", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("worker_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThan(Long value) {
            addCriterion("worker_id >", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("worker_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("worker_id >=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanOrEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("worker_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThan(Long value) {
            addCriterion("worker_id <", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("worker_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanOrEqualTo(Long value) {
            addCriterion("worker_id <=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanOrEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("worker_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdIn(List<Long> values) {
            addCriterion("worker_id in", values, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotIn(List<Long> values) {
            addCriterion("worker_id not in", values, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdBetween(Long value1, Long value2) {
            addCriterion("worker_id between", value1, value2, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotBetween(Long value1, Long value2) {
            addCriterion("worker_id not between", value1, value2, "workerId");
            return (Criteria) this;
        }

        public Criteria andAssignAmountIsNull() {
            addCriterion("assign_amount is null");
            return (Criteria) this;
        }

        public Criteria andAssignAmountIsNotNull() {
            addCriterion("assign_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAssignAmountEqualTo(Integer value) {
            addCriterion("assign_amount =", value, "assignAmount");
            return (Criteria) this;
        }

        public Criteria andAssignAmountEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("assign_amount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAssignAmountNotEqualTo(Integer value) {
            addCriterion("assign_amount <>", value, "assignAmount");
            return (Criteria) this;
        }

        public Criteria andAssignAmountNotEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("assign_amount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAssignAmountGreaterThan(Integer value) {
            addCriterion("assign_amount >", value, "assignAmount");
            return (Criteria) this;
        }

        public Criteria andAssignAmountGreaterThanColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("assign_amount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAssignAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("assign_amount >=", value, "assignAmount");
            return (Criteria) this;
        }

        public Criteria andAssignAmountGreaterThanOrEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("assign_amount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAssignAmountLessThan(Integer value) {
            addCriterion("assign_amount <", value, "assignAmount");
            return (Criteria) this;
        }

        public Criteria andAssignAmountLessThanColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("assign_amount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAssignAmountLessThanOrEqualTo(Integer value) {
            addCriterion("assign_amount <=", value, "assignAmount");
            return (Criteria) this;
        }

        public Criteria andAssignAmountLessThanOrEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("assign_amount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAssignAmountIn(List<Integer> values) {
            addCriterion("assign_amount in", values, "assignAmount");
            return (Criteria) this;
        }

        public Criteria andAssignAmountNotIn(List<Integer> values) {
            addCriterion("assign_amount not in", values, "assignAmount");
            return (Criteria) this;
        }

        public Criteria andAssignAmountBetween(Integer value1, Integer value2) {
            addCriterion("assign_amount between", value1, value2, "assignAmount");
            return (Criteria) this;
        }

        public Criteria andAssignAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("assign_amount not between", value1, value2, "assignAmount");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountIsNull() {
            addCriterion("distribute_amount is null");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountIsNotNull() {
            addCriterion("distribute_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountEqualTo(Integer value) {
            addCriterion("distribute_amount =", value, "distributeAmount");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("distribute_amount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistributeAmountNotEqualTo(Integer value) {
            addCriterion("distribute_amount <>", value, "distributeAmount");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountNotEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("distribute_amount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistributeAmountGreaterThan(Integer value) {
            addCriterion("distribute_amount >", value, "distributeAmount");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountGreaterThanColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("distribute_amount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistributeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("distribute_amount >=", value, "distributeAmount");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountGreaterThanOrEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("distribute_amount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistributeAmountLessThan(Integer value) {
            addCriterion("distribute_amount <", value, "distributeAmount");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountLessThanColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("distribute_amount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistributeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("distribute_amount <=", value, "distributeAmount");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountLessThanOrEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("distribute_amount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDistributeAmountIn(List<Integer> values) {
            addCriterion("distribute_amount in", values, "distributeAmount");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountNotIn(List<Integer> values) {
            addCriterion("distribute_amount not in", values, "distributeAmount");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountBetween(Integer value1, Integer value2) {
            addCriterion("distribute_amount between", value1, value2, "distributeAmount");
            return (Criteria) this;
        }

        public Criteria andDistributeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("distribute_amount not between", value1, value2, "distributeAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountIsNull() {
            addCriterion("rush_amount is null");
            return (Criteria) this;
        }

        public Criteria andRushAmountIsNotNull() {
            addCriterion("rush_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRushAmountEqualTo(Integer value) {
            addCriterion("rush_amount =", value, "rushAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountNotEqualTo(Integer value) {
            addCriterion("rush_amount <>", value, "rushAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountNotEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountGreaterThan(Integer value) {
            addCriterion("rush_amount >", value, "rushAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountGreaterThanColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("rush_amount >=", value, "rushAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountGreaterThanOrEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountLessThan(Integer value) {
            addCriterion("rush_amount <", value, "rushAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountLessThanColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountLessThanOrEqualTo(Integer value) {
            addCriterion("rush_amount <=", value, "rushAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountLessThanOrEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountIn(List<Integer> values) {
            addCriterion("rush_amount in", values, "rushAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountNotIn(List<Integer> values) {
            addCriterion("rush_amount not in", values, "rushAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountBetween(Integer value1, Integer value2) {
            addCriterion("rush_amount between", value1, value2, "rushAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("rush_amount not between", value1, value2, "rushAmount");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainIsNull() {
            addCriterion("rush_amount_bargain is null");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainIsNotNull() {
            addCriterion("rush_amount_bargain is not null");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainEqualTo(Integer value) {
            addCriterion("rush_amount_bargain =", value, "rushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount_bargain = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainNotEqualTo(Integer value) {
            addCriterion("rush_amount_bargain <>", value, "rushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainNotEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount_bargain <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainGreaterThan(Integer value) {
            addCriterion("rush_amount_bargain >", value, "rushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainGreaterThanColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount_bargain > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainGreaterThanOrEqualTo(Integer value) {
            addCriterion("rush_amount_bargain >=", value, "rushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainGreaterThanOrEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount_bargain >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainLessThan(Integer value) {
            addCriterion("rush_amount_bargain <", value, "rushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainLessThanColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount_bargain < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainLessThanOrEqualTo(Integer value) {
            addCriterion("rush_amount_bargain <=", value, "rushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainLessThanOrEqualToColumn(YxxWorkerOrderCount.Column column) {
            addCriterion(new StringBuilder("rush_amount_bargain <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainIn(List<Integer> values) {
            addCriterion("rush_amount_bargain in", values, "rushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainNotIn(List<Integer> values) {
            addCriterion("rush_amount_bargain not in", values, "rushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainBetween(Integer value1, Integer value2) {
            addCriterion("rush_amount_bargain between", value1, value2, "rushAmountBargain");
            return (Criteria) this;
        }

        public Criteria andRushAmountBargainNotBetween(Integer value1, Integer value2) {
            addCriterion("rush_amount_bargain not between", value1, value2, "rushAmountBargain");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private YxxWorkerOrderCountExample example;

        protected Criteria(YxxWorkerOrderCountExample example) {
            super();
            this.example = example;
        }

        public YxxWorkerOrderCountExample example() {
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
        void example(com.macro.mall.example.YxxWorkerOrderCountExample example);
    }
}