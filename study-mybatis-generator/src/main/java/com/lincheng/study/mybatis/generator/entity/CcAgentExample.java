package com.lincheng.study.mybatis.generator.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CcAgentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CcAgentExample() {
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

        public Criteria andAgentIdIsNull() {
            addCriterion("AGENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("AGENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(Integer value) {
            addCriterion("AGENT_ID =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(Integer value) {
            addCriterion("AGENT_ID <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(Integer value) {
            addCriterion("AGENT_ID >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGENT_ID >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(Integer value) {
            addCriterion("AGENT_ID <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("AGENT_ID <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<Integer> values) {
            addCriterion("AGENT_ID in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<Integer> values) {
            addCriterion("AGENT_ID not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("AGENT_ID between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AGENT_ID not between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNull() {
            addCriterion("AGENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNotNull() {
            addCriterion("AGENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAgentNameEqualTo(String value) {
            addCriterion("AGENT_NAME =", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotEqualTo(String value) {
            addCriterion("AGENT_NAME <>", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThan(String value) {
            addCriterion("AGENT_NAME >", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThanOrEqualTo(String value) {
            addCriterion("AGENT_NAME >=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThan(String value) {
            addCriterion("AGENT_NAME <", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThanOrEqualTo(String value) {
            addCriterion("AGENT_NAME <=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLike(String value) {
            addCriterion("AGENT_NAME like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotLike(String value) {
            addCriterion("AGENT_NAME not like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameIn(List<String> values) {
            addCriterion("AGENT_NAME in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotIn(List<String> values) {
            addCriterion("AGENT_NAME not in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameBetween(String value1, String value2) {
            addCriterion("AGENT_NAME between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotBetween(String value1, String value2) {
            addCriterion("AGENT_NAME not between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andCompIdIsNull() {
            addCriterion("COMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andCompIdIsNotNull() {
            addCriterion("COMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCompIdEqualTo(Integer value) {
            addCriterion("COMP_ID =", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotEqualTo(Integer value) {
            addCriterion("COMP_ID <>", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdGreaterThan(Integer value) {
            addCriterion("COMP_ID >", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMP_ID >=", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdLessThan(Integer value) {
            addCriterion("COMP_ID <", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdLessThanOrEqualTo(Integer value) {
            addCriterion("COMP_ID <=", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdIn(List<Integer> values) {
            addCriterion("COMP_ID in", values, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotIn(List<Integer> values) {
            addCriterion("COMP_ID not in", values, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdBetween(Integer value1, Integer value2) {
            addCriterion("COMP_ID between", value1, value2, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COMP_ID not between", value1, value2, "compId");
            return (Criteria) this;
        }

        public Criteria andCompNameIsNull() {
            addCriterion("COMP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompNameIsNotNull() {
            addCriterion("COMP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompNameEqualTo(String value) {
            addCriterion("COMP_NAME =", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotEqualTo(String value) {
            addCriterion("COMP_NAME <>", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameGreaterThan(String value) {
            addCriterion("COMP_NAME >", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_NAME >=", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLessThan(String value) {
            addCriterion("COMP_NAME <", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLessThanOrEqualTo(String value) {
            addCriterion("COMP_NAME <=", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLike(String value) {
            addCriterion("COMP_NAME like", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotLike(String value) {
            addCriterion("COMP_NAME not like", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameIn(List<String> values) {
            addCriterion("COMP_NAME in", values, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotIn(List<String> values) {
            addCriterion("COMP_NAME not in", values, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameBetween(String value1, String value2) {
            addCriterion("COMP_NAME between", value1, value2, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotBetween(String value1, String value2) {
            addCriterion("COMP_NAME not between", value1, value2, "compName");
            return (Criteria) this;
        }

        public Criteria andCustomeIdIsNull() {
            addCriterion("CUSTOME_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustomeIdIsNotNull() {
            addCriterion("CUSTOME_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomeIdEqualTo(Integer value) {
            addCriterion("CUSTOME_ID =", value, "customeId");
            return (Criteria) this;
        }

        public Criteria andCustomeIdNotEqualTo(Integer value) {
            addCriterion("CUSTOME_ID <>", value, "customeId");
            return (Criteria) this;
        }

        public Criteria andCustomeIdGreaterThan(Integer value) {
            addCriterion("CUSTOME_ID >", value, "customeId");
            return (Criteria) this;
        }

        public Criteria andCustomeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUSTOME_ID >=", value, "customeId");
            return (Criteria) this;
        }

        public Criteria andCustomeIdLessThan(Integer value) {
            addCriterion("CUSTOME_ID <", value, "customeId");
            return (Criteria) this;
        }

        public Criteria andCustomeIdLessThanOrEqualTo(Integer value) {
            addCriterion("CUSTOME_ID <=", value, "customeId");
            return (Criteria) this;
        }

        public Criteria andCustomeIdIn(List<Integer> values) {
            addCriterion("CUSTOME_ID in", values, "customeId");
            return (Criteria) this;
        }

        public Criteria andCustomeIdNotIn(List<Integer> values) {
            addCriterion("CUSTOME_ID not in", values, "customeId");
            return (Criteria) this;
        }

        public Criteria andCustomeIdBetween(Integer value1, Integer value2) {
            addCriterion("CUSTOME_ID between", value1, value2, "customeId");
            return (Criteria) this;
        }

        public Criteria andCustomeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CUSTOME_ID not between", value1, value2, "customeId");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("NUMBER =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("NUMBER <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("NUMBER >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("NUMBER >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("NUMBER <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("NUMBER <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("NUMBER like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("NUMBER not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("NUMBER in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("NUMBER not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("NUMBER between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("NUMBER not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andAgentStateIsNull() {
            addCriterion("AGENT_STATE is null");
            return (Criteria) this;
        }

        public Criteria andAgentStateIsNotNull() {
            addCriterion("AGENT_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andAgentStateEqualTo(String value) {
            addCriterion("AGENT_STATE =", value, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateNotEqualTo(String value) {
            addCriterion("AGENT_STATE <>", value, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateGreaterThan(String value) {
            addCriterion("AGENT_STATE >", value, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateGreaterThanOrEqualTo(String value) {
            addCriterion("AGENT_STATE >=", value, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateLessThan(String value) {
            addCriterion("AGENT_STATE <", value, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateLessThanOrEqualTo(String value) {
            addCriterion("AGENT_STATE <=", value, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateLike(String value) {
            addCriterion("AGENT_STATE like", value, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateNotLike(String value) {
            addCriterion("AGENT_STATE not like", value, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateIn(List<String> values) {
            addCriterion("AGENT_STATE in", values, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateNotIn(List<String> values) {
            addCriterion("AGENT_STATE not in", values, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateBetween(String value1, String value2) {
            addCriterion("AGENT_STATE between", value1, value2, "agentState");
            return (Criteria) this;
        }

        public Criteria andAgentStateNotBetween(String value1, String value2) {
            addCriterion("AGENT_STATE not between", value1, value2, "agentState");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdIsNull() {
            addCriterion("SUB_ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdIsNotNull() {
            addCriterion("SUB_ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdEqualTo(String value) {
            addCriterion("SUB_ACCOUNT_ID =", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdNotEqualTo(String value) {
            addCriterion("SUB_ACCOUNT_ID <>", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdGreaterThan(String value) {
            addCriterion("SUB_ACCOUNT_ID >", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_ACCOUNT_ID >=", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdLessThan(String value) {
            addCriterion("SUB_ACCOUNT_ID <", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdLessThanOrEqualTo(String value) {
            addCriterion("SUB_ACCOUNT_ID <=", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdLike(String value) {
            addCriterion("SUB_ACCOUNT_ID like", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdNotLike(String value) {
            addCriterion("SUB_ACCOUNT_ID not like", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdIn(List<String> values) {
            addCriterion("SUB_ACCOUNT_ID in", values, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdNotIn(List<String> values) {
            addCriterion("SUB_ACCOUNT_ID not in", values, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdBetween(String value1, String value2) {
            addCriterion("SUB_ACCOUNT_ID between", value1, value2, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdNotBetween(String value1, String value2) {
            addCriterion("SUB_ACCOUNT_ID not between", value1, value2, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubTokenIsNull() {
            addCriterion("SUB_TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andSubTokenIsNotNull() {
            addCriterion("SUB_TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andSubTokenEqualTo(String value) {
            addCriterion("SUB_TOKEN =", value, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenNotEqualTo(String value) {
            addCriterion("SUB_TOKEN <>", value, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenGreaterThan(String value) {
            addCriterion("SUB_TOKEN >", value, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_TOKEN >=", value, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenLessThan(String value) {
            addCriterion("SUB_TOKEN <", value, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenLessThanOrEqualTo(String value) {
            addCriterion("SUB_TOKEN <=", value, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenLike(String value) {
            addCriterion("SUB_TOKEN like", value, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenNotLike(String value) {
            addCriterion("SUB_TOKEN not like", value, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenIn(List<String> values) {
            addCriterion("SUB_TOKEN in", values, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenNotIn(List<String> values) {
            addCriterion("SUB_TOKEN not in", values, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenBetween(String value1, String value2) {
            addCriterion("SUB_TOKEN between", value1, value2, "subToken");
            return (Criteria) this;
        }

        public Criteria andSubTokenNotBetween(String value1, String value2) {
            addCriterion("SUB_TOKEN not between", value1, value2, "subToken");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIsNull() {
            addCriterion("DATE_CREATED is null");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIsNotNull() {
            addCriterion("DATE_CREATED is not null");
            return (Criteria) this;
        }

        public Criteria andDateCreatedEqualTo(Date value) {
            addCriterion("DATE_CREATED =", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotEqualTo(Date value) {
            addCriterion("DATE_CREATED <>", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedGreaterThan(Date value) {
            addCriterion("DATE_CREATED >", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("DATE_CREATED >=", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedLessThan(Date value) {
            addCriterion("DATE_CREATED <", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedLessThanOrEqualTo(Date value) {
            addCriterion("DATE_CREATED <=", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIn(List<Date> values) {
            addCriterion("DATE_CREATED in", values, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotIn(List<Date> values) {
            addCriterion("DATE_CREATED not in", values, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedBetween(Date value1, Date value2) {
            addCriterion("DATE_CREATED between", value1, value2, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotBetween(Date value1, Date value2) {
            addCriterion("DATE_CREATED not between", value1, value2, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andVoipAccountIsNull() {
            addCriterion("VOIP_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andVoipAccountIsNotNull() {
            addCriterion("VOIP_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andVoipAccountEqualTo(String value) {
            addCriterion("VOIP_ACCOUNT =", value, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountNotEqualTo(String value) {
            addCriterion("VOIP_ACCOUNT <>", value, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountGreaterThan(String value) {
            addCriterion("VOIP_ACCOUNT >", value, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountGreaterThanOrEqualTo(String value) {
            addCriterion("VOIP_ACCOUNT >=", value, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountLessThan(String value) {
            addCriterion("VOIP_ACCOUNT <", value, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountLessThanOrEqualTo(String value) {
            addCriterion("VOIP_ACCOUNT <=", value, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountLike(String value) {
            addCriterion("VOIP_ACCOUNT like", value, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountNotLike(String value) {
            addCriterion("VOIP_ACCOUNT not like", value, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountIn(List<String> values) {
            addCriterion("VOIP_ACCOUNT in", values, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountNotIn(List<String> values) {
            addCriterion("VOIP_ACCOUNT not in", values, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountBetween(String value1, String value2) {
            addCriterion("VOIP_ACCOUNT between", value1, value2, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipAccountNotBetween(String value1, String value2) {
            addCriterion("VOIP_ACCOUNT not between", value1, value2, "voipAccount");
            return (Criteria) this;
        }

        public Criteria andVoipPwdIsNull() {
            addCriterion("VOIP_PWD is null");
            return (Criteria) this;
        }

        public Criteria andVoipPwdIsNotNull() {
            addCriterion("VOIP_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andVoipPwdEqualTo(String value) {
            addCriterion("VOIP_PWD =", value, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdNotEqualTo(String value) {
            addCriterion("VOIP_PWD <>", value, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdGreaterThan(String value) {
            addCriterion("VOIP_PWD >", value, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdGreaterThanOrEqualTo(String value) {
            addCriterion("VOIP_PWD >=", value, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdLessThan(String value) {
            addCriterion("VOIP_PWD <", value, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdLessThanOrEqualTo(String value) {
            addCriterion("VOIP_PWD <=", value, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdLike(String value) {
            addCriterion("VOIP_PWD like", value, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdNotLike(String value) {
            addCriterion("VOIP_PWD not like", value, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdIn(List<String> values) {
            addCriterion("VOIP_PWD in", values, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdNotIn(List<String> values) {
            addCriterion("VOIP_PWD not in", values, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdBetween(String value1, String value2) {
            addCriterion("VOIP_PWD between", value1, value2, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andVoipPwdNotBetween(String value1, String value2) {
            addCriterion("VOIP_PWD not between", value1, value2, "voipPwd");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIsNull() {
            addCriterion("CREATE_OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIsNotNull() {
            addCriterion("CREATE_OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdEqualTo(String value) {
            addCriterion("CREATE_OPER_ID =", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotEqualTo(String value) {
            addCriterion("CREATE_OPER_ID <>", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdGreaterThan(String value) {
            addCriterion("CREATE_OPER_ID >", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER_ID >=", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLessThan(String value) {
            addCriterion("CREATE_OPER_ID <", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER_ID <=", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLike(String value) {
            addCriterion("CREATE_OPER_ID like", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotLike(String value) {
            addCriterion("CREATE_OPER_ID not like", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIn(List<String> values) {
            addCriterion("CREATE_OPER_ID in", values, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotIn(List<String> values) {
            addCriterion("CREATE_OPER_ID not in", values, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdBetween(String value1, String value2) {
            addCriterion("CREATE_OPER_ID between", value1, value2, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_OPER_ID not between", value1, value2, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeIsNull() {
            addCriterion("CREATE_OPER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeIsNotNull() {
            addCriterion("CREATE_OPER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeEqualTo(Date value) {
            addCriterion("CREATE_OPER_TIME =", value, "createOperTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeNotEqualTo(Date value) {
            addCriterion("CREATE_OPER_TIME <>", value, "createOperTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeGreaterThan(Date value) {
            addCriterion("CREATE_OPER_TIME >", value, "createOperTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_OPER_TIME >=", value, "createOperTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeLessThan(Date value) {
            addCriterion("CREATE_OPER_TIME <", value, "createOperTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_OPER_TIME <=", value, "createOperTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeIn(List<Date> values) {
            addCriterion("CREATE_OPER_TIME in", values, "createOperTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeNotIn(List<Date> values) {
            addCriterion("CREATE_OPER_TIME not in", values, "createOperTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_OPER_TIME between", value1, value2, "createOperTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_OPER_TIME not between", value1, value2, "createOperTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIsNull() {
            addCriterion("UPDATE_OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIsNotNull() {
            addCriterion("UPDATE_OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID =", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID <>", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThan(String value) {
            addCriterion("UPDATE_OPER_ID >", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID >=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThan(String value) {
            addCriterion("UPDATE_OPER_ID <", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID <=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLike(String value) {
            addCriterion("UPDATE_OPER_ID like", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotLike(String value) {
            addCriterion("UPDATE_OPER_ID not like", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIn(List<String> values) {
            addCriterion("UPDATE_OPER_ID in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotIn(List<String> values) {
            addCriterion("UPDATE_OPER_ID not in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdBetween(String value1, String value2) {
            addCriterion("UPDATE_OPER_ID between", value1, value2, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_OPER_ID not between", value1, value2, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeIsNull() {
            addCriterion("UPDATE_OPER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeIsNotNull() {
            addCriterion("UPDATE_OPER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeEqualTo(Date value) {
            addCriterion("UPDATE_OPER_TIME =", value, "updateOperTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_OPER_TIME <>", value, "updateOperTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeGreaterThan(Date value) {
            addCriterion("UPDATE_OPER_TIME >", value, "updateOperTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_OPER_TIME >=", value, "updateOperTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeLessThan(Date value) {
            addCriterion("UPDATE_OPER_TIME <", value, "updateOperTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_OPER_TIME <=", value, "updateOperTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeIn(List<Date> values) {
            addCriterion("UPDATE_OPER_TIME in", values, "updateOperTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_OPER_TIME not in", values, "updateOperTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_OPER_TIME between", value1, value2, "updateOperTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_OPER_TIME not between", value1, value2, "updateOperTime");
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